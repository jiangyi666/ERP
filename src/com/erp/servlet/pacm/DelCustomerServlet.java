package com.erp.servlet.pacm;

import com.erp.Utils.PageModel;
import com.erp.pojo.pacm.Customer;
import com.erp.service.pacm.CustomerService;
import com.erp.service.pacm.CustomerServiceImpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name="DelCustomerServlet", urlPatterns="/delcustomer")
public class DelCustomerServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			HttpSession session = req.getSession();
			String customerId = req.getParameter("customerid");
			//获取业务层对象
			CustomerService cs = new CustomerServiceImpl();
			cs.delcustomer(customerId);
			int pageNo ;
			String s = req.getParameter("pageNo");
			if(s==null){
				pageNo = 1;
			}else{
				pageNo = Integer.parseInt(req.getParameter("pageNo"));
			}
			List<Customer> list = cs.getAll(pageNo);//查询每一页列表
			//查询总记录数
			int totalRecords = cs.queryTotalRecords();
			PageModel pm = new PageModel();
			//将数据存入pm中
			pm.setCuList(list);
			pm.setTotalRecords(totalRecords);
			pm.setPageNo(pageNo);
			req.setAttribute("pageModel", pm);
			//重定向到jsp页面
			req.getRequestDispatcher("/customerall").forward(req, resp);
		
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			this.doPost(req, resp);
		
	}


}
