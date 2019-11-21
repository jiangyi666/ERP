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
            <li role="presentation"><a href="/ueditor/main.jsp" target="_blank">消息</a></li>
            <li role="presentation"><a href="#">反馈</a></li>
        </ul>
    </div>
</div>

<iframe src="<%=basePath%>main/frame1.jsp" width="15%" height="600" frameborder="1"></iframe>
<iframe src="<%=basePath%>main/frame2.jsp" marginheight="0" marginwidth="0" height="600" width="60%" frameborder="1"></iframe>
<iframe src="<%=basePath%>main/frame3.jsp" marginheight="0" marginwidth="0" height="600" width="20%" frameborder="1"></iframe>
<!--<div align="center">
    <iframe src="frame4.jsp" width="70%" height="600" style="margin-top: 2px;margin-left: 4px;margin-right: 4px"
            frameborder="1"></iframe>
</div>-->
<br>
<br>
<br>
<br>
<%--<div id="footer">--%>
    <%--<font style="color: white;font-family: 仿宋" size="5">--%>
        <%--<span class="glyphicon glyphicon-envelope"></span>--%>
        <%--联系：<br>jy350@icloud.com--%>
    <%--</font></b>--%>
    <%--<div style="float: right">--%>
        <%--<p><font color="black" style="font-family: 华文行楷" size="4"><span class="glyphicon glyphicon-share-alt"></span>--%>
            <%--友情链接</font></p>--%>
        <%--<p><a class="a1" href="http://www.fjnu.edu.cn/"><span class="glyphicon glyphicon-asterisk"></span> 福建师范大学网站</a>--%>
        <%--</p>--%>
        <%--<p><a class="a1" href="http://cpc.people.com.cn/"><span class="glyphicon glyphicon-asterisk"></span>人民网</a></p>--%>
    <%--</div>--%>
    <%--<div style="text-align: center">--%>
        <%--<br><br><br><br>--%>
        <%--<font color="black" style="font-family: 华文行楷" size="4">版权所有</font>--%>
        <%--<span class="glyphicon glyphicon-copyright-mark"></span>--%>
        <%--<font color="black" style="font-family: -apple-system" size="4">Designed By JiangYi In FJNU.2018</font>--%>
    <%--</div>--%>

<%--</div>--%>
</body>
</html>