package com.erp.dao.rgm;
import com.erp.pojo.crm.Employee;

import java.util.List;




public interface EmployeeDao {
	// 添加员工
	public boolean insertEmployee(Employee e);

	// 删除员工
	public boolean deleteEmployee(String id);

	// 修改员工信息
	public boolean updateEmployee(Employee e);

	// 查找员工
	public Employee findEmployeeById(String id);

	// 通过员工登录账号和密码查询用户
	public Employee findEmployeeByIdAndPasswd(String loginId, String password);

	// 获取员工列表
	public List<Employee> getEmployees();

	// 获取分页的记录
	public List<Employee> getAllEmpByStartEnd(int start, int end);

	// 获取表的全部记录数
	public int getEmpCount();

	// 获取数据库表中符合条件总的记录数
	public int getEmpCount(String empName, double salary);

	// 获取符合条件分页查询结果
	public List<Employee> getAllEmpByStartEnd(int start, int end, String empName, double salary);

}
