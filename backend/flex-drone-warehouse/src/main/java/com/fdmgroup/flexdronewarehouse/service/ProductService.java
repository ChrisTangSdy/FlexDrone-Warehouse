package com.fdmgroup.flexdronewarehouse.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.fdmgroup.flexdronewarehouse.dto.ProductDto;
import com.fdmgroup.flexdronewarehouse.model.Product;
import com.fdmgroup.flexdronewarehouse.repository.ProductRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductService {
	
	private final ProductRepository productRepo;
	
	
	
	// create product: validate productDto from user
	public void validateProductDto(ProductDto pDto) {
		// check every field
	}
	
	// validate fields from product
	public void validateDescription() {
		
	}
	
	public void validateRetailPrice() {
		
	}
	
	public void validateCategory() {
		
	}
	
	public void validateName() {
		
	}
	
	public void validateExternalStock() {
		
	}
	
	public void validateInternalStock() {
		
	}
	
	public void validateMinStockLevel() {
		
	}
	
	public void createProduct(ProductDto pDto) {
		
		Product p = new Product();
		p.setSku(pDto.getSku());
		p.setDescription(pDto.getDescription());
		p.setRetailPrice(pDto.getRetailPrice());
		p.setCategory(pDto.getCategory());
		p.setName(pDto.getName());
		p.setExternalStock(pDto.getExternalStock());
		p.setInternalStock(pDto.getInternalStock());
		p.setMinStockLevel(pDto.getMinStockLevel());
		p.setPart(pDto.isPart());
		p.setExternalNote(pDto.getExternalNote());
		p.setInternalNote(pDto.getInternalNote());
		save(p);
	}

	
	public void save(Product p) {
		
		productRepo.save(p);
	}

	
	public List<ProductDto> findAll() {
		
		List<Product> allProducts = productRepo.findAll();
		List<ProductDto> pDtos = new ArrayList<ProductDto>();
		for(Product p: allProducts) {
			// convert product to productDto
			ProductDto pDto = convertToProductDto(p);
			pDtos.add(pDto);
		}
		return pDtos;
	}
	
	
	public ProductDto convertToProductDto(Product p) {
		
		ProductDto pDto = new ProductDto();
		pDto.setSku(p.getSku());
		pDto.setDescription(p.getDescription());
		pDto.setRetailPrice(p.getRetailPrice());
		pDto.setCategory(p.getCategory());
		pDto.setName(p.getName());
		pDto.setExternalStock(p.getExternalStock());
		pDto.setInternalStock(p.getInternalStock());
		pDto.setMinStockLevel(p.getMinStockLevel());
		pDto.setPart(p.isPart());
		pDto.setExternalNote(p.getExternalNote());
		pDto.setInternalNote(p.getInternalNote());
		return pDto;
	}

	
	public ProductDto findBySKU(String sku) {
		Optional<Product> opProduct = productRepo.findBySku(sku);
		if(opProduct.isEmpty()) {
			return null;
		}
		Product p = opProduct.get();
		return convertToProductDto(p);
	}

	
	public void updateOneProduct(ProductDto pDto, String sku) {
		Optional<Product> opProduct = productRepo.findBySku(sku);
		if (opProduct.isEmpty()) {
			// TODO:error handling 
		}
		Product p = opProduct.get();
		p.setSku(pDto.getSku());
		p.setDescription(pDto.getDescription());
		p.setRetailPrice(pDto.getRetailPrice());
		p.setCategory(pDto.getCategory());
		p.setName(pDto.getName());
		p.setExternalStock(pDto.getExternalStock());
		p.setInternalStock(pDto.getInternalStock());
		p.setMinStockLevel(pDto.getMinStockLevel());
		p.setPart(pDto.isPart());
		p.setExternalNote(pDto.getExternalNote());
		p.setInternalNote(pDto.getInternalNote());
		save(p);
	}

	public void deleteOneProduct(String sku) {
		Optional<Product> opProduct = productRepo.findBySku(sku);
		if (opProduct.isEmpty()) {
			// TODO:error handling 
		}
		Product p = opProduct.get();
		productRepo.delete(p);
	}

}
