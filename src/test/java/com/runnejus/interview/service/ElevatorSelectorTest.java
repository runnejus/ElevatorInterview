package com.runnejus.interview.service;

import org.junit.jupiter.api.Test;

import java.util.TreeSet;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.HashMap;

import com.runnejus.interview.model.elevator.Elevator;
import com.runnejus.interview.model.elevator.ElevatorImpl;
import com.runnejus.interview.request.FloorRequest;
import com.runnejus.interview.request.FloorRequestImpl;
import com.runnejus.interview.util.TestUtils;

public class ElevatorSelectorTest {
    
    ElevatorSelector selector;

    @Test
    public void basicSelectorTestOnlyOneElevator() {
        TreeSet<Integer> floorsRequest = new TreeSet<Integer>();
        floorsRequest.add(5);

        int defaultFloorId = 1;

        FloorRequest floorRequest = new FloorRequestImpl(floorsRequest, defaultFloorId);

        String elevatorKey = "A";

        Map<String, Elevator> elevatorMap = new HashMap<String, Elevator>();
        Elevator elevator = new ElevatorImpl(TestUtils.createFloorsInput());
        elevatorMap.put(elevatorKey, elevator);
        
        selector = new ElevatorSelectorImpl();
        String result = selector.findNearestElevator(floorRequest, elevatorMap);

        assertEquals(elevatorKey, result);    
    }

    @Test
    public void basicSelectorTestOnlyTwoElevators() {
        TreeSet<Integer> floorsRequest = new TreeSet<Integer>();
        floorsRequest.add(5);

        int defaultFloorId = 1;

        FloorRequest floorRequest = new FloorRequestImpl(floorsRequest, defaultFloorId);

        String elevatorKeyA = "A";
        String elevatorKeyB = "B";

        Map<String, Elevator> elevatorMap = new HashMap<String, Elevator>();
        Elevator elevatorA = new ElevatorImpl(TestUtils.createFloorsInput());
        Elevator elevatorB = new ElevatorImpl(TestUtils.createFloorsInput());
        elevatorA.setCurrentFloor(defaultFloorId);
        elevatorB.setCurrentFloor(defaultFloorId);
        elevatorMap.put(elevatorKeyA, elevatorA);
        elevatorMap.put(elevatorKeyB, elevatorB);
        
        selector = new ElevatorSelectorImpl();
        String result = selector.findNearestElevator(floorRequest, elevatorMap);

        assertEquals(elevatorKeyA, result);    
    }

    @Test
    public void haveElevatorThatIsCurrentlyOnSameFloor() {
        int requestFromFloorId = 5;
        
        TreeSet<Integer> floorsRequest = new TreeSet<Integer>();
        
        floorsRequest.add(6);

        int defaultFloorId = 1;

        FloorRequest floorRequest = new FloorRequestImpl(floorsRequest, requestFromFloorId);

        String elevatorKeyA = "A";
        String elevatorKeyB = "B";

        Map<String, Elevator> elevatorMap = new HashMap<String, Elevator>();
        Elevator elevatorA = new ElevatorImpl(TestUtils.createFloorsInput());
        Elevator elevatorB = new ElevatorImpl(TestUtils.createFloorsInput());
        elevatorA.setCurrentFloor(defaultFloorId);
        elevatorB.setCurrentFloor(requestFromFloorId);
        elevatorMap.put(elevatorKeyA, elevatorA);
        elevatorMap.put(elevatorKeyB, elevatorB);
        
        selector = new ElevatorSelectorImpl();
        String result = selector.findNearestElevator(floorRequest, elevatorMap);

        assertEquals(elevatorKeyB, result);    
    }

    @Test
    public void haveElevatorThatIsCurrentlyEqualDistance() {
        int requestFromFloorId = 4;
        int floorIdTwo = 2;
        int floorIdSix = 6;
        
        TreeSet<Integer> floorsRequest = new TreeSet<Integer>();
        floorsRequest.add(5);

        FloorRequest floorRequest = new FloorRequestImpl(floorsRequest, requestFromFloorId);

        String elevatorKeyA = "A";
        String elevatorKeyB = "B";

        Map<String, Elevator> elevatorMap = new HashMap<String, Elevator>();
        Elevator elevatorA = new ElevatorImpl(TestUtils.createFloorsInput());
        Elevator elevatorB = new ElevatorImpl(TestUtils.createFloorsInput());
        elevatorA.setCurrentFloor(floorIdTwo);
        elevatorB.setCurrentFloor(floorIdSix);
        elevatorMap.put(elevatorKeyA, elevatorA);
        elevatorMap.put(elevatorKeyB, elevatorB);
        
        selector = new ElevatorSelectorImpl();
        String result = selector.findNearestElevator(floorRequest, elevatorMap);

        assertEquals(elevatorKeyA, result);    
    }

    @Test
    public void nullElevatorMap() {
        selector = new ElevatorSelectorImpl();
        assertNull(selector.findNearestElevator(null, null));
    }
}
