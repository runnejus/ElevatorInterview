package com.runnejus.interview.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Map;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.runnejus.interview.request.FloorRequest;
import com.runnejus.interview.requesthandler.FloorRequestHandler;
import com.runnejus.interview.util.TestUtils;
import com.runnejus.interview.model.ElevatorKey;
import com.runnejus.interview.model.FloorRequestStatus;
import com.runnejus.interview.model.FloorRequestStatusCode;
import com.runnejus.interview.model.elevator.Elevator;

public class ElevatorServiceTest {
    private ElevatorService elevatorService = null;

    private FloorRequestHandler mockFloorRequestHandler;
    private Map<ElevatorKey, Elevator> mockElevators;

    @Test
    public void processFloorRequestMoveElevatorFromFloorOneToFloorTwo() throws Exception{
        // Create a request
        FloorRequest floorRequest = TestUtils.createRequest();

        mockFloorRequestHandler = Mockito.mock(FloorRequestHandler.class);
        mockElevators = (Map<ElevatorKey, Elevator>)Mockito.mock(Map.class);

        elevatorService = new ElevatorServiceImpl(mockFloorRequestHandler, mockElevators);
        FloorRequestStatus status = elevatorService.processFloorRequests(floorRequest);   
        
        assertTrue(status != null);
        assertEquals(FloorRequestStatusCode.COMPLETED, status.getFloorStatusCode());
    }


}
