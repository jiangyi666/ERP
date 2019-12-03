package com.erp.pojo.rgm;

public class Dept {
	private String deptId;
	private String deptname;

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getDeptname() {
		return deptname;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}

	@Override
	public String toString() {
		return "Dept [deptId=" + deptId + ", deptname=" + deptname + "]";
	}
}

