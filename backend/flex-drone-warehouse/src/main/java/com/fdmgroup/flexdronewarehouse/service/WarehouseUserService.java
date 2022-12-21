package com.fdmgroup.flexdronewarehouse.service;

import javax.transaction.Transactional;

import com.fdmgroup.flexdronewarehouse.exception.UserNotFoundException;
import com.fdmgroup.flexdronewarehouse.model.WarehouseUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.fdmgroup.flexdronewarehouse.repository.WarehouseUserRepository;

import lombok.RequiredArgsConstructor;

import java.util.Optional;

/**
 * Warehouse User Service
 * @author Indrayutta, Summer
 *
 */
@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class WarehouseUserService {

	private final WarehouseUserRepository warehouseUserRepo;
	private final PasswordEncoder passwordEncoder;

	public WarehouseUser getWarehouseUserByUsername(String username){
		Optional<WarehouseUser> warehouseUser = warehouseUserRepo.findUserByUsername(username);
		if(warehouseUser.isEmpty()){
			throw new UserNotFoundException();
		}
		return warehouseUser.get();
	}

	public void save(WarehouseUser warehouseUser){
		warehouseUser.setPassword(passwordEncoder.encode(warehouseUser.getPassword()));
		warehouseUserRepo.save(warehouseUser);
	}

	public void checkPasswordIntegrity(){

	}
	
	
}
