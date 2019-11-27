package com.erp.dao.pmg;

import com.erp.Utils.JDBCUtil;
import com.erp.pojo.pmg.Product;

import java.sql.Connection;
import java.util.List;



public interface ProductDao {
	
	Connection conn = new JDBCUtil().getConnection();  //获取数据库连接
	
	public void addProduct(Product product); //增加产品
	
	public void deleteProduct(String productId);  //删除产品
	
	public void updateProduct(Product product);  //修改产品信息
	
	public List<Product> getAllProduct();	//获取所有产品信息
	
	public Product getProductById(String productId);	//根据主键ID获取某一个产品信息
}
