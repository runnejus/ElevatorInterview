package com.runnejus.interview.model;

public class FloorIdentifier {
    private int floorIndex;
    private int floorId;
    private String floorName;

    public FloorIdentifier(int floorIndex, int floorId, String floorName) {
        this.floorIndex = floorIndex;
        this.floorId = floorId;
        this.floorName = floorName;
    }

    public int getFloorIndex() {
        return this.floorIndex;
    }

    public int getFloorId() {
        return this.floorId;
    }

    public String getFloorName() {
        return this.floorName;
    }

    public String toString() {
        return "[index=" + this.floorIndex + ", id=" + this.floorId + ", name=" + this.floorName +"]";
    }
}