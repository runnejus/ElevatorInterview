package com.runnejus.interview.exception;

public class IllegalFloorRequestException extends Exception {

    public IllegalFloorRequestException(String message) {
        super(message);
    }

    public IllegalFloorRequestException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalFloorRequestException(Throwable cause) {
        super(cause);
    }
}