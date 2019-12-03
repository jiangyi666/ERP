package com.erp.servlet.pm;

import com.erp.pojo.pm.purchasedetail;
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
 * Servlet implementation class purchaseordergetdetail
 */
@WebServlet("/purchaseordergetdetail.do")
public class purchaseordergetdetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public purchaseordergetdetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//System.out.println(request.getParameter("purchaseId"));
		String value=request.getParameter("purchasedetailInsert");
		String purchaseId = request.getParameter("purchaseId");
		if(value.equals("1"))
		{
		String pageItem = request.getParameter("pageItem");
		List<Map<String, Object>> list = purchasedetailservice.getpurchaseorderdetail(purchaseId);
		// 将数据放入请求域
		request.setAttribute("pageItem", pageItem);
		request.setAttribute("list", list);
		request.setAttribute("purchaseId", purchaseId);
		request.getRequestDispatcher("/pm/showpurchasedetail.jsp").forward(request, response);
		}
		if(value.equals("2"))
		{
			purchasedetail pur=new purchasedetail();
			pur.setPurchaseId(purchaseId);
			String matId=request.getParameter("matId");
			double qty=Double.parseDouble(request.getParameter("qty"));
			double price=Double.parseDouble(request.getParameter("price"));
			double transpCosts=Double.parseDouble(request.getParameter("transpCosts"));
			pur.setMatId(matId);
			pur.setQty(qty);
			pur.setPrice(price);
			pur.setTranspCosts(transpCosts);
			purchasedetailservice.save(pur);
			purchaseorderservice.update(purchaseId, qty*price+transpCosts);
			request.setAttribute("purchaseId", purchaseId);
			request.getRequestDispatcher("/pm/addpurchasedetail.jsp").forward(request, response);
		}
		if(value.equals("3")) {
			request.setAttribute("purchaseId", purchaseId);
			request.getRequestDispatcher("/pm/addpurchasedetail.jsp").forward(request, response);
		}
		if(value.equals("4")) {
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
