package com.fdmgroup.flexdronewarehouse.exception;

/**
 * This class defines NotEnoughAccessException
 */
public class NotEnoughAccessRightException extends IllegalArgumentException {
    public NotEnoughAccessRightException(String msg) {
        super(msg);
    }

}
