package com.erp.dao.pm;

import com.erp.Utils.JDBCUtil;
import com.erp.pojo.pm.employee;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;



public class employeeDaoImpl implements employeeDao{
	JDBCUtil db=new JDBCUtil();
	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rst = null; 
	List<employee> list=new ArrayList<employee>();
	public List<employee> getemployee(){
		String sql="select * from employee";
        try {    
             conn = db.getConnection();    
             pst = conn.prepareStatement(sql);    
             rst = pst.executeQuery();  
             while (rst.next()) {     
         		employee em =new employee(); 
         		em.setEmployeeId(rst.getString(1));
         		//System.out.println(em.getEmployeeId());
         		list.add(em);
         	}   
         	} catch (SQLException e) {    
         			System.out.println(e.getMessage());    
         		}      finally {    
        	//db.release(conn, pst, rst);
        }    
		return list;
	}
	
}
