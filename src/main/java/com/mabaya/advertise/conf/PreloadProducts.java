package com.mabaya.advertise.conf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mabaya.advertise.entities.Product;
import com.mabaya.advertise.repos.ProductRepo;

@Configuration
class PreloadProducts {

	private static final Logger LOG = LoggerFactory.getLogger(PreloadProducts.class);

	@Bean
	CommandLineRunner initProducts(ProductRepo repository) {

		return args -> {
			LOG.info(repository.save(new Product("Apple MacBook Pro", "Laptop", 5000)).toString());
			LOG.info(repository.save(new Product("Garmin Forerunner", "Smart Watch", 1234)).toString());
			LOG.info(repository.save(new Product("Samsung Odyssey G5", "Monitor", 1719)).toString());		
		};
	}
}
