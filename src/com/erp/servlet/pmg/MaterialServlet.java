package com.erp.servlet.pmg;

import com.erp.pojo.pmg.Materiel;
import com.erp.service.pmg.MaterialServiceImpl;
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

/**
 * Servlet implementation class MaterialServlet
 */
@WebServlet("/MaterialServlet")
public class MaterialServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	public MaterialServiceImpl MSI = new MaterialServiceImpl();
   
 
    public MaterialServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");  response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		JSONArray jsonArray = new JSONArray();
		JSONObject jsonObj;
		String oper = request.getParameter("oper");
		
		if(oper.equals("addMaterial")) {
			
			//反序列化
			String Material_str = request.getParameter("material");
			JSONObject jsonObject = JSONObject.fromObject(Material_str);
			Materiel materiel = (Materiel) JSONObject.toBean(jsonObject,Materiel.class);
			//添加
			MSI.addMaterial(materiel);
		}
		if(oper.equals("deleteMaterial")) {
			String matId = 	request.getParameter("matId");
			MSI.deleteMaterial(matId);
		}
		if(oper.equals("updateMaterial")) {
			
			String Material_str = request.getParameter("material");
			System.out.println(Material_str);
			JSONObject jsonObject = JSONObject.fromObject(Material_str);
			Materiel materiel = (Materiel) JSONObject.toBean(jsonObject,Materiel.class);
			MSI.updateMaterial(materiel);
		}
		if(oper.equals("getAllMaterial")) {
			
			List<Materiel> materielList = new ArrayList<Materiel>();
			materielList = MSI.getAllMaterial();
			Materiel materiel = null;
			
			jsonArray.add(MSI.thead);
			if(!(materielList == null))
				for(int i=0;i<materielList.size();i++) {
					
					materiel = materielList.get(i);
					jsonObj = new JSONObject().fromObject(materiel);
					jsonArray.add(jsonObj);
			
				}
			
				out.print(jsonArray.toString());
				out.flush();
				out.close();
		}
		if(oper.equals("getMaterialById")) {
			String matId = request.getParameter("matId");
			MSI.deleteMaterial(matId);
		}
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
