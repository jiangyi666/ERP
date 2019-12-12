package com.erp.service.rgm;

import com.erp.pojo.rgm.SalesReturn;

import java.util.List;



/**
 *             退货单的增删改查
 *
 */
public interface SaleService {

	/* 退货单的增删改查 */
	
	// 添加退货单记录
	public boolean insertReturn(SalesReturn r);

	// 删除退货单记录
	public boolean deleteReturn(String id);

	// 修改退货单记录信息
	public boolean updateReturn(SalesReturn r);

	// 查找退货单记录
	public SalesReturn findReturnById(String id);

	// 获取退货单记录列表
	public List<SalesReturn> getReturns();

	

	
}

