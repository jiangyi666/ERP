package com.erp.service.rgm;

import com.erp.dao.rgm.SalesReturnDao;
import com.erp.dao.rgm.SalesReturnDaoImpl;
import com.erp.pojo.rgm.SalesReturn;

import java.util.List;



public class SaleServiceImpl implements SaleService {
	SalesReturnDao dao = new SalesReturnDaoImpl();
	@Override
	public boolean insertReturn(SalesReturn r) {
		// TODO Auto-generated method stub
		return dao.addReturn(r);
	}

	@Override
	public boolean deleteReturn(String id) {
		// TODO Auto-generated method stub
		return dao.deleteReturn(id);
	}

	@Override
	public boolean updateReturn(SalesReturn r) {
		// TODO Auto-generated method stub
		return dao.updateReturn(r);
	}

	@Override
	public SalesReturn findReturnById(String id) {
		// TODO Auto-generated method stub
		return dao.findReturnById(id);
	}

	@Override
	public List<SalesReturn> getReturns() {
		// TODO Auto-generated method stub
		return dao.getReturns();
	}

}
