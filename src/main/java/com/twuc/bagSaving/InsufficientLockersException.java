package com.twuc.bagSaving;

public class InsufficientLockersException extends RuntimeException {
    public InsufficientLockersException(String message) {
        super(message);
    }
}
