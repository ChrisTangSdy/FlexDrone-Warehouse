package com.fdmgroup.flexdronewarehouse.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fdmgroup.flexdronewarehouse.common.ApiResponse;
import com.fdmgroup.flexdronewarehouse.dto.ProductDto;
import com.fdmgroup.flexdronewarehouse.service.ProductService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
public class productController {
	
	private final ProductService productService;
	
	
	// FROM HAILIE: CRUD TODO: ERROR HANDLING
	
	// create one product snap
	//QUESTION: HOW TO CREATE SKU? MANUAL INPUT OR GENERATE BASED ON INPUTS?
	
	@PostMapping("/{active_user_id}")
	public ResponseEntity<ApiResponse> createProduct(@PathVariable long active_user_id, @RequestBody ProductDto productDto){
		//TODO: product dto and user role validation
		
		productService.createProduct(productDto);
		return new ResponseEntity<>(new ApiResponse(true, "product creation success"),HttpStatus.CREATED);

	}
	
	// view all products
	@GetMapping("/{active_user_id}")
	public ResponseEntity<List<ProductDto>> getAllProducts(){
		//TODO: validate user role
		
		List<ProductDto> pDtos = productService.findAll();
		return new ResponseEntity<>(pDtos, HttpStatus.OK);
	}
	
	// view one product by (sku)
	@GetMapping("/{active_user_id}/{productSKU}")
	public ResponseEntity<ProductDto> getProductBySKU(@PathVariable long active_user_id, @PathVariable String productSKU){
		
		ProductDto pDto = productService.findBySKU(productSKU);
		return new ResponseEntity<>(pDto, HttpStatus.OK);
	}
	
	// update one product
	@PutMapping("/{active_user_id}/{productSKU}")
	public ResponseEntity<ApiResponse> updateProduct(@PathVariable long active_user_id, @RequestBody ProductDto productDto, @PathVariable String productSKU){
		//TODO: check if updated fields are valid
		
		productService.updateOneProduct(productDto, productSKU);
		return new ResponseEntity<>(new ApiResponse(true, "product update success"),HttpStatus.OK);

	}

	
	// delete one product
	@DeleteMapping("/{active_user_id}/{productSKU}")
	public ResponseEntity<ApiResponse> deleteProduct(@PathVariable long active_user_id, @PathVariable String productSKU){
		
		productService.deleteOneProduct(productSKU);
		return new ResponseEntity<>(new ApiResponse(true, "product deletion success"),HttpStatus.OK);

	}

}
