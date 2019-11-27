package com.erp.service.pacm;


import com.erp.dao.pacm.ProviderDao;
import com.erp.dao.pacm.ProviderDaoImpl;
import com.erp.pojo.pacm.Providers;

import java.util.List;

public class ProviderServiceImpl implements ProviderService{
	ProviderDao pDao = new ProviderDaoImpl();
	@Override
	public List<Providers> getAll(int pageNo) {
		return pDao.getAll(pageNo);
	}

	@Override
	public int queryTotalRecords() {
		return pDao.queryTotalRecords();
	}

	@Override
	public void delproviders(String peeId) {
		pDao.delProviders(peeId);
		
	}

	@Override
	public List<Providers> getProviders(String peeName, int pageNo) {
		return pDao.getProviders(peeName, pageNo);
	}

	@Override
	public int querySomeoneRecords(String peeName) {
		return pDao.querySomeoneRecords(peeName);
	}

	@Override
	public void updProviders(Providers p) {
		pDao.updProviders(p);
	}

	@Override
	public void addProviders(Providers p) {
		pDao.addProviders(p);
	}

	@Override
	public String queryfinalpee() {
		return pDao.queryfinalprovider();
	}
	
}
