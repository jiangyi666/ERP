package com.erp.servlet.storeManage.PSD;

import com.erp.pojo.pmg.Product;
import com.erp.service.storeManage.ProductStorageDetailServiceImpl;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "getProductByPSDIdServlet",urlPatterns = "/getProductByPSDId.do")
public class getProductByPSDIdServlet extends HttpServlet{

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductStorageDetailServiceImpl productStorageDetailServiceImpl = new ProductStorageDetailServiceImpl();
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        String productStoId = request.getParameter("productStoId");
        Product product = productStorageDetailServiceImpl.getSingleProductDetailById(productStoId);
        
        String productId =product.getProductId();
        String productName=product.getProductName();
        String brand=product.getBrand();
        String type=product.getType();
        String level=product.getLevel();
        double gram=product.getGram();
		String productSpec=product.getProductSpec();
		String unit=product.getUnit();
		double productPrice=product.getProductPrice();
        out.print("{\"productId\":\""+productId+"\"," +
                "\"productName\":\""+productName+"\"," +
                "\"brand\":\""+brand+"\",\"type\":\""+type+"\",\"level\":\""+level+"\",\"gram\":\""+gram+"\","
                + "\"productSpec\":\""+productSpec+"\",\"unit\":\""+unit+"\",\"productPrice\":\""+productPrice+"\"}");
    }
}
