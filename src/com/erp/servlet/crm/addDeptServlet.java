package com.erp.servlet.crm;

import com.erp.Utils.FindPrivilegeByHeadship;
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

@WebServlet(name = "addDeptServlet",urlPatterns = "/addDept.do")
public class addDeptServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        DeptServiceImpl deptService = new DeptServiceImpl();
        PrintWriter out=response.getWriter();
        if (!deptService.checkDeptIdIsExist(request.getParameter("deptId"))){
            //如果不存在，添加
            Dept dept = new Dept();
            dept.setDeptname(request.getParameter("deptName"));
            dept.setDeptId(request.getParameter("deptId"));
            deptService.addDept(dept);
            out.print("ok");
        }else {
            //如果存在就提示前端该员工号已经存在！请重新输入一个
            out.print("false");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
