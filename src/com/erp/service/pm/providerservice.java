package com.erp.service.pm;

import com.erp.dao.pm.providerDaoImpl;
import com.erp.pojo.pm.provider;

import java.util.List;



public class providerservice {
	static com.erp.dao.pm.providerDaoImpl providerDaoImpl;
	static {
		providerDaoImpl=new providerDaoImpl();
	}
	public static List<provider> getprovider(){
		return providerDaoImpl.getprovider();
	}
}
