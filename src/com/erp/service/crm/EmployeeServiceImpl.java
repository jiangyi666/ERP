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
    /**
     * 通过员工的编号来获得职工的信息
     * @param employeeId
     * @return
     */
    @Override
    public Employee getEmployeeById(String employeeId) {
        return employeeDao.getEmployeeById(employeeId);
    }
    /**
     * 根据employeeId来更新员工信息
     * @param employee
     */
    @Override
    public void updateEmployeeById(Employee employee) {
        employeeDao.updateEmployeeById(employee);
    }

    /**
     * 根据职工ID来删除职工
     * @param employeeId
     */
    @Override
    public void deleteEmployeeById(String employeeId) {
        employeeDao.deleteEmployeeById(employeeId);
    }

    /**
     * 添加新的职工
     * @param employee
     */
    @Override
    public void addEmployee(Employee employee) {
        employeeDao.addEmployee(employee);
    }

    /**
     *用来检测一个员工号是否已经存在
     * @param employeeId
     * @return
     */
    @Override
    public boolean checkEmpIdIsExist(String employeeId) {
        return employeeDao.checkEmpIdIsExist(employeeId);
    }
}
