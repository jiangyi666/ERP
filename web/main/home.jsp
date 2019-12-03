<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>|
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>纸业管理系统</title>
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link href="<%=basePath%>commons/css/footer.css" rel="stylesheet">
</head>
<body>
<%--<img src="<%=basePath%>commons/image/main_image/header.jpg" width="100%">--%>
<div style="text-align: center;background-color: gainsboro"><font style="text-align: center;color: black;font-size: xx-large"><b>纸业销售ERP系统</b></font></div>
<div class="panel-danger">
    <div class="panel-heading">
        <ul class="nav nav-pills">
            <li role="presentation" class="active"><a href="#"><span class="glyphicon glyphicon-home"></span> 首页</a>
            </li>
            <li role="presentation"><a href="#" target="_blank">消息</a></li>
            <li role="presentation"><a href="#">反馈</a></li>
        </ul>
    </div>
</div>

<iframe src="<%=basePath%>main/frame1.jsp" width="15%" height="600" frameborder="1"></iframe>
<iframe src="<%=basePath%>getAllEmployee.do" name="main" marginheight="0" marginwidth="0" height="600" width="80%" frameborder="0">
</iframe>
</body>
</html>