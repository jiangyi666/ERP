package com.erp.servlet.crm;

import com.erp.Utils.FindPrivilegeByHeadship;
import com.erp.pojo.crm.Employee;
import com.erp.service.crm.EmployeeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "updateEmployeeByIdServlet",urlPatterns = "/updateEmployeeById.do")
public class updateEmployeeByIdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        PrintWriter out=response.getWriter();;
        //先判断是否有权限更改！
        Employee currentEmployee = (Employee)request.getSession().getAttribute("employee");
        //需要拿到当前职工的权限编码
        int privilege = currentEmployee.getPrivilege();
        //这里只有总经理可以修改
        if (privilege==FindPrivilegeByHeadship.getPrivilege("总经理"))
        {
            EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
            Employee employee = new Employee();
            //需要通过headship来获得特权编号,而后再保存在对象里面
            employee.setPrivilege(FindPrivilegeByHeadship.getPrivilege(request.getParameter("headship")));
            employee.setEmployeeId(request.getParameter("employeeId"));
            employee.setEmployeeName(request.getParameter("employeeName"));
            employee.setDeptName(request.getParameter("deptName"));
            employee.setHeadship(request.getParameter("headship"));
            employee.setSalary((Double.valueOf(request.getParameter("salary"))));
            employeeService.updateEmployeeById(employee);
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
