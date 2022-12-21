package com.fdmgroup.flexdronewarehouse.model;

import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
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
	private long id;
	
	private String sku;
	
	private String description;
	private float retailPrice;
	private String category;
	private String name;
	private long externalStock;
	private long internalStock;
	private long minStockLevel;
	private boolean isPart;
	private String externalNote; //warranty, out of stock
	private String internalNote; //
	
	@Override
	public int hashCode() {
		return Objects.hash(category, isPart, name, sku);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(category, other.category) && isPart == other.isPart && Objects.equals(name, other.name)
				&& sku == other.sku;
	}

	@Override
	public String toString() {
		return "Product [sku=" + sku + ", description=" + description + ", retailPrice=" + retailPrice + ", category="
				+ category + ", name=" + name + ", externalStock=" + externalStock + ", internalStock=" + internalStock
				+ ", minStockLevel=" + minStockLevel + ", isPart=" + isPart + ", externalNote=" + externalNote
				+ ", internalNote=" + internalNote + "]";
	}
	
	

}
