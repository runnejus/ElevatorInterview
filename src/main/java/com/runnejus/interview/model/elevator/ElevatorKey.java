package com.runnejus.interview.model.elevator;

public class ElevatorKey {
    private String elevatorId;

    private ElevatorKey(String elevatorId) {
        this.elevatorId = elevatorId;
    }

    public String elevatorId() {
        return elevatorId;
    }
}
