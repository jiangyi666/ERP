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


@WebServlet(name="ProviderOneServlet" ,urlPatterns="/providerone")
public class ProviderOneSerlvet extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
				HttpSession session = req.getSession();
				//处理乱码 
				req.setCharacterEncoding("utf-8");
				resp.setCharacterEncoding("utf-8");
				resp.setContentType("text/html;charset=utf-8");
				//获取模糊查询部分搜索词
				
				String peeName = req.getParameter("peename");
				if(peeName != null)
					session.setAttribute("name2", peeName);
				
				if(peeName == null){
				
					peeName = (String) session.getAttribute("name2");
				}
			
				System.out.println(peeName);
				//获取业务层对象
				ProviderService ps = new ProviderServiceImpl();
				//处理业务
				int pageNo ;
				String s = req.getParameter("pageNo");
				if(s==null){
					pageNo = 1;
				}else{
					pageNo = Integer.parseInt(req.getParameter("pageNo"));
				}
				List<Providers> list = ps.getProviders(peeName,pageNo);//查询每一页列表
				//查询总记录数
				int tr = ps.queryTotalRecords();
				int totalRecords = ps.querySomeoneRecords(peeName);
				PageModel pm = new PageModel();
				//将数据存入pm中
				pm.setProList(list);
				pm.setTotalRecords(totalRecords);
				pm.setPageNo(pageNo);
				req.setAttribute("pageModel", pm);
				session.setAttribute("tr", tr);
				//重定向到jsp页面
				req.getRequestDispatcher("/pacm/allproviders.jsp").forward(req, resp);
	}
	

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}

}
