package com.erp.dao.pacm;

import com.erp.Utils.JDBCUtil;
import com.erp.pojo.pacm.Providers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ProviderDaoImpl implements ProviderDao{

	@Override
	public List<Providers> getAll(int pageNo) {
		List<Providers> list = new ArrayList<Providers>();
        Connection connection = JDBCUtil.getConnection();
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        String sql="select * from providers limit ?,? ";
        
        try {
             preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
             preparedStatement.setInt(1, (pageNo-1)*6);
             preparedStatement.setInt(2, 6);
             
             
             resultSet = preparedStatement.executeQuery();
            while(resultSet.next())
            {
            	
            	list.add(new Providers(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.release(connection,  preparedStatement,resultSet);
           
        }
        return list;
	}

	@Override
	public void addProviders(Providers p) {
		Connection connection = JDBCUtil.getConnection();
		 PreparedStatement preparedStatement=null;
	        ResultSet resultSet=null;
	    	String sql="insert into providers(peeId,peeName,telephone,address) values(?,?,?,?)";
	        PreparedStatement pst;
			try {
				pst = connection.prepareStatement(sql);
				pst.setString(1, p.getPeeId());
				pst.setString(2, p.getPeeName());
				pst.setString(3, p.getTelephone());
				pst.setString(4, p.getAddress());
				pst.executeUpdate();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
		
	}

	@Override
	public void updProviders(Providers p) {
		Connection connection = JDBCUtil.getConnection();
		 PreparedStatement preparedStatement=null;
	        ResultSet resultSet=null;
	    	String sql="update providers set peeName=?,telephone=?,address=? where peeId=?";
	        PreparedStatement pst;
			try {
				pst = connection.prepareStatement(sql);
				pst.setString(1, p.getPeeName());
				pst.setString(2, p.getTelephone());
				pst.setString(3, p.getAddress());
				pst.setString(4, p.getPeeId());
			
				pst.executeUpdate();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	}

	@Override
	public void delProviders(String peeId) {
		Connection connection = JDBCUtil.getConnection();
		 PreparedStatement preparedStatement=null;
	        ResultSet resultSet=null;
	    	String sql="delete from providers where peeId = ?";
	        PreparedStatement pst;
			try {
				pst = connection.prepareStatement(sql);
				pst.setString(1, peeId);
				pst.executeUpdate();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	}

	@Override
	public List<Providers> getProviders(String peeName, int pageNo) {
		List<Providers> list = new ArrayList<Providers>();
        Connection connection = JDBCUtil.getConnection();
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        String sql="select * from providers where peeName like ? limit ?,? ";
        
        try {
             preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
             preparedStatement.setString(1, "%"+peeName+"%");
             preparedStatement.setInt(2, (pageNo-1)*6);
             preparedStatement.setInt(3, 6);
             
             
             resultSet = preparedStatement.executeQuery();
            while(resultSet.next())
            {
            	
            	list.add(new Providers(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
			JDBCUtil.release(connection,  preparedStatement,resultSet);
           
        }
        return list;
	}

	@Override
	public int queryTotalRecords() {
		int count = 0;
		  Connection connection = JDBCUtil.getConnection();
	        PreparedStatement preparedStatement=null;
	        ResultSet resultSet=null;
		String sql = "select count(*) from providers";
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
	public int querySomeoneRecords(String peeName) {
		int count = 0;
		  Connection connection = JDBCUtil.getConnection();
	        PreparedStatement preparedStatement=null;
	        ResultSet resultSet=null;
		String sql = "select count(*) from providers where peeName like ?";
		 try {
           preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
           preparedStatement.setString(1, "%"+peeName+"%");
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
	public String queryfinalprovider() {
		String customerId = null;
        Connection connection = JDBCUtil.getConnection();
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        String sql="select peeId from providers order by peeId desc limit 1 ";
        
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
