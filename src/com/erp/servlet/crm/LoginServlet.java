package com.erp.servlet.crm;

import com.erp.pojo.crm.Employee;
import com.erp.service.crm.LoginServiceImpl;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
@WebServlet(name = "loginServlet", urlPatterns = "/loginServlet.do")
public class LoginServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String employeeId =request.getParameter("employeeId");
        String password = request.getParameter("password");
        LoginServiceImpl loginService = new LoginServiceImpl();
        Employee employee = loginService.checkEmployee(employeeId, password);
        if(employee!=null)
        {
            //即登录成功！
            request.getSession().setAttribute("employeeName",employee.getEmployeeName());
            request.getRequestDispatcher("/main/home.jsp").forward(request, response);
        }else {
            //登录失败，就重新登录
            response.sendRedirect("login.jsp");
        }

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doPost(request,response);

    }
}
