package com.erp.service.crm;

import com.erp.dao.crm.DeptDao;
import com.erp.dao.crm.DeptDaoImpl;
import com.erp.pojo.crm.Dept;

import java.util.List;

public class DeptServiceImpl implements DeptService {
    DeptDaoImpl deptDao=new DeptDaoImpl();
    @Override
    public List<Dept> getAllDept() {
        return deptDao.getAllDept();
    }

    /**
     * 根据部门名称获得部门编号
     * @param deptName
     * @return
     */
    @Override
    public String getDeptIdByDeptName(String deptName) {
        return deptDao.getDeptIdByDeptName(deptName);
    }

    /**
     * 跟新部门信息
     * @param dept
     */
    @Override
    public void updateDept(Dept dept) {
        deptDao.updateDept(dept);
    }

    /**
     * 根据部门编号来删除部门信息
     * @param deptId
     */
    @Override
    public void deleteDept(String deptId) {
        deptDao.deleteDept(deptId);
    }

    /**
     * 根据部门的编号来获得部门的信息
     * @param deptId
     * @return
     */
    @Override
    public Dept getDeptById(String deptId) {
        return deptDao.getDeptById(deptId);
    }

    @Override
    public void addDept(Dept dept) {
        deptDao.addDept(dept);
    }

    @Override
    public boolean checkDeptIdIsExist(String deptId) {
        return deptDao.checkDeptIdIsExist(deptId);
    }
}
