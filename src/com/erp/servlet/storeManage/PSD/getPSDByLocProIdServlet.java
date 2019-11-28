package com.erp.servlet.storeManage.PSD;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.erp.dao.pmg.GoodsLocationDaoImpl;
import com.erp.dao.pmg.ProductDaoImpl;
import com.erp.pojo.crm.PageResult;
import com.erp.pojo.pmg.GoodsLocation;
import com.erp.pojo.pmg.Product;
import com.erp.pojo.storeManage.ProductStorageDetail;
import com.erp.service.storeManage.ProductStorageDetailServiceImpl;


@WebServlet(name = "getPSDByLocProIdServlet",urlPatterns = "/getPSDByLocProId.do")
public class getPSDByLocProIdServlet extends HttpServlet{

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	ProductStorageDetailServiceImpl productStorageDetailServiceImpl=new ProductStorageDetailServiceImpl();
        GoodsLocationDaoImpl goodsLocationDaoImpl=new GoodsLocationDaoImpl();
        ProductDaoImpl productDaoImpl=new ProductDaoImpl();
        String location = request.getParameter("location");
        String productId = request.getParameter("productId");
        List<ProductStorageDetail> productStorageDetails = productStorageDetailServiceImpl.getPSDByLocProId(location, productId);
        List<GoodsLocation> goodsLocations = goodsLocationDaoImpl.getAllGoodsLocation();//获得仓库列表
        List<Product> products = productDaoImpl.getAllProduct();//获得产品列表
        request.setAttribute("goodsLocations",goodsLocations);//将仓库列表返回给前端jsp
        request.setAttribute("products",products);//将产品列表返回给前端jsp
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
        int len = productStorageDetails.size();
        len = len > (pageNo) * pageSize ? (pageNo) * pageSize : len;//显示当前页的记录数
        //将第pageNO页的数据从list中复制到list1数组中
        List<ProductStorageDetail> list1 = productStorageDetails.subList((pageNo-1 ) * pageSize, len);
        //将要显示的当前页的数据，当前页数保存到pageresult中
        pageResult.setList(list1);
        pageResult.setPageNo(pageNo);
        pageResult.setRecTotal(productStorageDetails.size());
        pageResult.setPageSize(pageSize);
        request.setAttribute("pageResult",pageResult);
        request.getRequestDispatcher("/productstoragedetail/productStorageDetailList.jsp").forward(request,response);
    }
}
