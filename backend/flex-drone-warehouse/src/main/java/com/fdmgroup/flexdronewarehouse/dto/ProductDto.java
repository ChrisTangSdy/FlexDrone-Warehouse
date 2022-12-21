package com.fdmgroup.flexdronewarehouse.dto;

import java.util.List;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor 
@Getter 
@Setter 
@AllArgsConstructor
public class ProductDto {

	@NotBlank
	private String sku;
	@NotBlank
	private String description;
	@NotBlank
	private float retailPrice;
	@NotBlank
	private String category;
	@NotBlank
	private String name;
	@NotBlank
	private long externalStock;
	@NotBlank
	private long internalStock;
	@NotBlank
	private long minStockLevel;
	@NotBlank
	private boolean isPart;

	private String externalNote;

	private String internalNote;
	
}
