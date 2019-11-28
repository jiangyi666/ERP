package com.erp.service.storeManage;

import com.erp.pojo.pmg.Materiel;
import com.erp.pojo.storeManage.MaterrielStorageDetail;

import java.util.List;



public interface MaterrielStorageDetailService {

	/**
	 * 添加原材料库存
	 * @param materrielStorageDetail
	 */
	public void addMaterrielStorageDetail(MaterrielStorageDetail materrielStorageDetail);
	
	/**
	 * 根据库存编号删除原材料库存
	 * @param matStoreDetId
	 */
	public void deleteMaterrielStorageDetail(String matStoreDetId);
	
	/**
	 * 修改原材料库存
	 * @param materrielStorageDetail
	 */
	public void updateMaterrielStorageDetail(MaterrielStorageDetail materrielStorageDetail);
	
	/**
	 * 获取原材料库存列表
	 * @return
	 */
	public List<MaterrielStorageDetail> getAllMaterrielStorageDetail();
	
	/**
	 * 根据原材料库存编号获取原材料详情
	 * @param matStoreDetId
	 * @return
	 */
	public Materiel getSingleMaterialDetailById(String matStoreDetId);
	
	/**
	 * 根据仓库查库存
	 * @param location
	 * @return
	 */
	public List<MaterrielStorageDetail> getMSDByGoodLoc(String location);
	
	/**
	 * 根据物料id查库存
	 * @param matId
	 * @return
	 */
	public List<MaterrielStorageDetail> getSingleMDSByMatId(String matId);
	

	
	/**
	 * 根据仓库和物料查库存
	 * @param location
	 * @param matId
	 * @return
	 */
	public List<MaterrielStorageDetail> getMSDByLocMatId(String location, String matId);
	
	
	/**
     * 查询原材料库存Id是否已经存在（用来新增加原材料库存的时候使用)
     * @param matStoreDetId
     * @return
     */
    public boolean checkMatStoreDetIdIsExist(String matStoreDetId);
	
}
