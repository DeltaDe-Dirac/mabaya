package com.mabaya.advertise.entities.cust;

import java.sql.Timestamp;

public interface ICampaignCust {
	Long getId();    
    String getName();
    Timestamp getStart_Date();
    String getBid();
    String getProd_List();
}