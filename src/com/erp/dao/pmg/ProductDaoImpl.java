package com.erp.dao.pmg;

import com.erp.pojo.pmg.Product;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class ProductDaoImpl implements ProductDao {

	PreparedStatement pst;
	ResultSet rs;
	//存放表头信息
	public String[] thead;
	@Override
	public void addProduct(Product product) {
		// TODO Auto-generated method stub
		String sql = "insert into product values(?,?,?,?,?,?,?,?,?)";
		try {
			pst = conn.prepareStatement(sql);
			
			pst.setString(1, product.productId);
			pst.setString(2, product.productName);
			pst.setString(3, product.brand);
			pst.setString(4, product.type);
			pst.setString(5, product.level);
			pst.setDouble(6, product.gram);
			pst.setString(7, product.productSpec);
			pst.setString(8, product.unit);
			pst.setDouble(9, product.productPrice);
			
			pst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deleteProduct(String productId) {
		// TODO Auto-generated method stub
		String sql = "delete from product where productId=?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1,productId);
			pst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void updateProduct(Product product) {
		// TODO Auto-generated method stub
				String sql = "update product set "
												+ "productName=?,"
												+ "brand=?,"
												+ "type=?,"
												+ "level=?,"
												+ "gram=?,"
												+ "productSpec=?,"
												+ "unit=?,"
												+ "productPrice=?"
										+" where productId=?";
		
		try {
		
			pst = conn.prepareStatement(sql);
			
			pst.setString(1, product.productName);
			pst.setString(2, product.brand);
			pst.setString(3, product.type);
			pst.setString(4, product.level);
			pst.setDouble(5, product.gram);
			pst.setString(6, product.productSpec);
			pst.setString(7, product.unit);
			pst.setDouble(8, product.productPrice);
			pst.setString(9, product.productId);
			
			pst.executeUpdate();
		
		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
	}

	@Override
	public List<Product> getAllProduct() {
		// TODO Auto-generated method stub
		String sql = "select * from product";
		Product product = null;
		List<Product> list = new ArrayList<Product>();
		try {
			pst = conn.prepareStatement(sql);
			rs =  pst.executeQuery();
			
/*			ResultSetMetaData rsmd = rs.getMetaData();
			
			int col = rsmd.getColumnCount();  //获取表的列数
*/			this.thead = new String[9];
			
			this.thead[0] = "产品编号";
			this.thead[1] = "产品名称";
			this.thead[2] = "品牌";
			this.thead[3] = "纸种";
			this.thead[4] = "级别";
			this.thead[5] = "克重";
			this.thead[6] = "规格型号";
			this.thead[7] = "单位";
			this.thead[8] = "单价";
			
			while(rs.next()) {
				product = new Product(rs.getString(1),
										rs.getString(2),
										rs.getString(3),
										rs.getString(4),
										rs.getString(5),
										rs.getDouble(6),
										rs.getString(7),
										rs.getString(8),
										rs.getDouble(9));
				list.add(product);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
 		return list;
	}

	@Override
	public Product getProductById(String productId) {
		// TODO Auto-generated method stub
		String sql = "select * from product where productId=?";
		Product product = null;
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, productId);
			rs = pst.executeQuery();
		
			while(rs.next()) {
				
				product = new Product(rs.getString(1),
										rs.getString(2),
										rs.getString(3),
										rs.getString(4),
										rs.getString(5),
										rs.getDouble(6),
										rs.getString(7),
										rs.getString(8),
										rs.getDouble(9));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return product;
	
	}

}
