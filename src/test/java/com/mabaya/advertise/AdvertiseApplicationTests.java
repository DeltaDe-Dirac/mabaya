package com.mabaya.advertise;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mabaya.advertise.entities.cust.IProductCust;

@SpringBootTest
class AdvertiseApplicationTests {
	
	@Autowired
	private AdsController controller;

	@Test
	void contextLoads() throws Exception {
		assertNotNull(controller);
	}
	
	@Test
	void nullWhenNoActiveCampaigns() throws Exception {
		controller.setDaysActivePeriod(0);
		assertNull(controller.advertise("Cat1"));
	}
	
	@Test
	void nullWhenActiveCampaignNoMatchingProduct() throws Exception {
		controller.setDaysActivePeriod(1);
		assertNull(controller.advertise("Cat3"));
	}
	
	@Test
	void activeCampaignNotMatchingCategory() throws Exception {
		controller.setDaysActivePeriod(2);
		
		IProductCust promotedProduct =  controller.advertise("Cat3");
		
		assertNotNull(promotedProduct);
		assertEquals("Prod1-Cat1", promotedProduct.getTitle());
	}
	
	@Test
	void activeCampaignMatchingCategory() throws Exception {
		controller.setDaysActivePeriod(2);
		
		IProductCust promotedProduct =  controller.advertise("Cat1");
		assertNotNull(promotedProduct);
		assertEquals("Prod1-Cat1", promotedProduct.getTitle());
	}
	
	@Test
	void activeCampaignMatchingCategoryMaxBid() throws Exception {
		controller.setDaysActivePeriod(5);
		
		IProductCust promotedProduct =  controller.advertise("Cat1");
		assertNotNull(promotedProduct);
		assertEquals("Prod2-Cat1", promotedProduct.getTitle());
	}
	
	@Test
	void activeCampaignEdgeCase() throws Exception {
		controller.setDaysActivePeriod(10);
		
		IProductCust promotedProduct =  controller.advertise("Cat4");
		assertNotNull(promotedProduct);
		assertEquals("Prod1-Cat4", promotedProduct.getTitle());
	}
	
	@Test
	void createCampaign() throws Exception {
		String newCampaign =  controller.addCampaign("NewPromo", 9999, "7", Timestamp.valueOf(LocalDateTime.now().minusDays(12)));
		assertNotNull(newCampaign);
		
		controller.setDaysActivePeriod(12);
		IProductCust promotedProduct =  controller.advertise("Cat4");
		assertNotNull(promotedProduct);
		assertEquals("Prod3-Cat4", promotedProduct.getTitle());
	}
}
