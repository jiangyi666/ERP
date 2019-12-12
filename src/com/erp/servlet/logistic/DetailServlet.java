package com.erp.servlet.logistic;

import com.erp.dao.logistic.UserDao;
import com.erp.pojo.logistic.DetailBill;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/DetailServlet")
public class DetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static String id;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailServlet() {
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
		res.setCharacterEncoding("utf-8");

		this.id=req.getParameter("id");
		int pageNow=1;
		UserDao user=new UserDao();
		List<DetailBill> l=user.getDetailList(id,pageNow);
		req.setAttribute("DetailBill", l);
		req.setAttribute("now", pageNow);
		req.getRequestDispatcher("logistic/detailTable.jsp").forward(req, res);
		
		
	
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		res.setContentType("text/html;charset=utf-8");
		req.setCharacterEncoding("utf-8");

		res.setCharacterEncoding("utf-8");
		int pageNow=1;
		String sPageNow=req.getParameter("pageNow");
		UserDao user=new UserDao();
		List<DetailBill> li=user.getDetailList(id,pageNow);
		DetailBill d=(DetailBill)li.get(0);
		
		if(sPageNow!=""&&sPageNow!=null){
			pageNow=Integer.parseInt(sPageNow);
		}
		if(pageNow>=1&&pageNow<=d.getPageCount()){	
			List<DetailBill> l=user.getDetailList(id,pageNow);
			req.setAttribute("DetailBill", l);
			req.setAttribute("now", pageNow);
			req.getRequestDispatcher("logistic/detailTable.jsp").forward(req, res);
	    }else{
	    	req.setCharacterEncoding("utf-8");
	    	PrintWriter out=res.getWriter();
	    	out.print("false");
	    	out.flush();
	    	out.close();
		}
	
		
	}

}
