package com.erp.dao.pmg;

import com.erp.Utils.JDBCUtil;
import com.erp.pojo.pmg.GoodsLocation;

import java.sql.Connection;
import java.util.List;



public interface GoodsLocationDao {
	
	Connection conn = new JDBCUtil().getConnection(); //获取数据库连接

	
	public void addGoodsLocation(GoodsLocation goodsLocation);
	
	public void deleteGoodsLocation(String location);
	
	public void updateGoodsLocation(GoodsLocation goodsLocation);
	
	public List<GoodsLocation> getAllGoodsLocation();
	
	public GoodsLocation  getGoodsLocationByPK(String location);
}
