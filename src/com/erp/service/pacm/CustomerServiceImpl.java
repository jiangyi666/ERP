package com.erp.service.pacm;


import com.erp.dao.pacm.CustomerDao;
import com.erp.dao.pacm.CustomerDaoImpl;
import com.erp.pojo.pacm.Customer;

import java.util.List;

public class CustomerServiceImpl implements CustomerService{
	CustomerDao cDao = new CustomerDaoImpl();
	@Override
	public List<Customer> getAll(int pageNo) {
		return cDao.getAll(pageNo);
		
	}
	@Override
	public int queryTotalRecords() {
		
		return cDao.queryTotalRecords();
	}
	@Override
	public void delcustomer(String customerId) {
		cDao.delCustomer(customerId);
		
	}
	@Override
	public List<Customer> getCustomer(String customerName, int pageNo) {
		return cDao.getCustomer(customerName, pageNo);
	}
	@Override
	public int querySomeoneRecords(String customerName) {
		return cDao.querySomeoneRecords(customerName);
	}
	@Override
	public void updCustomer(Customer customer) {
		cDao.updCustomer(customer);
		
	}
	@Override
	public void addCustomer(Customer c) {
		cDao.addCustomer(c);
	}
	@Override
	public String queryfinalcustomer() {
		return cDao.queryfinalcustomer();
	}

}
