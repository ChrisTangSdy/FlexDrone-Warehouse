package com.fdmgroup.flexdronewarehouse.controller;


import com.fdmgroup.flexdronewarehouse.dto.StringDto;
import com.fdmgroup.flexdronewarehouse.util.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import com.fdmgroup.flexdronewarehouse.dto.WarehouseUserDto;
import com.fdmgroup.flexdronewarehouse.model.WarehouseUser;
import com.fdmgroup.flexdronewarehouse.service.WarehouseUserService;
import com.fdmgroup.flexdronewarehouse.util.ModelToDTO;

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

	private final PasswordEncoder passwordEncoder;

	private final ModelToDTO modelToDTO;

	
	/**
	 * API to get a Warehouse user using their ID
	 * 
	 * @param id - WarehouseUserId
	 * @return WarehouseUserDTO of the found User
	 */
	@GetMapping("/{id}")
	public ResponseEntity<WarehouseUserDto> getUserById(@PathVariable long id){
		
		return new ResponseEntity<>( modelToDTO.userToOutput(warehouseUserService.findUserById(id)), HttpStatus.OK);
	}


	/**
	 * API to check whether the password from frontend equals the password in the backend
	 * @param password password from the frontend
	 * @param warehouseUserId userId
	 * @return apiResponse
	 */
	@PostMapping("/{warehouseUserId}/checkPassword")
	public ResponseEntity<ApiResponse> checkPassword(@Valid @RequestBody StringDto password, @Valid @PathVariable Long warehouseUserId){

		return warehouseUserService.checkPassword(password.getText(),warehouseUserId) ?
				new ResponseEntity<>(new ApiResponse(true, "Match"), HttpStatus.OK) :
                 new ResponseEntity<>(new ApiResponse(false, "Do Not Match"), HttpStatus.OK);

	}

	/**
	 * API to change a Warehouse users password using their ID
	 * 
	 * @param id - WarehouseUserId
	 * @return WarehouseUserDTO with updated password (Note: password is not part of the DTO)
	 */
	@PutMapping("/{id}/password")
	public ResponseEntity<String> changePasswordById(@PathVariable long id, @RequestBody StringDto newPass){
		WarehouseUser user = warehouseUserService.changePasswordById(id, newPass.getText());
		
		return new ResponseEntity<>( "Password Successfully Changed", HttpStatus.OK);
	}

}
