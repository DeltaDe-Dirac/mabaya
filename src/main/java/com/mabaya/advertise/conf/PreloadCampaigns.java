package com.mabaya.advertise.conf;

import java.sql.Timestamp;
import java.time.LocalDateTime;
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
			LOG.info(repository.save(new Campaign("Promo1", 10, "8,9,10", Timestamp.valueOf(LocalDateTime.now().minusDays(1)))).toString());
			LOG.info(repository.save(new Campaign("Promo2", 9, "8,9,10,1", Timestamp.valueOf(LocalDateTime.now().minusDays(2)))).toString());
			LOG.info(repository.save(new Campaign("Promo3", 90, "8,9,2,10", Timestamp.valueOf(LocalDateTime.now().minusDays(3)))).toString());
			LOG.info(repository.save(new Campaign("Promo4", 10, "4", Timestamp.valueOf(LocalDateTime.now().minusDays(5)))).toString());			
			LOG.info(repository.save(new Campaign("Promo5", 200, "1,2,3,4,5", Timestamp.valueOf(LocalDateTime.now().minusDays(10)))).toString());
			LOG.info(repository.save(new Campaign("Promo6", 2000, "1,2,3,4,6", Timestamp.valueOf(LocalDateTime.now().minusDays(11)))).toString());
		};
	}
}
