package com.erp.servlet.pmg;

import com.erp.pojo.pmg.Product;
import com.erp.service.pmg.ProductServiceImpl;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class productServlet
 */
@WebServlet("/productServlet")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	public ProductServiceImpl PSI = new ProductServiceImpl();
 
    public ProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");  response.setContentType("text/html;charset=utf-8");
		
			PrintWriter out = response.getWriter();
			JSONArray jsonArray = new JSONArray();
			JSONObject jsonObj;
			String oper = request.getParameter("oper");
			
			if(oper.equals("addProduct")) {
				
				//反序列化
				String Product_str = request.getParameter("product");
				JSONObject jsonObject = JSONObject.fromObject(Product_str);
				Product product = (Product) JSONObject.toBean(jsonObject,Product.class);
				//添加
				PSI.addProduct(product);
			}
			if(oper.equals("deleteProduct")) {
				String productId = 	request.getParameter("productId");
				PSI.deleteProduct(productId);
			}
			if(oper.equals("updateProduct")) {
				
				String Product_str = request.getParameter("product");
				JSONObject jsonObject = JSONObject.fromObject(Product_str);
				Product product = (Product) JSONObject.toBean(jsonObject,Product.class);
				
				PSI.updateProduct(product);
			}
			if(oper.equals("getAllProduct")) {
				
				List<Product> productlList = new ArrayList<Product>();
				productlList = PSI.getAllProduct();
				Product product = null;
				jsonArray.add(PSI.thead);
				if(!(productlList == null))
					for(int i=0;i<productlList.size();i++) {
						
						product = productlList.get(i);
						jsonObj = new JSONObject().fromObject(product);
						jsonArray.add(jsonObj);
				
					}
					out.print(jsonArray.toString());
					out.flush();
					out.close();
			}
			if(oper.equals("getProductById")) {
				String productId = request.getParameter("productId");
				PSI.deleteProduct(productId);
			}
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
