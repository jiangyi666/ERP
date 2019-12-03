package com.erp.servlet.erm;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.erp.service.erm.PurchaseImpl;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class getlocation
 */
@WebServlet("/getlocation")
public class getlocation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getlocation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PurchaseImpl service=new PurchaseImpl();
		List<Map<String,Object>> list = service.getlocation();
		System.out.println(list);
		PrintWriter out=response.getWriter();
		JSONArray arr=new JSONArray();
		JSONObject obj=null;
		for(int i=0;i<list.size();i++) {
			obj=JSONObject.fromObject(list.get(i));
			arr.add(obj);
		}
		System.out.println(obj);
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
