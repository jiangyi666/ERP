package com.erp.pojo.pacm;

public class Customer {
	private String customerId;	//�ͻ����
	private String password;	//�ͻ�����
	private String customerName;	//�ͻ�����
	private String telephone;	//�ͻ��绰

	public Customer() {
	}

	public Customer(String customerId, String customerName, String telephone){
		this.customerId = customerId;
		this.customerName = customerName;
		this.telephone = telephone;
	}
	
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	
}
