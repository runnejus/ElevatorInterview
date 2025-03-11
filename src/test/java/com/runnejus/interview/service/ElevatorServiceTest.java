package com.runnejus.interview.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


import org.junit.jupiter.api.Test;
import com.runnejus.interview.request.FloorRequest;
import com.runnejus.interview.util.TestUtils;
import com.runnejus.interview.model.FloorRequestStatus;
import com.runnejus.interview.model.FloorRequestStatusCode;

public class ElevatorServiceTest {
    private ElevatorService elevatorService = null;

    @Test
    public void processFloorRequestMoveElevatorFromFloorOneToFloorTwo() {
        // Create a request
        FloorRequest floorRequest = TestUtils.createRequest();

        // Hand off to handler
        FloorRequestStatus status = elevatorService.processFloorRequests(floorRequest);   
        assertTrue(status != null);
        assertEquals(FloorRequestStatusCode.COMPLETED, status.getFloorStatusCode());
    }
}
