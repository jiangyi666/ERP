package com.erp.service.crm;

import com.erp.pojo.crm.Employee;

import java.util.List;

public interface EmployeeService {
    /**
     * 获得职工列表
     * @return
     */
    public List<Employee> getAllEmployee();
}
