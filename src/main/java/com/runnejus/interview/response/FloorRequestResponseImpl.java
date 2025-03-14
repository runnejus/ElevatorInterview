package com.runnejus.interview.response;

import com.runnejus.interview.model.floor.FloorRequestStatus;
import com.runnejus.interview.request.FloorRequest;

/*
 * class FloorRequestResponseImpl will handle reporting back to the user.
 * Controller will pass back the response object on the status of what occurred processing the requests from the users
 * 
 */
public class FloorRequestResponseImpl implements FloorRequestResponse {

    private FloorRequestStatus floorRequestStatus;
    private FloorRequest floorRequest;

    public FloorRequestResponseImpl(FloorRequestStatus floorRequestStatus, FloorRequest floorRequest) {
        this.floorRequestStatus = floorRequestStatus;
        this.floorRequest = floorRequest;
    }

    @Override
    public String getResponse() {
        return "{Response=[floorRequestStatus="+floorRequestStatus.getFloorStatusCode()+", floorRequest="+floorRequest+"]}";
    }
    
}
