package com.erp.service.pmg;

import com.erp.pojo.pmg.Materiel;

import java.util.List;


public interface MaterialService {
	
	public void addMaterial(Materiel materiel); //增加物料
	
	public void deleteMaterial(String matId);  //删除物料
	
	public void updateMaterial(Materiel materiel);  //修改物料信息
	
	public List<Materiel> getAllMaterial();	//获取所有物料
	
	public Materiel getMaterialById(String maatId);	//根据主键ID获取某一个物料信息
}
