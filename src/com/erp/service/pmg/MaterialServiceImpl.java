package com.erp.service.pmg;

import com.erp.dao.pmg.MaterialDaoImpl;
import com.erp.pojo.pmg.Materiel;

import java.util.List;


public class MaterialServiceImpl implements MaterialService {
	
	MaterialDaoImpl MD = new MaterialDaoImpl();
	public String [] thead;

	@Override
	public void addMaterial(Materiel materiel) {
		// TODO Auto-generated method stub
		MD.addMaterial(materiel);
	}

	@Override
	public void deleteMaterial(String matId) {
		// TODO Auto-generated method stub
		MD.deleteMaterial(matId);
	}

	@Override
	public void updateMaterial(Materiel materiel) {
		// TODO Auto-generated method stub
		MD.updateMaterial(materiel);
	}

	@Override
	public List<Materiel> getAllMaterial() {
		// TODO Auto-generated method stub
		List<Materiel> list = MD.getAllMaterial();
		this.thead = MD.thead;
		return list;
	}

	@Override
	public Materiel getMaterialById(String matId) {
		// TODO Auto-generated method stub
		return MD.getMaterialById(matId);
	}

}
