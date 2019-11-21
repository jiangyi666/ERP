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
}
