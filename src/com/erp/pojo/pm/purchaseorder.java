package com.erp.pojo.pm;

//import java.sql.Date;
import java.util.Date;
import java.sql.Timestamp;

public class purchaseorder {
		private String purchaseId;//采购订单编号
		private String employeId;//采购员编号
		private String peeId;//供应商编号
		private double purchaseSum;//采购金额
		private Date purchaseDate;//采购时间
		private String ifStorage;//是否入库
		public String getIfStorage() {
			return ifStorage;
		}
		public void setIfStorage(String ifStorage) {
			this.ifStorage = ifStorage;
		}
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
		public Date getPurchaseDate() {
			return purchaseDate;
		}
		public void setPurchaseDate(Date purchaseDate) {
			this.purchaseDate = purchaseDate;
		}

}
