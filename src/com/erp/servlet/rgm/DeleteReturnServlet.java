package com.erp.servlet.rgm;

import com.erp.service.rgm.SaleServiceImpl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "/DeleteReturnServlet", urlPatterns = "/DeleteReturnServlet.do")
public class DeleteReturnServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public DeleteReturnServlet() {
		super();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");// 解决post提交的中文乱码
		response.setContentType("text/html;charset=utf-8");
		
		String ReturnId = request.getParameter("ReturnId");//从页面获取文本框数据
		System.out.println(ReturnId);
		boolean status = new SaleServiceImpl().deleteReturn(ReturnId);
		
		if(status==true) {
			System.out.println("删除成功");
		}else {
			System.out.println("删除失败");
		}
		request.getRequestDispatcher("rgm/ShowSalesReturn.jsp").forward(request, response);
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
}
