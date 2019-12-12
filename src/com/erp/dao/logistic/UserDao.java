package com.erp.dao.logistic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import com.erp.Utils.JDBCUtil;
import com.erp.pojo.logistic.DeliveryBill;
import com.erp.pojo.logistic.DetailBill;


public class UserDao{

	public List<DeliveryBill> getDeliveryList(int page) {
		// TODO Auto-generated method stub
		int pageNow=page;//当前页
		int pageSize=6;//每页显示的记录
		int pageCount=1;//页数
		int rowCount=0;//共有几条数据
		List<DeliveryBill> dbs=new LinkedList<>();
		PreparedStatement ps=null;
		ResultSet rs=null;
		Connection c=null;
		PreparedStatement ps2=null;
		ResultSet rs2=null;
		Connection c2=null;
		
			try{
			c=JDBCUtil.getConnection();
			c2=JDBCUtil.getConnection();
			//算出页数
			ps=c.prepareStatement("select count(distinct customerId)from delivery");
			rs=ps.executeQuery();
			rs.next();
			rowCount=rs.getInt(1);
			if(rowCount%pageSize==0){
				pageCount=rowCount/pageSize;
			}else{
				pageCount=rowCount/pageSize+1;
			}
			String sql=("select distinct orderId,customerId,customerName,telephone,deliveryStatus,orderDate "
					+ "from delivery where orderId not in(select t.orderId from(select orderId from delivery order by customerId limit 0,"+pageSize*(pageNow-1)+")as t) and customerId is not null"
					+ " order by orderId limit 0,"+pageSize);	
			ps2=c2.prepareStatement(sql);
			rs2=ps2.executeQuery();
			while(rs2.next()){
				DeliveryBill db=new DeliveryBill();
				db.setOrderId(rs2.getString("orderId"));
				db.setCuetomerId(rs2.getString("customerId"));
				db.setCustomerName(rs2.getString("customerName"));
				db.setTelephone(rs2.getString("telephone"));
				db.setStatus(rs2.getString("deliveryStatus"));
				db.setDate(rs2.getString("orderDate"));
				db.setPageCount(pageCount);
				dbs.add(db);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JDBCUtil.release(c, ps, rs);
			JDBCUtil.release(c2, ps2, rs2);
		}
		
		return dbs;
	}

	public List<DetailBill> getDetailList(String orderId, int page) {
		// TODO Auto-generated method stub
		int pageNow=page;//当前页
		int pageSize=6;//每页显示的记录
		int pageCount=1;//页数
	    int rowCount=0;//共有几条数据
	    System.out.println(orderId);
		List<DetailBill> ds=new LinkedList<>();
		PreparedStatement ps=null;
		ResultSet rs=null;
		Connection c=null;
		PreparedStatement ps2=null;
		ResultSet rs2=null;
		Connection c2=null;
		String []paras={orderId};
			try{
			c=JDBCUtil.getConnection();
			c2=JDBCUtil.getConnection();
			//算出页数
			ps=c.prepareStatement("select count(*) from delivery where orderId = ?");
			for(int i=0;i<paras.length;i++){
				ps.setString(i+1,paras[i]);
			}
			rs=ps.executeQuery();
			rs.next();
			rowCount=rs.getInt(1);
			JDBCUtil.release(c, ps, rs);

			if(rowCount%pageSize==0){
				pageCount=rowCount/pageSize;
			}else{
				pageCount=rowCount/pageSize+1;
			}

			String sql="select goodsId,customerName,productName,qty,orderPrice "
					+ "from delivery where orderId=? and goodsId "
					+ "not in"
					+ "(select t.goodsId "
					+ "from(select goodsId from delivery order by productName limit 0,"+pageSize*(pageNow-1)+")as t) "
			+ " order by productName limit 0,"+pageSize;
					
			
			
			ps2=c2.prepareStatement(sql);
		
			ps2.setString(1,orderId);
		
			rs2=ps2.executeQuery();
			while(rs2.next()){
				DetailBill db=new DetailBill();
				db.setGoodsId(rs2.getString("goodsId"));
				db.setCustomerName(rs2.getString("customerName"));
				db.setProductName(rs2.getString("productName"));
				db.setQty(rs2.getDouble("qty"));
				db.setPrice(rs2.getDouble("orderPrice"));
				db.setPageCount(pageCount);
				ds.add(db);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JDBCUtil.release(c2, ps2, rs2);
		}
		
		return ds;
	}

	public void done(String orderId){
		PreparedStatement ps=null;
		ResultSet rs=null;
		Connection c=null;
		String sql="update delivery set deliveryStatus='已送达' where orderId=?";
		String []paras={orderId};
		
		try {
			c=JDBCUtil.getConnection();
			ps=c.prepareStatement(sql);
			for(int i=0;i<paras.length;i++){
				ps.setString(i+1,paras[i]);
			}
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	
		}finally{
			JDBCUtil.release(c, ps, rs);
		}
	
	}
	public void undone(String orderId){
		PreparedStatement ps=null;
		ResultSet rs=null;
		Connection c=null;
		String sql="update delivery set deliveryStatus='待发货' where orderId=?";
		String []paras={orderId};
		
		try {
			c=JDBCUtil.getConnection();
			ps=c.prepareStatement(sql);
			for(int i=0;i<paras.length;i++){
				ps.setString(i+1,paras[i]);
			}
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	
		}finally{
			JDBCUtil.release(c, ps, rs);
		}
	
	}
	public void doing(String orderId){
		PreparedStatement ps=null;
		ResultSet rs=null;
		Connection c=null;
		String sql="update delivery set deliveryStatus='已发货' where orderId=?";
		String []paras={orderId};
		
		try {
			c=JDBCUtil.getConnection();
			ps=c.prepareStatement(sql);
			for(int i=0;i<paras.length;i++){
				ps.setString(i+1,paras[i]);
			}
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	
		}finally{
			JDBCUtil.release(c, ps, rs);
		}
	
	}
	public List<DeliveryBill> search(String index) {
		// TODO Auto-generated method stub
		List<DeliveryBill> dbs=new LinkedList<>();
		PreparedStatement ps=null;
		ResultSet rs=null;
		Connection c=null;
		PreparedStatement ps2=null;
		ResultSet rs2=null;
		Connection c2=null;
		String sql=("select distinct orderId,customerId,customerName,telephone,deliveryStatus,orderDate "
					+ "from delivery where orderId=? or customerId=? or customerName=? or telephone=?"
					+ " group by orderId,customerId,customerName,telephone,deliveryStatus,orderDate");	
		String []paras={index,index,index,index};
			try{
			c2=JDBCUtil.getConnection();
		
			ps2=c2.prepareStatement(sql);
			for(int i=0;i<paras.length;i++){
				ps2.setString(i+1,paras[i]);
			}
			rs2=ps2.executeQuery();
			while(rs2.next()){
				DeliveryBill db=new DeliveryBill();
				db.setOrderId(rs2.getString(1));
				db.setCuetomerId(rs2.getString(2));
				db.setCustomerName(rs2.getString(3));
				db.setTelephone(rs2.getString(4));
				db.setStatus(rs2.getString(5));
				db.setDate(rs2.getString(6));
				dbs.add(db);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JDBCUtil.release(c2, ps2, rs2);
		}
		return dbs;
	}

}
