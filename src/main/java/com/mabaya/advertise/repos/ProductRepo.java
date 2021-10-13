package com.mabaya.advertise.repos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mabaya.advertise.entities.Product;
import com.mabaya.advertise.entities.cust.IProductCust;


public interface ProductRepo extends JpaRepository<Product, Long> {
	@Query(value = "SELECT P.* FROM PRODUCTS P WHERE P.CATEGORY = :category AND P.ID IN :prod_list LIMIT 1", nativeQuery = true)
	IProductCust getProductByCategory( @Param("category") String category, @Param("prod_list") String[] prodList);
	
	@Query(value = "SELECT P.* FROM PRODUCTS P WHERE P.ID IN :prod_list LIMIT 1", nativeQuery = true)
	IProductCust getProductByIDs( @Param("prod_list") String[] prodList);
}

