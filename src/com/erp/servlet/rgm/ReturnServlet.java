package com.erp.servlet.rgm;

import com.erp.pojo.rgm.SalesReturn;
import com.erp.service.rgm.SaleService;
import com.erp.service.rgm.SaleServiceImpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "/ReturnServlet", urlPatterns = "/ReturnServlet.do")
public class ReturnServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ReturnServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");// 解决post提交的中文乱码
		response.setContentType("text/html;charset=utf-8");
		SaleService ss = new SaleServiceImpl();
		
		List<SalesReturn> list = ss.getReturns();
		
		request.setAttribute("list", list);
		//System.out.println(list);
		request.getRequestDispatcher("rgm/ShowSalesReturn.jsp").forward(request, response);
	}
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
}

