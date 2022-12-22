package com.fdmgroup.flexdronewarehouse.service;

import java.util.Optional;

import javax.transaction.Transactional;

import com.fdmgroup.flexdronewarehouse.exception.NotEnoughAccessRightException;
import com.fdmgroup.flexdronewarehouse.exception.UserNotFoundException;
import com.fdmgroup.flexdronewarehouse.model.WarehouseUser;
import com.fdmgroup.flexdronewarehouse.util.WarehouseUserDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

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
@Slf4j
public class WarehouseUserService {

	private final WarehouseUserRepository warehouseUserRepo;
	private final PasswordEncoder passwordEncoder;

	/**
	 * Persists WarehouseUser into database
	 * 
	 * @param warehouseUser
	 * @return persisted WarehouseUser
	 */
	public WarehouseUser save(WarehouseUser warehouseUser) {
		warehouseUser.setPassword(passwordEncoder.encode(warehouseUser.getPassword()));
		return warehouseUserRepo.save(warehouseUser);
	}
	
	/**
	 * Retrieve a Warehouse user from the database using their id.
	 * 
	 * @param id
	 * @return WarehouseUser with the given id
	 */
	public WarehouseUser findUserById(long id) {
		Optional<WarehouseUser> user = warehouseUserRepo.findById(id);
		if (user.isEmpty()) {
			throw new UserNotFoundException();
		}
		return user.get();
	}

	/**
	 * Change the password of Warehouse user using their id.
	 * 
	 * @param id
	 * @param newPass - new password
	 * @return WarehouseUser with the given id
	 */
	public WarehouseUser changePasswordById(long id, String newPass) {
		WarehouseUser user = findUserById(id);
		
		//TODO need a method to encrypt password
		user.setPassword(passwordEncoder.encode(newPass));
		
		return warehouseUserRepo.save(user);
	}

	/**
	 * Get warehouse User by usernames
	 *
	 * @param username username
	 * @return warehouseUser object
	 */
	public WarehouseUser getWarehouseUserByUsername(String username){
		Optional<WarehouseUser> warehouseUser = warehouseUserRepo.findUserByUsername(username);
		if(warehouseUser.isEmpty()){
			throw new UserNotFoundException();
		}
		return warehouseUser.get();
	}

	/**
	 * Check whether the password from frontend is the same as the backend
	 * @param password
	 * @param warehouseUserId
	 * @return
	 */
	public Boolean checkPassword(String password, Long warehouseUserId){

		WarehouseUserDetails userDetails = WarehouseUserDetailsServiceImpl.getWarehouseUserDetails();

		if(warehouseUserId != userDetails.getId()) throw new NotEnoughAccessRightException("Access Denied");

		return passwordEncoder.matches(password,userDetails.getPassword());

	}




}
