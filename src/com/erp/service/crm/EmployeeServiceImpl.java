package com.erp.service.crm;

import com.erp.dao.crm.EmployeeDaoImpl;
import com.erp.pojo.crm.Employee;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    EmployeeDaoImpl employeeDao=new EmployeeDaoImpl();

    /**
     * 获得所有的员工列表
     * @return
     */
    @Override
    public List<Employee> getAllEmployee() {
        return employeeDao.getAllEmployee();
    }
}
