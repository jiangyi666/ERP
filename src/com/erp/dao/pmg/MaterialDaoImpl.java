package com.erp.dao.pmg;

import com.erp.pojo.pmg.Materiel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class MaterialDaoImpl implements MaterialDao {
	
	PreparedStatement pst;
	ResultSet rs;
	
	public String[] thead;

	@Override
	public void addMaterial(Materiel materiel) {
		// TODO Auto-generated method stub
		String sql = "insert into materiel values(?,?,?,?,?,?,?,?,?)";
		try {
			pst = conn.prepareStatement(sql);
			
			pst.setString(1, materiel.matId);
			pst.setString(2, materiel.matName);
			pst.setString(3, materiel.brand);
			pst.setString(4, materiel.type);
			pst.setString(5, materiel.level);
			pst.setDouble(6, materiel.gram);
			pst.setString(7, materiel.matSpec);
			pst.setString(8, materiel.unit);
			pst.setDouble(9, materiel.matPrice);
			
			pst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deleteMaterial(String matId) {
		// TODO Auto-generated method stub
		String sql = "delete from materiel where matId=?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1,matId);
			pst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void updateMaterial(Materiel materiel) {
		// TODO Auto-generated method stub
		String sql = "update materiel set "
											+ "matName=?,"
											+ "brand=?,"
											+ "type=?,"
											+ "level=?,"
											+ "gram=?,"
											+ "matSpec=?,"
											+ "unit=?,"
											+ "matPrice=?"
									+" where matId=?";
			
		try {
			
			pst = conn.prepareStatement(sql);
			
			pst.setString(1, materiel.matName);
			pst.setString(2, materiel.brand);
			pst.setString(3, materiel.type);
			pst.setString(4, materiel.level);
			pst.setDouble(5, materiel.gram);
			pst.setString(6, materiel.matSpec);
			pst.setString(7, materiel.unit);
			pst.setDouble(8, materiel.matPrice);
			pst.setString(9, materiel.matId);
			
			pst.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	@Override
	public List<Materiel> getAllMaterial() {
		// TODO Auto-generated method stub
		String sql = "select " + "matId as '物料编号'," + 
								"matName as '物料名称',"+
								"brand as '品牌',"+
								"type as '纸种',"+
								"level as '级别',"+
								"gram as '克重',"+
								"matSpec as '规格型号',"+
								"unit as '单位',"+
								"matPrice as '单价'"+
					" from materiel";
		Materiel materiel = null;
		List<Materiel> list = new ArrayList<Materiel>();
		
		try {
			pst = conn.prepareStatement(sql);
			rs =  pst.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			
			int col = rsmd.getColumnCount();  //获取表的列数
			this.thead = new String[col];
			
			/*for(int i=0;i<col;i++) {
				this.thead[i] = rsmd.getColumnName(i+1);
				System.out.println(thead[i]);
			}*/
			this.thead[0] = "物料编号";
			this.thead[1] = "物料名称";
			this.thead[2] = "品牌";
			this.thead[3] = "纸种";
			this.thead[4] = "级别";
			this.thead[5] = "克重";
			this.thead[6] = "规格型号";
			this.thead[7] = "单位";
			this.thead[8] = "单价";
			
			
			while(rs.next()) {
				materiel = new Materiel(rs.getString(1),
										rs.getString(2),
										rs.getString(3),
										rs.getString(4),
										rs.getString(5),
										rs.getDouble(6),
										rs.getString(7),
										rs.getString(8),
										rs.getDouble(9));
				list.add(materiel);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
 		return list;
	}

	@Override
	public Materiel getMaterialById(String matId) {
		// TODO Auto-generated method stub
		String sql = "select * from materiel where matId=?";
		Materiel materiel = null;
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, matId);
			rs = pst.executeQuery();
			while(rs.next()) {
				
				materiel = new Materiel(rs.getString(1),
										rs.getString(2),
										rs.getString(3),
										rs.getString(4),
										rs.getString(5),
										rs.getDouble(6),
										rs.getString(7),
										rs.getString(8),
										rs.getDouble(9));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return materiel;
	}

}
