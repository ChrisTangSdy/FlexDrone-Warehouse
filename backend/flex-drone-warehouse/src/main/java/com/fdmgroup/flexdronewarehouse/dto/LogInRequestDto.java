package com.fdmgroup.flexdronewarehouse.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;


/**
 * LogIn Data sent from frontend
 * @author Chris
 */
@Data
@NoArgsConstructor
public class LogInRequestDto {
    public static final String USERNAME_EMPTY = "Username cannot be empty";
    public static final String PASSWORD_EMPTY = "Password cannot be empty";
    @NotBlank(message = USERNAME_EMPTY)
    private String username;
    @NotBlank(message = PASSWORD_EMPTY)
    private String password;

}
