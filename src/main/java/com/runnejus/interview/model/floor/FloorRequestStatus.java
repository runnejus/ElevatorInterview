package com.runnejus.interview.model.floor;

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