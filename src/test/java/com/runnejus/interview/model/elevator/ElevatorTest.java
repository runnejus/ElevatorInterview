package com.runnejus.interview.model.elevator;

import org.junit.jupiter.api.Test;

import com.runnejus.interview.exception.IllegalFloorRequestException;
import com.runnejus.interview.model.floor.FloorIdentifier;

import java.util.List;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ElevatorTest {
    
    private Elevator elevator = null;

    private Integer totalFloorsDefault = 10;

    private List<FloorIdentifier> floorsInput;

    public void initFloorsInput() {
        floorsInput = new ArrayList<FloorIdentifier>();
        floorsInput.add(new FloorIdentifier(0, 1, "Lobby"));
        floorsInput.add(new FloorIdentifier(1, 2, "Gym"));
        floorsInput.add(new FloorIdentifier(2, 3, "Floor 3"));
        floorsInput.add(new FloorIdentifier(3, 4, "Floor 4"));
        floorsInput.add(new FloorIdentifier(4, 5, "Floor 5"));
        floorsInput.add(new FloorIdentifier(5, 6, "Floor 6"));
        floorsInput.add(new FloorIdentifier(6, 7, "Floor 7"));
        floorsInput.add(new FloorIdentifier(7, 8, "Floor 8"));
        floorsInput.add(new FloorIdentifier(8, 9, "Floor 9"));
        floorsInput.add(new FloorIdentifier(9, 10, "Penthouse"));
    }

    @Test
    public void invalidEvelatorConstructorNullTotalFloors() {
        floorsInput = null;
        
        assertThrows(IllegalArgumentException.class, () -> new ElevatorImpl(floorsInput)) ;
    }
    

    @Test
    public void getTotalFloorsTest() {
        initFloorsInput();

        elevator = new ElevatorImpl(floorsInput);
        assertEquals(totalFloorsDefault, elevator.getTotalFloors());
    }

    @Test
    public void getCurrentFloorDefaultOne() {
        initFloorsInput();

        elevator = new ElevatorImpl(floorsInput);

        int defaultStartFloor = 1;
        assertEquals(defaultStartFloor, elevator.getCurrentFloor().getFloorId());
        assertEquals("Lobby", elevator.getCurrentFloor().getFloorName());
    }

    @Test
    public void moveUpOneFloorGoFromOneToTwo() throws Exception{
        initFloorsInput();

        elevator = new ElevatorImpl(floorsInput);

        //int defaultStartFloor = 1; +1
        int destinationFloor = 2;

        elevator.moveUpOneFloor();
        

        System.out.println(floorsInput.get(1));
        assertEquals(destinationFloor-1, elevator.getCurrentFloor().getFloorIndex());
        assertEquals(destinationFloor, elevator.getCurrentFloor().getFloorId());
    }

    @Test
    public void invalidRequestToGoFromOneDown() throws Exception{
        initFloorsInput();

        elevator = new ElevatorImpl(floorsInput);

        //not possible to go to floor 0 doesn't exist

        assertThrows(IllegalFloorRequestException.class, () -> elevator.moveDownOneFloor());
    }

    @Test
    public void invalidRequestToGoFrom10UpOneMoreFloor() throws Exception{
        initFloorsInput();

        elevator = new ElevatorImpl(floorsInput);
        elevator.setCurrentFloor(9);
        //not possible to go to floor 11 doesn't exist

        assertThrows(IllegalFloorRequestException.class, () -> elevator.moveUpOneFloor());
    }

    @Test
    public void moveDwonOneFloorGoFromTwoToOne() throws Exception{
        initFloorsInput();

        elevator = new ElevatorImpl(floorsInput);
        elevator.setCurrentFloor(1); //floor level 2
        int initFloor = 2;
        assertEquals(initFloor, elevator.getCurrentFloor().getFloorId());
        assertEquals(initFloor-1, elevator.getCurrentFloor().getFloorIndex());

        int destinationFloor = 1;
        elevator.moveDownOneFloor();
        assertEquals(destinationFloor, elevator.getCurrentFloor().getFloorId());
        assertEquals(destinationFloor -1, elevator.getCurrentFloor().getFloorIndex());
    }

    @Test
    public void stopAtFloorFiveStartingAtFloorOne() throws Exception{
        initFloorsInput();

        elevator = new ElevatorImpl(floorsInput);

        int floorIndex = 4; //floor 5
        int floorId = 5;
        elevator.stopAtFloor(4);

        //when the elevator stops at floor 5 the doors should open
        assertEquals(floorIndex, elevator.getCurrentFloor().getFloorIndex());
        assertEquals(floorId, elevator.getCurrentFloor().getFloorId());
        assertEquals(ElevatorDoorStatusCode.OPEN, elevator.getCurrentDoorStatusCode());

    }

    

}
