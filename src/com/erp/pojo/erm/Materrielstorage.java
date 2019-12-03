package com.erp.pojo.erm;

import java.sql.Date;
import java.sql.Timestamp;

public class Materrielstorage {

	private String matStoreld;
	private String matType;
	private String matId;
	private String employeeId;
	private double qty;
	private Timestamp date;
	private String location;
	private String inspectionStatus;//״̬
	private String inspectionRemarks;
	
	public String getMatStoreld() {
		return matStoreld;
	}
	public void setMatStoreld(String matStoreld) {
		this.matStoreld = matStoreld;
	}
	public String getMatType() {
		return matType;
	}
	public void setMatType(String matType) {
		this.matType = matType;
	}
	public String getMatId() {
		return matId;
	}
	public void setMatId(String matId) {
		this.matId = matId;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public double getQty() {
		return qty;
	}
	public void setQty(double qty) {
		this.qty = qty;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getInspectionStatus() {
		return inspectionStatus;
	}
	public void setInspectionStatus(String inspectionStatus) {
		this.inspectionStatus = inspectionStatus;
	}
	public String getInspectionRemarks() {
		return inspectionRemarks;
	}
	public void setInspectionRemarks(String inspectionRemarks) {
		this.inspectionRemarks = inspectionRemarks;
	}
	@Override
	public String toString() {
		return "Materrielstorage [matStoreld=" + matStoreld + ", matType=" + matType + ", matId=" + matId
				+ ", employeeId=" + employeeId + ", qty=" + qty + ", date=" + date + ", location=" + location
				+ ", inspectionStatus=" + inspectionStatus + ", inspectionRemarks=" + inspectionRemarks + "]";
	}
		
}
