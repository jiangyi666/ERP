package com.erp.pojo.erm;

public class Materiel {
	private String matId;
	private String matName;
	private String brand;
	private String type;
	private String level;
	private double gram;
	private String matSpec;
	private String unit;
	private double matPrice;
	public String getMatId() {
		return matId;
	}
	public void setMatId(String matId) {
		this.matId = matId;
	}
	public String getMatName() {
		return matName;
	}
	public void setMatName(String matName) {
		this.matName = matName;
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
	public String getMatSpec() {
		return matSpec;
	}
	public void setMatSpec(String matSpec) {
		this.matSpec = matSpec;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public double getMatPrice() {
		return matPrice;
	}
	public void setMatPrice(double matPrice) {
		this.matPrice = matPrice;
	}
	@Override
	public String toString() {
		return "Materiel [matId=" + matId + ", matName=" + matName + ", brand=" + brand + ", type=" + type + ", level="
				+ level + ", gram=" + gram + ", matSpec=" + matSpec + ", unit=" + unit + ", matPrice=" + matPrice + "]";
	}
	
}
