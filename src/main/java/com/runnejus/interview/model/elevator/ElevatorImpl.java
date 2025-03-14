package com.runnejus.interview.model.elevator;

import java.util.List;

import com.runnejus.interview.exception.IllegalFloorRequestException;
import com.runnejus.interview.model.floor.FloorIdentifier;

/*
 * class +{@code ElevatorImpl} implements Elevator interface
 * 
 * totalFloors - are the total number of floors that the elevator goes up to
 * defaultFloor - this is where the elevator starts at when application starts
 * floors - list of all the floor identifiers that an elevator can stop at
 * elevatorDoorStatusCode - provides a status code enum of either open or closed
 * currentFloor - provides an identifier where the eleivator currently resides
 */
public class ElevatorImpl implements Elevator{
    
    private Integer totalFloors = null;
    private int defaultFloor = 0;
    private List<FloorIdentifier> floors;
    private ElevatorDoorStatusCode elevatorDoorStatusCode = ElevatorDoorStatusCode.CLOSED;
    private FloorIdentifier currentFloor;

    public ElevatorImpl(List<FloorIdentifier> floorsInput) throws IllegalArgumentException {
    
        if(floorsInput == null || floorsInput.size() < 1) {
            throw new IllegalArgumentException("Invalid Floors Input Definition");
        }
        this.totalFloors = floorsInput.size();

        
        this.floors = floorsInput;
        this.currentFloor = this.floors.get(defaultFloor);
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
        System.out.println(this.currentFloor);
        return this.currentFloor;
    }

    public void setCurrentFloor(FloorIdentifier floorIdentifer) {
        this.currentFloor = floorIdentifer;
    }

    /*
     * method moveUpOneFloor
     * 
     * moves the elevator up one level
     * throws IllegalFloorRequestException if request is invalid
     */
    @Override
    public void moveUpOneFloor() throws IllegalFloorRequestException {
        if(this.getCurrentFloor().getFloorIndex() < this.getTotalFloors()-1) {
            int floorIndex = this.getCurrentFloor().getFloorIndex();
            int nextFloorIndex = floorIndex + 1;
            this.setCurrentFloor(floors.get(nextFloorIndex));
        } else {
            throw new IllegalFloorRequestException("Invalid Floor Request, Floor is not available");
        }
    }

    /*
     * method moveDownOneFloor
     * 
     * moves the elevator down one level
     * throws IllegalFloorRequestException if request is invalid
     */
    @Override
    public void moveDownOneFloor() throws IllegalFloorRequestException {
        if(this.getCurrentFloor().getFloorIndex() > 0) {
            int floorIndex = this.getCurrentFloor().getFloorIndex(); 
            int nextFloorIndex = floorIndex - 1;
            this.setCurrentFloor(floors.get(nextFloorIndex));
        } else {
            throw new IllegalFloorRequestException("Invalid Floor Request, Floor is not available");
        }
    }

    @Override
    public void setCurrentFloor(int floorIndex) {
        this.setCurrentFloor(this.floors.get(floorIndex));
    }

    /*
     * stopAtFloor method
     * elevator will move to destinationed floor index whether that is up or down from its current location
     * @param floorIndex - zero index value for where the elevator should stop
     * 
     */
    @Override
    public void stopAtFloor(int floorIndex) throws IllegalFloorRequestException {
        //which direction does the elevator need to go?

        int currentFloorIndex = this.currentFloor.getFloorIndex();
        if(currentFloorIndex == floorIndex) {
            this.openElevatorDoors();
        }
        
        if(this.currentFloor.getFloorIndex() < floorIndex) {
            moveElevatorUpUntilDest(currentFloorIndex, floorIndex);
        } else {
            moveElevatorDownUntilDest(currentFloorIndex, floorIndex);
        }
    }

    private void moveElevatorUpUntilDest(int currentFloorIndex, int floorIndex) throws IllegalFloorRequestException {
        for(int count = 0; currentFloorIndex + count < floorIndex; count++) {
            this.moveUpOneFloor();
        }
        this.openElevatorDoors();
    }

    private void moveElevatorDownUntilDest(int currentFloorIndex, int floorIndex) throws IllegalFloorRequestException {
        for(int count = 0; currentFloorIndex - count < floorIndex; count++) {
            this.moveDownOneFloor();
        }
        this.openElevatorDoors();
    }

    @Override
    public ElevatorDoorStatusCode getCurrentDoorStatusCode() {
        return this.elevatorDoorStatusCode;
    }

    

}
