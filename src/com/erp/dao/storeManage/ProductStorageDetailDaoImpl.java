package com.erp.dao.storeManage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.erp.Utils.JDBCUtil;
import com.erp.pojo.pmg.Product;
import com.erp.pojo.storeManage.ProductStorageDetail;


public class ProductStorageDetailDaoImpl implements ProductStorageDetailDao{

	@Override
	public void addProductStorageDetail(ProductStorageDetail productStorageDetail) {
		Connection connection = JDBCUtil.getConnection();
        PreparedStatement preparedStatement=null;
        String sql="insert into productstoragedetail(productStoId,productId,amount,date,min) values(?,?,?,?,?)";
        try {
            preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
            preparedStatement.setString(1,productStorageDetail.getProductStoId());
            preparedStatement.setString(2,productStorageDetail.getProductId());
            preparedStatement.setDouble(3, productStorageDetail.getAmount());
            preparedStatement.setTimestamp(4, productStorageDetail.getDate());
            preparedStatement.setDouble(5, productStorageDetail.getMin());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.release(connection,preparedStatement,null);
        }
		
	}

	@Override
	public void deleteProductStorageDetail(String productStoId) {
		Connection connection = JDBCUtil.getConnection();
        PreparedStatement preparedStatement=null;
        String sql="delete from productstoragedetail where productStoId=?";
        try {
            preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
            preparedStatement.setString(1,productStoId);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.release(connection,preparedStatement,null);
        }
		
	}

	@Override
	public void updateProductStorageDetail(ProductStorageDetail productStorageDetail) {
		Connection connection = JDBCUtil.getConnection();
        PreparedStatement preparedStatement=null;
        String sql="update productstoragedetail set productId=?,amount=?,date=?,min=? where productStoId=?;";
        try {
            preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
            preparedStatement.setString(1,productStorageDetail.getProductId());
            preparedStatement.setDouble(2, productStorageDetail.getAmount());
            preparedStatement.setTimestamp(3, productStorageDetail.getDate());
            preparedStatement.setDouble(4, productStorageDetail.getMin());
            preparedStatement.setString(5,productStorageDetail.getProductStoId());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.release(connection,preparedStatement,null);
        }
		
	}

	@Override
	public List<ProductStorageDetail> getAllProductStorageDetail() {
		List<ProductStorageDetail> list=new LinkedList<>();
        Connection connection = JDBCUtil.getConnection();
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        String sql="SELECT * from productstoragedetail order by productStoId;";
        try {
            preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
            {
            	ProductStorageDetail productStorageDetail = new ProductStorageDetail();
            	productStorageDetail.setProductStoId(resultSet.getString("productStoId"));
            	productStorageDetail.setProductId(resultSet.getString("productId"));
            	productStorageDetail.setAmount(resultSet.getDouble("amount"));
            	productStorageDetail.setDate(resultSet.getTimestamp("date"));
            	productStorageDetail.setMin(resultSet.getDouble("min"));
                list.add(productStorageDetail);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.release(connection,preparedStatement,resultSet);
        }
        return list;
	}

	@Override
	public Product getSingleProductDetailById(String productStoId) {
		Connection connection = JDBCUtil.getConnection();
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        Product product = null;
        String sql="SELECT product.* from productstoragedetail,product where productStoId=? and productstoragedetail.productId=product.productId;";
        try {
            preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
            preparedStatement.setString(1,productStoId);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
            {
            	product = new Product(resultSet.getString(1),
										resultSet.getString(2),
										resultSet.getString(3),
										resultSet.getString(4),
										resultSet.getString(5),
										resultSet.getDouble(6),
										resultSet.getString(7),
										resultSet.getString(8),
										resultSet.getDouble(9));
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.release(connection,preparedStatement,resultSet);
        }
        return product;
	}

	@Override
	public List<ProductStorageDetail> getPSDByGoodLoc(String location) {
		List<ProductStorageDetail> list=new LinkedList<>();
		Connection connection = JDBCUtil.getConnection();
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        String sql="SELECT DISTINCT productstoragedetail.* FROM productstoragedetail,productstorage,goodslocation "+
        		"WHERE productstoragedetail.productId=productstorage.productId and "+
        		"productstorage.location=goodslocation.location and "+
        		"goodslocation.location=? order by productStoId";
        try {
            preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
            preparedStatement.setString(1,location);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
            {
            	ProductStorageDetail productStorageDetail = new ProductStorageDetail();
            	productStorageDetail.setProductStoId(resultSet.getString("productStoId"));
            	productStorageDetail.setProductId(resultSet.getString("productId"));
            	productStorageDetail.setAmount(resultSet.getDouble("amount"));
            	productStorageDetail.setDate(resultSet.getTimestamp("date"));
            	productStorageDetail.setMin(resultSet.getDouble("min"));
                list.add(productStorageDetail);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.release(connection,preparedStatement,resultSet);
        }
        return list;
	}

	@Override
	public List<ProductStorageDetail> getSinglePSDByProId(String productId) {
		List<ProductStorageDetail> list=new LinkedList<>();
		Connection connection = JDBCUtil.getConnection();
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        String sql="SELECT * FROM productstoragedetail WHERE productId=?";
        try {
            preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
            preparedStatement.setString(1,productId);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
            {
            	ProductStorageDetail productStorageDetail = new ProductStorageDetail();
            	productStorageDetail.setProductStoId(resultSet.getString("productStoId"));
            	productStorageDetail.setProductId(resultSet.getString("productId"));
            	productStorageDetail.setAmount(resultSet.getDouble("amount"));
            	productStorageDetail.setDate(resultSet.getTimestamp("date"));
            	productStorageDetail.setMin(resultSet.getDouble("min"));
                list.add(productStorageDetail);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.release(connection,preparedStatement,resultSet);
        }
        return list;
	}

	@Override
	public List<ProductStorageDetail> getPSDByLocProId(String location, String productId) {
		List<ProductStorageDetail> list=new LinkedList<>();
		Connection connection = JDBCUtil.getConnection();
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        String sql="SELECT DISTINCT productstoragedetail.* FROM productstoragedetail,productstorage,goodslocation "+
        		"WHERE productstoragedetail.productId=productstorage.productId and "+
        		"productstorage.location=goodslocation.location and "+
        		"goodslocation.location=? and productStoId=? order by productStoId";
        try {
            preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
            preparedStatement.setString(1,location);
            preparedStatement.setString(2,productId);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
            {
            	ProductStorageDetail productStorageDetail = new ProductStorageDetail();
            	productStorageDetail.setProductStoId(resultSet.getString("productStoId"));
            	productStorageDetail.setProductId(resultSet.getString("productId"));
            	productStorageDetail.setAmount(resultSet.getDouble("amount"));
            	productStorageDetail.setDate(resultSet.getTimestamp("date"));
            	productStorageDetail.setMin(resultSet.getDouble("min"));
                list.add(productStorageDetail);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.release(connection,preparedStatement,resultSet);
        }
        return list;
	}
	
	@Override
	public boolean checkProductStoIdIsExist(String productStoId) {
		Connection connection = JDBCUtil.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        String sql = "select productStoId from productstoragedetail where productStoId=?";
        try {
            preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
            preparedStatement.setString(1, productStoId);
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
