package com.mabaya.advertise.entities.dto;

import java.sql.Timestamp;

public class CampaignDto {
	private String name;
	private int bid ;
	private String prodList;
	private Timestamp startDate;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getProdList() {
		return prodList;
	}
	public void setProdList(String prodList) {
		this.prodList = prodList;
	}
	public Timestamp getStartDate() {
		return startDate;
	}
	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}	
}
