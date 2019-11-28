package com.erp.servlet.storeManage.MSD;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.erp.dao.pmg.GoodsLocationDaoImpl;
import com.erp.pojo.crm.PageResult;
import com.erp.pojo.pmg.GoodsLocation;
import com.erp.pojo.pmg.Materiel;
import com.erp.pojo.storeManage.MaterrielStorageDetail;
import com.erp.service.pmg.MaterialServiceImpl;
import com.erp.service.storeManage.MaterrielStorageDetailServiceImpl;


@WebServlet(name = "getMSDByLocMatIdServlet",urlPatterns = "/getMSDByLocMatId.do")
public class getMSDByLocMatIdServlet extends HttpServlet{

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MaterrielStorageDetailServiceImpl service=new MaterrielStorageDetailServiceImpl();
        GoodsLocationDaoImpl goodsLocationDaoImpl=new GoodsLocationDaoImpl();
        MaterialServiceImpl materialServiceImpl=new MaterialServiceImpl();
        String location = request.getParameter("location");
        String matId = request.getParameter("matId");
        List<MaterrielStorageDetail> materrielStorageDetails = service.getMSDByLocMatId(location, matId);
        List<GoodsLocation> goodsLocations = goodsLocationDaoImpl.getAllGoodsLocation();//获得仓库列表
        List<Materiel> materiels = materialServiceImpl.getAllMaterial();//获得原材料列表
        request.setAttribute("goodsLocations",goodsLocations);//将仓库列表返回给前端jsp
        request.setAttribute("materiels",materiels);//将原材料列表返回给前端jsp
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
        int len = materrielStorageDetails.size();
        len = len > (pageNo) * pageSize ? (pageNo) * pageSize : len;//显示当前页的记录数
        //将第pageNO页的数据从list中复制到list1数组中
        List<MaterrielStorageDetail> list1 = materrielStorageDetails.subList((pageNo-1 ) * pageSize, len);
        //将要显示的当前页的数据，当前页数保存到pageresult中
        pageResult.setList(list1);
        pageResult.setPageNo(pageNo);
        pageResult.setRecTotal(materrielStorageDetails.size());
        pageResult.setPageSize(pageSize);
        request.setAttribute("pageResult",pageResult);
        request.getRequestDispatcher("/materrielstoragedetail/materrielStorageDetailList.jsp").forward(request,response);
    }
}
