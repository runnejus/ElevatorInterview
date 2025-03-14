package com.runnejus.interview.controller;

import com.runnejus.interview.request.FloorRequest;
import com.runnejus.interview.response.FloorRequestResponse;

public interface ElevatorController {
    public FloorRequestResponse userRequestsFloor(FloorRequest floorRequestInput);
}