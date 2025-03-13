package com.runnejus.interview.request;

import java.util.Set;

import com.runnejus.interview.model.floor.FloorIdentifier;


public class FloorRequestImpl implements FloorRequest {

    private Set<FloorIdentifier> floorsRequested;
    private FloorIdentifier currentFloor;

    public FloorRequestImpl(Set<FloorIdentifier> floorsRequested, FloorIdentifier currentFloor) {
        //TODO validate that request is valid, floor requested must not match current floor
        
        this.floorsRequested = floorsRequested;
        this.currentFloor = currentFloor;
    }

    public Set<FloorIdentifier> getFloorsRequested() {
        return this.floorsRequested;
    }

    public FloorIdentifier getCurrentFloor() {
        return this.currentFloor;
    }
}
