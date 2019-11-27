package com.erp.pojo.pmg;

public class Materiel {
	
	public String matId;	//物料编号
	public String matName;		//物料名称
	public String brand;  //品牌
	public String type;	//纸种
	public String level;	//级别，约束再A，B，C中
	public double gram;	//克重
	public String matSpec;	//规格型号
	public String unit;	//单位
	public double matPrice;	//物料单价	
	
	public Materiel() {};
	
	public Materiel(String matId, String matName, String brand, String type, String lever, double gram, String matSpec,
			String unit, double matPrice) {
		super();
		this.matId = matId;
		this.matName = matName;
		this.brand = brand;
		this.type = type;
		this.level = lever;
		this.gram = gram;
		this.matSpec = matSpec;
		this.unit = unit;
		this.matPrice = matPrice;
	}
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
