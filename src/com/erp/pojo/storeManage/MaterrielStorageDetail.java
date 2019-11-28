package com.erp.pojo.storeManage;

import java.sql.Timestamp;

public class MaterrielStorageDetail {
	
//	原材料库存编号
	String matStoreDetId;
//	原材料编号
	String matId;
//	剩余数量
	double amount;
//	统计录入时间
	Timestamp date;
//	最低库存量(吨)
	double min;
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
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	public double getMin() {
		return min;
	}
	public void setMin(double min) {
		this.min = min;
	}
	@Override
	public String toString() {
		return "MaterrielStorageDetail [matStoreDetId=" + matStoreDetId + ", matId=" + matId + ", amount=" + amount
				+ ", date=" + date + ", min=" + min + "]";
	}
	public MaterrielStorageDetail(String matStoreDetId, String matId, double amount, Timestamp date, double min) {
		super();
		this.matStoreDetId = matStoreDetId;
		this.matId = matId;
		this.amount = amount;
		this.date = date;
		this.min = min;
	}
	public MaterrielStorageDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
