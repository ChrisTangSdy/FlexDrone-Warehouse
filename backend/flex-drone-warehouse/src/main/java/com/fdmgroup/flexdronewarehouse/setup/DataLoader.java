package com.fdmgroup.flexdronewarehouse.setup;


import javax.transaction.Transactional;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Component;

import com.fdmgroup.flexdronewarehouse.model.Product;
import com.fdmgroup.flexdronewarehouse.service.ProductService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@RequiredArgsConstructor
@Slf4j
public class DataLoader implements ApplicationRunner{
	
	private final ProductService productService;
	
	@Override
	@Transactional
	@Modifying
	public void run(ApplicationArguments args) throws Exception{
		
		///// LOAD PRODUCTS /////
		
		Product p1 = new Product();
		p1.setSku("skup1");
		p1.setDescription("This is a camera");
		p1.setRetailPrice((float) 5022);
		p1.setCategory("CAMERA");
		p1.setName("ABC Camera");
		p1.setExternalStock(2);
		p1.setInternalStock(10);
		p1.setMinStockLevel(1);
		p1.setPart(true);
		p1.setExternalNote("Best Camera ever");
		p1.setInternalNote("worst camera ever");
		productService.save(p1);
		
		Product p2 = new Product();
		p2.setSku("skup2");
		p2.setDescription("This is a droneeee");
		p2.setRetailPrice((float) 5022);
		p2.setCategory("DRONE");
		p2.setName("DRONEEEEEE");
		p2.setExternalStock(20);
		p2.setInternalStock(22);
		p2.setMinStockLevel(10);
		p2.setPart(false);
		p2.setExternalNote("Best DRONE ever");
		p2.setInternalNote("Safest option");
		productService.save(p2);
		
		System.out.println("DATA LOADER DONE");
		
	}

}
