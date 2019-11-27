package com.erp.servlet.pmg;

import com.erp.pojo.pmg.GoodsLocation;
import com.erp.service.pmg.GoodsLocationServiceImpl;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/GoodsLocationServlet")
public class GoodsLocationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

   public GoodsLocationServiceImpl GLSI = new GoodsLocationServiceImpl();
    public GoodsLocationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");  response.setContentType("text/html;charset=utf-8");

		PrintWriter out = response.getWriter();
		String oper = request.getParameter("oper");
		JSONArray jsonArray = new JSONArray();
		JSONObject jsonObj;
		
		if(oper.equals("addGoodsLocation")) {
			//反序列化
			String GoodsLocation_str = request.getParameter("goodsLocation");
			JSONObject jsonObject = JSONObject.fromObject(GoodsLocation_str);
			GoodsLocation goodsLocation = (GoodsLocation) JSONObject.toBean(jsonObject,GoodsLocation.class);
			//添加
			GLSI.addGoodsLocation(goodsLocation);
		}
		if(oper.equals("deleteGoodsLocation")) {
			String location = 	request.getParameter("location");
			GLSI.deleteGoodsLocation(location);	
		}
		if(oper.equals("updateGoodsLocation")) {
			String GoodsLocation_str = request.getParameter("goodsLocation");
			JSONObject jsonObject = JSONObject.fromObject(GoodsLocation_str);
			GoodsLocation goodsLocation = (GoodsLocation) JSONObject.toBean(jsonObject,GoodsLocation.class);
			
			GLSI.updateGoodsLocation(goodsLocation);
		}
		if(oper.equals("getAllGoodsLocation")) {

			List<GoodsLocation> goodsLocationlList = new ArrayList<GoodsLocation>();
			goodsLocationlList = GLSI.getAllGoodsLocation();
			GoodsLocation goodsLocation = null;
			
			jsonArray.add(GLSI.thead);	
			if(!(goodsLocationlList == null))
				for(int i=0;i<goodsLocationlList.size();i++) {
					
					goodsLocation = goodsLocationlList.get(i);
					jsonObj = new JSONObject().fromObject(goodsLocation);
					jsonArray.add(jsonObj);
			
				}
				
				out.print(jsonArray.toString());
				out.flush();
				out.close();
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
