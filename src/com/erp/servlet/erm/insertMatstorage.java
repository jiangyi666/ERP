package com.erp.servlet.erm;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.erp.pojo.erm.Materrielstorage;
import com.erp.service.erm.MaterStorageImpl;


/**
 * Servlet implementation class insertMatstorage
 */
@WebServlet("/insertMatstorage")
public class insertMatstorage extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public insertMatstorage() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Content-type", "text/html;charset=UTF-8");	
		MaterStorageImpl service=new MaterStorageImpl();
		
		String date=request.getParameter("date");
		String purchaseId=request.getParameter("purchaseId");
		String employeeId=request.getParameter("employeeId");
		String location=request.getParameter("location");
		
		date=date+" 00:00:00";
		System.out.println(date);		
	
		Timestamp date1=Timestamp.valueOf(date);
		String inspectionStatus="通过";
		
		
		Materrielstorage mat=new Materrielstorage();
		
		mat.setDate(date1);	
		mat.setEmployeeId(employeeId);
		mat.setLocation(location);
		mat.setInspectionStatus(inspectionStatus);
		
		boolean flag=service.insertmat(mat,purchaseId);
		
		PrintWriter out=response.getWriter();
			
		
		if(flag) {
			service.CheckPurchase(purchaseId);
			out.print(true);
		}else {
			out.print(false);
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
