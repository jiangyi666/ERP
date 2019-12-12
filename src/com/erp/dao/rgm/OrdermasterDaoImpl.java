package com.erp.dao.rgm;

import com.erp.Utils.JDBCUtil;
import com.erp.pojo.rgm.Ordermaster;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class OrdermasterDaoImpl implements OrdermasterDao {

	@Override
	public boolean insertOrdermaster(Ordermaster o) {
		Connection conn=null;
		PreparedStatement ps=null;
		String sql;
		int status = 0;
		try {
			conn = JDBCUtil.getConnection();
			// 主键,需要查询数据库中看是否冲突，如果主键值已经存在直接return false
			if (findOrdermasterById(o.getOrderId()) != null) {
				return false;
			}
			// 外键约束
			if (new CustomerDaoImpl().findCustomerById(o.getCustomerId()) == null) {
				return false;
			}
			if (new EmployeeDaoImpl().findEmployeeById(o.getSaleId()) == null) {
				return false;
			}

			sql = "insert into ordermaster values(?,?,?,?,?,?);";

			ps = conn.prepareStatement(sql);
			ps.setString(1, o.getOrderId());
			ps.setString(2, o.getCustomerId());
			ps.setString(3, o.getSaleId());
			ps.setDouble(4, o.getOrderSum());
			ps.setString(5, o.getOrderDate());
			ps.setString(6, o.getVerify());

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

	@Override
	public boolean deleteOrdermaster(String id) {
		Connection conn=null;
		PreparedStatement ps=null;
		String sql;
		int status = 0;
		try {
			conn = JDBCUtil.getConnection();
			sql = "delete from ordermaster where orderId=?;";

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

	@Override
	public boolean updateOrdermaster(Ordermaster o) {
		Connection conn=null;
		PreparedStatement ps=null;
		String sql;
		int status = 0;

		try {
			// 外键约束
			if (new CustomerDaoImpl().findCustomerById(o.getCustomerId()) == null) {
				return false;
			}
			if (new EmployeeDaoImpl().findEmployeeById(o.getSaleId()) == null) {
				return false;
			}

			conn = JDBCUtil.getConnection();
			sql = "update ordermaster set customerId=?,saleId=?,orderSum=?,orderDate=?,verify=? where orderId=?";
			ps = conn.prepareStatement(sql);
			// 不允许修改主键
			ps.setString(1, o.getCustomerId());
			ps.setString(2, o.getSaleId());
			ps.setDouble(3, o.getOrderSum());
			ps.setString(4, o.getOrderDate());
			ps.setString(5, o.getVerify());
			ps.setString(6, o.getOrderId());
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

	@Override
	public Ordermaster findOrdermasterById(String id) {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String sql;

		Ordermaster ordermaster = null;
		try {
			conn = JDBCUtil.getConnection();
			sql = "select * from ordermaster where orderId=?;";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();

			if (rs.next()) {
				ordermaster = new Ordermaster();
				ordermaster.setOrderId(rs.getString(1));
				ordermaster.setCustomerId(rs.getString(2));
				ordermaster.setSaleId(rs.getString(3));
				ordermaster.setOrderSum(rs.getDouble(4));
				ordermaster.setOrderDate(rs.getString(5));
				ordermaster.setVerify(rs.getString(6));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeall(conn, ps, rs);
		}
		return ordermaster;
	}
	
	@Override
	public List<Ordermaster> findOrdermasterByeId(String id) {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String sql;

		List<Ordermaster> list = new ArrayList<Ordermaster>();
		try {
			conn = JDBCUtil.getConnection();
			sql = "select * from ordermaster where saleId=?;";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			// 读取行数据
			while (rs.next()) {
				Ordermaster ordermaster = new Ordermaster();
				ordermaster.setOrderId(rs.getString(1));
				ordermaster.setCustomerId(rs.getString(2));
				ordermaster.setSaleId(rs.getString(3));
				ordermaster.setOrderSum(rs.getDouble(4));
				ordermaster.setOrderDate(rs.getString(5));
				ordermaster.setVerify(rs.getString(6));
				list.add(ordermaster);
			}
		} catch (SQLException exception) {
			exception.printStackTrace();
		} finally {
			JDBCUtil.closeall(conn, ps, rs);
		}
		return list;
	}

	@Override
	public List<Ordermaster> getOrdermasters() {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String sql;

		List<Ordermaster> list = new ArrayList<Ordermaster>();
		try {
			conn = JDBCUtil.getConnection();
			sql = "SELECT * FROM ordermaster ORDER BY orderId;";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			// 读取行数据
			while (rs.next()) {
				Ordermaster ordermaster = new Ordermaster();
				ordermaster.setOrderId(rs.getString(1));
				ordermaster.setCustomerId(rs.getString(2));
				ordermaster.setSaleId(rs.getString(3));
				ordermaster.setOrderSum(rs.getDouble(4));
				ordermaster.setOrderDate(rs.getString(5));
				ordermaster.setVerify(rs.getString(6));
				list.add(ordermaster);
			}
		} catch (SQLException exception) {
			exception.printStackTrace();
		} finally {
			JDBCUtil.closeall(conn, ps, rs);
		}
		return list;
	}

	@Override
	public List<Ordermaster> getAllCusByStartEnd(int start, int end) {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String sql;

		List<Ordermaster> list = new ArrayList<Ordermaster>();
		try {
			conn = JDBCUtil.getConnection();
			sql = "SELECT * from ordermaster LIMIT ?,?;";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, start);
			ps.setInt(2, end);
			rs = ps.executeQuery();
			// 读取行数据
			while (rs.next()) {
				Ordermaster ordermaster = new Ordermaster();
				ordermaster.setOrderId(rs.getString(1));
				ordermaster.setCustomerId(rs.getString(2));
				ordermaster.setSaleId(rs.getString(3));
				ordermaster.setOrderSum(rs.getDouble(4));
				ordermaster.setOrderDate(rs.getString(5));
				ordermaster.setVerify(rs.getString(6));
				list.add(ordermaster);
			}
		} catch (SQLException exception) {
			exception.printStackTrace();
		} finally {
			JDBCUtil.closeall(conn, ps, rs);
		}
		return list;
	}

}