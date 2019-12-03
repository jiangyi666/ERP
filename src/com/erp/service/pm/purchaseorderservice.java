package com.erp.service.pm;

import com.erp.dao.pm.purchaseorderDaoImpl;
import com.erp.pojo.pm.purchaseorder;

import java.util.List;
import java.util.Map;


public class purchaseorderservice {
		static com.erp.dao.pm.purchaseorderDaoImpl purchaseorderDaoImpl;
		static {
			purchaseorderDaoImpl = new purchaseorderDaoImpl();
		}
		public static List<Map<String,Object>> getpurchaseorder(){
			return purchaseorderDaoImpl.getpurchaseorder();
		}
		public static int save(purchaseorder q){
			return purchaseorderDaoImpl.save(q);
		}
		public static int delete(String purchaseId){
			return purchaseorderDaoImpl.delete(purchaseId);
		}
		public static int update(String purchaseId, double purchaseSum) {
			return purchaseorderDaoImpl.update(purchaseId, purchaseSum);
		}
		public static List<Map<String, Object>> getpurchaseorderById(String purchaseId){
			return purchaseorderDaoImpl.getpurchaseorderById(purchaseId);
		}
}
