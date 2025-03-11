package com.runnejus.interview.requesthandler;

import com.runnejus.interview.request.FloorRequest;
import com.runnejus.interview.model.FloorRequestStatus;

public interface FloorRequestHandler {
    public FloorRequestStatus handle(FloorRequest floorRequest);
}
