package com.fdmgroup.flexdronewarehouse.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fdmgroup.flexdronewarehouse.service.WarehouseUserService;

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
	
//	@GetMapping("/{id}")
//	public ResponseEntity<WarehouseUserDto> getUserById(@PathVariable long id){
//		return new ResponseEntity<>( (warehouseUserService.findUserById(id)), HttpStatus.OK);;
//	}

	

}
