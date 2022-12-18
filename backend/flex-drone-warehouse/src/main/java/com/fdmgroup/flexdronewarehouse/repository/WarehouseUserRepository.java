package com.fdmgroup.flexdronewarehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fdmgroup.flexdronewarehouse.model.WarehouseUser;

/**
 * Warehouse user repository
 * @author Indrayutta, Summer
 *
 */
@Repository
public interface WarehouseUserRepository extends JpaRepository<WarehouseUser, Long> {
	

}
