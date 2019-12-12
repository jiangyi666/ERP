package com.erp.servlet.logistic;

import com.erp.dao.logistic.UserDao;
import com.erp.pojo.logistic.DeliveryBill;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class Search
 */
@WebServlet("/StatusServlet")
public class StatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static String id;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StatusServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		res.setContentType("text/html;charset=utf-8");
		req.setCharacterEncoding("utf-8");
		id=req.getParameter("id");
		UserDao userDao=new UserDao();
		List <DeliveryBill> l=userDao.search(id);
		req.setAttribute("alterSta", l);
		req.getRequestDispatcher("logistic/alterStatus.jsp").forward(req, res);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String sta=req.getParameter("status");
		UserDao userDao=new UserDao();
		if(sta.equals("1")){
			userDao.undone(id);
	
		}else if(sta.equals("2")){
			userDao.doing(id);
			
			
		}else if(sta.equals("3")){
			userDao.done(id);
			
			
		}
	}

}
