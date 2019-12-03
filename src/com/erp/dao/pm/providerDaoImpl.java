package com.erp.dao.pm;

import com.erp.Utils.JDBCUtil;
import com.erp.pojo.pm.provider;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;



public class providerDaoImpl implements providerDao{
	JDBCUtil db=new JDBCUtil();
	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rst = null; 
	List<provider> list=new ArrayList<provider>();
	public List<provider> getprovider(){
		String sql="select * from providers";
        try {    
             conn = db.getConnection();    
             pst = conn.prepareStatement(sql);    
             rst = pst.executeQuery();  
             while (rst.next()) {     
            	 provider pr =new provider(); 
         		pr.setPeeId(rst.getString(1));
         		list.add(pr);
         	}   
         	} catch (SQLException e) {    
         			System.out.println(e.getMessage());    
         		}      finally {    
        	db.release(conn, pst, rst);
        }    
		return list;
	}
}
