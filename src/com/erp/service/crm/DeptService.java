package com.erp.service.crm;

import com.erp.pojo.crm.Dept;

import java.util.List;

public interface DeptService {
    /**
     * 获得所有的部门
     * @return
     */
    public List<Dept> getAllDept();
}
