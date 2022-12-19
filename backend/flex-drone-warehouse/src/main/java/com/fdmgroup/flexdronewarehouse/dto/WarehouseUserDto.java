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
    

}
