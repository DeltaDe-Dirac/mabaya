package com.mabaya.advertise.repos;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mabaya.advertise.entities.Campaign;
import com.mabaya.advertise.entities.cust.ICampaignCust;

public interface CampaignRepo extends JpaRepository<Campaign, Long> {
	@Query(value = "SELECT C.* FROM CAMPAIGNS C WHERE DATEDIFF(day, C.START_DATE, CURDATE()) BETWEEN 0 AND ?1", nativeQuery = true)
	List<ICampaignCust> getActiveCampaigns(int daysActivePeriod);
}

