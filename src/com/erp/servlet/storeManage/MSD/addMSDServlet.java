package com.erp.servlet.storeManage.MSD;



import com.erp.pojo.storeManage.MaterrielStorageDetail;
import com.erp.service.storeManage.MaterrielStorageDetailServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

/**
 * 用来添加新的原材料库存
 */
@WebServlet(name = "addMSDServlet",urlPatterns = "/addMSD.do")
public class addMSDServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        MaterrielStorageDetailServiceImpl materrielStorageDetailServiceImpl = new MaterrielStorageDetailServiceImpl();
        PrintWriter out=response.getWriter();
        if (!materrielStorageDetailServiceImpl.checkMatStoreDetIdIsExist(request.getParameter("matStoreDetId"))){
            //如果不存在，添加
        	MaterrielStorageDetail materrielStorageDetail = new MaterrielStorageDetail(request.getParameter("matStoreDetId"),
        			request.getParameter("matId"),
        			Double.valueOf(request.getParameter("amount")),
        			Timestamp.valueOf(request.getParameter("date")),
        			Double.valueOf(request.getParameter("min"))
        			);
            materrielStorageDetailServiceImpl.addMaterrielStorageDetail(materrielStorageDetail);
            out.print("ok");
        }else {
            //如果存在就提示前端该库存编号已经存在！请重新输入一个
            out.print("false");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
