package com.erp.dao.pm;

import com.erp.pojo.pm.purchaseorder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class purchaseorderDaoImpl implements purchaseorderDao{
	
	
	public List<Map<String,Object>> getpurchaseorder(){
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rst = null; 
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		String sql="select * from purchasemaster";
		Object[] params=null;
		try {    
            // 获得连接    
            conn = db.getConnection();    
            // 调用SQL    
            pst = conn.prepareStatement(sql);    
            // 参数赋值      
            // 执行    
            rst = pst.executeQuery();
            ResultSetMetaData rsmd = null;
            int columnCount = 0; 
            rsmd = rst.getMetaData();  
            columnCount = rsmd.getColumnCount();
            while (rst.next()) {    
                Map<String, Object> map = new HashMap<String, Object>();    
                for (int i = 1; i <= columnCount; i++) {   
                	System.out.println("rs.getObject(i):     "+rst.getObject(i));
                    map.put(rsmd.getColumnLabel(i), rst.getObject(i));   
                    System.out.println("map:   "+map);
                }    
                list.add(map);//每一个map代表一条记录，把所有记录存在list中    
            }    
        } catch (SQLException e) {    
            System.out.println(e.getMessage());    
        }     
		return list;  
	}
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
        }     
		return list;  
	}
	public int save(purchaseorder q) {  //返回值设成int用来返回成功了多少条
		int affectLine = 0;
		
		String sql = "insert into purchasemaster(purchaseId, employeId, peeId, purchaseSum,purchaseDate,ifStorage)" +
				 " values(?,?,?,?,?,?)";
		Object[] params = new Object[6];
		params[0] = q.getPurchaseId();
		params[1] = q.getEmployeId();
		params[2] = q.getPeeId();
		params[3] = q.getPurchaseSum();
		params[4] = q.getPurchaseDate();
		params[5] = q.getIfStorage();
		affectLine = db.executeUpdate(sql, params);
		System.out.println(affectLine);
		return affectLine;
	}
	public int delete(String PurchaseId) {
		int affectLine = 0;
		String sql = "delete from purchasemaster where purchaseId = ?";
		String[] params = new String[1];
		params[0] = String.valueOf(PurchaseId);		
		return affectLine = db.executeUpdate(sql, params);
	}
	@Override
	public int update(String purchaseId, double purchaseSum) {
		int affectLine = 0;
		String sql ="update purchasemaster set purchaseSum=purchaseSum+? where purchaseId=?";
		Object[] params = new Object[2];
		params[0] = purchaseSum;
		params[1] = purchaseId;
		affectLine=db.executeUpdate(sql, params);
		return affectLine;
	}
	@Override
	public List<Map<String, Object>> getpurchaseorderById(String purchaseId) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rst = null; 
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		int affectLine = 0;
		String sql="select * from purchasemaster where purchaseId like \"%\"?\"%\"";
		Object[] params= new Object[1];
		params[0] = purchaseId;
		try {    
            // 获得连接    
            conn = db.getConnection();    
            // 调用SQL    
            pst = conn.prepareStatement(sql);    
            // 参数赋值    
            if (params != null) {    
                for (int i = 0; i < params.length; i++) {    
                	pst.setObject(i + 1, params[i]);
                	System.out.println(params[i]);
                	System.out.println(params.length);
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
                	System.out.println("rs.getObject(i):     "+rst.getObject(i));
                    map.put(rsmd.getColumnLabel(i), rst.getObject(i));   
                    System.out.println("map:   "+map);
                }    
                list.add(map);//每一个map代表一条记录，把所有记录存在list中    
            }    
        } catch (SQLException e) {    
            System.out.println(e.getMessage());    
        }     
		return list;  
	}
		
}
