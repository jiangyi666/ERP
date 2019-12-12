package com.erp.dao.rgm;

import com.erp.pojo.crm.Dept;

import java.util.List;




public interface DeptDao {
	// 添加部门
	public boolean insertDept(Dept dept);

	// 删除部门
	public boolean deleteDept(String id);

	// 修改部门信息
	public boolean updateDept(Dept dept);

	// 查找部门
	public Dept findDeptById(String id);

	// 获取部门列表
	public List<Dept> getDepts();

	//获取所有部门名称列表
	public List<String> getdeptNames();

	public int getDeptCount();

	public List<Dept> getAllDeptsByStartEnd(int start, int end);
}

