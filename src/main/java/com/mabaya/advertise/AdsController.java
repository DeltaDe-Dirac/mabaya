package com.mabaya.advertise;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mabaya.advertise.entities.Campaign;
import com.mabaya.advertise.entities.cust.ICampaignCust;
import com.mabaya.advertise.entities.cust.IProductCust;
import com.mabaya.advertise.repos.CampaignRepo;
import com.mabaya.advertise.repos.ProductRepo;

@RestController
public class AdsController {
	private int daysActivePeriod = 10;
	
	private final ProductRepo productRepo;
	private final CampaignRepo campaignRepo;
	
	AdsController(ProductRepo productRepo,  CampaignRepo campaignRepo) {
		this.productRepo = productRepo;
		this.campaignRepo = campaignRepo;		
	}

	public int getDaysActivePeriod() {
		return daysActivePeriod;
	}

	public void setDaysActivePeriod(int daysActivePeriod) {
		this.daysActivePeriod = daysActivePeriod;
	}
	
	@GetMapping("/advertise/{cat}")
	public IProductCust advertise(@PathVariable String cat) {		
		List<ICampaignCust> cList = campaignRepo.getActiveCampaigns(daysActivePeriod);
		
		for(ICampaignCust campaign:cList) {
			IProductCust optProduct = productRepo.getProductByCategory(cat,campaign.getProd_List().split(","));
			
			if(optProduct != null) {
				return optProduct;
			}
		}
		
		for(ICampaignCust campaign:cList) {
			IProductCust optProduct = productRepo.getProductByIDs(campaign.getProd_List().split(","));
			
			if(optProduct != null) {
				return optProduct;
			}
		}
		
		return null;
	}
	
	
	@GetMapping("/createCampaign")
	@ResponseBody
	public String addCampaign(@RequestParam String name, @RequestParam int bid, @RequestParam String prodList, @RequestParam Timestamp startDate) {
		return campaignRepo.save(new Campaign(name, bid, prodList, startDate)).toString();
	}
}
