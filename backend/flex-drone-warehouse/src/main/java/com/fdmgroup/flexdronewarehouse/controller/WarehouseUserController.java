package com.fdmgroup.flexdronewarehouse.controller;

import com.fdmgroup.flexdronewarehouse.dto.StringDto;
import com.fdmgroup.flexdronewarehouse.exception.NotEnoughAccessRightException;
import com.fdmgroup.flexdronewarehouse.util.ApiResponse;
import com.fdmgroup.flexdronewarehouse.util.WarehouseUserDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.fdmgroup.flexdronewarehouse.service.WarehouseUserService;

import lombok.RequiredArgsConstructor;

import javax.validation.Valid;

/**
 * User CRUD operations.
 * @author Indrayutta, Summer
 *
 */

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/warehouse-users")
public class WarehouseUserController {
	
	private final WarehouseUserService warehouseUserService;
	private final WarehouseUserDetails warehouseUserDetails;
	private final PasswordEncoder passwordEncoder;
	
//	@GetMapping("/{id}")
//	public ResponseEntity<WarehouseUserDto> getUserById(@PathVariable long id){
//		return new ResponseEntity<>( (warehouseUserService.findUserById(id)), HttpStatus.OK);;
//	}

	/**
	 * Check whether the password from frontend equals the password in the backend
	 * @param password password from the frontend
	 * @param warehouseUserId userId
	 * @return apiResponse
	 */
	@PutMapping("/{warehouseUserId}/checkPassword")
	public ResponseEntity<ApiResponse> checkPassword(@Valid @RequestBody StringDto password, @Valid @PathVariable Long warehouseUserId){

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		WarehouseUserDetails userDetails = (WarehouseUserDetails) authentication.getPrincipal();

		if(warehouseUserId != userDetails.getId()) throw new NotEnoughAccessRightException("Access Denied");

		if(passwordEncoder.matches(password.getText(),userDetails.getPassword()))
			return new ResponseEntity<>(new ApiResponse(true, "Match"), HttpStatus.OK);

		return new ResponseEntity<>(new ApiResponse(false, "Do Not Match"), HttpStatus.OK);

	}


}
