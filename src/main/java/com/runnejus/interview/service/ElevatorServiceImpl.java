package com.runnejus.interview.service;

import com.runnejus.interview.requesthandler.FloorRequestHandler;
import java.util.Map;

import com.runnejus.interview.model.elevator.ElevatorKey;
import com.runnejus.interview.request.FloorRequest;
import com.runnejus.interview.model.floor.FloorRequestStatus;
import com.runnejus.interview.model.floor.FloorRequestStatusCode;
import com.runnejus.interview.model.elevator.Elevator;

public class ElevatorServiceImpl implements ElevatorService {
    
    FloorRequestHandler floorRequestHandler = null;
    Map<ElevatorKey, Elevator> evelators = null;
    

    public ElevatorServiceImpl(FloorRequestHandler floorRequestHandler, Map<ElevatorKey, Elevator> elevators) {
        this.floorRequestHandler = floorRequestHandler;
        this.evelators = elevators;
    }

    @Override
    public FloorRequestStatus processFloorRequests(FloorRequest floorRequest) {
        FloorRequestStatus status = initStatus();
        
        try {
            Elevator elevator = findNearestElevator(floorRequest);
            //TODO
        } catch (Exception e) {
            
        }

        status.updateFloorRequestStatus(FloorRequestStatusCode.COMPLETED, "Elevator has completed route");
        return status;

    }

    private FloorRequestStatus initStatus() {
        return new FloorRequestStatus(FloorRequestStatusCode.PENDING, "Floor Request Status has been recieved by service");
    }

    //This method will decide which elevator to give floor request based on which elevator is "closest" to current request
    private Elevator findNearestElevator(FloorRequest floorRequest) throws Exception {
         if(evelators != null) {
             Elevator selectedElevator = null;
             int bestFloorDiff = -1;
             for(ElevatorKey key : evelators.keySet()) {
                Elevator currentElevator = evelators.get(key);

                int currentFloorDiff = Math.abs(currentElevator.getCurrentFloor().getFloorIndex() - floorRequest.getCurrentFloor().getFloorIndex());
            
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

         //TODO write exception handling when elevators are not initialized
         throw new Exception("Invalid Configuration");

         
    }    

}
