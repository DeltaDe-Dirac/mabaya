package com.mabaya.advertise.repos;
import org.springframework.data.jpa.repository.JpaRepository;

import com.mabaya.advertise.entities.Campaign;


public interface CampaignRepo extends JpaRepository<Campaign, Long> {
	
}

