package com.fdmgroup.flexdronewarehouse.service;

import javax.transaction.Transactional;

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
public class WarehouseUserService {

	private final WarehouseUserRepository warehouseUserRepo;
	
	
	
}
