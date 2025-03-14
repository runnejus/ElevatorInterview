package com.runnejus.interview.service;

import java.util.Map;

import com.runnejus.interview.model.elevator.Elevator;
import com.runnejus.interview.request.FloorRequest;

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
