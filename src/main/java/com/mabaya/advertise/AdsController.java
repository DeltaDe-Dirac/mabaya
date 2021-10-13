package com.mabaya.advertise;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mabaya.advertise.entities.Campaign;
import com.mabaya.advertise.entities.cust.ICampaignCust;
import com.mabaya.advertise.entities.cust.IProductCust;
import com.mabaya.advertise.entities.dto.CampaignDto;
import com.mabaya.advertise.repos.CampaignRepo;
import com.mabaya.advertise.repos.ProductRepo;

@RestController
public class AdsController {
	@Autowired
	private ModelMapper modelMapper;
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
	
	
//	@GetMapping("/createCampaign")
//	@ResponseBody
//	public String addCampaign(@RequestParam String name, @RequestParam int bid, @RequestParam String prodList, @RequestParam Timestamp startDate) {
//		return campaignRepo.save(new Campaign(name, bid, prodList, startDate)).toString();
//	}
	
	@PostMapping("/createCampaign")
	public Campaign addCampaign(@RequestBody CampaignDto newCampaignDto) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		modelMapper.typeMap(CampaignDto.class, Campaign.class);
		Campaign newCampaign = modelMapper.map(newCampaignDto, Campaign.class);
		return campaignRepo.save(newCampaign);
	}
}
