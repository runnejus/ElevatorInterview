package com.runnejus.interview.request;

import java.util.TreeSet;

public class FloorRequestImpl implements FloorRequest {

    private TreeSet<Integer> floorsRequested;
    private int currentFloorId;

    public FloorRequestImpl(TreeSet<Integer> floorsRequestedInput, int currentFloorIdInput) {    
        this.floorsRequested = floorsRequestedInput; 
        this.currentFloorId = currentFloorIdInput;
    }

    public TreeSet<Integer> getFloorIdsRequested() {
        return this.floorsRequested;
    }

    public int getCurrentFloorId() {
        return this.currentFloorId;
    }

    public String toString() {
        return "[floorsRequested="+floorsRequested + ", currentFloorId=" + currentFloorId + "]"; 
    }
}
