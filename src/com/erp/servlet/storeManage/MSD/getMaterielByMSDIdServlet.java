package com.erp.servlet.storeManage.MSD;

import com.erp.pojo.pmg.Materiel;
import com.erp.service.storeManage.MaterrielStorageDetailServiceImpl;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "getMaterielByMSDIdServlet",urlPatterns = "/getMaterielByMSDId.do")
public class getMaterielByMSDIdServlet extends HttpServlet{

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MaterrielStorageDetailServiceImpl materrielStorageDetailServiceImpl = new MaterrielStorageDetailServiceImpl();
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        String matStoreDetId = request.getParameter("matStoreDetId");
        Materiel materiel = materrielStorageDetailServiceImpl.getSingleMaterialDetailById(matStoreDetId);
        
        String matId=materiel.getMatId();
        String matName=materiel.getMatName();
        String brand=materiel.getBrand();
        String type=materiel.getType();
        String level=materiel.getLevel();
        double gram=materiel.getGram();
        String matSpec=materiel.getMatSpec();
        String unit=materiel.getUnit();
        double matPrice=materiel.getMatPrice();
        out.print("{\"matId\":\""+matId+"\"," +
                "\"matName\":\""+matName+"\"," +
                "\"brand\":\""+brand+"\",\"type\":\""+type+"\",\"level\":\""+level+"\",\"gram\":\""+gram+"\","
                + "\"matSpec\":\""+matSpec+"\",\"unit\":\""+unit+"\",\"matPrice\":\""+matPrice+"\"}");
    }
}
