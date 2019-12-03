package com.erp.dao.erm;

import com.erp.pojo.erm.Purchasedetail;
import com.erp.pojo.erm.Purchasemaster;

import java.util.List;
import java.util.Map;

public interface Purchase {
	public List<Purchasedetail> getPurchasedet(String pruchaseId);
	public List<Map<String,Object>> getpruchaseId();
	public List<Map<String,Object>> getemployeeId(String purchaseId);
	public List<Purchasemaster> getPurchasemas(String pruchaseId);
	public List<Map<String,Object>> getemplname();
	public List<Map<String,Object>> getlocation();
}
