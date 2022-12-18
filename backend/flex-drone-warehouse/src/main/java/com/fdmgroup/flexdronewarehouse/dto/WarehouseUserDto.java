package com.fdmgroup.flexdronewarehouse.dto;

import com.fdmgroup.flexdronewarehouse.model.WarehouseUser;

import lombok.Data;


/**
 * Warehouse user DTO
 * @author Indrayutta, Summer
 *
 */

@Data
public class WarehouseUserDto {
	
    private Long id;

    private String username;

    private String email;

    private String firstName;

    private String lastName;

    private String role;
    
    public WarehouseUserDto warehouseUserToDto(WarehouseUser warehouseUser) {
    	WarehouseUserDto warehouseDto = new WarehouseUserDto();
    	warehouseDto.setId(warehouseUser.getId());
    	warehouseDto.setUsername(warehouseUser.getUsername());
    	warehouseDto.setEmail(warehouseUser.getEmail());
    	warehouseDto.setFirstName(warehouseUser.getFirstName());
    	warehouseDto.setLastName(warehouseUser.getLastName());
		return warehouseDto;
    }

}
