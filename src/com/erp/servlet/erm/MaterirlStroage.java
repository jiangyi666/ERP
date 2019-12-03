package com.erp.servlet.erm;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.erp.pojo.erm.Materrielstorage;


import com.erp.service.erm.MaterStorageImpl;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class GetAllMateriel
 */
@WebServlet("/GetAllMateriel")
public class MaterirlStroage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MaterirlStroage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Content-type", "text/html;charset=UTF-8");	
		
		String purchaseId=request.getParameter("purchaseId");
		System.out.println(purchaseId);
		MaterStorageImpl mater=new MaterStorageImpl();
		Materrielstorage[] service=mater.createMatStorage(purchaseId);
		System.out.println(service[0]);
		
		PrintWriter out=response.getWriter();
		JSONArray arr=new JSONArray();
		JSONObject obj=null;
		for(int i=0;i<service.length;i++) {
			obj=JSONObject.fromObject(service[i]);
			arr.add(obj);
		}
		System.out.println(obj.toString());
		out.print(arr);
		out.flush();
		out.close();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
