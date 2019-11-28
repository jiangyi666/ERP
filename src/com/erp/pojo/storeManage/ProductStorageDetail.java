package com.erp.pojo.storeManage;

import java.sql.Timestamp;

public class ProductStorageDetail {
	
//	产品库存编号
	String productStoId;
//	产品编号
	String productId;
//	剩余数量
	double amount;
//	统计录入时间
	Timestamp date;
//	最低库存量(吨)
	double min;
	
	public String getProductStoId() {
		return productStoId;
	}
	public void setProductStoId(String productStoId) {
		this.productStoId = productStoId;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
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
		return "ProductStorageDetail [productStoId=" + productStoId + ", productId=" + productId + ", amount=" + amount
				+ ", date=" + date + ", min=" + min + "]";
	}

	

	
}
