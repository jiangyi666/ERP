package com.erp.dao.pm;

import com.erp.Utils.JDBCUtil;
import com.erp.pojo.pm.employee;

import java.util.List;



public interface employeeDao {
	static JDBCUtil db=new JDBCUtil();
	public List<employee> getemployee();
}
