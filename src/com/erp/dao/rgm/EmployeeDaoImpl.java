package com.erp.dao.rgm;


import com.erp.Utils.JDBCUtil;
import com.erp.pojo.crm.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;




public class EmployeeDaoImpl implements EmployeeDao {
	/*
	 * 注意: 为了统一标准，并解决jdbc对象的关闭与使用的问题，Connection，
	 * PreparedStatement和ResultSet的对象都声明为dao方法的局部变量，不宜作为成员变量。
	 */

	// 添加员工
	@Override
	public boolean insertEmployee(Employee employee) {
		Connection conn=null;
		PreparedStatement ps=null;
		String sql;
		int status = 0;
		try {
			conn = JDBCUtil.getConnection();
			String employeeId = employee.getEmployeeId();// 主键,需要查询数据库中看是否冲突，如果冲突直接return false
			if (findEmployeeById(employeeId) != null) { // 将conn,ps和rs声明为函数的局部变量，能解决jdbc对象的关闭与使用的问题。如果conn,ps和rs是成员变量，必须要new一个新的EmployeeDaoImpl对象来执行findEmployeeById执行了本条件语句，因为findEmployeeById方法会关闭掉conn,ps和rs,而本条件语句之后还会使用到conn,ps和rs，所以conn,ps和rs是成员变量时会编译失败.这种情况只要通过new另一个本类对象来解决即可。
				return false;
			}
			String employeeName = employee.getEmployeeName();
			String password = employee.getPassword();
			String deptId = employee.getDeptId();// 外键，需要查看部门表看是否冲突，如果冲突直接return false
			if ((new DeptDaoImpl().findDeptById(deptId)) == null) {
				return false;
			}
			String headship = employee.getHeadship();
			double salary = employee.getSalary();

			int privilege= employee.getPrivilege();
			
			sql = "insert into employee values(?,?,?,?,?,?,?)";

			ps = conn.prepareStatement(sql);
			ps.setString(1, employeeId);
			ps.setString(2, employeeName);
			ps.setString(3, password);
			ps.setString(4, deptId);
			ps.setString(5, headship);
			ps.setDouble(6, salary);
			ps.setInt(7, privilege);

			status = JDBCUtil.executeUpdate(ps);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeall(conn, ps, null);
		}

		if (status > 0) {
			return true;
		} else {
			return false;
		}
	}

	// 删除员工
	@Override
	public boolean deleteEmployee(String id) {
		Connection conn=null;
		PreparedStatement ps=null;
		String sql;
		int status = 0;
		try {
			conn = JDBCUtil.getConnection();
			sql = "delete from employee where employeeId=?;";

			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			status = JDBCUtil.executeUpdate(ps);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeall(conn, ps, null);
		}

		if (status > 0) {
			return true;
		} else {
			return false;
		}
	}

	// 修改员工信息
	@Override
	public boolean updateEmployee(Employee employee) {
		Connection conn=null;
		PreparedStatement ps=null;
		String sql;
		int status = 0;
		try {
			conn = JDBCUtil.getConnection();
			// 为了数据安全，不提供修改员工编号的接口
			sql = "update employee set  employeeName=?,password=?, deptId=?, headship=?, salary=?,privilege=? where employeeId=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, employee.getEmployeeName());
			ps.setString(2, employee.getPassword());
			ps.setString(3, employee.getDeptId());
			if (findEmployeeById(employee.getDeptId()) != null) {
				return false;
			}
			ps.setString(4, employee.getHeadship());
			ps.setDouble(5, employee.getSalary());
			ps.setInt(6, employee.getPrivilege());
			ps.setString(7, employee.getEmployeeId());
			status = JDBCUtil.executeUpdate(ps);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeall(conn, ps, null);
		}
		if (status > 0) {
			return true;
		} else {
			return false;
		}
	}

	// 查找员工
	@Override
	public Employee findEmployeeById(String id) {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String sql;
		Employee employee = null;
		try {
			conn = JDBCUtil.getConnection();
			sql = "select * from employee where employeeId=?;";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = JDBCUtil.query(ps);

			if (rs.next()) {
				employee = new Employee();
				employee.setEmployeeId(rs.getString(1));
				employee.setEmployeeName(rs.getString(2));
				employee.setPassword(rs.getString(3));
				employee.setDeptId(rs.getString(4));
				employee.setHeadship(rs.getString(5));
				employee.setSalary(rs.getDouble(6));
				employee.setPrivilege(rs.getInt(7));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeall(conn, ps, rs);
		}
		return employee;
	}

	// 通过员工登录账号和密码查询员工
	@Override
	public Employee findEmployeeByIdAndPasswd(String loginId, String password) {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String sql;
		Employee employee = null;
		try {
			conn = JDBCUtil.getConnection();
			sql = "select * from employee where employeeId=? and password=? ;";
			ps = conn.prepareStatement(sql);
			ps.setString(1, loginId);
			ps.setString(2, password);
			rs = JDBCUtil.query(ps);

			if (rs.next()) {
				employee = new Employee();
				employee.setEmployeeId(rs.getString(1));
				employee.setEmployeeName(rs.getString(2));
				employee.setPassword(rs.getString(3));
				employee.setDeptId(rs.getString(4));
				employee.setHeadship(rs.getString(5));
				employee.setSalary(rs.getDouble(6));
				employee.setPrivilege(rs.getInt(7));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeall(conn, ps, rs);
		}
		return employee;
	}

	// 获取员工列表
	@Override
	public List<Employee> getEmployees() {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String sql;

		List<Employee> list = new ArrayList<Employee>();
		try {
			conn = JDBCUtil.getConnection();
			sql = "select * from employee order by employeeId;";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			// 读取行数据
			while (rs.next()) {
				Employee employee = new Employee();
				employee.setEmployeeId(rs.getString(1));
				employee.setEmployeeName(rs.getString(2));
				employee.setPassword(rs.getString(3));
				employee.setDeptId(rs.getString(4));
				employee.setHeadship(rs.getString(5));
				employee.setSalary(rs.getDouble(6));
				employee.setPrivilege(rs.getInt(7));
				list.add(employee);
			}
		} catch (SQLException exception) {
			exception.printStackTrace();
		} finally {
			JDBCUtil.closeall(conn, ps, rs);
		}
		return list;
	}

	@Override
	public List<Employee> getAllEmpByStartEnd(int start, int end) {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String sql;

		List<Employee> list = new ArrayList<Employee>();
		try {
			conn = JDBCUtil.getConnection();
			sql = "SELECT * from employee LIMIT ?,?;";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, start);
			ps.setInt(2, end);
			rs = ps.executeQuery();
			// 读取行数据
			while (rs.next()) {
				Employee employee = new Employee();
				employee.setEmployeeId(rs.getString(1));
				employee.setEmployeeName(rs.getString(2));
				employee.setPassword(rs.getString(3));
				employee.setDeptId(rs.getString(4));
				employee.setHeadship(rs.getString(5));
				employee.setSalary(rs.getDouble(6));
				employee.setPrivilege(rs.getInt(7));
				list.add(employee);
			}
		} catch (SQLException exception) {
			exception.printStackTrace();
		} finally {
			JDBCUtil.closeall(conn, ps, rs);
		}
		return list;
	}


	
	// 获取表的全部记录数
	@Override
	public int getEmpCount() {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String sql;
		int count = 0;
		
		try {
			conn = JDBCUtil.getConnection();
			sql = "SELECT count(*) from employee";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			// 读取行数据
			if (rs.next()) {
				count=rs.getInt(1);
			}
		} catch (SQLException exception) {
			exception.printStackTrace();
		} finally {
			JDBCUtil.closeall(conn, ps, rs);
		}
		return count;
	}

	
	// 获取数据库表中符合条件总的记录数
	@Override
	public int getEmpCount(String empName, double salary) {
		Connection conn=null;
		Statement stmt = null;
		ResultSet rs=null;
		int count = 0;
		
		try {
			conn = JDBCUtil.getConnection();
			stmt=conn.createStatement();
			StringBuilder sql= new StringBuilder("select count(*) from employee where 1=1");
			if(empName !=null || ! "".equals(empName)) {
				sql.append(" and employeeName like '%"+empName+"%'");
			}
			if(salary>0) {
				sql.append(" and salary >="+salary);
			}
			rs=stmt.executeQuery(sql.toString());
			// 读取行数据
			if (rs.next()) {
				count=rs.getInt(1);
			}
		} catch (SQLException exception) {
			exception.printStackTrace();
		} finally {
			JDBCUtil.closeall(conn, null, rs);
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return count;
	}

	// 获取符合条件分页查询结果
	/*public List<Employee> getAllEmpByStartEnd(String empName, double salary) {
		
		return null;
	}*/
	@Override
	public List<Employee> getAllEmpByStartEnd(int start, int end, String empName, double salary) {
		Connection conn=null;
		Statement stmt = null;
		ResultSet rs=null;
		
		
		List<Employee> list = new ArrayList<Employee>();
		try {
			conn = JDBCUtil.getConnection();
			stmt=conn.createStatement();
			StringBuilder sql= new StringBuilder("SELECT * from( SELECT * FROM employee where 1=1");
			if(empName !=null || ! "".equals(empName)) {
				sql.append(" and employeeName like '%"+empName+"%'");
			}
			if(salary>0) {
				sql.append(" and salary >="+salary);
			}
			sql.append(") t LIMIT "+start+","+end);
			
			rs=stmt.executeQuery(sql.toString());
			// 读取行数据
			while (rs.next()) {
				Employee employee = new Employee();
				employee.setEmployeeId(rs.getString(1));
				employee.setEmployeeName(rs.getString(2));
				employee.setPassword(rs.getString(3));
				employee.setDeptId(rs.getString(4));
				employee.setHeadship(rs.getString(5));
				employee.setSalary(rs.getDouble(6));
				employee.setPrivilege(rs.getInt(7));
				list.add(employee);
			}
		} catch (SQLException exception) {
			exception.printStackTrace();
		} finally {
			JDBCUtil.closeall(conn, null, rs);
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
}

