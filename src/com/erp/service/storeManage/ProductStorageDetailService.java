package com.erp.service.storeManage;

import com.erp.pojo.pmg.Product;
import com.erp.pojo.storeManage.ProductStorageDetail;

import java.util.List;



public interface ProductStorageDetailService {

	/**
	 * 添加产品库存
	 * @param productStorageDetail
	 */
	public void addProductStorageDetail(ProductStorageDetail productStorageDetail);
	
	/**
	 * 根据库存编号删除产品库存
	 * @param productStoId
	 */
	public void deleteProductStorageDetail(String productStoId);
	
	/**
	 * 修改产品库存
	 * @param productStorageDetail
	 */
	public void updateProductStorageDetail(ProductStorageDetail productStorageDetail);
	
	/**
	 * 获取产品库存列表
	 * @return
	 */
	public List<ProductStorageDetail> getAllProductStorageDetail();
	
	/**
	 * 根据产品库存编号获取产品详情
	 * @param productStoId
	 * @return
	 */
	public Product getSingleProductDetailById(String productStoId);
	
	/**
	 * 根据仓库查库存
	 * @param location
	 * @return
	 */
	public List<ProductStorageDetail> getPSDByGoodLoc(String location);
	
	/**
	 * 根据产品id查库存
	 * @param productId
	 * @return
	 */
	public List<ProductStorageDetail> getSinglePSDByProId(String productId);
	
	/**
	 * 根据仓库和产品查库存
	 * @param location
	 * @param
	 * @return
	 */
	public List<ProductStorageDetail> getPSDByLocProId(String location, String productId);
	
	/**
     * 查询产品库存Id是否已经存在（用来新增加产品库存的时候使用)
     * @return
     */
    public boolean checkProductStoIdIsExist(String productStoId);
	
}
