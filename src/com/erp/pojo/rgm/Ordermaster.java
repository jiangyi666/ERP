package com.erp.pojo.rgm;

public class Ordermaster {
	private String orderId;
	private String customerId;
	private String saleId;
	private double orderSum;
	private String orderDate;
	private String verify;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getSaleId() {
		return saleId;
	}

	public void setSaleId(String saleId) {
		this.saleId = saleId;
	}

	public double getOrderSum() {
		return orderSum;
	}

	public void setOrderSum(double orderSum) {
		this.orderSum = orderSum;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getVerify() {
		return verify;
	}

	public void setVerify(String verify) {
		this.verify = verify;
	}

	@Override
	public String toString() {
		return "Ordermaster [orderId=" + orderId + ", customerId=" + customerId + ", saleId=" + saleId + ", orderSum="
				+ orderSum + ", orderDate=" + orderDate + ", verify=" + verify + "]";
	}
}
