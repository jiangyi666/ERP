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

@WebServlet(name = "updateDeptServlet",urlPatterns = "/updateDept.do")
public class updateDeptServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        PrintWriter out=response.getWriter();
        //先判断是否有权限更改！
        Employee currentEmployee = (Employee)request.getSession().getAttribute("employee");
        //需要拿到当前职工的权限编码
        int privilege = currentEmployee.getPrivilege();
        //这里只有总经理可以修改
        if (privilege== FindPrivilegeByHeadship.getPrivilege("总经理"))
        {
            DeptServiceImpl deptService = new DeptServiceImpl();
            Dept dept = new Dept();
            dept.setDeptId(request.getParameter("deptId"));
            dept.setDeptname(request.getParameter("deptName"));
            deptService.updateDept(dept);
            out.print("ok");
        }else{
            //没有权限更改，就返回false
            out.print("false");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);

    }
}
