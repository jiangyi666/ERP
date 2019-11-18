package com.erp.dao.crm;

import com.erp.pojo.crm.Employee;

import java.util.List;

public interface EmployeeDao {
    /**
     * 校验用户，用来登录
     * 使用唯一的员工编号
     * @param employeeId
     * @param password
     * @return
     */
    public Employee checkEmployee(String employeeId, String password);

    /**
     * 获得职工列表
     * @return
     */
    public List<Employee> getAllEmployee();
}
