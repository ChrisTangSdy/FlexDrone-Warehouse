package com.fdmgroup.flexdronewarehouse.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fdmgroup.flexdronewarehouse.dto.WarehouseUserDto;
import com.fdmgroup.flexdronewarehouse.model.WarehouseUser;
import com.fdmgroup.flexdronewarehouse.service.WarehouseUserService;
import com.fdmgroup.flexdronewarehouse.util.ModelToDTO;

import lombok.RequiredArgsConstructor;
/**
 * User CRUD operations.
 * @author Indrayutta, Summer
 *
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/warehouse-users")
public class WarehouseUserController {
	
	private final WarehouseUserService warehouseUserService;
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
	 * API to change a Warehouse users password using their ID
	 * 
	 * @param id - WarehouseUserId
	 * @return WarehouseUserDTO with updated password (Note: password is not part of the DTO)
	 */
	@PutMapping("/{id}/password")
	public ResponseEntity<WarehouseUserDto> changePasswordById(@PathVariable long id, @RequestBody String newPass){
		WarehouseUser user = warehouseUserService.changePasswordById(id, newPass);
		
		return new ResponseEntity<>( modelToDTO.userToOutput(user), HttpStatus.OK);
	}

}
