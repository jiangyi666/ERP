package com.erp.dao.rgm;

import com.erp.Utils.JDBCUtil;
import com.erp.pojo.pacm.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class CustomerDaoImpl implements CustomerDao{

	//向客户表中添加客户数据
	@Override
	public boolean insertCustomer(Customer customer) {
		Connection connection =null;
		PreparedStatement ps = null;
		String sql;
		int status = 0;
		try {
			connection = JDBCUtil.getConnection();
			String customerID = customer.getCustomerId();
			// 主键,需要查询数据库中看是否冲突，如果冲突直接return false
			if (findCustomerById(customerID) != null) { 
				return false;
			}
			
			String password=customer.getPassword();
			
			String customerName = customer.getCustomerName();
			String telephone = customer.getTelephone();

			sql = "insert into customer values(?,?,?,?)";

			ps = connection.prepareStatement(sql);
			ps.setString(1, customerID);
			ps.setString(2,password);
			ps.setString(3, customerName);
			ps.setString(4, telephone);

			status = JDBCUtil.executeUpdate(ps);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeall(connection, ps, null);
		}

		if (status > 0) {
			return true;
		} else {
			return false;
		}
	}

	//向客户表中删除客户数据
	@Override
	public boolean deleteCustomer(String id) {
		Connection conn =null;
		PreparedStatement ps =null;
		String sql;
		int status = 0;
		try {
			conn = JDBCUtil.getConnection();
			sql = "delete from customer where customerId=?;";

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

	//向客户表中更新数据
	@Override
	public boolean updateCustomer(Customer customer) {
		Connection conn=null;
		PreparedStatement ps=null;
		String sql;
		int status = 0;
		try {
			conn = JDBCUtil.getConnection();
			// 为了数据安全，不提供修改客户编号的接口
			sql = "update customer set password=?,customerName=?,telephone=? where customerId=?";
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, customer.getPassword());
			ps.setString(2, customer.getCustomerName());
			ps.setString(3, customer.getTelephone());
			ps.setString(4, customer.getCustomerId());
			
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

	//通过customerID查询客户表中的数据
	@Override
	public Customer findCustomerById(String id) {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String sql;
		Customer customer = null;
		try {
			conn = JDBCUtil.getConnection();
			sql = "select * from customer where customerId=?;";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = JDBCUtil.query(ps);

			if (rs.next()) {
				customer = new Customer();
				customer.setCustomerId(rs.getString(1));
				customer.setPassword(rs.getString(2));
				customer.setCustomerName(rs.getString(3));
				customer.setTelephone(rs.getString(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeall(conn, ps, rs);
		}
		return customer;
	}

	//获取客户列表信息
	@Override
	public List<Customer> getCustomers() {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String sql;
		List<Customer> list = new ArrayList<Customer>();
		try {
			conn = JDBCUtil.getConnection();
			sql = "select * from customer order by customerId;";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			// 读取行数据
			while (rs.next()) {
				Customer customer = new Customer();
				customer.setCustomerId(rs.getString(1));
				customer.setPassword(rs.getString(2));
				customer.setCustomerName(rs.getString(3));
				customer.setTelephone(rs.getString(4));
				list.add(customer);
			}
		} catch (SQLException exception) {
			exception.printStackTrace();
		} finally {
			JDBCUtil.closeall(conn, ps, rs);
		}
		return list;
	}

	@Override
	public Customer findCustomerById(String loginId, String password) {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String sql;
		Customer customer = null;
		try {
			conn = JDBCUtil.getConnection();
			sql = "select * from customer where customerId=? and password=?;";
			ps = conn.prepareStatement(sql);
			ps.setString(1, loginId);
			ps.setString(2, password);
			rs = JDBCUtil.query(ps);

			if (rs.next()) {
				customer = new Customer();
				customer.setCustomerId(rs.getString(1));
				customer.setPassword(rs.getString(2));
				customer.setCustomerName(rs.getString(3));
				customer.setTelephone(rs.getString(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeall(conn, ps, rs);
		}
		return customer;
	}

	@Override
	public List<Customer> getAllCusByStartEnd(int start, int end) {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String sql;

		List<Customer> list = new ArrayList<Customer>();
		try {
			conn = JDBCUtil.getConnection();
			sql = "SELECT * from customer LIMIT ?,?;";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, start);
			ps.setInt(2, end);
			rs = ps.executeQuery();
			// 读取行数据
			while (rs.next()) {
				Customer customer = new Customer();
				customer.setCustomerId(rs.getString(1));
				customer.setCustomerName(rs.getString(2));
				customer.setTelephone(rs.getString(3));
				list.add(customer);
			}
		} catch (SQLException exception) {
			exception.printStackTrace();
		} finally {
			JDBCUtil.closeall(conn, ps, rs);
		}
		return list;
	}
}

