package com.erp.dao.rgm;
import com.erp.pojo.rgm.Ordermaster;

import java.util.List;




public interface OrdermasterDao {
	// 添加销售订单主表记录
	public boolean insertOrdermaster(Ordermaster o);

	// 删除销售订单主表记录
	public boolean deleteOrdermaster(String id);

	// 修改销售订单主表记录信息
	public boolean updateOrdermaster(Ordermaster o);

	// 查找销售订单主表记录
	public Ordermaster findOrdermasterById(String id);

	// 获取销售订单主表记录列表
	public List<Ordermaster> getOrdermasters();
	
	public List<Ordermaster> findOrdermasterByeId(String id);

	public List<Ordermaster> getAllCusByStartEnd(int start, int end);
}

