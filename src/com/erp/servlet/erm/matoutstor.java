package com.erp.servlet.erm;

import com.erp.service.erm.MaterStorageImpl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class matoutstor
 */
@WebServlet("/matoutstor")
public class matoutstor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public matoutstor() {
        super();
        
    }

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		String outqty=request.getParameter("outqty");
		String amount=request.getParameter("amount");		
		String matId=request.getParameter("matId");		
		int qty=0;
		try {
			int amount1=Integer.parseInt(amount);
			int outqty1=Integer.parseInt(outqty);
			qty=amount1-outqty1;
		} catch (NumberFormatException e) {
		    e.printStackTrace();
		}
		System.out.println(qty);
		MaterStorageImpl service = new MaterStorageImpl();
		int count = service.updateamount(matId,qty);
		System.out.println(count);
		
		PrintWriter out=response.getWriter();
		out.print(true);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
