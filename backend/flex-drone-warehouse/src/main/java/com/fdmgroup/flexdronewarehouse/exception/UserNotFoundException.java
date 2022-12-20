package com.fdmgroup.flexdronewarehouse.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * User is not found in the database.
 *
 */
@ResponseStatus( code = HttpStatus.NOT_FOUND, reason = "Bad Authentication")
public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(){}

    public UserNotFoundException(String message) {
        super(message);
    }
}
