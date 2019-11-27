package com.erp.service.pacm;


import com.erp.pojo.pacm.Providers;

import java.util.List;

public interface ProviderService {
		//得到指定页customer
		public List<Providers> getAll(int pageNo);
		//查询总条数
		public int queryTotalRecords();
		//删除对应客户记录
		public void delproviders(String peeId);
		//查询模糊搜索
		public List<Providers> getProviders(String peeName, int pageNo);
		//查询模糊搜索的总条数
		public int querySomeoneRecords(String peeName);
		//更新客户信息
		public void updProviders(Providers p);
		//新增客户
		public void addProviders(Providers p);
		//获得peeid为最后的一名客户的peeid
		public String queryfinalpee();
}
