package com.erp.dao.pm;

import com.erp.Utils.JDBCUtil;
import com.erp.pojo.pm.purchasedetail;

import java.util.List;
import java.util.Map;



public interface purchasedetailDao {
	static JDBCUtil db=new JDBCUtil();
	public List<Map<String,Object>> getpurchaseorderdetail(String PurchaseId);
	public int save(purchasedetail q);
	public int delete(String purchaseId);
	public int deleteSingle(String matId);
}
