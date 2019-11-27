package com.erp.dao.pacm;

import com.erp.Utils.JDBCUtil;
import com.erp.pojo.pacm.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class CustomerDaoImpl implements CustomerDao{
	//查找相关页数的所有客户信息
	public List<Customer> getAll(int pageNo) {
		List<Customer> list = new ArrayList<Customer>();
        Connection connection = JDBCUtil.getConnection();
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        String sql="select customerId,customerName,telephone from customer limit ?,? ";
        
        try {
             preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
             preparedStatement.setInt(1, (pageNo-1)*6);
             preparedStatement.setInt(2, 6);
             
             
             resultSet = preparedStatement.executeQuery();
            while(resultSet.next())
            {
            	
            	list.add(new Customer(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
			JDBCUtil.release(connection,preparedStatement,resultSet);
           
        }
        return list;
	}
	
	//插入新客户
	@Override
	public void addCustomer(Customer c) {
		Connection connection = JDBCUtil.getConnection();
		 PreparedStatement preparedStatement=null;
	        ResultSet resultSet=null;
	    	String sql="insert into customer(customerId,customerName,telephone) values(?,?,?)";
	        PreparedStatement pst;
			try {
				pst = connection.prepareStatement(sql);
				pst.setString(1, c.getCustomerId());
				pst.setString(2, c.getCustomerName());
				pst.setString(3, c.getTelephone());
				pst.executeUpdate();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
	}

	//更新客户信息
	@Override
	public void updCustomer(Customer c) {
		// TODO Auto-generated method stub
		Connection connection = JDBCUtil.getConnection();
		 PreparedStatement preparedStatement=null;
	        ResultSet resultSet=null;
	    	String sql="update customer set customerName=?,telephone=? where customerId=?";
	        PreparedStatement pst;
			try {
				pst = connection.prepareStatement(sql);
				pst.setString(1, c.getCustomerName());
				pst.setString(2, c.getTelephone());
				pst.setString(3, c.getCustomerId());
			
				pst.executeUpdate();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	}

	//删除客户
	@Override
	public void delCustomer(String customerId) {
		// TODO Auto-generated method stub
		Connection connection = JDBCUtil.getConnection();
		 PreparedStatement preparedStatement=null;
	        ResultSet resultSet=null;
	    	String sql="delete from customer where customerId = ?";
	        PreparedStatement pst;
			try {
				pst = connection.prepareStatement(sql);
				pst.setString(1, customerId);
				pst.executeUpdate();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
	
	}

	//通过客户名称来获得客户信息
	@Override
	public List<Customer> getCustomer(String customerName,int pageNo) {
		List<Customer> list = new ArrayList<Customer>();
        Connection connection = JDBCUtil.getConnection();
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        String sql="select customerId,customerName,telephone from customer where customerName like ? limit ?,? ";
        
        try {
             preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
             preparedStatement.setString(1, "%"+customerName+"%");
             preparedStatement.setInt(2, (pageNo-1)*6);
             preparedStatement.setInt(3, 6);
             
             
             resultSet = preparedStatement.executeQuery();
            while(resultSet.next())
            {
            	
            	list.add(new Customer(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
			JDBCUtil.release(connection,  preparedStatement,resultSet);
           
        }
        return list;
	}
	//查询总记录数
			@Override
			public int queryTotalRecords() {
				int count = 0;
				  Connection connection = JDBCUtil.getConnection();
			        PreparedStatement preparedStatement=null;
			        ResultSet resultSet=null;
				String sql = "select count(*) from customer";
				 try {
		             preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
		             resultSet = preparedStatement.executeQuery();
		            while(resultSet.next())
		            {
		            	count = resultSet.getInt(1);
		            	
		            }
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }finally {
					 JDBCUtil.release(connection, preparedStatement,resultSet);
		           
		        }
				return count;
			}

			@Override
			public int querySomeoneRecords(String customerName) {
				int count = 0;
				  Connection connection = JDBCUtil.getConnection();
			        PreparedStatement preparedStatement=null;
			        ResultSet resultSet=null;
				String sql = "select count(*) from customer where customerName like ?";
				 try {
		             preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
		             preparedStatement.setString(1, "%"+customerName+"%");
		             resultSet = preparedStatement.executeQuery();
		            while(resultSet.next())
		            {
		            	count = resultSet.getInt(1);
		            	
		            }
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }finally {
					 JDBCUtil.release(connection, preparedStatement,resultSet);
		           
		        }
				return count;
			}

			@Override
			public String queryfinalcustomer() {
				String customerId = null;
		        Connection connection = JDBCUtil.getConnection();
		        PreparedStatement preparedStatement=null;
		        ResultSet resultSet=null;
		        String sql="select customerId from customer order by customerId desc limit 1 ";
		        
		        try {
		             preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
		             resultSet = preparedStatement.executeQuery();
		            while(resultSet.next())
		            {
		            	customerId = resultSet.getString(1);
		            }
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }finally {
					JDBCUtil.release(connection,  preparedStatement,resultSet);
		           
		        }
		        return customerId;
			}

}
