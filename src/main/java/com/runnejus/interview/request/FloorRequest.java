package com.runnejus.interview.request;

import java.util.TreeSet;

public interface FloorRequest {
    public TreeSet<Integer> getFloorIdsRequested(); 
    public int getCurrentFloorId();
    public String toString();
}
