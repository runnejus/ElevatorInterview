package com.runnejus.interview.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.junit.jupiter.api.Test;


import com.runnejus.interview.request.FloorRequest;
import com.runnejus.interview.util.TestUtils;
import com.runnejus.interview.model.floor.FloorIdentifier;
import com.runnejus.interview.model.floor.FloorRequestStatus;
import com.runnejus.interview.model.floor.FloorRequestStatusCode;
import com.runnejus.interview.model.elevator.Elevator;
import com.runnejus.interview.model.elevator.ElevatorImpl;

public class ElevatorServiceTest {
    private ElevatorService elevatorService = null;

    private Map<String, Elevator> elevators;

    @Test
    public void processFloorRequestMoveElevatorFromFloorOneToFloorTwo() throws Exception{
        // Create a request
        FloorRequest floorRequest = TestUtils.createRequest();

        createSampleElevators();
        elevatorService = new ElevatorServiceImpl(elevators);
        FloorRequestStatus status = elevatorService.processFloorRequests(floorRequest);   
        
        assertTrue(status != null);
        assertEquals(FloorRequestStatusCode.COMPLETED, status.getFloorStatusCode());
    }

    private void createSampleElevators() {
        String keyA = "A";
        String keyB = "B";

        List<FloorIdentifier> floorsInput = TestUtils.createFloorsInput();
        Elevator elevatorA = new ElevatorImpl(floorsInput);
        Elevator elevatorB = new ElevatorImpl(floorsInput);

        elevators = new HashMap<String, Elevator>();
        elevators.put(keyA, elevatorA);
        elevators.put(keyB, elevatorB);
    }
}

