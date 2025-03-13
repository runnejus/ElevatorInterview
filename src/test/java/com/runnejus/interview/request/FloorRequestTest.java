package com.runnejus.interview.request;

import org.junit.jupiter.api.Test;
import com.runnejus.interview.util.TestUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FloorRequestTest {
    
    @Test
    public void createRequestFloorOneToFloorTwo() {
        FloorRequest floorRequest = TestUtils.createRequest();

        assertEquals(TestUtils.currentFloorIndex, floorRequest.getCurrentFloor().getFloorId());
        assertNotNull(floorRequest);
        assertNotNull(floorRequest.getFloorsRequested());
        assertTrue(floorRequest.getFloorsRequested().contains(TestUtils.nextFloorIdentifier));
    }
}
