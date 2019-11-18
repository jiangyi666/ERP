package com.erp.service.crm;

import com.erp.pojo.crm.Employee;

public interface LoginService {
    /**
     * 校验用户，用来登录
     * 使用唯一的员工编号
     * @param employeeId
     * @param password
     * @return
     */
    public Employee checkEmployee(String employeeId, String password);
}
