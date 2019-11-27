package com.erp.Utils;

import java.util.List;

import com.erp.pojo.pacm.Customer;
import com.erp.pojo.pacm.Providers;


public class PageModel {
	private List<Providers> proList;
	private List<Customer> cuList;
	private int totalRecords;
	private int pageSize = 10;
	private int totalPages;
	private int pageNo;
	
	
	public List<Customer> getCuList() {
		return cuList;
	}
	public void setCuList(List<Customer> cuList) {
		this.cuList = cuList;
	}
	public List<Providers> getProList() {
		return proList;
	}
	public void setProList(List<Providers> proList) {
		this.proList = proList;
	}
	public int getTotalRecords() {
		return totalRecords;
	}
	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalPages() {
		return totalRecords%10==0?totalRecords/6:(totalRecords/6+1);
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	
	//首页
	public int getTopPage(){
		return 1;
	}
	//上一页
	public int getPreviousPage(){
		return pageNo<=1?1:(pageNo-1);
	}
	//下一页
		public int getNextPage(){
			return pageNo>=getTotalPages()?getTotalPages():(pageNo+1);
		}
	//尾页
		public int getLastPage(){
			return getTotalPages();
		}

}

