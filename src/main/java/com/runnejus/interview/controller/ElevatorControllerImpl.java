package com.runnejus.interview.controller;

import com.runnejus.interview.model.floor.FloorRequestStatus;
import com.runnejus.interview.request.FloorRequest;
import com.runnejus.interview.response.FloorRequestResponse;
import com.runnejus.interview.response.FloorRequestResponseImpl;
import com.runnejus.interview.service.ElevatorService;

/*
 *  This class is the {@code ElevatorControllerImpl} class (implements from ElevatorController) that will allow for users to interact with the Elevator 
 *  by passing FloorRequest objects.
 * 
 */
public class ElevatorControllerImpl implements ElevatorController {

    private ElevatorService elevatorService;

    public ElevatorControllerImpl(ElevatorService elevatorService) {
        this.elevatorService = elevatorService;
    }
 
    /*
     * The userRequestsFloor method will return FloorRequestResponse which will return an object describing the status of the response
     * Delegates to the elevator service to perform specific operations on an elevator
     * 
     * @param floorRequestInput - request object that contains details of where user would like to travel on elevator
     * @return FloorRequestResponse - response object to communicate status of request 
     */
    public FloorRequestResponse userRequestsFloor(FloorRequest floorRequestInput) {
        FloorRequestStatus status = elevatorService.processFloorRequests(floorRequestInput);       
        return createFloorRequestResponseFromStatus(status, floorRequestInput);
    }

    /*
     * The createFloorRequestResponseForStatus method creates a FloorRequestResponse to provide insights to user on result of operations
     * 
     * @param status - returned status from service 
     * @param floorRequestInput - original request that was made by user
     * @return FloorRequestResponse - response of 
     */
    private FloorRequestResponse createFloorRequestResponseFromStatus(FloorRequestStatus status, FloorRequest floorRequestInput) {
        return new FloorRequestResponseImpl(status, floorRequestInput);
    }
}
