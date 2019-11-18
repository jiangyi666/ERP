package com.erp.service.crm;


import com.erp.dao.crm.EmployeeDaoImpl;
import com.erp.pojo.crm.Employee;

public class LoginServiceImpl implements LoginService {
    EmployeeDaoImpl employeeDao=new EmployeeDaoImpl();
    @Override
    public Employee checkEmployee(String employeeId, String password) {
        return employeeDao.checkEmployee(employeeId,password);
    }
}
