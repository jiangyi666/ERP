package com.erp.service.pm;

import com.erp.dao.pm.employeeDaoImpl;
import com.erp.pojo.pm.employee;

import java.util.List;



public class employeeservice {
	static com.erp.dao.pm.employeeDaoImpl employeeDaoImpl;
	static {
		employeeDaoImpl=new employeeDaoImpl();
	}
	public static List<employee> getemployee(){
		return employeeDaoImpl.getemployee();
	}
}
