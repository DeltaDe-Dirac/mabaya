package com.mabaya.advertise;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

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
		controller.setDaysActivePeriod(3);
		
		IProductCust promotedProduct =  controller.advertise("Cat1");
		assertNotNull(promotedProduct);
		assertEquals("Prod2-Cat1", promotedProduct.getTitle());
	}
}
