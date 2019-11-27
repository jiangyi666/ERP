package com.erp.servlet.pacm;

import com.erp.pojo.pacm.Customer;
import com.erp.service.pacm.CustomerService;
import com.erp.service.pacm.CustomerServiceImpl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="UpdCustomerServlet", urlPatterns="/updcustomer")
public class UpdCustomerServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//处理乱码 
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		//获得customerid以及修改的信息
		String customerId = req.getParameter("customerid");
		String customerName = req.getParameter("customername");
		String telephone = req.getParameter("telephone");
		//获取业务层对象
		CustomerService cs = new CustomerServiceImpl();
		//处理业务
		Customer c = new Customer(customerId,customerName,telephone);
		cs.updCustomer(c);
		//重定向到jsp页面
		req.getRequestDispatcher("/customerall").forward(req, resp);
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			this.doPost(req, resp);
	}
}
