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
}
