package com.runnejus.interview.model;

public class ElevatorImpl implements Elevator{
    
    private Integer totalFloors = null;
    private Integer defaultFloor = 1;
    private ElevatorDoorStatusCode elevatorDoorStatusCode = ElevatorDoorStatusCode.CLOSED;
    private FloorIdentifier currentFloor = new FloorIdentifier(defaultFloor);

    public ElevatorImpl(Integer totalFloors) {
        //TODO validate totalFloors is not null and greater than 0
        this.totalFloors = totalFloors;
    }

    public int getTotalFloors() {
        return totalFloors;
    }

    @Override
    public void openElevatorDoors() {
        if(elevatorDoorStatusCode == ElevatorDoorStatusCode.CLOSED) {
            elevatorDoorStatusCode = ElevatorDoorStatusCode.OPEN;
        }
    }

    @Override
    public void closeElevatorDoors() {
        if(elevatorDoorStatusCode == ElevatorDoorStatusCode.OPEN) {
            elevatorDoorStatusCode = ElevatorDoorStatusCode.CLOSED;
        }
    }

    public FloorIdentifier getCurrentFloor() {
        return this.currentFloor;
    }

}
