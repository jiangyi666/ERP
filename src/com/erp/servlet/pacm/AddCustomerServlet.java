package com.erp.servlet.pacm;


import com.erp.pojo.crm.Employee;
import com.erp.pojo.pacm.Customer;
import com.erp.service.pacm.CustomerService;
import com.erp.service.pacm.CustomerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name="AddCustomerServlet",urlPatterns="/addcustomer")
public class AddCustomerServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
				//处理乱码 
				req.setCharacterEncoding("utf-8");
				resp.setCharacterEncoding("utf-8");
				resp.setContentType("text/html;charset=utf-8");
				//获得权限
				HttpSession session = req.getSession();
				Employee e = (Employee)session.getAttribute("employee");
				
				//获得新建的客户信息信息
				String customerId = null;
				String customerName = req.getParameter("customername");
				String telephone = req.getParameter("telephone");
				//获取业务层对象
				CustomerService cs = new CustomerServiceImpl();
				//处理业务
				String finId = cs.queryfinalcustomer();
				if(finId != null){
					String strid=finId.substring(1,4);
					int iid = Integer.valueOf(strid);
					customerId = String.valueOf(iid+1);
					switch (customerId.length()) {			
						case 1:				
							customerId = "c00" + customerId; 				
							break;			
						case 2:				
							customerId = "c0" + customerId; 				
							break;			
						case 3:				
							customerId = "c" + customerId; 				
							break;					
							}
					
				}else{
					customerId = "c001";
				}
				Customer c = new Customer(customerId,customerName,telephone);
				cs.addCustomer(c);
				//重定向到jsp页面
				req.getRequestDispatcher("/customerall").forward(req, resp);
				
	}

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}
}
