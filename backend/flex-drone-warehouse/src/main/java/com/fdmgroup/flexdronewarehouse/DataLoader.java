package com.fdmgroup.flexdronewarehouse;
import javax.transaction.Transactional;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Component;

import com.fdmgroup.flexdronewarehouse.model.Role;
import com.fdmgroup.flexdronewarehouse.model.WarehouseUser;
import com.fdmgroup.flexdronewarehouse.service.WarehouseUserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@RequiredArgsConstructor
@Slf4j
public class DataLoader implements ApplicationRunner {
	
	private final WarehouseUserService warehouseUserService;

    @Override
    @Transactional
    @Modifying
    public void run(ApplicationArguments args) throws Exception {
    	WarehouseUser user = new WarehouseUser(0, "yuttaFDM", "HelloWorld!", "yutta@fdmgroup.com", "yutta", "karima", Role.WAREHOUSE_MANAGER);
    	warehouseUserService.save(user);
        log.info("Finished setup");
    }
}
