package com.erp.service.storeManage;

import com.erp.dao.storeManage.ProductStorageDetailDaoImpl;
import com.erp.pojo.pmg.Product;
import com.erp.pojo.storeManage.ProductStorageDetail;

import java.util.List;


public class ProductStorageDetailServiceImpl implements ProductStorageDetailService{

	ProductStorageDetailDaoImpl productStorageDetailDaoImpl = new ProductStorageDetailDaoImpl();
	@Override
	public void addProductStorageDetail(ProductStorageDetail productStorageDetail) {
		productStorageDetailDaoImpl.addProductStorageDetail(productStorageDetail);
	}

	@Override
	public void deleteProductStorageDetail(String productStoId) {
		productStorageDetailDaoImpl.deleteProductStorageDetail(productStoId);
	}

	@Override
	public void updateProductStorageDetail(ProductStorageDetail productStorageDetail) {
		productStorageDetailDaoImpl.updateProductStorageDetail(productStorageDetail);
		
	}

	@Override
	public List<ProductStorageDetail> getAllProductStorageDetail() {
		return productStorageDetailDaoImpl.getAllProductStorageDetail();
	}

	@Override
	public Product getSingleProductDetailById(String productStoId) {
		return productStorageDetailDaoImpl.getSingleProductDetailById(productStoId);
	}
	
	@Override
	public List<ProductStorageDetail> getPSDByGoodLoc(String location) {
		// TODO Auto-generated method stub
		return productStorageDetailDaoImpl.getPSDByGoodLoc(location);
	}

	@Override
	public List<ProductStorageDetail> getSinglePSDByProId(String productId) {
		// TODO Auto-generated method stub
		return productStorageDetailDaoImpl.getSinglePSDByProId(productId);
	}

	@Override
	public List<ProductStorageDetail> getPSDByLocProId(String location, String productId) {
		// TODO Auto-generated method stub
		return productStorageDetailDaoImpl.getPSDByLocProId(location, productId);
	}
	
	@Override
	public boolean checkProductStoIdIsExist(String productStoId) {
		return productStorageDetailDaoImpl.checkProductStoIdIsExist(productStoId);
	}




}
