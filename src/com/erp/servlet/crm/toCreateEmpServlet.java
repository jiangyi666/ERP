package com.erp.servlet.crm;

import com.erp.Utils.FindPrivilegeByHeadship;
import com.erp.pojo.crm.Dept;
import com.erp.pojo.crm.Employee;
import com.erp.service.crm.DeptServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 跳转到添加新职工界面
 * 携带有部门列表和现有职务列表
 */
@WebServlet(name = "toCreateEmpServlet",urlPatterns = "/toCreateEmp.do")
public class toCreateEmpServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        //先判断是否有权限更改！
        Employee currentEmployee = (Employee)request.getSession().getAttribute("employee");
        //需要拿到当前职工的权限编码
        int privilege = currentEmployee.getPrivilege();
        //这里只有总经理可以修改
        if (privilege== FindPrivilegeByHeadship.getPrivilege("总经理"))
        {
            //如果有权限修改
            //******将部门列表和现有职务列表返回给前端
            DeptServiceImpl deptService = new DeptServiceImpl();
            List<Dept> deptList = deptService.getAllDept();//或得部门列表
            request.setAttribute("deptList",deptList);//将部门列表返回给前端jsp
            request.setAttribute("privilegeMap", FindPrivilegeByHeadship.getMap());//将职务权限映射返回给前端
            request.getRequestDispatcher("/employee/addEmployee.jsp").forward(request,response);//跳转到添加新职工界面
        }else {
            //如果没有权限修改，就跳转回职工列表
            request.getRequestDispatcher("/getAllEmployee.do").forward(request,response);
        }

    }
}
