package com.erp.dao.storeManage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.erp.Utils.JDBCUtil;
import com.erp.pojo.pmg.Materiel;
import com.erp.pojo.storeManage.MaterrielStorageDetail;

public class MaterrielStorageDetailDaoImpl implements MaterrielStorageDetailDao{

	@Override
	public void addMaterrielStorageDetail(MaterrielStorageDetail materrielStorageDetail) {
		Connection connection = JDBCUtil.getConnection();
        PreparedStatement preparedStatement=null;
        String sql="insert into materrielstoragedetail(matStoreDetId,matId,amount,date,min) values(?,?,?,?,?)";
        try {
            preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
            preparedStatement.setString(1,materrielStorageDetail.getMatStoreDetId());
            preparedStatement.setString(2,materrielStorageDetail.getMatId());
            preparedStatement.setDouble(3, materrielStorageDetail.getAmount());
            preparedStatement.setTimestamp(4, materrielStorageDetail.getDate());
            preparedStatement.setDouble(5, materrielStorageDetail.getMin());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.release(connection,preparedStatement,null);
        }
		
	}

	@Override
	public void deleteMaterrielStorageDetail(String matStoreDetId) {
        Connection connection = JDBCUtil.getConnection();
        PreparedStatement preparedStatement=null;
        String sql="delete from materrielstoragedetail where matStoreDetId=?";
        try {
            preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
            preparedStatement.setString(1,matStoreDetId);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.release(connection,preparedStatement,null);
        }
		
	}

	@Override
	public void updateMaterrielStorageDetail(MaterrielStorageDetail materrielStorageDetail) {
		Connection connection = JDBCUtil.getConnection();
        PreparedStatement preparedStatement=null;
        String sql="update materrielstoragedetail set matId=?,amount=?,date=?,min=? where matStoreDetId=?;";
        try {
            preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
            preparedStatement.setString(1,materrielStorageDetail.getMatId());
            preparedStatement.setDouble(2, materrielStorageDetail.getAmount());
            preparedStatement.setTimestamp(3, materrielStorageDetail.getDate());
            preparedStatement.setDouble(4, materrielStorageDetail.getMin());
            preparedStatement.setString(5,materrielStorageDetail.getMatStoreDetId());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.release(connection,preparedStatement,null);
        }
		
	}

	@Override
	public List<MaterrielStorageDetail> getAllMaterrielStorageDetail() {
		List<MaterrielStorageDetail> list=new LinkedList<>();
        Connection connection = JDBCUtil.getConnection();
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        String sql="SELECT * from materrielstoragedetail order by matStoreDetId;";
        try {
            preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
            {
            	MaterrielStorageDetail materrielStorageDetail = new MaterrielStorageDetail();
            	materrielStorageDetail.setMatStoreDetId(resultSet.getString("matStoreDetId"));
            	materrielStorageDetail.setMatId(resultSet.getString("matId"));
            	materrielStorageDetail.setAmount(resultSet.getDouble("amount"));
            	materrielStorageDetail.setDate(resultSet.getTimestamp("date"));
            	materrielStorageDetail.setMin(resultSet.getDouble("min"));
               list.add(materrielStorageDetail);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.release(connection,preparedStatement,resultSet);
        }
        return list;
	}

	@Override
	public Materiel getSingleMaterialDetailById(String matStoreDetId) {
		Materiel material = new Materiel();
		Connection connection = JDBCUtil.getConnection();
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        String sql="SELECT materiel.* from materrielstoragedetail,materiel where matStoreDetId=? and materrielstoragedetail.matId=materiel.matId;";
        try {
            preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
            preparedStatement.setString(1,matStoreDetId);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
            {
                material.setMatId(resultSet.getString("matId"));
                material.setMatName(resultSet.getString("matName"));
                material.setBrand(resultSet.getString("brand"));
                material.setType(resultSet.getString("type"));
                material.setLevel(resultSet.getString("level"));
                material.setGram(resultSet.getDouble("gram"));
                material.setMatSpec(resultSet.getString("matSpec"));
                material.setUnit(resultSet.getString("unit"));
                material.setMatPrice(resultSet.getDouble("matPrice"));
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.release(connection,preparedStatement,resultSet);
        }
        return material;
	}
	
	@Override
	public List<MaterrielStorageDetail> getMSDByGoodLoc(String location) {
		List<MaterrielStorageDetail> list=new LinkedList<>();
		Connection connection = JDBCUtil.getConnection();
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        String sql="SELECT DISTINCT materrielstoragedetail.* FROM materrielstoragedetail,materrielstorage,goodslocation "+
        		"WHERE materrielstoragedetail.matId=materrielstorage.matId and "+
        		"materrielstorage.location=goodslocation.location and "+
        		"goodslocation.location=? order by matStoreDetId";
        try {
            preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
            preparedStatement.setString(1,location);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
            {
            	MaterrielStorageDetail materrielStorageDetail = new MaterrielStorageDetail();
            	materrielStorageDetail.setMatStoreDetId(resultSet.getString("matStoreDetId"));
            	materrielStorageDetail.setMatId(resultSet.getString("matId"));
            	materrielStorageDetail.setAmount(resultSet.getDouble("amount"));
            	materrielStorageDetail.setDate(resultSet.getTimestamp("date"));
            	materrielStorageDetail.setMin(resultSet.getDouble("min"));
               list.add(materrielStorageDetail);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.release(connection,preparedStatement,resultSet);
        }
        return list;
	}
	
	@Override
	public List<MaterrielStorageDetail> getSingleMDSByMatId(String matId) {
		List<MaterrielStorageDetail> list=new LinkedList<>();
		Connection connection = JDBCUtil.getConnection();
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        String sql="SELECT * FROM materrielstoragedetail WHERE matId=?";
        try {
            preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
            preparedStatement.setString(1,matId);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
            {
            	MaterrielStorageDetail materrielStorageDetail = new MaterrielStorageDetail();
            	materrielStorageDetail.setMatStoreDetId(resultSet.getString("matStoreDetId"));
            	materrielStorageDetail.setMatId(resultSet.getString("matId"));
            	materrielStorageDetail.setAmount(resultSet.getDouble("amount"));
            	materrielStorageDetail.setDate(resultSet.getTimestamp("date"));
            	materrielStorageDetail.setMin(resultSet.getDouble("min"));
               list.add(materrielStorageDetail);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.release(connection,preparedStatement,resultSet);
        }
        return list;
	}
	
	@Override
	public List<MaterrielStorageDetail> getMSDByLocMatId(String location, String matId) {
		List<MaterrielStorageDetail> list=new LinkedList<>();
		Connection connection = JDBCUtil.getConnection();
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        String sql="SELECT DISTINCT materrielstoragedetail.* FROM materrielstoragedetail,materrielstorage,goodslocation "+
        		"WHERE materrielstoragedetail.matId=materrielstorage.matId and "+
        		"materrielstorage.location=goodslocation.location and "+
        		"goodslocation.location=? and materrielstoragedetail.matId=? order by matStoreDetId";
        try {
            preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
            preparedStatement.setString(1,location);
            preparedStatement.setString(2,matId);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
            {
            	MaterrielStorageDetail materrielStorageDetail = new MaterrielStorageDetail();
            	materrielStorageDetail.setMatStoreDetId(resultSet.getString("matStoreDetId"));
            	materrielStorageDetail.setMatId(resultSet.getString("matId"));
            	materrielStorageDetail.setAmount(resultSet.getDouble("amount"));
            	materrielStorageDetail.setDate(resultSet.getTimestamp("date"));
            	materrielStorageDetail.setMin(resultSet.getDouble("min"));
               list.add(materrielStorageDetail);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.release(connection,preparedStatement,resultSet);
        }
        return list;
	}
	
	@Override
	public boolean checkMatStoreDetIdIsExist(String matStoreDetId) {
		Connection connection = JDBCUtil.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "select matStoreDetId from materrielstoragedetail where matStoreDetId=?";
        try {
            preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
            preparedStatement.setString(1, matStoreDetId);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                //有查询到数据
                return true;//如果存在就返回true
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.release(connection, preparedStatement, resultSet);
        }

        return false;
	}






	
}
