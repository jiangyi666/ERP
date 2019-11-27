package com.erp.servlet.pacm;

import com.erp.Utils.PageModel;
import com.erp.pojo.crm.Employee;
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


@WebServlet(name="CustomerAllServlet" ,urlPatterns="/customerall")
public class CustomerAllServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		HttpSession session = req.getSession();
		Employee e = (Employee)session.getAttribute("employee");
		//System.out.println(e.getPrivilege());
		if(e.getPrivilege()!=1&&e.getPrivilege()!=3&&e.getPrivilege()!=4&&e.getPrivilege()!=6){
			req.getRequestDispatcher("/pacm/nopower.jsp").forward(req, resp);
			
		}else{
		//处理请求信息
		//获取业务层对象
		CustomerService cs = new CustomerServiceImpl();
		//处理业务
		int pageNo ;
		String s = req.getParameter("pageNo");
		if(s==null){
			pageNo = 1;
		}else{
			pageNo = Integer.parseInt(req.getParameter("pageNo"));
		}
		List<Customer> list = cs.getAll(pageNo);//查询每一页列表
		//查询总记录数
		int tr = cs.queryTotalRecords();
		int totalRecords = cs.queryTotalRecords();
		PageModel pm = new PageModel();
		//将数据存入pm中
		pm.setCuList(list);
		pm.setTotalRecords(totalRecords);
		pm.setPageNo(pageNo);
		req.setAttribute("pageModel", pm);
		//System.out.println(tr);
		session.setAttribute("tr", tr);
		//重定向到jsp页面
		req.getRequestDispatcher("/pacm/allcustomer.jsp").forward(req, resp);
		}
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}
}
