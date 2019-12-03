package com.erp.pojo.rgm;

public class SalesReturn {
	private String returnId;
	private String orderId;
	private String customerId;
	private String customerAddress;
	private String address;
	private String returnDate;
	private String status;
	public String getReturnId() {
		return returnId;
	}
	public void setReturnId(String returnId) {
		this.returnId = returnId;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "SaleReturn [returnId=" + returnId + ", orderId=" + orderId + ", customerId=" + customerId
				+ ", customerAddress=" + customerAddress + ", address=" + address + ", returnDate=" + returnDate
				+ ", status=" + status + "]";
	}
	
}
