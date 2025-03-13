package com.runnejus.interview.service;

import java.util.Map;

import com.runnejus.interview.request.FloorRequest;
import com.runnejus.interview.model.floor.FloorRequestStatus;
import com.runnejus.interview.model.floor.FloorRequestStatusCode;
import com.runnejus.interview.model.elevator.Elevator;

public class ElevatorServiceImpl implements ElevatorService {
    
    Map<String, Elevator> evelators = null;
    

    public ElevatorServiceImpl(Map<String, Elevator> elevatorsInput) throws IllegalArgumentException {
        if(elevatorsInput == null || elevatorsInput.size() < 1) {
            throw new IllegalArgumentException("Invalid Elevators Input Definition");
        }
        this.evelators = elevatorsInput;
    }

    @Override
    public FloorRequestStatus processFloorRequests(FloorRequest floorRequest) {
        FloorRequestStatus status = initStatus();
        
        try {
            Elevator elevator = findNearestElevator(floorRequest);
            //TODO
        } catch (Exception e) {
            status.updateFloorRequestStatus(FloorRequestStatusCode.FAILED, "Elevator has an unexpected failure");
            return status;
        }

        status.updateFloorRequestStatus(FloorRequestStatusCode.COMPLETED, "Elevator has completed route");
        return status;

    }

    private FloorRequestStatus initStatus() {
        return new FloorRequestStatus(FloorRequestStatusCode.PENDING, "Floor Request Status has been recieved by service");
    }

    //This method will decide which elevator to give floor request based on which elevator is "closest" to current request
    public Elevator findNearestElevator(FloorRequest floorRequest) throws Exception {
         if(evelators != null) {
             Elevator selectedElevator = null;
             int bestFloorDiff = -1;
             for(String key : evelators.keySet()) {
                Elevator currentElevator = evelators.get(key);

                int currentFloorDiff = Math.abs(currentElevator.getCurrentFloor().getFloorIndex() - convertFloorIdToFloorIndex(floorRequest.getCurrentFloorId()));
            
                if(bestFloorDiff == -1 || currentFloorDiff < bestFloorDiff) {
                    bestFloorDiff = currentFloorDiff;
                    selectedElevator = currentElevator;
                }
                if(currentFloorDiff == 0) {
                    return selectedElevator;
                }
             }

             return selectedElevator;
         }

         return null;
    }
    
    private int convertFloorIdToFloorIndex(int floorId) {
        return floorId - 1;
    }

}
