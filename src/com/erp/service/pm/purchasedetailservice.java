package com.erp.service.pm;

import com.erp.dao.pm.purchasedetailDaoImpl;
import com.erp.pojo.pm.purchasedetail;

import java.util.List;
import java.util.Map;



public class purchasedetailservice {
	static com.erp.dao.pm.purchasedetailDaoImpl purchasedetailDaoImpl;
	static {
		purchasedetailDaoImpl = new purchasedetailDaoImpl();
	}
	public static int delete(String purchaseId) {
		return purchasedetailDaoImpl.delete(purchaseId);
	}
	public static int deleteSingle(String matId){
		return purchasedetailDaoImpl.deleteSingle(matId);
	}
	public static List<Map<String,Object>> getpurchaseorderdetail(String PurchaseId){
		return purchasedetailDaoImpl.getpurchaseorderdetail(PurchaseId);
	}
	public static int save(purchasedetail q) {
		return purchasedetailDaoImpl.save(q);
	}
}
