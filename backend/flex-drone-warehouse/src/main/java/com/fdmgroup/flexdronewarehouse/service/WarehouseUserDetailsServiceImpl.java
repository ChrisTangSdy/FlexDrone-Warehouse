package com.fdmgroup.flexdronewarehouse.service;

import com.fdmgroup.flexdronewarehouse.exception.UserNotFoundException;
import com.fdmgroup.flexdronewarehouse.model.WarehouseUser;
import com.fdmgroup.flexdronewarehouse.util.WarehouseUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * Concrete class for the UserDetailService.
 * @author Chris
 */
@Service
@RequiredArgsConstructor
public class WarehouseUserDetailsServiceImpl implements UserDetailsService {

    private final WarehouseUserService userService;
    private final WarehouseUserDetails warehouseUserDetails;

    @Override
    public UserDetails loadUserByUsername(String username) {
        WarehouseUser user = userService.getWarehouseUserByUsername(username);
        List<SimpleGrantedAuthority> authorities = Collections.singletonList(new SimpleGrantedAuthority(user.getRole().toString()));
        return mapWarehouseUserToWarehouseUserDetails(user, authorities);
    }

    /**
     * Map the user to UserDetails.
     * @param user User
     * @return     UserDetails
     */
    protected WarehouseUserDetails mapWarehouseUserToWarehouseUserDetails(WarehouseUser user, List<SimpleGrantedAuthority> authorities) {

        warehouseUserDetails.setId(user.getId());
        warehouseUserDetails.setUsername(user.getUsername());
        warehouseUserDetails.setPassword(user.getPassword());
        warehouseUserDetails.setEmail(user.getEmail());
        warehouseUserDetails.setAuthorities(authorities);
        return warehouseUserDetails;
    }

    public static WarehouseUserDetails getWarehouseUserDetails() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        WarehouseUserDetails userDetails = (WarehouseUserDetails) authentication.getPrincipal();

        if (userDetails == null) throw new UserNotFoundException();
        return userDetails;
    }


}
