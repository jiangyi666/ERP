package com.erp.servlet.erm;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.erp.pojo.erm.Materiel;


import com.erp.service.erm.MaterStorageImpl;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class getmaterriel
 */
@WebServlet("/getmaterriel")
public class getmaterriel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getmaterriel() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Content-type", "text/html;charset=UTF-8");	
		
		
		MaterStorageImpl service = new MaterStorageImpl();
		String matId=request.getParameter("matId");	
		List<Materiel> list=service.getmaterrelbyid(matId);
		
		PrintWriter out=response.getWriter();
		JSONArray arr=new JSONArray();
		JSONObject obj;

		for(int i=0;i<list.size();i++) {
			obj=new JSONObject().fromObject(list.get(i));
			arr.add(obj);
		}
		
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
