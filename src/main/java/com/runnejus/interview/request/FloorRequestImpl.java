package com.runnejus.interview.request;

import java.util.TreeSet;

/*
 * class FloorRequestImpl is a request object that allows a user to request a function of the elevator
 * Request will contain a list of floors that the user would like to travel to and will include where the user currently resides
 * 
 */
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
