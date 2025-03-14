package com.runnejus.interview.model.floor;

/*
 * class FloorRequestStatus
 * 
 * provides a basic status of request of whether it failed or succeeded as well as a description of the status
 * 
 */
public class FloorRequestStatus {
    private FloorRequestStatusCode floorRequestStatusCode;
    private String floorStatusDescription;

    public FloorRequestStatus(FloorRequestStatusCode floorRequestStatusCode, String floorStatusDescription) {
        this.floorRequestStatusCode = floorRequestStatusCode;
        this.floorStatusDescription = floorStatusDescription;
    }

    public FloorRequestStatusCode getFloorStatusCode() {
        return this.floorRequestStatusCode;
    }

    public String getFloorStatusDescription() {
        return this.floorStatusDescription;
    }

    public void updateFloorRequestStatus(FloorRequestStatusCode floorRequestStatusCode, String floorStatusDescription) {
        this.floorRequestStatusCode = floorRequestStatusCode;
        this.floorStatusDescription = floorStatusDescription;
    }
}