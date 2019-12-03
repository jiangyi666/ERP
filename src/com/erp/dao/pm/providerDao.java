package com.erp.dao.pm;

import com.erp.Utils.JDBCUtil;
import com.erp.pojo.pm.provider;

import java.util.List;



public interface providerDao {
	static JDBCUtil db=new JDBCUtil();
	public List<provider> getprovider();
}
