package com.erp.dao.rgm;
import com.erp.Utils.JDBCUtil;
import com.erp.pojo.crm.Dept;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class DeptDaoImpl implements DeptDao {

	// 添加部门
	@Override
	public boolean insertDept(Dept dept) {
		Connection conn=null;
		PreparedStatement ps=null;
		String sql;
		int status = 0;
		try {
			conn = JDBCUtil.getConnection();
			// 主键,需要查询数据库中看是否冲突，如果主键值已经存在直接return false
			if (findDeptById(dept.getDeptId()) != null) {
				return false;
			}

			sql = "insert into dept values(?,?);";

			ps = conn.prepareStatement(sql);
			ps.setString(1, dept.getDeptId());
			ps.setString(2, dept.getDeptname());

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

	// 删除部门
	@Override
	public boolean deleteDept(String id) {
		Connection conn=null;
		PreparedStatement ps=null;
		String sql;
		int status = 0;
		try {
			conn = JDBCUtil.getConnection();
			sql = "delete from dept where deptId=?;";

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

	// 修改部门信息
	@Override
	public boolean updateDept(Dept dept) {
		Connection conn=null;
		PreparedStatement ps=null;
		String sql;
		int status = 0;
		try {
			conn = JDBCUtil.getConnection();
			// 为了数据安全，不提供修改部门编号的接口
			sql = "update dept set  deptName=? where deptId=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, dept.getDeptname());
			ps.setString(2, dept.getDeptId());
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

	// 查找部门
	@Override
	public Dept findDeptById(String id) {
		Dept dept = null;
		try {
			Connection conn = JDBCUtil.getConnection();
			String sql = "select * from dept where DeptId=?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				dept = new Dept();
				dept.setDeptId(rs.getString(1));
				dept.setDeptname(rs.getString(2));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeall(null, null, null);
		}
		return dept;
	}

	// 获取部门列表
	@Override
	public List<Dept> getDepts() {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String sql;

		List<Dept> list = new ArrayList<Dept>();
		try {
			conn = JDBCUtil.getConnection();
			sql = "SELECT * FROM dept ORDER BY deptId;";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			// 读取行数据
			while (rs.next()) {
				Dept dept = new Dept();
				dept.setDeptId(rs.getString(1));
				dept.setDeptname(rs.getString(2));
				list.add(dept);
			}
		} catch (SQLException exception) {
			exception.printStackTrace();
		} finally {
			JDBCUtil.closeall(conn, ps, rs);
		}
		return list;
	}

	//获得部门名称列表
	@Override
	public List<String> getdeptNames() {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String sql;

		List<String> list = new ArrayList<String>();
		try {
			conn = JDBCUtil.getConnection();
			sql = "SELECT deptname FROM dept ORDER BY deptId;";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			// 读取行数据
			while (rs.next()) {
				String deptname=rs.getString(1);
				list.add(deptname);
			}
		} catch (SQLException exception) {
			exception.printStackTrace();
		} finally {
			JDBCUtil.closeall(conn, ps, rs);
		}
		return list;
	}

	@Override
	public int getDeptCount() {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String sql;
		int count = 0;
		
		try {
			conn = JDBCUtil.getConnection();
			sql = "SELECT count(*) from dept";
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

	@Override
	public List<Dept> getAllDeptsByStartEnd(int start, int end) {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String sql;

		List<Dept> list = new ArrayList<Dept>();
		try {
			conn = JDBCUtil.getConnection();
			sql = "SELECT * from dept LIMIT ?,?;";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, start);
			ps.setInt(2, end);
			rs = ps.executeQuery();
			// 读取行数据
			while (rs.next()) {
				Dept dept = new Dept();
				dept.setDeptId(rs.getString(1));
				dept.setDeptname(rs.getString(2));
				list.add(dept);
			}
		} catch (SQLException exception) {
			exception.printStackTrace();
		} finally {
			JDBCUtil.closeall(conn, ps, rs);
		}
		return list;
	}
}
