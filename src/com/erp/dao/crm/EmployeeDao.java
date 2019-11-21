package com.erp.dao.crm;

import com.erp.pojo.crm.Employee;

import java.util.EnumMap;
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

    /**
     * 添加新的职工
     * @param employee
     */
    public void addEmployee(Employee employee);

    /**
     * 用来查看一个职工编号是否已经存在
     * @param employeeId
     * @return
     */
    public boolean checkEmpIdIsExist(String employeeId);

}
