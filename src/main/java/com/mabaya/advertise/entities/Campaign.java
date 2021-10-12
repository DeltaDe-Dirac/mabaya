package com.mabaya.advertise.entities;

import java.sql.Timestamp;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "campaigns")
public class Campaign {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private int bid ;
	private String prodList;
	private Timestamp startDate;
	
	public Campaign() {
	}

	public Campaign(String name, int bid, String prodList, Timestamp startDate) {

		this.setName(name);
		this.setBid(bid);
		this.setProdList(prodList);
		this.setStartDate(startDate);
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	@Override
	public String toString() {
		StringBuilder campaign = new StringBuilder("Campaign [id=");

		campaign.append(this.id);
		campaign.append(", name=");
		campaign.append(this.name);
		campaign.append(", startDate=");
		campaign.append(this.startDate);
		campaign.append(", bid=");
		campaign.append(this.bid);
		campaign.append(", prodList=");
		campaign.append(this.prodList);
		campaign.append("]");
		return campaign.toString();
	}

	@Override
	public boolean equals(Object o) {

		if (this == o)
			return true;
		if (!(o instanceof Campaign))
			return false;
		Campaign campaign = (Campaign) o;
		return Objects.equals(this.id, campaign.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.id);
	}
}
