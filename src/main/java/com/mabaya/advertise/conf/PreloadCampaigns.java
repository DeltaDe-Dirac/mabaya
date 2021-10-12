package com.mabaya.advertise.conf;

import java.sql.Timestamp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mabaya.advertise.entities.Campaign;
import com.mabaya.advertise.repos.CampaignRepo;

@Configuration
class PreloadCampaigns {

	private static final Logger LOG = LoggerFactory.getLogger(PreloadCampaigns.class);

	@Bean
	CommandLineRunner initCampaings(CampaignRepo repository) {
		return args -> {
			LOG.info(repository.save(new Campaign("MobilePromo", 1, "1", Timestamp.valueOf("2021-10-11"))).toString());	
			LOG.info(repository.save(new Campaign("HardwarePromo", 2, "2,3", Timestamp.valueOf("2021-10-01"))).toString());
		};
	}
}
