package com.mabaya.advertise;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mabaya.advertise.entities.Campaign;
import com.mabaya.advertise.entities.Product;
import com.mabaya.advertise.entities.cust.ICampaignCust;
import com.mabaya.advertise.entities.cust.IProductCust;
import com.mabaya.advertise.repos.CampaignRepo;
import com.mabaya.advertise.repos.ProductRepo;

@RestController
public class AdsController {
	private final int ACTIVE_PERIOD = 11; 
	
	private final ProductRepo productRepo;
	private final CampaignRepo campaignRepo;
	
	AdsController(ProductRepo productRepo,  CampaignRepo campaignRepo) {
		this.productRepo = productRepo;
		this.campaignRepo = campaignRepo;		
	}

	@GetMapping("/products")
	public List<Product> products() {
		return productRepo.findAll();
	}
	
	@GetMapping("/campaigns")
	public List<Campaign> campaigns() {
		return campaignRepo.findAll();
	}
	
	@GetMapping("/advertise/{cat}")
	public List<ICampaignCust> advertise(@PathVariable String cat) {
		List<IProductCust> optProduct = productRepo.getProductByCategory(cat);
		List<ICampaignCust> cList = campaignRepo.getActiveCampaigns(ACTIVE_PERIOD);

		return cList;
	}
	
	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
	return String.format("Hello %s!", name);
	}

}
