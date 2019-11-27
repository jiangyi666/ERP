package com.erp.service.pacm;


import com.erp.pojo.pacm.Customer;

import java.util.List;

public interface CustomerService {
	//得到指定页customer
	public List<Customer> getAll(int pageNo);
	//查询总条数
	public int queryTotalRecords();
	//删除对应客户记录
	public void delcustomer(String customerId);
	//查询模糊搜索
	public List<Customer> getCustomer(String customerName, int pageNo);
	//查询模糊搜索的总条数
	public int querySomeoneRecords(String customerName);
	//更新客户信息
	public void updCustomer(Customer c);
	//新增客户
	public void addCustomer(Customer c);
	//获得customerid为最后的一名客户的customerid
	public String queryfinalcustomer();
}
