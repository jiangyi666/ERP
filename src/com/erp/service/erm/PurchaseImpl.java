package com.erp.service.erm;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;


import com.erp.Utils.MyJDBCUtil;
import com.erp.dao.erm.Purchase;
import com.erp.pojo.erm.Purchasedetail;
import com.erp.pojo.erm.Purchasemaster;

public class PurchaseImpl implements Purchase{
	MyJDBCUtil util=new MyJDBCUtil();
	
	@Override
	public List<Purchasedetail> getPurchasedet(String purchaseId) {
		String sql="select * from purchasedetail where purchaseId = ?";
		Object[] params=new Object[] {purchaseId};
		List<Purchasedetail> purdetail=null;
		try {
			purdetail=util.populate(sql, params, Purchasedetail.class);
		} catch (InstantiationException | IllegalAccessException | SecurityException | IllegalArgumentException
				| SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return purdetail;
	}

	public List<Map<String,Object>> getpruchaseId() {
		String sql="select purchaseId from purchasemaster";
		List<Map<String,Object>> pruchase=(List)util.excuteQuery(sql, null);
		return pruchase;
	}
	
	public List<Map<String,Object>> getemployeeId(String purchaseId){
		String sql="select employeId from purchasemaster where purchaseId";
		Object[] params=new Object[] {purchaseId};
		List<Map<String,Object>> employeeid=(List)util.excuteQuery(sql, params);
		return employeeid;
	}
	
	public List<Purchasemaster> getPurchasemas(String pruchaseId){
		String sql="select * from purchasemaster where purchaseId=?";
		Object[] params=new Object[] {pruchaseId};
		List<Purchasemaster> purmas=null;
		try {
			purmas=util.populate(sql, params, Purchasemaster.class);
		} catch (InstantiationException | IllegalAccessException | SecurityException | IllegalArgumentException
				| SQLException e) {
			e.printStackTrace();
		}
		return purmas;
	}
	
	public List<Map<String,Object>> getemplname(){
		String sql="select employeeId,employeename from employee where privilege=1 or privilege=2";
		List<Map<String,Object>> list=(List)util.excuteQuery(sql, null);
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i).get("employeename"));
		}
		return list;
	}
	
	public List<Map<String,Object>> getlocation(){
		String sql="select location from goodslocation where goodsType=?";
		Object[] params=new Object[] {"原材料"};
		List<Map<String,Object>> list=(List)util.excuteQuery(sql, params);
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i).get("location"));
		}
		return list;
	}
	
}
