package com.runnejus.interview.util;

import java.util.HashSet;
import java.util.Set;

import com.runnejus.interview.model.FloorIdentifier;
import com.runnejus.interview.request.FloorRequest;
import com.runnejus.interview.request.FloorRequestImpl;

public class TestUtils {
    public static int currentFloorIndex = 1;
    public static int nextFloorIndex = 2;
    public static FloorIdentifier nextFloorIdentifier = createNextFloorIdentifier();
    
    //This helper method creates a request for the elevator to go from floor one to floor two
    public static FloorRequest createRequest() {
        Set<FloorIdentifier> floorsRequested = new HashSet<FloorIdentifier>();
        floorsRequested.add(nextFloorIdentifier);
        FloorIdentifier currentFloor = new FloorIdentifier(currentFloorIndex);
        FloorRequest floorRequest = new FloorRequestImpl(floorsRequested, currentFloor);
        return floorRequest;
    }

    public static FloorIdentifier createNextFloorIdentifier() {
        return new FloorIdentifier(nextFloorIndex);
    }
}
