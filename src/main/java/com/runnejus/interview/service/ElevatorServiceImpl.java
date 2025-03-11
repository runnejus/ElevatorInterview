package com.runnejus.interview.service;

import com.runnejus.interview.requesthandler.FloorRequestHandler;
import java.util.Map;
import com.runnejus.interview.model.Elevator;
import com.runnejus.interview.model.ElevatorKey;
import com.runnejus.interview.request.FloorRequest;
import com.runnejus.interview.model.FloorRequestStatus;
import com.runnejus.interview.model.FloorRequestStatusCode;

public class ElevatorServiceImpl implements ElevatorService {
    
    FloorRequestHandler floorRequestHandler = null;
    Map<ElevatorKey, Elevator> evelators = null;
    

    private ElevatorServiceImpl(FloorRequestHandler floorRequestHandler, Map<ElevatorKey, Elevator> elevators) {
        this.floorRequestHandler = floorRequestHandler;
        this.evelators = elevators;
    }

    @Override
    public FloorRequestStatus processFloorRequests(FloorRequest floorRequest) {
        FloorRequestStatus status = initStatus();
        
        Elevator elevator = findNearestElevator(floorRequest);

        return null;

    }

    private FloorRequestStatus initStatus() {
        return new FloorRequestStatus(FloorRequestStatusCode.PENDING, "Floor Request Status has been recieved by service");
    }

    private Elevator findNearestElevator(FloorRequest floorRequest) {
        if(evelators != null) {
            Elevator selectedElevator = null;
            for(ElevatorKey key : evelators.keySet()) {
                
            }
        }

        //TODO write exception handling when elevators are not initialized
        return null;
    }    

}
