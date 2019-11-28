package com.erp.servlet.storeManage.MSD;

import com.erp.Utils.FindPrivilegeByHeadship;
import com.erp.pojo.crm.Employee;
import com.erp.pojo.pmg.Materiel;
import com.erp.service.pmg.MaterialServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 跳转到添加新原材料库存界面
 * 携带有原材料列表和现有职务列表
 */
@WebServlet(name = "toCreateMSDServlet",urlPatterns = "/toCreateMSD.do")
public class toCreateMSDServlet extends HttpServlet {
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
        //这里只有仓管经理可以修改
        if (privilege== FindPrivilegeByHeadship.getPrivilege("仓管经理"))
        {
            //如果有权限修改
            //******将原材料列表和现有职务列表返回给前端
            MaterialServiceImpl materialServiceImpl = new MaterialServiceImpl();
            List<Materiel> materiels= materialServiceImpl.getAllMaterial();//或得原材料列表
            request.setAttribute("materielList",materiels);//将原材料列表返回给前端jsp
            request.setAttribute("privilegeMap", FindPrivilegeByHeadship.getMap());//将职务权限映射返回给前端
            request.getRequestDispatcher("/materrielstoragedetail/addMaterrielStorageDetail.jsp").forward(request,response);//跳转到添加新职工界面
        }else {
            //如果没有权限修改，就跳转回原材料列表
            request.getRequestDispatcher("/getAllMaterrielStorageDetail.do").forward(request,response);
        }

    }
}
