package com.fdmgroup.flexdronewarehouse.setUp;


import com.fdmgroup.flexdronewarehouse.model.Role;
import com.fdmgroup.flexdronewarehouse.model.WarehouseUser;
import com.fdmgroup.flexdronewarehouse.service.WarehouseUserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@RequiredArgsConstructor
@Slf4j
public class DataLoader implements ApplicationRunner {

    private final WarehouseUserService warehouseUserService;
    @Override
    @Transactional
    @Modifying
    public void run(ApplicationArguments args) throws Exception {
        WarehouseUser andrew = new WarehouseUser();
        andrew.setUsername("Andrew");
        andrew.setPassword("1");
        andrew.setEmail("123@gmail.com");
        andrew.setFirstName("Andrew");
        andrew.setLastName("Tate");
        andrew.setRole(Role.WAREHOUSE_MANAGER);
        warehouseUserService.save(andrew);
        log.info("register Andrew success");

        WarehouseUser john = new WarehouseUser();
        john.setUsername("John");
        john.setPassword("1");
        john.setEmail("john@gmail.com");
        john.setFirstName("John");
        john.setLastName("Boris");
        john.setRole(Role.WAREHOUSE_USER);
        warehouseUserService.save(john);
        log.info("register John success");
        
    	WarehouseUser user = new WarehouseUser(0, "yuttaFDM", "HelloWorld!", "yutta@fdmgroup.com", "yutta", "karima", Role.WAREHOUSE_MANAGER);
    	warehouseUserService.save(user);
        log.info("Finished setup");
    }

}
