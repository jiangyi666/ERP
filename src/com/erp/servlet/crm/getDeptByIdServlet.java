package com.erp.servlet.crm;

import com.erp.pojo.crm.Dept;
import com.erp.pojo.crm.Employee;
import com.erp.service.crm.DeptServiceImpl;
import com.erp.service.crm.EmployeeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "getDeptByIdServlet",urlPatterns = "/getDeptById.do")
public class getDeptByIdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DeptServiceImpl deptService = new DeptServiceImpl();
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        String id = request.getParameter("deptId");
        Dept deptById = deptService.getDeptById(id);
        String deptId = deptById.getDeptId();
        String deptname = deptById.getDeptname();
        out.print("{\"deptId\":\""+deptId+"\"," +
                "\"deptName\":\""+deptname+"\"}");
    }
}
