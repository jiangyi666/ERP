<%@ taglib prefix="for" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.erp.pojo.crm.PageResult" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="com.erp.pojo.pmg.GoodsLocation" %>
<%@ page import="com.erp.pojo.pmg.Product" %>
<%@ page import="com.erp.pojo.storeManage.ProductStorageDetail" %><%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/11/18
  Time: 21:39

  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%
    PageResult pageResult = (PageResult) request.getAttribute("pageResult");
    List<GoodsLocation> GoodsLocationList = (List<GoodsLocation>) request.getAttribute("goodsLocations");
    session.setAttribute("GoodsLocationList", GoodsLocationList);
    
        List<Product> productList = (List<Product>) request.getAttribute("products");
    session.setAttribute("productList", productList);
    //拿到权限职务列表
    Map privilegeMap = (Map) request.getAttribute("privilegeMap");
    session.setAttribute("map", privilegeMap);//把权限职务列表放进session中方便下面遍历
%>
<%--使用formdata来上传文件一定要注明该注释为html5--%>
<!DOCTYPE HTML>
<html>
<head>
    <title>产品库存管理</title>
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script>
        <%@ include file="pagination.js" %>
    </script>
    <script type="text/javascript"> 
        function searchPSD(){
	        var location=$("#loction")[0].value;
	        var productId=$("#productId")[0].value;
	        console.log(loction);
	        console.log(productId);
	        
	        var urlType;
	        if(!location&&!productId){//获取全部
	        	urlType="<%=basePath%>getAllProductStorageDetail.do";
	        	$("#data")[0].action=urlType;
	        	$("#data")[0].submit();
	        }
	        if(location&&!productId){//根据仓库查
	        	console.log(111);
	        	urlType="<%=basePath%>getPSDByGoodLoc.do?location="+location;
	        	console.log();
	        	$("#data")[0].action=urlType;
	        	$("#data")[0].submit();
	        	console.log(urlType);
	        	
	        }
	        if(!location&&productId){//根据产品查
	        	urlType="<%=basePath%>getPSDByProductId.do?productId="+productId;
	        	$("#data")[0].action=urlType;
	        	$("#data")[0].submit();
	        }
	        if(location&&productId){
	        	urlType="<%=basePath%>getPSDByLocProId.do?location="+location+"&&productId="+productId;
	        	$("#data")[0].action=urlType;
	        	$("#data")[0].submit();
	        } 
	      }  
	        function getMateriel(productStoId) {
            $.ajax({
                type: "get",
                url: "<%=basePath%>getProductByPSDId.do",
                data: {"productStoId": productStoId},
                dataType: "json",
                success: function (data) {
                    $("#proId").val(data.productId);
                    $("#productName").val(data.productName);
                    $("#brand").val(data.brand);
                    $("#type").val(data.type);
                    $("#level").val(data.level);
                    $("#gram").val(data.gram);
                    $("#productSpec").val(data.productSpec);
                    $("#unit").val(data.unit);
                    $("#productPrice").val(data.productPrice);
                }
            });
           
        }
  
    </script>
    <style type="text/css">
#nav {

    height: 50px;

    margin-top: 30px;
	text-align:center;
}

 

#nav ul {

     display: inline-block;
                margin: 10px 30px;
                padding: 0px;
                height:30px;
	list-style: none;
  

}

 

#nav li {

    display: block;

    float: left;

}
    </style>
    
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
        
        
        <div id="nav">
             <ul>
	        <li>
	        	<div class="form-group">
                        <label for="loction" class="col-sm-2 control-label">仓库</label>
                        <div class="col-sm-10">
                            <select class="form-control" id="loction" name="loction">
                                <option value="">--请选择--</option>
                                <c:forEach items="${GoodsLocationList}" var="loc">
                                    <option value="${loc.location}">${loc.location}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
	        </li>
	       
	        <li id="goods" style="display: list-item;">
		        <div class="form-group">
                        <label for="productId" class="col-sm-2 control-label">产品</label>
                        <div class="col-sm-10">
                            <select class="form-control" id="productId" name="productId">
                                <option value="">--请选择--</option>
                                <c:forEach items="${productList}" var="product">
                                    <option value="${product.productId}">${product.productId}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
	        </li>
        	
        	<button type="button" class="btn btn-success" onclick="searchPSD()">
                                查询
            </button>


        </ul>
       </div> 
        
        
            <h3 class="text-center text-info">
              	 产品库存列表
            </h3>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-2 column">
        </div>
        <div class="col-md-8 column">
            <form id="data" action="<%=basePath%>getAllProductStorageDetail.do" method="post">
                <table class="table table-hover table-bordered">
                    <thead>
                    <tr>
                        <th>库存编号</th>
                        <th>产品编号</th>
                        <th>剩余数量</th>
                        <th>录入时间</th>
                        <th>最低库存量</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <%
                        List<ProductStorageDetail> list = pageResult.getList();
                        ProductStorageDetail productStorageDetail = null;
                        for (int i = 0; i < list.size(); i++) {
                            productStorageDetail = list.get(i);
                    %>
                    <tr>
                    	<td>
                            <%=productStorageDetail.getProductStoId()%>
                        </td>
                        <td>
                            <%=productStorageDetail.getProductId()%>
                        </td>
                        <td>
                            <%=productStorageDetail.getAmount()%>
                        </td>
                        <td>
                            <%=productStorageDetail.getDate()%>
                        </td>
                        <td>
                            <%=productStorageDetail.getMin()%>
                        </td>
                        <%--可以具体操作，查看产品详情--%>
                        <td>
                        <button type="button"
                                    data-toggle="modal"
                                    data-target="#modifyTitleModal"
                                    class="btn  btn-success" onclick="getMateriel('<%=productStorageDetail.getProductStoId()%>')">
                              	 查看详情
                            </button>
                        </td>
                    </tr>
                    <%
                        }
                    %>
                    </tbody>
                </table>
                <%--分页显示--%>
                <div style="text-align: right;padding: 6px 6px 0 0;">
                    共<input type="text" value="<%=pageResult.getRecTotal()%>" readonly="true" size="3"/> 条记录
                    &nbsp;
                    每页显示<input name="pageResult.pageSize" value="<%=pageResult.getPageSize()%>" size="3">条
                    &nbsp;
                    第<input name="pageResult.pageNo" value="<%=pageResult.getPageNo()%>" size="3">页
                    &nbsp;
                    共<input name="page_total" readonly="true" value="<%=pageResult.getPageTotal()%>" size="3">页
                    &nbsp;
                    <a href="javascript:page_first()">第一页</a>&nbsp;
                    <a href="javascript:page_pre()">上一页</a>&nbsp;
                    <a href="javascript:page_next()">下一页</a>&nbsp;
                    <a href="javascript:page_last()">最后一页</a>&nbsp;
                    <input type="button" onclick="javascript:page_go()" value="转到"/>
                </div>
            </form>
        </div>
        <div class="col-md-2 column">
        </div>
    </div>
</div>

<%--显示产品详情 --%>
<div class="modal fade" id="modifyTitleModal" tabindex="-1" role="dialog"
     aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title" id="myModalLabel">产品详情</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" id="modifyTitle_from">
                    <%--<input type="hidden" id="edit_cust_id" name="cust_id"/>--%>
                    <div class="form-group">
                        <label for="proId" class="col-sm-2 control-label">产品编号</label>
                        <div class="col-sm-10">
                            <input type="text" readonly class="form-control" id="proId" placeholder="产品编号"
                                   name="proId">
                        </div>                    

                    </div>
                    <div class="form-group">
                        <label for="productName" class="col-sm-2 control-label">产品名称</label>
                         <div class="col-sm-10">
                            <input type="text" readonly class="form-control" id="productName" placeholder="产品名称"
                                   name="productName">
                        </div>
                    </div>
                   
                   <div class="form-group">
                        <label for="brand" class="col-sm-2 control-label">品牌</label>
                         <div class="col-sm-10">
                            <input type="text" readonly class="form-control" id="brand" placeholder="品牌"
                                   name="brand">
                        </div>
                    </div>    
                    <div class="form-group">
                        <label for="type" class="col-sm-2 control-label">纸种</label>
                         <div class="col-sm-10">
                            <input type="text" readonly class="form-control" id="type" placeholder="纸种"
                                   name="type">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="level" class="col-sm-2 control-label">级别</label>
                         <div class="col-sm-10">
                            <input type="text" readonly class="form-control" id="level" placeholder="级别"
                                   name="level">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="gram" class="col-sm-2 control-label">克重</label>
                         <div class="col-sm-10">
                            <input type="text" readonly class="form-control" id="gram" placeholder="克重"
                                   name="gram">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="productSpec" class="col-sm-2 control-label">规格型号</label>
                         <div class="col-sm-10">
                            <input type="text" readonly class="form-control" id="productSpec" placeholder="规格型号"
                                   name="productSpec">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="unit" class="col-sm-2 control-label">单位</label>
                         <div class="col-sm-10">
                            <input type="text" readonly class="form-control" id="unit" placeholder="单位"
                                   name="unit">
                        </div>
                    </div><div class="form-group">
                        <label for="productPrice" class="col-sm-2 control-label">产品单价</label>
                         <div class="col-sm-10">
                            <input type="text" readonly class="form-control" id="productPrice" placeholder="产品单价"
                                   name="productPrice">
                        </div>
                    </div>
                    
                
           
            </form>
        </div>
        <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
        </div>
    </div>
</div>
</div>

</body>
</html>

