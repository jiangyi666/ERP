package com.erp.pojo.pmg;

public class GoodsLocation {
	
	public String location;
	public String goodsType;
	
	public GoodsLocation() {}
	
	public GoodsLocation(String location, String goodsType) {
		super();
		this.location = location;
		this.goodsType = goodsType;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getGoodsType() {
		return goodsType;
	}
	public void setGoodsType(String goodsType) {
		this.goodsType = goodsType;
	}
	@Override
	public String toString() {
		return "GoodsLocation [location=" + location + ", goodsType=" + goodsType + "]";
	}
	
}
