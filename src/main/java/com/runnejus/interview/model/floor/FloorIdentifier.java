package com.runnejus.interview.model.floor;

/*
 * Model class FloorIdentifier is a representation of Floor that the elevator will stop at.
 * This class contains a floorIndex which is a zero index number to describe position
 * FloorId contains a number representation of the floor (ex: Floor 4)
 * FloorName contains a string description of the floor so that the user can understand what is available at the floor
 * Constructor provided with the ability to create object with provided all three elements
 */
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