package com.runnejus.interview.service;

import com.runnejus.interview.request.FloorRequest;
import com.runnejus.interview.model.FloorRequestStatus;

public interface ElevatorService {

      public FloorRequestStatus processFloorRequests(FloorRequest floorRequest) throws Exception;

      
}
