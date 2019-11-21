package com.erp.service.crm;

import com.erp.pojo.crm.Employee;

import java.util.List;

public interface EmployeeService {
    /**
     * 获得职工列表
     * @return
     */
    public List<Employee> getAllEmployee();
    /**
     * 通过员工的编号来获得职工的信息
     * @param employeeId
     * @return
     */
    public Employee getEmployeeById(String employeeId);

    /**
     * 根据employeeId来更新员工信息
     * @param employee
     */
    public void updateEmployeeById(Employee employee);

    /**
     * 根据职工ID来删除职工
     * @param employeeId
     */
    public void deleteEmployeeById(String employeeId);
}
