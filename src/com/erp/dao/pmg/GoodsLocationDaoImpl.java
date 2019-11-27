package com.erp.dao.pmg;

import com.erp.pojo.pmg.GoodsLocation;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class GoodsLocationDaoImpl implements GoodsLocationDao {

	PreparedStatement pst;
	ResultSet rs;
	
	public String[] thead;
	
	@Override
	public void addGoodsLocation(GoodsLocation goodsLocation) {
		// TODO Auto-generated method stub
		String sql = "insert into goodsLocation values(?,?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, goodsLocation.location);
			pst.setString(2, goodsLocation.goodsType);
			
			pst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void deleteGoodsLocation(String location) {
		// TODO Auto-generated method stub
		String sql = "delete from goodsLocation where location=?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, location);
			pst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateGoodsLocation(GoodsLocation goodsLocation) {
		// TODO Auto-generated method stub
		String sql = "update goodsLocation set goodsType=? where location=?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, goodsLocation.goodsType);
			pst.setString(2, goodsLocation.location);
			pst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<GoodsLocation> getAllGoodsLocation() {
		// TODO Auto-generated method stub
		String sql = "select * from goodsLocation";
		GoodsLocation GL = null;
		List<GoodsLocation> list = new ArrayList<GoodsLocation>();
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			
			ResultSetMetaData rsmd = rs.getMetaData();
			
/*			int col = rsmd.getColumnCount();  //获取表的列数
			this.thead = new String[col];
			*/
			this.thead = new String[2];
			
			this.thead[0] = "仓库编号";
			this.thead[1] = "仓库类型";
			
			while(rs.next()) {
				GL = new GoodsLocation(rs.getString(1),rs.getString(2));
				list.add(GL);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public GoodsLocation getGoodsLocationByPK(String location) {
		// TODO Auto-generated method stub
		String sql = "select * from goodsLocation where location=?";
		GoodsLocation GL = null;
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, location);
			rs = pst.executeQuery();
			while(rs.next()) {
				GL = new GoodsLocation(rs.getString(1),rs.getString(2));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return GL;
	}

}
