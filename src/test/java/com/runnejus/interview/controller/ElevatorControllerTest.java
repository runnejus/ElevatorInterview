package com.runnejus.interview.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.runnejus.interview.model.floor.FloorRequestStatus;
import com.runnejus.interview.model.floor.FloorRequestStatusCode;
import com.runnejus.interview.request.FloorRequest;
import com.runnejus.interview.response.FloorRequestResponse;
import com.runnejus.interview.service.ElevatorService;
import com.runnejus.interview.util.TestUtils;

public class ElevatorControllerTest {
    
    private ElevatorController controller;
    private ElevatorService mockService;

    @Test
    public void successfulCallToServiceFromController() {
        FloorRequest floorRequest = TestUtils.createRequest();
        mockService = Mockito.mock(ElevatorService.class);
        FloorRequestStatus status = new FloorRequestStatus(FloorRequestStatusCode.COMPLETED, "Elevator has completed route");
        Mockito.when(mockService.processFloorRequests(floorRequest)).thenReturn(status);

        
        controller = new ElevatorControllerImpl(mockService);
        FloorRequestResponse statusReturned = controller.userRequestsFloor(floorRequest);
        assertNotNull(statusReturned);
        
    }

    @Test
    public void unsuccessfulCallFromServiceToController() {
        FloorRequest floorRequest = TestUtils.createRequest();
        mockService = Mockito.mock(ElevatorService.class);
        FloorRequestStatus status = new FloorRequestStatus(FloorRequestStatusCode.FAILED, "Elevator had an unexpected failure");
        Mockito.when(mockService.processFloorRequests(floorRequest)).thenReturn(status);

        
        controller = new ElevatorControllerImpl(mockService);
        FloorRequestResponse statusReturned = controller.userRequestsFloor(floorRequest);
        assertNotNull(statusReturned);
    }
}
