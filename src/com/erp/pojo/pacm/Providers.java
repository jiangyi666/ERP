package com.erp.pojo.pacm;

public class Providers {
	private String peeId;
	private String peeName;
	private String telephone;
	private String address;
	
	public Providers(String peeId,String peeName,String telephone,String address){
		this.peeId = peeId;
		this.peeName = peeName;
		this.telephone = telephone;
		this.address = address;
	}

	public String getPeeId() {
		return peeId;
	}
	public void setPeeId(String peeId) {
		this.peeId = peeId;
	}
	public String getPeeName() {
		return peeName;
	}
	public void setPeeName(String peeName) {
		this.peeName = peeName;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
