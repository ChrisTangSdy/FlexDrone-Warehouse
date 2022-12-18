package com.fdmgroup.flexdronewarehouse.controller;

import org.springframework.web.bind.annotation.RestController;

import com.fdmgroup.flexdronewarehouse.service.ProductService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class productController {
	
	private final ProductService productService;

}
