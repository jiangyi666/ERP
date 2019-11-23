<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/11/23
  Time: 18:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <title>新增部门</title>
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <script type="text/javascript">
        function addDept() {
            //做为空判断
            if($("#deptId").val()!=''&$("#deptName").val()!=""){
                //不为空就提交
                $.post("<%=basePath%>addDept.do", $("#addDept_from").serialize(), function (data) {
                    if (data=='ok')
                    {
                        alert("添加新部门成功！")
                    }
                    if (data=='false')
                    {
                        alert("该部门编号已经存在！请再次输入！")
                    }

                    window.location.reload();
                });
            }else {
                alert("请填写好相关字段后再提交！")
            }
        }
    </script>
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <h3>新增部门</h3>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-2 column">
        </div>
        <div class="col-md-6 column">
            <form role="form" action="<%=basePath%>createEmployee.do" id="addDept_from" method="post">
                <div class="form-group">
                    <label for="deptId" class="col-sm-2 control-label">部门编号</label>
                    <div class="col-sm-10">
                        <input type="text" autofocus class="form-control" id="deptId" placeholder="部门编号"
                               name="deptId" required>
                    </div>
                </div>
                <div class="form-group">
                    <label for="deptName" class="col-sm-2 control-label">部门名称</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="deptName" placeholder="部门名称"
                               name="deptName" required/>
                    </div>
                </div>
            </form>
            <button type="button" class="btn  btn-success" onclick="addDept()">添加</button>
        </div>
        <div class="col-md-4 column">
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-12 column">
        </div>
    </div>
</div>
</body>
</html>
