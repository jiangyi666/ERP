package com.erp.servlet.rgm;

import com.erp.pojo.rgm.SalesReturn;
import com.erp.service.rgm.SaleServiceImpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet(name = "/FindReturnByIdServlet", urlPatterns = "/FindReturnByIdServlet.do")
public class FindReturnByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FindReturnByIdServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");// 解决post提交的中文乱码
		response.setContentType("text/html;charset=utf-8");
		 
		
		/*
		 * List<SalesReturn> list = new SalesReturnDaoImpl().getReturns();
		 * 
		 * SalesReturn sr; PrintWriter out = response.getWriter(); JSONObject obj;
		 * JSONArray arr = new JSONArray(); for(int i=0;i<list.size();i++) { sr =
		 * list.get(i); obj = new JSONObject().fromObject(sr); arr.add(obj); }
		 * 
		 * out.print(arr); out.flush(); out.close();
		 * 
		 * response.getWriter().append("Served at: ").append(request.getContextPath());
		 */ 
		PrintWriter out = response.getWriter();
		
		String ReturnId = request.getParameter("ReturnId");//从页面获取文本框数据
		System.out.println(ReturnId);
		SalesReturn sr = new SaleServiceImpl().findReturnById(ReturnId);
		request.setAttribute("sr", sr);
		request.getRequestDispatcher("rgm/FindReturnById.jsp").forward(request, response);
	}
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
}
