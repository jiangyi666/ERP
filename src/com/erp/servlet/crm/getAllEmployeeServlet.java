package com.erp.servlet.crm;

import com.erp.Utils.FindPrivilegeByHeadship;
import com.erp.pojo.crm.Dept;
import com.erp.pojo.crm.Employee;
import com.erp.pojo.crm.PageResult;
import com.erp.service.crm.DeptServiceImpl;
import com.erp.service.crm.EmployeeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "getAllEmployeeServlet",urlPatterns = "/getAllEmployee.do")
public class getAllEmployeeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DeptServiceImpl deptService = new DeptServiceImpl();
        List<Dept> deptList = deptService.getAllDept();//或得部门列表
        request.setAttribute("deptList",deptList);//将部门列表返回给前端jsp
        request.setAttribute("privilegeMap", FindPrivilegeByHeadship.getMap());//将职务权限映射返回给前端
        //*******************下面是包含分页操作的*************
        EmployeeServiceImpl service=new EmployeeServiceImpl();
        List<Employee> employeeList = service.getAllEmployee();
        PageResult pageResult = new PageResult();
        int pageSize = pageResult.getPageSize();//每页显示的记录数
        int pageNo;//当前页号
        if(request.getParameter("pageResult.pageNo")!=null){
            pageNo=Integer.parseInt(request.getParameter("pageResult.pageNo"));
        }
        else{
            pageNo=pageResult.getPageNo();//使用默认的页号
        }
        if(request.getParameter("pageResult.pageSize")!=null) {
            pageSize = Integer.parseInt(request.getParameter("pageResult.pageSize"));
        }
        int len = employeeList.size();
        len = len > (pageNo) * pageSize ? (pageNo) * pageSize : len;//显示当前页的记录数
        //将第pageNO页的数据从list中复制到list1数组中
        List<Employee> list1 = employeeList.subList((pageNo-1 ) * pageSize, len);
        //System.out.println(list1);
        //将要显示的当前页的数据，当前页数保存到pageresult中
        pageResult.setList(list1);
        pageResult.setPageNo(pageNo);
        pageResult.setRecTotal(employeeList.size());
        pageResult.setPageSize(pageSize);
        request.setAttribute("pageResult",pageResult);
        request.getRequestDispatcher("/employee/employeeList.jsp").forward(request,response);
    }
}
