<%@ taglib prefix="for" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.erp.pojo.crm.PageResult" %>
<%@ page import="com.erp.pojo.crm.Employee" %>
<%@ page import="java.util.List" %>
<%@ page import="com.erp.pojo.crm.Dept" %>
<%@ page import="java.util.Map" %><%--
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
    List<Dept> deptList = (List<Dept>) request.getAttribute("deptList");
    session.setAttribute("deptList", deptList);
    //拿到权限职务列表
    Map privilegeMap = (Map) request.getAttribute("privilegeMap");
    session.setAttribute("map", privilegeMap);//把权限职务列表放进session中方便下面遍历
%>
<%--使用formdata来上传文件一定要注明该注释为html5--%>
<!DOCTYPE HTML>
<html>
<head>
    <title>职工管理</title>
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
        function modifyEmployee(id) {
            var deptId;
            $.ajax({
                type: "get",
                url: "<%=basePath%>getEmployeeById.do",
                data: {"employeeId": id},
                dataType: "json",
                success: function (data) {
                    $("#employeeId").val(data.employeeId);
                    $("#employeeName").val(data.employeeName);
                    $("#deptName").val(data.deptName);
                    $("#headship").val(data.headship);
                    $("#salary").val(data.salary);
                    deptId = data.deptId;
                }
            });
        }

        function updateEmployee() {
            $.post("<%=basePath%>updateEmployeeById.do", $("#modifyTitle_from").serialize(), function (data) {
                if (data == 'false') {
                    alert("没有权限更改！请联系总经理！")
                }
                if (data == 'ok') {
                    alert("职工信息更新成功！");
                }
                window.location.reload();
            });
        }

        function deleteEmployee(id) {
            if (confirm('确实要删除该职工吗?')) {
                $.post("<%=basePath%>deleteEmployeeById.do", {"employeeId": id}, function (data) {
                    if (data == 'false') {
                        alert("没有权限删除！请联系总经理！")
                    }
                    if (data == 'ok') {
                        alert("职工删除更新成功！");
                    }
                    window.location.reload();
                });
            }
        }
    </script>
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <h3 class="text-center text-info">
                职工列表 <a type="button" href="<%=basePath%>toCreateEmp.do" class="btn btn-success" target="_blank">添加职工</a>
            </h3>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-2 column">
        </div>
        <div class="col-md-8 column">
            <form action="<%=basePath%>getAllEmployee.do" method="post">
                <table class="table table-hover table-bordered">
                    <thead>
                    <tr>
                        <th>编号</th>
                        <th>姓名</th>
                        <th>部门名称</th>
                        <th>职务</th>
                        <th>薪水</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <%
                        List<Employee> list = pageResult.getList();
                        Employee employee = null;
                        for (int i = 0; i < list.size(); i++) {
                            employee = list.get(i);
                    %>
                    <tr>
                        <td>
                            <%=employee.getEmployeeId()%>
                        </td>
                        <td>
                            <%=employee.getEmployeeName()%>
                        </td>
                        <td>
                            <%=employee.getDeptName()%>
                        </td>
                        <td>
                            <%=employee.getHeadship()%>
                        </td>
                        <td>
                            <%=employee.getSalary()%>
                        </td>
                        <%--可以具体操作，包括修改和删除--%>
                        <td>
                            <button type="button"
                                    data-toggle="modal"
                                    data-target="#modifyTitleModal"
                                    class="btn  btn-success" onclick="modifyEmployee('<%=employee.getEmployeeId()%>')">
                                修改
                            </button>
                            <button type="button"
                                    class="btn btn-danger" onclick="deleteEmployee('<%=employee.getEmployeeId()%>')">
                                删除
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
<%--修改课程--%>
<div class="modal fade" id="modifyTitleModal" tabindex="-1" role="dialog"
     aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title" id="myModalLabel">修改职工</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" id="modifyTitle_from">
                    <%--<input type="hidden" id="edit_cust_id" name="cust_id"/>--%>
                    <div class="form-group">
                        <label for="employeeId" class="col-sm-2 control-label">职工编号</label>
                        <div class="col-sm-10">
                            <input type="text" readonly class="form-control" id="employeeId" placeholder="编号"
                                   name="employeeId">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="employeeName" class="col-sm-2 control-label">姓名</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="employeeName" placeholder="姓名"
                                   name="employeeName"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="deptName" class="col-sm-2 control-label">部门</label>
                        <div class="col-sm-10">
                            <%--<input type="text" class="form-control" id="deptName" placeholder="部门"--%>
                            <%--name="deptName">--%>
                            <select class="form-control" id="deptName" name="deptName">
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
                            <select class="form-control" id="headship" name="headship">
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
                                   name="salary">
                        </div>
                    </div>
            </div>
            </form>
        </div>
        <div class="modal-footer">
            <button type="button" id="modifyTitle" class="btn btn-success" onclick="updateEmployee()">确认修改</button>
            <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
            <%--<button type="button" class="btn btn-primary" onclick="updateCustomer()">保存修改</button>--%>
        </div>
    </div>
</div>
</div>
</body>
</html>
