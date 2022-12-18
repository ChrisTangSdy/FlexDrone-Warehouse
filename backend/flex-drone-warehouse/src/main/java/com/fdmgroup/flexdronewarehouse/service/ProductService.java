package com.fdmgroup.flexdronewarehouse.service;

import org.springframework.stereotype.Service;

import com.fdmgroup.flexdronewarehouse.repository.ProductRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductService {
	
	private final ProductRepository productRepo;

}
