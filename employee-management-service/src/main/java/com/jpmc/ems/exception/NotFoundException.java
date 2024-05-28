package com.jpmc.ems.exception;

/**
 * This exception can be used to represent and handle business-related errors
 * in the application,where the errorCode can be used to provide more detailed
 * information about the error that occurred.
 */

public class NotFoundException extends RuntimeException {

    private final int errorCode;

    public NotFoundException(int errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public NotFoundException(int errorCode, String message, Throwable rootCause) {
        super(message, rootCause);
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }
}
