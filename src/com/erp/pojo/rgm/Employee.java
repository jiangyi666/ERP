package com.erp.pojo.rgm;
public class Employee {
	private String employeeId;
	private String employeeName;
	private String password;
	private String deptId;
	private String headship;
	private double salary;
	private int privilege;

	public Employee(){
		super();
	}
	
	public Employee(String employeeId, String employeeName, String password, String deptId, String headship,
			double salary, int privilege) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.password = password;
		this.deptId = deptId;
		this.headship = headship;
		this.salary = salary;
		this.privilege = privilege;
	}
	
	
	
	
	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getHeadship() {
		return headship;
	}

	public void setHeadship(String headship) {
		this.headship = headship;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}



	public int getPrivilege() {
		return privilege;
	}

	public void setPrivilege(int privilege) {
		this.privilege = privilege;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", password=" + password
				+ ", deptId=" + deptId + ", headship=" + headship + ", salary=" + salary + ", privilege=" + privilege
				+ "]";
	}

}
