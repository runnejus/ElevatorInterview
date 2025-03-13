package com.runnejus.interview.request;

import java.util.Set;

public interface FloorRequest {
    public Set<Integer> getFloorIdsRequested(); 
    public int getCurrentFloorId();
}
