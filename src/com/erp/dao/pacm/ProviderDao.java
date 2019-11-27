package com.erp.dao.pacm;


import com.erp.pojo.pacm.Providers;

import java.util.List;

public interface ProviderDao {
		//查询所有供应商
		public List<Providers> getAll(int pageNo);
		
		//增加供应商信息
		public void addProviders(Providers p);
		
		//修改供应商信息
		public void updProviders(Providers p);
		
		//删除供应商
		public void delProviders(String peeId);
		
		//按名字寻找供应商
		public List<Providers> getProviders(String peeName, int pageNo);

		//查询总记录条数
		public int queryTotalRecords();
		
		//查询模糊搜索的总条数
		public int querySomeoneRecords(String peeName);
		
		//查找最后一名供应商的peeid
		public String queryfinalprovider();
}
