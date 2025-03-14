package com.runnejus.interview.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.times;

import java.util.Map;
import java.util.HashMap;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.runnejus.interview.request.FloorRequest;
import com.runnejus.interview.util.TestUtils;
import com.runnejus.interview.model.floor.FloorIdentifier;
import com.runnejus.interview.model.floor.FloorRequestStatus;
import com.runnejus.interview.model.floor.FloorRequestStatusCode;
import com.runnejus.interview.model.elevator.Elevator;

public class ElevatorServiceTest {
    private ElevatorService elevatorService = null;

    private Elevator mockElevatorA;
    private Elevator mockElevatorB;
    private FloorIdentifier mockFloorIdentifierA;
    private FloorIdentifier mockFloorIdentifierB;
    private Map<String, Elevator> elevators;

    @Test
    public void processFloorRequestMoveElevatorFromFloorOneToFloorTwo() throws Exception{
        // Create a floor request
        FloorRequest floorRequest = TestUtils.createRequest();

        mockElevatorA = Mockito.mock(Elevator.class);
        mockElevatorB = Mockito.mock(Elevator.class);
        mockFloorIdentifierA = Mockito.mock(FloorIdentifier.class);
        mockFloorIdentifierB = Mockito.mock(FloorIdentifier.class);
        Mockito.when(mockElevatorA.getCurrentFloor()).thenReturn(mockFloorIdentifierA);
        Mockito.when(mockElevatorB.getCurrentFloor()).thenReturn(mockFloorIdentifierB);
        Mockito.when(mockFloorIdentifierA.getFloorIndex()).thenReturn(0);
        Mockito.when(mockFloorIdentifierB.getFloorIndex()).thenReturn(0);

        createSampleElevators();
        elevatorService = new ElevatorServiceImpl(elevators);
        FloorRequestStatus status = elevatorService.processFloorRequests(floorRequest);   
        
        Mockito.verify(mockElevatorA, atLeastOnce()).getCurrentFloor();
        Mockito.verify(mockElevatorA, times(1)).stopAtFloor(1);
        
        assertTrue(status != null);
        assertEquals(FloorRequestStatusCode.COMPLETED, status.getFloorStatusCode());
    }

    private void createSampleElevators() {
        String keyA = "A";
        String keyB = "B";
        
        elevators = new HashMap<String, Elevator>();
        elevators.put(keyA, mockElevatorA);
        elevators.put(keyB, mockElevatorB);
    }
}

