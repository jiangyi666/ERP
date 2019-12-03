package com.erp.dao.erm;

import java.util.List;
import java.util.Map;

import com.erp.pojo.erm.Materiel;
import com.erp.pojo.erm.Materrielstorage;

public interface MaterielStorage {
	public List<Materiel> getAllMateriel();	
	public void CheckPurchase(String purchaseId);
	public Materrielstorage[] createMatStorage(String purchaseId);	
	public boolean insertmat(Materrielstorage mat, String purchaseId);
	public List<Map<String,Object>> matadd();
	
	public List<Materiel> getmaterrelbyid(String matId);
	
	public int updateamount(String matId, int amount);
}
