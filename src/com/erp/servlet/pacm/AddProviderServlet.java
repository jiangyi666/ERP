package com.erp.servlet.pacm;

import com.erp.pojo.pacm.Providers;
import com.erp.service.pacm.ProviderService;
import com.erp.service.pacm.ProviderServiceImpl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="AddProviderServlet",urlPatterns="/addprovider")
public class AddProviderServlet extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
				//处理乱码 
				req.setCharacterEncoding("utf-8");
				resp.setCharacterEncoding("utf-8");
				resp.setContentType("text/html;charset=utf-8");
				//获得新建的客户信息信息
				String peeId = null;
				String peeName = req.getParameter("peename");
				String telephone = req.getParameter("telephone");
				String address = req.getParameter("address");
				//获取业务层对象
				ProviderService ps = new ProviderServiceImpl();
				//处理业务
				String finId = ps.queryfinalpee();
				if(finId != null){
					String strid=finId.substring(1,4);
					int iid = Integer.valueOf(strid);
					peeId = String.valueOf(iid+1);
					switch (peeId.length()) {			
						case 1:				
							peeId = "p00" + peeId; 				
							break;			
						case 2:				
							peeId = "p0" + peeId; 				
							break;			
						case 3:				
							peeId = "p" + peeId; 				
							break;					
							}
					
				}else{
					peeId = "p001";
				}
				Providers p = new Providers(peeId,peeName,telephone,address);
				ps.addProviders(p);
				//重定向到jsp页面
				req.getRequestDispatcher("/providerall").forward(req, resp);
	}

	

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}
}
