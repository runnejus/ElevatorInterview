package com.runnejus.interview.model.elevator;

import com.runnejus.interview.exception.IllegalFloorRequestException;
import com.runnejus.interview.model.ElevatorDoorStatusCode;
import com.runnejus.interview.model.FloorIdentifier;

public interface Elevator {
    
    public int getTotalFloors();
    public FloorIdentifier getCurrentFloor();
    public void setCurrentFloor(int floorIndex);
    public void moveUpOneFloor() throws IllegalFloorRequestException;
    public void moveDownOneFloor() throws IllegalFloorRequestException;
    public void stopAtFloor(int floorIndex) throws IllegalFloorRequestException;
    public void openElevatorDoors();
    public void closeElevatorDoors();
    public ElevatorDoorStatusCode getCurrentDoorStatusCode();
}
