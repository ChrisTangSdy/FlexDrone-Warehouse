package com.fdmgroup.flexdronewarehouse.util;

import com.fdmgroup.flexdronewarehouse.exception.UserNotFoundException;
import lombok.Data;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * User details for spring security
 *
 * @author Chris
 */
@Data
public class WarehouseUserDetails implements UserDetails {

    private long id;

    private String username;

    private String password;

    private String email;

    private Collection<? extends GrantedAuthority> authorities;

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }



}
