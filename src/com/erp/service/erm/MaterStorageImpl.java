package com.erp.service.erm;


import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.erp.Utils.MyJDBCUtil;
import com.erp.dao.erm.MaterielStorage;
import com.erp.pojo.erm.*;

public class MaterStorageImpl implements MaterielStorage{

	MyJDBCUtil util=new MyJDBCUtil();
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Materiel> getAllMateriel(){
		String sql="select * from materiel";
		List<Materiel> allmat = null;
		try {
			allmat = util.populate(sql, null, Materiel.class);
			for(int i=0;i<allmat.size();i++) {
				Materiel mat=allmat.get(i);
				System.out.println(mat.getMatId());
				System.out.println(mat.getType());
				System.out.println(mat.getBrand());
			}
		} catch (InstantiationException | IllegalAccessException | SecurityException | IllegalArgumentException
				| SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return allmat;
	}
	

	
	public void CheckPurchase(String purchaseId) {
		PurchaseImpl purimpl=new PurchaseImpl();
		List<Purchasedetail> purde=purimpl.getPurchasedet(purchaseId);
		List<Purchasemaster> purmas=purimpl.getPurchasemas(purchaseId);
		Purchasemaster purmaster=purmas.get(0);
		
		List<Materrielstoragedetail> matde=null;		
		try {
			matde=util.populate("select * from materrielstoragedetail", null, Materrielstoragedetail.class);
		} catch (InstantiationException | IllegalAccessException | SecurityException | IllegalArgumentException
				| SQLException e) {
			e.printStackTrace();
		}
		
		for(int i=0;i<purde.size();i++) {
			boolean flag=false;			
			for(int j=0;j<matde.size();j++) {				
				if(purde.get(i).getMatId().equals(matde.get(j).getMatId())) {	
					String sql="update materrielstoragedetail set amount=amount+?,date=? where matId=?";
					Object[] params=new Object[] {
							purde.get(i).getQty(),
							purmaster.getPurchaseDate(),
							purde.get(i).getMatId()
						};
					util.executeUpdate(sql, params);
					flag=true;
					break;
				}	
				
			}
			
			if(flag=false) {
				String sql="insert into materrielstoragedetail(matStoreDetId,matId,amount,date) values(?,?,?,?)";
				String matStoreDetId="mdnew"+i;
				Object[] parmas=new Object[] {
						matStoreDetId,
						purde.get(i).getMatId(),
						purde.get(i).getQty(),
						purmaster.getPurchaseDate()
					};
				if(util.insert(sql, parmas)) {
					System.out.println("success!");
				}else {
					System.out.println("error!");
				}				
			}
		}
		
		
	}
	
	public Materrielstorage[] createMatStorage(String purchaseId) {	
		
		PurchaseImpl purimpl=new PurchaseImpl();
		List<Purchasedetail> purde=purimpl.getPurchasedet(purchaseId);
		List<Purchasemaster> purmas=purimpl.getPurchasemas(purchaseId);
		Purchasemaster purmaster=purmas.get(0);		
		Materrielstorage[] matstor=new Materrielstorage[purde.size()];	
		
		for(int i=0;i<purde.size();i++) {
			
			matstor[i]=new Materrielstorage();
			matstor[i].setMatStoreld(purmas.get(0).getPurchaseId()+i);//
			matstor[i].setMatId(purde.get(i).getMatId());//
			matstor[i].setEmployeeId(purmas.get(0).getEmployeId());
			matstor[i].setQty(purde.get(i).getQty());//
			matstor[i].setInspectionStatus("未验货");
			
		}
		return matstor;
	}	
	
	
	public boolean insertmat(Materrielstorage mat,String purchaseId) {
		Materrielstorage[] matstor=createMatStorage(purchaseId);
		
		for(int i=0;i<matstor.length;i++) {		
				matstor[i].setMatType("进");
				matstor[i].setEmployeeId(mat.getEmployeeId());
				matstor[i].setDate(mat.getDate());
				matstor[i].setLocation(mat.getLocation());
				matstor[i].setInspectionStatus(mat.getInspectionStatus());
				matstor[i].setInspectionRemarks("success!");
			};
		for(int i=0;i<matstor.length;i++) {
			String sql="insert into materrielstorage values(?,?,?,?,?,?,?,?,?)";
			Object[] parmas=new Object[] {
					matstor[i].getMatStoreld(),
					matstor[i].getMatType(),
					matstor[i].getMatId(),
					matstor[i].getEmployeeId(),
					matstor[i].getQty(),
					matstor[i].getDate(),
					matstor[i].getLocation(),
					matstor[i].getInspectionStatus(),
					matstor[i].getInspectionRemarks()
				}; 
				boolean flag=util.insert(sql, parmas);
				if(!flag) {
					return false;
				}			
				
			}			
		return true;
	}
	
	public List<Map<String,Object>> matadd(){
		String sql="select matStoreDetId,materrielstoragedetail.matId,matName,matSpec,amount,date,min from materrielstoragedetail,materiel where materrielstoragedetail.matId=materiel.matId";
		List<Map<String,Object>> matadd=(List)util.excuteQuery(sql, null);
		for(int i=0;i<matadd.size();i++) {
			System.out.println(matadd.get(i).get("matName"));
		}
		return matadd;
	}
	
	public List<Materiel> getmaterrelbyid(String matId){
		String sql="select * from materiel where matId =?";
		Object[] obj=new Object[] {
			matId	
		};
		List<Materiel> list=null;
		try {
			list=util.populate(sql, obj, Materiel.class);
		} catch (InstantiationException | IllegalAccessException | SecurityException | IllegalArgumentException
				| SQLException e) {
			e.printStackTrace();
		}
		return list;		
	}



	public int updateamount(String matId, int amount) {
		String sql="UPDATE materrielstoragedetail set  amount = ? WHERE matId=?";
		Object[] obj = new Object[] {
			amount,matId
		};
		int count=util.executeUpdate(sql, obj);
		return count;
	}
}
