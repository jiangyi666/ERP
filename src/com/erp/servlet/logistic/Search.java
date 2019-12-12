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
@WebServlet("/Search")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Search() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		res.setContentType("text/html;charset=utf-8");
		req.setCharacterEncoding("utf-8");
		String id=req.getParameter("id");
		UserDao userDao=new UserDao();
			List <DeliveryBill> l=userDao.search(id);
			if(l.size()>=1){
			req.setAttribute("delivery", l);
			req.getRequestDispatcher("logistic/search.jsp").forward(req, res);
		}else{
			req.setCharacterEncoding("utf-8");
	    	PrintWriter out=res.getWriter();
	    	out.print("false");
	    	out.flush();
	    	out.close();   	
		}
		
	}
	

}
