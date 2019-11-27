package com.erp.servlet.pacm;

import com.erp.pojo.pacm.Providers;
import com.erp.service.pacm.ProviderService;
import com.erp.service.pacm.ProviderServiceImpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="UpdProviderServlet", urlPatterns="/updprovider")
public class UpdProviderServlet extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//处理乱码 
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		//获得customerid以及修改的信息
		String peeId = req.getParameter("peeid");
		String peeName = req.getParameter("peename");
		String telephone = req.getParameter("telephone");
		String address = req.getParameter("address");
		//获取业务层对象
		ProviderService ps = new ProviderServiceImpl();
		//处理业务
		Providers p = new Providers(peeId,peeName,telephone,address);
		ps.updProviders(p);
		//重定向到jsp页面
		req.getRequestDispatcher("/providerall").forward(req, resp);
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			this.doPost(req, resp);
	}
}
