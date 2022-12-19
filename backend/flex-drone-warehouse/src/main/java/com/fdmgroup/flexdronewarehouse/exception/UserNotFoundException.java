package com.fdmgroup.flexdronewarehouse.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception for when a no user matches.
 * 
 * @author Yutta, Summer
 *
 */
@ResponseStatus( code = HttpStatus.NOT_FOUND, reason = "User not found")
public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(){}

    public UserNotFoundException(String message) {
        super(message);
    }
}
