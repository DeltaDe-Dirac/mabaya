package com.mabaya.advertise.repos;
import org.springframework.data.jpa.repository.JpaRepository;

import com.mabaya.advertise.entities.Product;


public interface ProductRepo extends JpaRepository<Product, Long> {
	
}

