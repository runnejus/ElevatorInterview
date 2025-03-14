package com.runnejus.interview.service;

import java.util.Map;

import com.runnejus.interview.model.elevator.Elevator;
import com.runnejus.interview.request.FloorRequest;

/*
 * class ElevatorSelectorImpl takes in a floorRequest and compares that where the elevators are currently
 * It will pick the elevator that is closest to where the user is currently located
 * If both elevators are the same distances away from each other it will pick the first elevator
 */
public class ElevatorSelectorImpl implements ElevatorSelector {

    @Override
    public String findNearestElevator(FloorRequest floorRequest, Map<String, Elevator> elevatorMap) {
        if(elevatorMap != null) {
            int bestFloorDiff = -1;
            String selectedKey = null;
            for(String key : elevatorMap.keySet()) {
               Elevator currentElevator = elevatorMap.get(key);

               int currentFloorDiff = Math.abs(currentElevator.getCurrentFloor().getFloorIndex() - convertFloorIdToFloorIndex(floorRequest.getCurrentFloorId()));
           
               if(bestFloorDiff == -1 || currentFloorDiff < bestFloorDiff) {
                   bestFloorDiff = currentFloorDiff;
                   selectedKey = key;
               }
               if(currentFloorDiff == 0) {
                   return key;
               }
            }

            return selectedKey;
        }

        return null;
    }

    private int convertFloorIdToFloorIndex(int floorId) {
        return floorId - 1;
    }

    
}
