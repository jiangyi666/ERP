package com.erp.dao.rgm;


import com.erp.pojo.pacm.Customer;

import java.util.List;


public interface CustomerDao {
	// 添加客户
	public boolean insertCustomer(Customer customer);

	// 删除客户
	public boolean deleteCustomer(String id);

	// 修改客户信息
	public boolean updateCustomer(Customer customer);

	// 查找客户
	public Customer findCustomerById(String id);

	// 获取客户列表
	public List<Customer> getCustomers();

	public Customer findCustomerById(String loginId, String password);
	public List<Customer> getAllCusByStartEnd(int start, int end);
}

