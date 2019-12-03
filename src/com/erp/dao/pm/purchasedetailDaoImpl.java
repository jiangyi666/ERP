package com.erp.dao.pm;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.erp.Utils.JDBCUtil;

import com.erp.pojo.pm.purchasedetail;

public class purchasedetailDaoImpl implements purchasedetailDao{
	
	
	public List<Map<String,Object>> getpurchaseorderdetail(String PurchaseId){
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rst = null; 
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		String sql = "select * from purchasedetail where purchaseId = ?";	
		Object[] params = new Object[1];
		params[0] = PurchaseId;
		try {    
            // 获得连接    
            conn = db.getConnection();    
            // 调用SQL    
            pst = conn.prepareStatement(sql);    
            // 参数赋值    
            if (params != null) {    
                for (int i = 0; i < params.length; i++) {    
                	pst.setObject(i + 1, params[i]);
                }    
            }    
            // 执行    
            rst = pst.executeQuery();
            ResultSetMetaData rsmd = null;
            int columnCount = 0; 
            rsmd = rst.getMetaData();  
            columnCount = rsmd.getColumnCount();
            while (rst.next()) {    
                Map<String, Object> map = new HashMap<String, Object>();    
                for (int i = 1; i <= columnCount; i++) {   
                    map.put(rsmd.getColumnLabel(i), rst.getObject(i));   
                }    
                list.add(map);//每一个map代表一条记录，把所有记录存在list中    
            }    
        } catch (SQLException e) {    
            System.out.println(e.getMessage());    
        }finally{
            JDBCUtil.closeall(conn, pst, null);
        }     
		return list;  
	}
	public int save(purchasedetail q) {  //返回值设成int用来返回成功了多少条
		int affectLine = 0;
		
		String sql = "insert into purchasedetail(purchaseId,matId, qty,price,transpCosts)" +
				 " values(?,?,?,?,?)";
		Object[] params = new Object[5];
		params[0] = q.getPurchaseId();
		params[1] = q.getMatId();
		params[2] = q.getQty();
		params[3] = q.getPrice();
		params[4] = q.getTranspCosts();
		affectLine = db.executeUpdate(sql, params);
		System.out.println(affectLine);
		return affectLine;
	}
	public int deleteSingle(String matId) {
		int affectLine = 0;
		String sql = "delete from purchasedetail where matId = ?";
		String[] params = new String[1];
		params[0] = String.valueOf(matId);		
		return affectLine = db.executeUpdate(sql, params);
	}
	@Override
	public int delete(String purchaseId) {
		int affectLine = 0;
		String sql = "delete from purchasedetail where purchaseId = ?";
		String[] params = new String[1];
		params[0] = String.valueOf(purchaseId);		
		return affectLine = db.executeUpdate(sql, params);
	}
		
}
