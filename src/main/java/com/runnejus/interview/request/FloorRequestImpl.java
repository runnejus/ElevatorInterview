package com.runnejus.interview.request;

import java.util.Set;

public class FloorRequestImpl implements FloorRequest {

    private Set<Integer> floorsRequested;
    private int currentFloorId;

    public FloorRequestImpl(Set<Integer> floorsRequestedInput, int currentFloorIdInput) {    
        this.floorsRequested = floorsRequestedInput;
        this.currentFloorId = currentFloorIdInput;
    }

    public Set<Integer> getFloorIdsRequested() {
        return this.floorsRequested;
    }

    public int getCurrentFloorId() {
        return this.currentFloorId;
    }
}
