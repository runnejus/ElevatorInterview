package com.runnejus.interview.request;

import java.util.Set;

import com.runnejus.interview.model.floor.FloorIdentifier;


public interface FloorRequest {
    public static final Set<FloorIdentifier> floorsRequested = null;
    public static final FloorIdentifier currentFloor = null;

    public Set<FloorIdentifier> getFloorsRequested();
    public FloorIdentifier getCurrentFloor();
}
