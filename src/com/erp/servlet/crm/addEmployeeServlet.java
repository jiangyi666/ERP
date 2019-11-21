package com.erp.servlet.crm;

import com.erp.Utils.FindPrivilegeByHeadship;
import com.erp.pojo.crm.Employee;
import com.erp.service.crm.DeptService;
import com.erp.service.crm.DeptServiceImpl;
import com.erp.service.crm.EmployeeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 用来添加新的职工
 */
@WebServlet(name = "addEmployeeServlet",urlPatterns = "/addEmployee.do")
public class addEmployeeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
        DeptServiceImpl deptService = new DeptServiceImpl();
        PrintWriter out=response.getWriter();
        if (!employeeService.checkEmpIdIsExist(request.getParameter("employeeId"))){
            //如果不存在，添加
            Employee employee = new Employee();
            employee.setEmployeeId(request.getParameter("employeeId"));
            employee.setEmployeeName(request.getParameter("employeeName"));
            employee.setPassword(request.getParameter("password"));
            employee.setDeptId(deptService.getDeptIdByDeptName(request.getParameter("deptName")));
            employee.setHeadship(request.getParameter("headship"));
            employee.setSalary(Double.valueOf(request.getParameter("salary")));
            employee.setPrivilege(FindPrivilegeByHeadship.getPrivilege(request.getParameter("headship")));
            employeeService.addEmployee(employee);
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
