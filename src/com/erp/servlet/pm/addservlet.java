package com.erp.servlet.pm;

import com.erp.pojo.pm.purchasedetail;
import com.erp.pojo.pm.purchaseorder;
import com.erp.service.pm.purchasedetailservice;
import com.erp.service.pm.purchaseorderservice;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class addservlet
 */
@WebServlet("/addservlet.do")
public class addservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addservlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		// 请求解决乱码
		request.setCharacterEncoding("utf-8");
		// 接收请求参数
		String value = (String)request.getParameter("purchaseInsert");
		String purchaseId =request.getParameter("purchaseId");
		List<Map<String, Object>> list = purchasedetailservice.getpurchaseorderdetail(purchaseId);
		System.out.println(purchaseId);
		//System.out.println(purchaseId.equals(null));
		//恶性BUG：如果取到的purchaseId为null，值却为4，并且String.equal(null)为false
		if(purchaseId.equals(null)|| purchaseId.length() == 4)
		{
			System.out.println(purchaseId);
			System.out.println(purchaseId.length());
			request.setAttribute("purchaseId", purchaseId);
			request.getRequestDispatcher("/pm/addpurchaseorder.jsp").forward(request, response);
		}
		if(value.equals("1"))
		{
			purchaseorder pro=new purchaseorder();
			String employeeId =request.getParameter("employeeId");
			String peeId =request.getParameter("peeId");
			String purchaseDate =request.getParameter("purchaseDate");
			System.out.println(purchaseDate);
			pro.setPurchaseId(purchaseId);
			pro.setEmployeId(employeeId);
			pro.setPeeId(peeId);
			pro.setIfStorage("否");
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			//String format = "yyyy-MM-dd'T'HH:mm";
			Date time = null;
			/*try {
				time = new SimpleDateFormat(format).parse(purchaseDate);
			} catch (ParseException e) {
				e.printStackTrace();
			}*/
			try {
				time= df.parse(purchaseDate);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			pro.setPurchaseDate(time);
			int affectLine = 0;
			affectLine= purchaseorderservice.save(pro);
			request.setAttribute("purchaseId", purchaseId);
			System.out.println("影响行数:" + affectLine);
			request.getRequestDispatcher("/pm/addpurchaseorder.jsp").forward(request, response);
		}
		if(value.equals("2"))
		{
			purchasedetail pur=new purchasedetail();
			pur.setPurchaseId(purchaseId);
			String matId=request.getParameter("matId");
			double qty=Double.parseDouble(request.getParameter("qty"));
			double price=Double.parseDouble(request.getParameter("price"));
			double transpCosts=Double.parseDouble(request.getParameter("transpCosts"));
			pur.setMatId(matId);
			pur.setQty(qty);
			pur.setPrice(price);
			pur.setTranspCosts(transpCosts);
			purchasedetailservice.save(pur);
			purchaseorderservice.update(purchaseId, qty*price+transpCosts);
			request.setAttribute("purchaseId", purchaseId);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("purchaseId", purchaseId);
			map.put("matId", matId);
			map.put("qty", qty);
			map.put("price", price);
			map.put("transpCosts", transpCosts);
			list.add(map);
			request.setAttribute("list", list);
			request.getRequestDispatcher("/pm/addpurchaseorder1.jsp").forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
