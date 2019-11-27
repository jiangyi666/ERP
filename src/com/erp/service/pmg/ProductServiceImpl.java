package com.erp.service.pmg;

import com.erp.dao.pmg.ProductDaoImpl;
import com.erp.pojo.pmg.Product;

import java.util.List;



public class ProductServiceImpl implements ProductService {

	public ProductDaoImpl PD = new ProductDaoImpl();
	public String[] thead;
	@Override
	public void addProduct(Product product) {
		// TODO Auto-generated method stub
		PD.addProduct(product);
	}

	@Override
	public void deleteProduct(String productId) {
		// TODO Auto-generated method stub
		PD.deleteProduct(productId);
	}

	@Override
	public void updateProduct(Product product) {
		// TODO Auto-generated method stub
		PD.updateProduct(product);
	}

	@Override
	public List<Product> getAllProduct() {
		// TODO Auto-generated method stub
		List<Product> list = PD.getAllProduct();
		this.thead = PD.thead;
		return list;
	}

	@Override
	public Product getProductById(String productId) {
		// TODO Auto-generated method stub
		return PD.getProductById(productId);
	}

}
