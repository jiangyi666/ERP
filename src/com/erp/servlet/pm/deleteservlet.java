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
 * Servlet implementation class deleteservlet
 */
@WebServlet("/deleteservlet.do")
public class deleteservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String re=request.getParameter("type");
		String pageItem=request.getParameter("pageItem");
		if(re.equals("1"))
		{
			int result = purchaseorderservice.delete(request.getParameter("purchaseId"));
			if(result!=0){
	             System.out.println(result+"-----------操作成功");
	             purchasedetailservice.delete(request.getParameter("purchaseId"));
	             request.setAttribute("pageItem",pageItem);
	             List<Map<String, Object>> list=purchaseorderservice.getpurchaseorder();
	             request.setAttribute("list",list);
	             request.getRequestDispatcher("/pm/showpurchaseorder.jsp").forward(request, response);
	          }else{
	              System.out.println("操作失败");
	          }
		}
		if(re.equals("2"))
		{
			int result = purchasedetailservice.deleteSingle(request.getParameter("matId"));
			String purchaseId=request.getParameter("purchaseId");
			List<Map<String, Object>> list = purchasedetailservice.getpurchaseorderdetail(purchaseId);
			request.setAttribute("list",list);
			request.setAttribute("pageItem",request.getParameter("pageItem"));
			request.setAttribute("purchaseId",purchaseId);
			if(result!=0){
	             System.out.println(result+"-----------操作成功");
	             request.getRequestDispatcher("/pm/showpurchasedetail.jsp").forward(request, response);
	          }else{
	              System.out.println("操作失败");
	          }
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
