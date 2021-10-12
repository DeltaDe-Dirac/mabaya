package com.mabaya.advertise.repos;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.mabaya.advertise.entities.Product;
import com.mabaya.advertise.entities.cust.IProductCust;


public interface ProductRepo extends JpaRepository<Product, Long> {
	@Query(value = "SELECT P.* FROM PRODUCTS P WHERE P.CATEGORY=?1", nativeQuery = true)
	List<IProductCust> getProductByCategory(String category);
}

