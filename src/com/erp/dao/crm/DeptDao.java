package com.erp.dao.crm;

import com.erp.pojo.crm.Dept;

import java.util.List;

/**
 * 部门操作
 */
public interface DeptDao {
    /**
     * 获得所有的部门
     * @return
     */
    public List<Dept> getAllDept();

    /**
     * 根据部门名获得部门编号
     * @param deptName
     * @return
     */
    public String getDeptIdByDeptName(String deptName);
}
