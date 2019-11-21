<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/11/20
  Time: 22:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <title>添加职工</title>
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <h3>
                添加职工
            </h3>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-4 column">
        </div>
        <div class="col-md-4 column">
            <form role="form" action="<%=basePath%>createEmployee.do" method="post">
                <div class="form-group">
                    <%--课程名称--%>
                    <label for="employeeId">编号</label>
                    <input type="text" class="form-control" name="employeeId" id="employeeId" required autofocus/>
                </div>
                <div class="form-group">
                    <%--课程代码--%>
                    <label for="employeeName">姓名</label>
                    <input type="text" class="form-control" name="employeeName" id="employeeName" required
                           autofocus/>
                </div>
                <div class="form-group">
                    <%--开课学校--%>
                    <label for="password">密码</label>
                    <input type="text" class="form-control" id="password" name="password" autofocus required/>
                </div>
                <div class="form-group">
                    <%--开课教师--%>
                    <label for="deptName">部门</label>
                    <input type="text" class="form-control" id="deptName" name="deptName" autofocus required/>
                </div>
                <div class="form-group">
                    <%--课程学分--%>
                    <label for="headship">职位</label>
                    <input type="text" class="form-control" id="headship" name="headship" autofocus required/>
                </div>
                <div class="form-group">
                    <%--课程学分--%>
                    <label for="salary">薪水</label>
                    <input type="text" class="form-control" id="salary" name="salary"  autofocus required />
                </div>
                <div class="form-group">
                    <%--课程学分--%>
                    <label for="privilege">权限</label>
                    <input type="text" class="form-control" id="privilege" name="privilege"  autofocus required />
                </div>
                <button type="submit" class="btn btn-default">提交</button>
            </form>
        </div>
        <div class="col-md-4 column">
        </div>
    </div>
</div>
</body>
</html>
