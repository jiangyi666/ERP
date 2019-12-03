package com.erp.servlet.pm;

import com.erp.service.pm.purchasedetailservice;
import com.erp.service.pm.purchaseorderservice;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class pagechange
 */
@WebServlet("/pagechange")
public class pagechange extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public pagechange() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String pageItem=request.getParameter("pageItem");
		String type=request.getParameter("type");
		if(type.equals("purchaseorder"))
		{
			List<Map<String, Object>> list= purchaseorderservice.getpurchaseorder();
			request.setAttribute("pageItem", pageItem);
			request.setAttribute("list", list);
			request.getRequestDispatcher("/pm/showpurchaseorder.jsp").forward(request, response);
		}
		if(type.equals("purchaseorderdetail"))
		{
			List<Map<String, Object>> list = purchasedetailservice.getpurchaseorderdetail(request.getParameter("purchaseId"));
			String purchaseId=request.getParameter("purchaseId");
			request.setAttribute("pageItem", pageItem);
			request.setAttribute("list", list);
			request.setAttribute("purchaseId", purchaseId);
			request.getRequestDispatcher("/pm/showpurchasedetail.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
