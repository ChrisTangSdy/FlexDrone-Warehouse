package com.fdmgroup.flexdronewarehouse.controller;

import com.fdmgroup.flexdronewarehouse.dto.LogInRequestDto;
import com.fdmgroup.flexdronewarehouse.util.WarehouseUserDetails;
import com.fdmgroup.flexdronewarehouse.util.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

import javax.validation.Valid;

/**
 * This class allows user to login
 *
 * @author Chris
 */
@RestController
@RequestMapping("/authenticate")
@RequiredArgsConstructor
@Slf4j
public class AuthenticationController {
    public static final String LOGIN = "/login";
    private  final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;

    @PostMapping(LOGIN)
    public ResponseEntity<String> LogIn(@Valid @RequestBody LogInRequestDto request){

        Authentication authentication =
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(),request.getPassword()));
        final WarehouseUserDetails warehouseUser = (WarehouseUserDetails) authentication.getPrincipal();

//        return warehouseUser != null ? ResponseEntity.ok(jwtUtils.generateToken(warehouseUser)): ResponseEntity.status(401).body("Bad Authentication");
          return ResponseEntity.ok(jwtUtils.generateToken(warehouseUser));
    }
}
