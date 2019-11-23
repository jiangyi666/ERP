package com.erp.servlet.crm;

import com.erp.Utils.FindPrivilegeByHeadship;
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

@WebServlet(name = "deleteDeptByIdServlet",urlPatterns = "/deleteDeptById.do")
public class deleteDeptByIdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        //先判断是否有权限更改！
        Employee currentEmployee = (Employee)request.getSession().getAttribute("employee");
        //需要拿到当前职工的权限编码
        int privilege = currentEmployee.getPrivilege();
        //这里只有总经理可以修改
        if (privilege== FindPrivilegeByHeadship.getPrivilege("总经理"))
        {
            DeptServiceImpl deptService = new DeptServiceImpl();
            String deptId = request.getParameter("deptId");
            deptService.deleteDept(deptId);
            out.print("ok");
        }
        else {
            //如果没有权限删除就返回false
            out.print("false");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);
    }
}
