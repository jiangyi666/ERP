<%@ page import="com.erp.pojo.crm.PageResult" %>
<%@ page import="com.erp.pojo.crm.Dept" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/11/23
  Time: 15:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%
    PageResult pageResult = (PageResult) request.getAttribute("pageResult");
%>
<html>
<head>
    <title>部门管理</title>
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script type="text/javascript">
        function modifyDept(id) {
            var deptId;
            $.ajax({
                type: "get",
                url: "<%=basePath%>getDeptById.do",
                data: {"deptId": id},
                dataType: "json",
                success: function (data) {
                    $("#deptId").val(data.deptId);
                    $("#deptName").val(data.deptName);
                    deptId = data.deptId;
                }
            });
        }
        function updateDept() {
            $.post("<%=basePath%>updateDept.do", $("#modifyTitle_from").serialize(), function (data) {
                if (data == 'false') {
                    alert("没有权限更改！请联系总经理！")
                }
                if (data == 'ok') {
                    alert("部门信息更新成功！");
                }
                window.location.reload();
            });
        }
        function deleteDept(id) {
            if (confirm('确实要删除该部门吗?')) {
                $.post("<%=basePath%>deleteDeptById.do", {"deptId": id}, function (data) {
                    if (data == 'false') {
                        alert("没有权限删除！请联系总经理！")
                    }
                    if (data == 'ok') {
                        alert("部门删除更新成功！");
                    }
                    window.location.reload();
                });
            }
        }
    </script>
</head>
<body>
<div style="text-align: center;background-color: gainsboro"><font style="text-align: center;color: black;font-size: xx-large"><b>纸业销售ERP系统</b></font></div>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <h3 class="text-center text-info">
                部门列表 <a type="button" href="<%=basePath%>toCreateDept.do" class="btn btn-success" target="_blank">新增部门</a>
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
                        <th>部门编号</th>
                        <th>部门名称</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <%
                        List<Dept> list = pageResult.getList();
                        Dept dept = null;
                        for (int i = 0; i < list.size(); i++) {
                            dept = list.get(i);
                    %>
                    <tr>
                        <td>
                            <%=dept.getDeptId()%>
                        </td>
                        <td>
                            <%=dept.getDeptname()%>
                        </td>
                        <%--可以具体操作，包括修改和删除--%>
                        <td>
                            <button type="button"
                                    data-toggle="modal"
                                    data-target="#modifyTitleModal"
                                    class="btn  btn-success" onclick="modifyDept('<%=dept.getDeptId()%>')">
                                修改
                            </button>
                            <button type="button"
                                    class="btn btn-danger" onclick="deleteDept('<%=dept.getDeptId()%>')">
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
                <h4 class="modal-title" id="myModalLabel">修改部门</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" id="modifyTitle_from">
                    <%--<input type="hidden" id="edit_cust_id" name="cust_id"/>--%>
                    <div class="form-group">
                        <label for="deptId" class="col-sm-2 control-label">部门编号</label>
                        <div class="col-sm-10">
                            <input type="text" readonly class="form-control" id="deptId" placeholder="部门编号"
                                   name="deptId">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="deptName" class="col-sm-2 control-label">部门名称</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="deptName" placeholder="部门名称"
                                   name="deptName"/>
                        </div>
                    </div>
            </div>
            </form>
        </div>
        <div class="modal-footer">
            <button type="button" id="modifyTitle" class="btn btn-success" onclick="updateDept()">确认修改</button>
            <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
            <%--<button type="button" class="btn btn-primary" onclick="updateCustomer()">保存修改</button>--%>
        </div>
    </div>
</div>
</div>
</body>
</html>
