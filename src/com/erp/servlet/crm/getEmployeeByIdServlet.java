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
import java.util.List;

@WebServlet(name = "getEmployeeByIdServlet",urlPatterns = "/getEmployeeById.do")
public class getEmployeeByIdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        String id = request.getParameter("employeeId");
        Employee employeeById = employeeService.getEmployeeById(id);
        String employeeId = employeeById.getEmployeeId();
        String employeeName = employeeById.getEmployeeName();
        String deptName = employeeById.getDeptName();
        String headship = employeeById.getHeadship();
        double salary = employeeById.getSalary();
        String deptId = employeeById.getDeptId();
        out.print("{\"employeeId\":\""+employeeId+"\"," +
                "\"employeeName\":\""+employeeName+"\"," +
                "\"deptName\":\""+deptName+"\",\"headship\":\""+headship+"\",\"salary\":\""+salary+"\",\"deptId\":\""+deptId+"\"}");

    }
}
