<%@ page import="com.erp.pojo.crm.Employee" %>
<%@page contentType="text/html; charset=UTF-8" language="java" %>
<%@page pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    Employee employee = (Employee) session.getAttribute("employee");
%>|
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link href="<%=basePath%>commons/css/footer.css" rel="stylesheet">
    <script type="text/javascript">
        $(document).ready(function () {
            $("#btn1").click(function () {
                $("#div0").slideToggle();
                $("#div1").slideToggle();
                $("#div2").slideToggle(1000);
                $("#div3").slideToggle(1500);
                $("#div4").slideToggle(1700);
                $("#div5").slideToggle(1900);
                $("#div6").slideToggle(2200);
            })
        })
    </script>
</head>
<body>
<button class="btn-danger" onclick="null"><span class="glyphicon glyphicon-flag"></span><%=employee.getEmployeeName()%></button>
<button class="btn-block btn-danger btn-lg" id="btn1">系统维护<span class="glyphicon glyphicon-th-list"></span></button>
<div class="panel-warning" id="div0" hidden>
    <div class="panel-heading"><span class="glyphicon glyphicon-menu-right"></span> <a href="<%=basePath%>getAllDept.do" target="main" style="text-decoration: none">部门管理</a> </div>
</div>
<div class="panel-warning" id="div1" hidden>
    <div class="panel-heading"><span class="glyphicon glyphicon-menu-right"></span>  <a href="<%=basePath%>getAllEmployee.do" target="main" style="text-decoration: none">职工管理</a></div>
</div>
<div class="panel-warning" id="div2" hidden>
    <div class="panel-heading"><span class="glyphicon glyphicon-menu-right"></span> <a href="<%=basePath%>pmg/product.jsp" target="main" style="text-decoration: none">产品管理</a></div>
</div>
<div class="panel-warning" id="div3" hidden>
    <%--<div class="panel-heading"><span class="glyphicon glyphicon-menu-right"></span> <a href="<%=basePath%>userServlet.do" target="_blank" style="text-decoration: none">成员管理</a></div>--%>
        <div class="panel-heading"><span class="glyphicon glyphicon-menu-right"></span> <a href="<%=basePath%>pmg/Material.jsp" target="main" style="text-decoration: none">物料管理</a></div>
</div>
<div class="panel-warning" id="div4" hidden>
    <div class="panel-heading"><span class="glyphicon glyphicon-menu-right"></span>  <a href="<%=basePath%>pmg/goodsLocation.jsp" target="main" style="text-decoration: none">仓库管理</a></div>
</div>
<div class="panel-warning" id="div5" hidden>
    <div class="panel-heading"><span class="glyphicon glyphicon-menu-right"></span>  <a href="<%=basePath%>customerall" target="main" style="text-decoration: none">客户管理</a></div>
</div>
<div class="panel-warning" id="div6" hidden>
    <div class="panel-heading"><span class="glyphicon glyphicon-menu-right"></span>  <a href="<%=basePath%>providerall" target="main" style="text-decoration: none">供应商管理</a></div>
</div>
<div class="list-group">
    <a href="#" class="list-group-item active">供销存</a>
    <a href="<%=basePath%>erm/MaterielManger.jsp" target="main" class="list-group-item list-group-item-success"><span class="glyphicon glyphicon-tag"></span>
        物料进仓管理</a>
    <a href="<%=basePath%>erm/Materielout.jsp" target="main" class="list-group-item list-group-item-success"><span class="glyphicon glyphicon-tag"></span>
        物料出仓管理</a>
    <a href="<%=basePath%>getAllProductStorageDetail.do" target="main" class="list-group-item list-group-item-info"><span class="glyphicon glyphicon-tag"></span>产品库存管理</a>
    <a href="<%=basePath%>getAllMaterrielStorageDetail.do" target="main" class="list-group-item list-group-item-info"><span class="glyphicon glyphicon-tag"></span>物料库存管理</a>
    <a href="#"target="main"  class="list-group-item list-group-item-warning"><span
            class="glyphicon glyphicon-tag"></span>订单管理</a>
    <a href="#" target="main" class="list-group-item list-group-item-danger"><span class="glyphicon glyphicon-tag"></span>退货管理</a>
    <a href="<%=basePath%>purchaseorderservlet.do?pageItem=0" target="main" class="list-group-item list-group-item-danger"><span class="glyphicon glyphicon-tag"></span>采购管理</a>
</div>

</body>
</html>