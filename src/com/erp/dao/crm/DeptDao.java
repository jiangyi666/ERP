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

    /**
     * 跟新部门信息
     * @param dept
     */
    public void updateDept(Dept dept);

    /**
     * 根据部门Id来更新部门信息
     * @param deptId
     */
    public void deleteDept(String deptId);

    /**
     * 根据部门的编号来获得部门的信息
     * @param deptId
     * @return
     */
    public Dept getDeptById(String deptId);

    /**
     * 新增加部门信息
     */
    public void addDept(Dept dept);

    /**
     * 查询部门Id是否已经存在（用来新增加部门的时候使用)
     * @param deptId
     * @return
     */
    public boolean checkDeptIdIsExist(String deptId);
}
