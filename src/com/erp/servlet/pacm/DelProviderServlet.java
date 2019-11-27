package com.erp.servlet.pacm;

import com.erp.Utils.PageModel;
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
import javax.servlet.http.HttpSession;

@WebServlet(name="DelProviderServlet", urlPatterns="/delprovider")
public class DelProviderServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			HttpSession session = req.getSession();
			String peeId = req.getParameter("peeid");
			//获取业务层对象
			ProviderService ps = new ProviderServiceImpl();
			ps.delproviders(peeId);
			int pageNo ;
			String s = req.getParameter("pageNo");
			if(s==null){
				pageNo = 1;
			}else{
				pageNo = Integer.parseInt(req.getParameter("pageNo"));
			}
			List<Providers> list = ps.getAll(pageNo);//查询每一页列表
			//查询总记录数
			int totalRecords = ps.queryTotalRecords();
			PageModel pm = new PageModel();
			//将数据存入pm中
			pm.setProList(list);
			pm.setTotalRecords(totalRecords);
			pm.setPageNo(pageNo);
			req.setAttribute("pageModel", pm);
			//重定向到jsp页面
			req.getRequestDispatcher("/providerall").forward(req, resp);
		
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			this.doPost(req, resp);
		
	}
}
