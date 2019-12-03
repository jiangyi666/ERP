package com.erp.dao.pm;

import com.erp.Utils.JDBCUtil;
import com.erp.pojo.pm.purchaseorder;

import java.util.List;
import java.util.Map;



public interface purchaseorderDao {
	static JDBCUtil db=new JDBCUtil();
	public List<Map<String,Object>> getpurchaseorder();
	public List<Map<String,Object>> getpurchaseorderById(String purchaseId);
	public List<Map<String,Object>> getpurchaseorderdetail(String PurchaseId);
	public int save(purchaseorder q);
	public int delete(String PurchaseId);
	public int update(String purchaseId, double purchaseSum);
}
