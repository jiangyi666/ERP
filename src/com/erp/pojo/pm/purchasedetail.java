package com.erp.pojo.pm;

public class purchasedetail {
		private String purchaseId;//采购订单编号
		private String matId;//原料编号
		private double qty;//原料数量
		private double price;//原料单价
		private double transpCosts;//运输费用
		public String getPurchaseId() {
			return purchaseId;
		}
		public void setPurchaseId(String purchaseId) {
			this.purchaseId = purchaseId;
		}
		public String getMatId() {
			return matId;
		}
		public void setMatId(String matId) {
			this.matId = matId;
		}
		public double getQty() {
			return qty;
		}
		public void setQty(double qty) {
			this.qty = qty;
		}
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}
		public double getTranspCosts() {
			return transpCosts;
		}
		public void setTranspCosts(double transpCosts) {
			this.transpCosts = transpCosts;
		}
}
