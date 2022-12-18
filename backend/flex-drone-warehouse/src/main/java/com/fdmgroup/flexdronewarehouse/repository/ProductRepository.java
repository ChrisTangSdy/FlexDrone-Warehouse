package com.fdmgroup.flexdronewarehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fdmgroup.flexdronewarehouse.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}
