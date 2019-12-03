package com.erp.pojo.erm;

import java.sql.Date;
import java.sql.Timestamp;

public class Purchasemaster {
	private String purchaseId;//采购订单编号
	private String employeId;//采购员编号
	private String peeId;//供应商编号
	private double purchaseSum;//采购金额
	private Timestamp purchaseDate;//采购时间
	public String getPurchaseId() {
		return purchaseId;
	}
	public void setPurchaseId(String purchaseId) {
		this.purchaseId = purchaseId;
	}
	public String getEmployeId() {
		return employeId;
	}
	public void setEmployeId(String employeId) {
		this.employeId = employeId;
	}
	public String getPeeId() {
		return peeId;
	}
	public void setPeeId(String peeId) {
		this.peeId = peeId;
	}
	public double getPurchaseSum() {
		return purchaseSum;
	}
	public void setPurchaseSum(double purchaseSum) {
		this.purchaseSum = purchaseSum;
	}
	public Timestamp getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(Timestamp purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	@Override
	public String toString() {
		return "Purchasemaster [purchaseId=" + purchaseId + ", employeId=" + employeId + ", peeId=" + peeId
				+ ", purchaseSum=" + purchaseSum + ", purchaseDate=" + purchaseDate + "]";
	}
	

}
