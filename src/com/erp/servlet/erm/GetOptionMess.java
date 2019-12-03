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
 * Servlet implementation class GetOptionMess
 */
@WebServlet("/GetOptionMess")
public class GetOptionMess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetOptionMess() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PurchaseImpl purimpl=new PurchaseImpl();
		List<Map<String,Object>> purchaseId=purimpl.getpruchaseId();
		
		PrintWriter data = response.getWriter();
		JSONArray arr =  new JSONArray();
		JSONObject obj;
		for(int i=0;i<purchaseId.size();i++) {
			Map<String,Object> map=purchaseId.get(i);
			obj=JSONObject.fromObject(map);
			arr.add(obj);
		}		
		data.print(arr);
		data.flush();
		data.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
