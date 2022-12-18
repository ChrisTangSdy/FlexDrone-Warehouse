package com.fdmgroup.flexdronewarehouse.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.fdmgroup.flexdronewarehouse.exception.UserNotFoundException;
import com.fdmgroup.flexdronewarehouse.model.WarehouseUser;
import com.fdmgroup.flexdronewarehouse.repository.WarehouseUserRepository;

import lombok.RequiredArgsConstructor;

/**
 * Warehouse User Service
 * @author Indrayutta, Summer
 *
 */
@Service
@Transactional
@RequiredArgsConstructor
public class WarehouseUserService {

	private final WarehouseUserRepository warehouseUserRepo;

	public WarehouseUser findUserById(long id) {
		Optional<WarehouseUser> user = warehouseUserRepo.findById(id);
		if (user.isEmpty()) {
			throw new UserNotFoundException();
		}
		return user.get();
	}

	public WarehouseUser changePasswordById(long id, String newPass) {
		WarehouseUser user = findUserById(id);
		
		//TODO need a method to encrypt password
		user.setPassword(newPass);
		
		return warehouseUserRepo.save(user);
	}
	
	
	
}
