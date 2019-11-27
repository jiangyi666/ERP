package com.erp.service.pmg;

import com.erp.dao.pmg.GoodsLocationDaoImpl;
import com.erp.pojo.pmg.GoodsLocation;

import java.util.List;



public class GoodsLocationServiceImpl implements GoodsLocationService {

	GoodsLocationDaoImpl GLD = new GoodsLocationDaoImpl();
	public String[] thead;
	@Override
	public void addGoodsLocation(GoodsLocation goodsLocation) {
		// TODO Auto-generated method stub
		
		GLD.addGoodsLocation(goodsLocation);
	}

	@Override
	public void deleteGoodsLocation(String location) {
		// TODO Auto-generated method stub
		GLD.deleteGoodsLocation(location);
	}

	@Override
	public void updateGoodsLocation(GoodsLocation goodsLocation) {
		// TODO Auto-generated method stub
		GLD.updateGoodsLocation(goodsLocation);
	}

	@Override
	public List<GoodsLocation> getAllGoodsLocation() {
		// TODO Auto-generated method stub
		GoodsLocationDaoImpl GLD = new GoodsLocationDaoImpl();
		List<GoodsLocation> list = GLD.getAllGoodsLocation();
		this.thead = GLD.thead;
		return list;
	}

	@Override
	public GoodsLocation getGoodsLocationByPK(String location) {
		// TODO Auto-generated method stub
		return GLD.getGoodsLocationByPK(location);
	}

}
