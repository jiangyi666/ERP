package com.erp.servlet.pm;

import com.erp.pojo.pm.employee;
import com.erp.pojo.pm.provider;
import com.erp.service.pm.employeeservice;
import com.erp.service.pm.providerservice;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class selectservlet
 */
@WebServlet("/selectservlet.do")
public class selectservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public selectservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * 该servlet主要用于新建采购订单填写订单信息时的下拉框动态的提供选择
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<employee> liste= employeeservice.getemployee();
		List<provider> listp= providerservice.getprovider();
		System.out.println(liste.get(1).getEmployeeId());
		String pageItem=request.getParameter("pageItem");
		request.setAttribute("pageItem", pageItem);
		HttpSession session = request.getSession();
		session.setAttribute("liste", liste);
		session.setAttribute("listp", listp);
		request.getRequestDispatcher("/pm/addpurchaseorder.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
