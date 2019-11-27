package com.erp.service.pmg;

import com.erp.pojo.pmg.GoodsLocation;

import java.util.List;



public interface GoodsLocationService {

	public void addGoodsLocation(GoodsLocation goodsLocation);
	
	public void deleteGoodsLocation(String location);
	
	public void updateGoodsLocation(GoodsLocation goodsLocation);
	
	public List<GoodsLocation> getAllGoodsLocation();
	
	public GoodsLocation  getGoodsLocationByPK(String location);
}
