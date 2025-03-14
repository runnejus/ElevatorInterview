package com.runnejus.interview.exception;

/*
 * Class IllegalFloorRequestException is an exception class to handle when an unexpected error requesting a floor that doesn't exist
 */
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