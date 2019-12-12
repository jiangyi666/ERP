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





@WebServlet("/DeliveryServlet")
public class DeliveryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeliveryServlet() {
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

		
		int pageNow=1;

		UserDao user=new UserDao();
		List<DeliveryBill> l=user.getDeliveryList(pageNow);
		req.setAttribute("DeliveryBill", l);
		req.setAttribute("now", pageNow);
		req.getRequestDispatcher("logistic/deliveryTable.jsp").forward(req, res);
	  
		
		
	
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
		List<DeliveryBill> li=user.getDeliveryList(pageNow);
		DeliveryBill db=(DeliveryBill)li.get(0);
		
		if(sPageNow!=""&&sPageNow!=null){
			pageNow=Integer.parseInt(sPageNow);
		}
		if(pageNow>=1&&pageNow<=db.getPageCount()){
			
			List<DeliveryBill> l=user.getDeliveryList(pageNow);
			req.setAttribute("DeliveryBill", l);
			req.setAttribute("now", pageNow);
			req.getRequestDispatcher("logistic/deliveryTable.jsp").forward(req, res);
	    }else{
	    	res.sendRedirect("/DeliveryServlet");
		}
		
	}

}
