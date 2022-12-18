package com.fdmgroup.flexdronewarehouse.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "product")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long sku;
	
	private String description;
	private float retail_price;
	private String category;
	private String name;
	private long external_stock;
	private long internal_stock;
	private long min_stock_level;
	private boolean is_part;
	private String external_note;
	private String internal_note;

}
