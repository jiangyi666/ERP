package com.erp.servlet.rgm;

import com.erp.dao.rgm.SalesReturnDao;
import com.erp.dao.rgm.SalesReturnDaoImpl;
import com.erp.pojo.rgm.SalesReturn;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "/UpdateReturnServlet",urlPatterns = "/UpdateReturnServlet.do")
public class UpdateReturnServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");// 解决post提交的中文乱码
		response.setContentType("text/html;charset=utf-8");
		 
		// 从页面获取文本框数据
		String ReturnId = request.getParameter("ReturnId");//从页面获取文本框数据
		String OrderId = request.getParameter("OrderId"); 
		String CustomerId = request.getParameter("CustomerId"); 
		String CustomerAddress = request.getParameter("CustomerAddress"); 
		String Address = request.getParameter("Address");
		String ReturnDate = request.getParameter("ReturnDate"); 
		String Status = request.getParameter("Status");
		
		SalesReturn sr = new SalesReturn();
		sr.setReturnId(ReturnId);
		sr.setOrderId(OrderId); 
		sr.setCustomerId(CustomerId);
		sr.setCustomerAddress(CustomerAddress); 
		sr.setAddress(Address);
		sr.setReturnDate(ReturnDate); 
		sr.setStatus(Status);
		
		SalesReturnDao srd = new SalesReturnDaoImpl();
		boolean status = srd.updateReturn(sr);
		
		if(status==true) {
			System.out.println("修改成功");
		}else {
			System.out.println("修改失败");
		}
		request.getRequestDispatcher("rgm/ShowSalesReturn.jsp").forward(request, response);
	}
	
}
