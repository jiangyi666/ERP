package com.erp.servlet.crm;

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

@WebServlet(name = "getAllDeptServlet",urlPatterns = "/getAllDept.do")
public class getAllDeptServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DeptServiceImpl service=new DeptServiceImpl();
        List<Dept> deptList = service.getAllDept();
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
        int len = deptList.size();
        len = len > (pageNo) * pageSize ? (pageNo) * pageSize : len;//显示当前页的记录数
        //将第pageNO页的数据从list中复制到list1数组中
        List<Dept> list1 = deptList.subList((pageNo-1 ) * pageSize, len);
        //System.out.println(list1);
        //将要显示的当前页的数据，当前页数保存到pageresult中
        pageResult.setList(list1);
        pageResult.setPageNo(pageNo);
        pageResult.setRecTotal(deptList.size());
        pageResult.setPageSize(pageSize);
        request.setAttribute("pageResult",pageResult);
        request.getRequestDispatcher("/employee/deptList.jsp").forward(request,response);
    }
}
