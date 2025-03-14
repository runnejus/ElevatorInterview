package com.runnejus.interview.service;

import java.util.Map;

import com.runnejus.interview.request.FloorRequest;
import com.runnejus.interview.model.floor.FloorRequestStatus;
import com.runnejus.interview.model.floor.FloorRequestStatusCode;
import com.runnejus.interview.model.elevator.Elevator;
import com.runnejus.interview.exception.IllegalFloorRequestException;

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

    private Elevator performOperationsOnSelectedElevator(Elevator selectedElevator, FloorRequest floorRequest) throws IllegalFloorRequestException {
        if(floorRequest != null && floorRequest.getFloorIdsRequested().size() > 0) {
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
