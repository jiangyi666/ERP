package com.erp.pojo.erm;

import java.sql.Date;

public class Materrielstoragedetail {
	private String matStoreDetId;
	private String matId;
	private double amount;
	private Date datetime;
	private double min;
	public String getMatStoreDetId() {
		return matStoreDetId;
	}
	public void setMatStoreDetId(String matStoreDetId) {
		this.matStoreDetId = matStoreDetId;
	}
	public String getMatId() {
		return matId;
	}
	public void setMatId(String matId) {
		this.matId = matId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Date getDatetime() {
		return datetime;
	}
	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}
	public double getMin() {
		return min;
	}
	public void setMin(double min) {
		this.min = min;
	}
	@Override
	public String toString() {
		return "Materrielstoragedetail [matStoreDetId=" + matStoreDetId + ", matId=" + matId + ", amount=" + amount
				+ ", datetime=" + datetime + ", min=" + min + "]";
	}
	
}
