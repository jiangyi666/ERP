package com.erp.dao.rgm;

import com.erp.Utils.JDBCUtil;
import com.erp.pojo.rgm.SalesReturn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class SalesReturnDaoImpl implements SalesReturnDao {

	@Override
	public boolean addReturn(SalesReturn sr) {
		// TODO Auto-generated method stub
		Connection connnection=null;
		PreparedStatement ps = null;
		String sql;
		int status = 0;
		try {
			// 主键,需要查询数据库中看是否冲突，如果主键值已经存在直接return false
			if (findReturnById(sr.getReturnId()) != null) {
				
				return false;
			}
			// 外键约束
			if ((new OrdermasterDaoImpl().findOrdermasterById(sr.getOrderId()) == null)) {
				
				return false;
			}
			if ((new CustomerDaoImpl().findCustomerById(sr.getCustomerId())) == null) {
				
				return false;
			}

			connnection = JDBCUtil.getConnection();

			sql = "insert into salesreturn values(?,?,?,?,?,?,?);";

			ps = connnection.prepareStatement(sql);
			ps.setString(1, sr.getReturnId());
			ps.setString(2, sr.getOrderId());
			ps.setString(3, sr.getCustomerId());
			ps.setString(4, sr.getCustomerAddress());
			ps.setString(5, sr.getAddress());
			ps.setString(6, sr.getReturnDate());
			ps.setString(7, sr.getStatus());

			status = JDBCUtil.executeUpdate(ps);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeall(connnection, ps, null);
		}
		System.out.println(status);
		if (status > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean deleteReturn(String id) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		String sql;
		int status = 0;
		try {
			conn = JDBCUtil.getConnection();
			System.out.println(id);
			sql = "delete from salesreturn where returnId=?;";

			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			status = JDBCUtil.executeUpdate(ps);
			System.out.println("111");
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
	public boolean updateReturn(SalesReturn sr) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		String sql;
		int status = 0;
		try {
			// 外键约束
			if ((new OrdermasterDaoImpl().findOrdermasterById(sr.getOrderId()) == null)) {
				return false;
			}
			if ((new CustomerDaoImpl().findCustomerById(sr.getCustomerId())) == null) {
				return false;
			}

			conn = JDBCUtil.getConnection();

			// 不提供主键的修改
			sql = "update salesreturn set orderId=?,customerId=?,customerAddress=?,address=?,returnDate=?,status=? where returnId=?";
			ps = conn.prepareStatement(sql);

			ps.setString(1, sr.getOrderId());
			ps.setString(2, sr.getCustomerId());
			ps.setString(3, sr.getCustomerAddress());
			ps.setString(4, sr.getAddress());
			ps.setString(5, sr.getReturnDate());
			ps.setString(6, sr.getStatus());
			ps.setString(7, sr.getReturnId());

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
	public SalesReturn findReturnById(String id) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql;
		SalesReturn sr = null;
		try {
			conn = JDBCUtil.getConnection();
			sql = "select * from salesreturn where returnId=?;";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();

			if (rs.next()) {
				sr = new SalesReturn();
				sr.setReturnId(rs.getString(1));
				sr.setOrderId(rs.getString(2));
				sr.setCustomerId(rs.getString(3));
				sr.setCustomerAddress(rs.getString(4));
				sr.setAddress(rs.getString(5));
				sr.setReturnDate(rs.getString(6));
				sr.setStatus(rs.getString(7));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeall(conn, ps, rs);
		}
		return sr;
	}

	@Override
	public List<SalesReturn> getReturns() {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql;

		List<SalesReturn> list = new ArrayList<SalesReturn>();
		try {
			conn = JDBCUtil.getConnection();
			sql = "SELECT * FROM salesreturn ORDER BY returnid;";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			// 读取行数据
			while (rs.next()) {
				SalesReturn sr = new SalesReturn();
				sr.setReturnId(rs.getString(1));
				sr.setOrderId(rs.getString(2));
				sr.setCustomerId(rs.getString(3));
				sr.setCustomerAddress(rs.getString(4));
				sr.setAddress(rs.getString(5));
				sr.setReturnDate(rs.getString(6));
				sr.setStatus(rs.getString(7));
				list.add(sr);
			}
		} catch (SQLException exception) {
			exception.printStackTrace();
		} finally {
			JDBCUtil.closeall(conn, ps, rs);
		}
		return list;
	}
	
}
