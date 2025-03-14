package com.runnejus.interview.service;

import java.util.Map;

import com.runnejus.interview.model.elevator.Elevator;
import com.runnejus.interview.request.FloorRequest;

public interface ElevatorSelector {
    public String findNearestElevator(FloorRequest floorRequest, Map<String, Elevator> elevatorMap);
}