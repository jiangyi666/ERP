<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

    <script type="text/javascript">
        function addEmployee() {
            //做为空判断
            if($("#employeeId").val()!=''&$("#employeeName").val()!=""
                &$("#password").val()!=""&$("#deptName").val()!=""
            &$("#headship").val()!=""&$("#salary").val()!=""){
                //不为空就提交
                $.post("<%=basePath%>addEmployee.do", $("#addEmployee_from").serialize(), function (data) {
                    if (data=='ok')
                    {
                        alert("添加新职工成功！")
                    }
                    if (data=='false')
                    {
                        alert("该员工号已经存在！请再次输入！")
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
            <h3>添加职工</h3>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-2 column">
        </div>
        <div class="col-md-6 column">
            <form role="form" action="<%=basePath%>createEmployee.do" id="addEmployee_from" method="post">
                <div class="form-group">
                    <label for="employeeId" class="col-sm-2 control-label">职工编号</label>
                    <div class="col-sm-10">
                        <input type="text" autofocus class="form-control" id="employeeId" placeholder="编号"
                               name="employeeId" required>
                    </div>
                </div>
                <div class="form-group">
                    <label for="employeeName" class="col-sm-2 control-label">姓名</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="employeeName" placeholder="姓名"
                               name="employeeName" required/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="password" class="col-sm-2 control-label">密码</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="password" placeholder="密码"
                               name="password" required/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="deptName" class="col-sm-2 control-label">部门</label>
                    <div class="col-sm-10">
                        <%--<input type="text" class="form-control" id="deptName" placeholder="部门"--%>
                        <%--name="deptName">--%>
                        <select class="form-control" id="deptName" name="deptName" required>
                            <option value="">--请选择--</option>
                            <c:forEach items="${deptList}" var="dept">
                                <option value="${dept.deptname}">${dept.deptname}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label for="headship" class="col-sm-2 control-label">职务</label>
                    <div class="col-sm-10">
                        <%--<input type="text" class="form-control" id="headship" placeholder="职务"--%>
                        <%--name="headship">--%>
                        <select class="form-control" id="headship" name="headship" required>
                            <option value="">--请选择--</option>
                            <c:forEach items="${map}" var="entry">
                                <option value="<c:if test="${not empty entry.key}">${entry.key}</c:if>">
                                    <c:if test="${not empty entry.key}">${entry.key}</c:if>
                                </option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label for="salary" class="col-sm-2 control-label">薪水</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="salary" placeholder="薪水"
                               name="salary" required>
                    </div>
                </div>
            </form>
            <button type="button" class="btn  btn-success" onclick="addEmployee()">添加</button>
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
