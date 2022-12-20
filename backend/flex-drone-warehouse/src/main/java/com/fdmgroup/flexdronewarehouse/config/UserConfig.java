package com.fdmgroup.flexdronewarehouse.config;


import com.fdmgroup.flexdronewarehouse.util.WarehouseUserDetails;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * config userDetails for spring security
 * @author Chris
 */
@Configuration
public class UserConfig {

    @Bean
    public WarehouseUserDetails warehouseUserDetails() {
        return new WarehouseUserDetails();
    }
}
