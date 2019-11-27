package com.erp.dao.pacm;

import com.erp.pojo.pacm.Customer;

import java.util.List;



public interface CustomerDao {
	//查询所有客户
	public List<Customer> getAll(int pageNo);
	
	//增加客户信息
	public void addCustomer(Customer c);
	
	//修改客户信息
	public void updCustomer(Customer c);
	
	//删除客户
	public void delCustomer(String customerId);
	
	//按名字寻找客户
	public List<Customer> getCustomer(String customerName, int pageNo);

	//查询总记录条数
	public int queryTotalRecords();
	
	//查询模糊搜索的总条数
	public int querySomeoneRecords(String customerName);
	
	//查找最后一名客户的customerid
	public String queryfinalcustomer();
}
