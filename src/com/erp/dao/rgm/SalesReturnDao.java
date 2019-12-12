package com.erp.dao.rgm;

import com.erp.pojo.rgm.SalesReturn;

import java.util.List;



public interface SalesReturnDao {
	//添加退货单记录
	public boolean addReturn(SalesReturn sr);
	
	//删除退货单记录
	public boolean deleteReturn(String id);
	  
	//修改退货单记录信息
	public boolean updateReturn(SalesReturn sr);
	
	//查找退货单记录
	public SalesReturn findReturnById(String id);
	
	//获取退货单记录列表
	public List<SalesReturn> getReturns();
}
