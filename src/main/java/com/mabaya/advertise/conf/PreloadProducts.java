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
			LOG.info(repository.save(new Product("Prod1-Cat1", "Cat1", 5000)).toString());
			LOG.info(repository.save(new Product("Prod2-Cat1", "Cat1", 6000)).toString());
			LOG.info(repository.save(new Product("Prod1-Cat2", "Cat2", 1234)).toString());
			LOG.info(repository.save(new Product("Prod1-Cat3", "Cat3", 4000)).toString());
			LOG.info(repository.save(new Product("Prod1-Cat4", "Cat4", 1719)).toString());
			LOG.info(repository.save(new Product("Prod2-Cat4", "Cat4", 1720)).toString());
			LOG.info(repository.save(new Product("Prod3-Cat4", "Cat4", 1721)).toString());
		};
	}
}
