package com.fdmgroup.flexdronewarehouse;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The entry point of application
 */
@SpringBootApplication
@OpenAPIDefinition (info =
@Info(
		title = "Warehouse API",
		version = "0.0",
		description = "API Definitions of the FlexDrone Warehouse system"
))
public class FlexDroneWarehouseApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlexDroneWarehouseApplication.class, args);
	}

}
