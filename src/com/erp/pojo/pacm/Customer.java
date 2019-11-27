package com.erp.pojo.pacm;

public class Customer {
	private String customerId;	//�ͻ����
	private String paasword;	//�ͻ�����
	private String customerName;	//�ͻ�����
	private String telephone;	//�ͻ��绰
	
	public Customer(String customerId,String customerName,String telephone){
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
	public String getPaasword() {
		return paasword;
	}
	public void setPaasword(String paasword) {
		this.paasword = paasword;
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
