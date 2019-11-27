package com.erp.pojo.pmg;

public class Product {
	
	public String productId;  //产品编号
	public String productName;  //产品名称
	public String brand;  //品牌
	public String type;	//纸种
	public String level;	//级别
	public double gram;	//克重
	public String productSpec;		//产品规格（单位）
	public String unit;	//单位
	public double productPrice;	//产品单价
	
	public Product() {};
	
	public Product(String productId, String productName, String brand, String type, String level, double gram,
			String productSpec, String unit, double productPrice) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.brand = brand;
		this.type = type;
		this.level = level;
		this.gram = gram;
		this.productSpec = productSpec;
		this.unit = unit;
		this.productPrice = productPrice;
	}
	
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public double getGram() {
		return gram;
	}
	public void setGram(double gram) {
		this.gram = gram;
	}
	public String getProductSpec() {
		return productSpec;
	}
	public void setProductSpec(String productSpec) {
		this.productSpec = productSpec;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", brand=" + brand + ", type="
				+ type + ", level=" + level + ", gram=" + gram + ", productSpec=" + productSpec + ", unit=" + unit
				+ ", productPrice=" + productPrice + "]";
	}
	
	
	
}
