package com.runnejus.interview.util;

import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import com.runnejus.interview.model.floor.FloorIdentifier;
import com.runnejus.interview.request.FloorRequest;
import com.runnejus.interview.request.FloorRequestImpl;

public class TestUtils {
    public static int currentFloorId = 1;
    public static int nextFloorId = 2;
    
    //This helper method creates a request for the elevator to go from floor one to floor two
    public static FloorRequest createRequest() {
        Set<Integer> floorsRequested = new HashSet<Integer>();
        floorsRequested.add(nextFloorId);
        FloorRequest floorRequest = new FloorRequestImpl(floorsRequested, currentFloorId);
        return floorRequest;
    }

    public static List<FloorIdentifier> createFloorsInput() {
        List<FloorIdentifier> floorsInput = new ArrayList<FloorIdentifier>();
        floorsInput.add(new FloorIdentifier(0, 1, "Lobby"));
        floorsInput.add(new FloorIdentifier(1, 2, "Gym"));
        floorsInput.add(new FloorIdentifier(2, 3, "Floor 3"));
        floorsInput.add(new FloorIdentifier(3, 4, "Floor 4"));
        floorsInput.add(new FloorIdentifier(4, 5, "Floor 5"));
        floorsInput.add(new FloorIdentifier(5, 6, "Floor 6"));
        floorsInput.add(new FloorIdentifier(6, 7, "Floor 7"));
        floorsInput.add(new FloorIdentifier(7, 8, "Floor 8"));
        floorsInput.add(new FloorIdentifier(8, 9, "Floor 9"));
        floorsInput.add(new FloorIdentifier(9, 10, "Penthouse"));
        return floorsInput;
    }

}
