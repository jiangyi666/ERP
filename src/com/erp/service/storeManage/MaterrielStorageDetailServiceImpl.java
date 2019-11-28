package com.erp.service.storeManage;

import com.erp.dao.storeManage.MaterrielStorageDetailDaoImpl;
import com.erp.pojo.pmg.Materiel;
import com.erp.pojo.storeManage.MaterrielStorageDetail;

import java.util.List;



public class MaterrielStorageDetailServiceImpl implements MaterrielStorageDetailService{

	MaterrielStorageDetailDaoImpl materrielStorageDetailDao = new MaterrielStorageDetailDaoImpl();
	@Override
	public void addMaterrielStorageDetail(MaterrielStorageDetail materrielStorageDetail) {
		materrielStorageDetailDao.addMaterrielStorageDetail(materrielStorageDetail);
	}

	@Override
	public void deleteMaterrielStorageDetail(String matStoreDetId) {
		materrielStorageDetailDao.deleteMaterrielStorageDetail(matStoreDetId);
	}

	@Override
	public void updateMaterrielStorageDetail(MaterrielStorageDetail materrielStorageDetail) {
		materrielStorageDetailDao.updateMaterrielStorageDetail(materrielStorageDetail);	
	}

	@Override
	public List<MaterrielStorageDetail> getAllMaterrielStorageDetail() {
		return materrielStorageDetailDao.getAllMaterrielStorageDetail();
	}

	@Override
	public Materiel getSingleMaterialDetailById(String matStoreDetId) {
		return materrielStorageDetailDao.getSingleMaterialDetailById(matStoreDetId);
	}
	
	@Override
	public List<MaterrielStorageDetail> getMSDByGoodLoc(String location) {
		return materrielStorageDetailDao.getMSDByGoodLoc(location);
	}
	
	@Override
	public List<MaterrielStorageDetail> getSingleMDSByMatId(String matId) {
		// TODO Auto-generated method stub
		return materrielStorageDetailDao.getSingleMDSByMatId(matId);
	}

	@Override
	public List<MaterrielStorageDetail> getMSDByLocMatId(String location, String matId) {
		// TODO Auto-generated method stub
		return materrielStorageDetailDao.getMSDByLocMatId(location, matId);
	}

	@Override
	public boolean checkMatStoreDetIdIsExist(String matStoreDetId) {
		return materrielStorageDetailDao.checkMatStoreDetIdIsExist(matStoreDetId);
	}




}
