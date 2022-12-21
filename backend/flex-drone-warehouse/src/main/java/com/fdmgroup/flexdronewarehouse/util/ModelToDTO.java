package com.fdmgroup.flexdronewarehouse.util;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fdmgroup.flexdronewarehouse.dto.WarehouseUserDto;
import com.fdmgroup.flexdronewarehouse.model.WarehouseUser;

@Component
public class ModelToDTO {

    private ModelMapper modelMapper;
    
    /**
     * Mapper configuration.
     * @param modelMapper ModelMapper.
     */
    @Autowired
    public ModelToDTO(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        modelMapper.typeMap(WarehouseUser.class, WarehouseUserDto.class)
	        .addMapping(WarehouseUser::getRole, WarehouseUserDto::setRole)
	        .addMapping(WarehouseUser::getUsername, WarehouseUserDto::setUsername)
	        .addMapping(WarehouseUser::getId, WarehouseUserDto::setId)
	        .addMapping(WarehouseUser::getFirstName, WarehouseUserDto::setFirstName)
	        .addMapping(WarehouseUser::getLastName, WarehouseUserDto::setLastName)
	        .addMapping(WarehouseUser::getEmail, WarehouseUserDto::setEmail);
    }
    
    /**
     * Map WarehouseUser to WarehouseUserDTO
     * @param user
     * @return WarehouseUserDTO
     */
    public WarehouseUserDto userToOutput(WarehouseUser user){
        return modelMapper.map(user, WarehouseUserDto.class);
    }
}
