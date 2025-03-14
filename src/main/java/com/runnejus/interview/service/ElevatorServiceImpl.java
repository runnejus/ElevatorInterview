package com.runnejus.interview.service;

import java.util.Map;

import com.runnejus.interview.request.FloorRequest;
import com.runnejus.interview.model.floor.FloorRequestStatus;
import com.runnejus.interview.model.floor.FloorRequestStatusCode;
import com.runnejus.interview.model.elevator.Elevator;
import com.runnejus.interview.exception.IllegalFloorRequestException;

/*
 * class ElevatorServiceImpl implements ElevatorService
 * 
 * Take in a map of elevators and the key is just a simple string to keep all the elevators unique
 * 
 * processFloorRequest method will call the ElevatorSelector class and will make the determination of which elevator should take on the request.
 * After elevator is selected, operations will be performed on the cooresponding elevator to either come down or come up to pick up the user and
 * then stop at 1 or many floors that user requested
 * 
 */
public class ElevatorServiceImpl implements ElevatorService {
    
    private Map<String, Elevator> elevatorMap = null;
    private ElevatorSelector elevatorSelector = null;    

    public ElevatorServiceImpl(Map<String, Elevator> elevatorsMapInput) throws IllegalArgumentException {
        if(elevatorsMapInput == null || elevatorsMapInput.size() < 1) {
            throw new IllegalArgumentException("Invalid Elevators Input Definition");
        }
        this.elevatorMap = elevatorsMapInput;
        this.elevatorSelector = new ElevatorSelectorImpl();
    }

    /*
     * method processFloorRequest
     * 
     * @param floorRequest - request by user to stop at a floor
     * @return FloorRequestStatus - returns the status of the operation that was attempted to be performed
     * 
     */
    @Override
    public FloorRequestStatus processFloorRequests(FloorRequest floorRequest) {
        try {
            String selectedElevatorKey = elevatorSelector.findNearestElevator(floorRequest, elevatorMap);
            Elevator selectedElevator = elevatorMap.get(selectedElevatorKey);
            selectedElevator = performOperationsOnSelectedElevator(selectedElevator, floorRequest);
            elevatorMap.put(selectedElevatorKey, selectedElevator);
        } catch (Exception e) {
            return createFailedStatus( "Elevator had an unexpected failure");
        }

        return createCompletedStatus("Elevator has completed route");
    }

    /*
     * method performOperationsOnSelectedElevator - call stop to return elevator to user as well as move elevator to all requested floors
     * @param selectedElevator - elevator where operations will be performed against
     * @param floorRequest - all floors that user has requested to have elevator stop at
     * @return Elevator - elevator is returned by the method to make sure that latest update is captured in the service layer
     * 
     */
    private Elevator performOperationsOnSelectedElevator(Elevator selectedElevator, FloorRequest floorRequest) throws IllegalFloorRequestException {
        if(floorRequest != null && floorRequest.getFloorIdsRequested().size() > 0) {
            selectedElevator.stopAtFloor(convertFloorIdToFloorIndex(floorRequest.getCurrentFloorId()));
            for(Integer floodIdRequested : floorRequest.getFloorIdsRequested()) {
                selectedElevator.stopAtFloor(convertFloorIdToFloorIndex(floodIdRequested));
            }
        }

        return selectedElevator;
    }

    private int convertFloorIdToFloorIndex(int floorId) {
        return floorId - 1;
    }

    private FloorRequestStatus createFailedStatus(String message) {
        return new FloorRequestStatus(FloorRequestStatusCode.FAILED, message);
    }

    private FloorRequestStatus createCompletedStatus(String message) {
        return new FloorRequestStatus(FloorRequestStatusCode.COMPLETED, message);
    }

}
