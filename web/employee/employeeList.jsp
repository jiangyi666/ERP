<%@ page import="com.erp.pojo.crm.PageResult" %>
<%@ page import="com.erp.pojo.crm.Employee" %>
<%@ page import="java.util.List" %><%--
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
%>
<%--使用formdata来上传文件一定要注明该注释为html5--%>
<!DOCTYPE HTML>
<html>
<head>
    <title>管理</title>
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script>
        <%@ include file="pagination.js" %>
    </script>
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <h3 class="text-center text-info">
                职工列表 <a type="button" href="<%=basePath%>/createTitle.jsp" class="btn btn-success">添加职工</a>
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
                        <th>部门编号</th>
                        <th>职务</th>
                        <th>薪水</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <%
                        //添加图书列表到集合类list中
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
                                    class="btn  btn-success" onclick="modifyTitle('<%=employee.getEmployeeId()%>')">
                                修改
                            </button>
                            <button type="button"
                                    class="btn btn-danger" onclick="deleteTitle('<%=employee.getEmployeeId()%>')">
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
                        <label for="titleNumber" class="col-sm-2 control-label">课程代码</label>
                        <div class="col-sm-10">
                            <input type="text" readonly class="form-control" id="titleNumber" placeholder="课程代码"
                                   name="titleNumber">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="titleName" class="col-sm-2 control-label">课程名称</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="titleName" placeholder="课程名称"
                                   name="titleName"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="titleSchool" class="col-sm-2 control-label">开课学校</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="titleSchool" placeholder="开课学校"
                                   name="titleSchool">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="titleTeacher" class="col-sm-2 control-label">开课教师</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="titleTeacher" placeholder="开课教师"
                                   name="titleTeacher">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="titleScore" class="col-sm-2 control-label">课程学分</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="titleScore" placeholder="课程学分"
                                   name="titleScore">
                        </div>
                    </div>
            </div>
            </form>
        </div>
        <div class="modal-footer">
            <button type="button" id="modifyTitle" class="btn btn-success" onclick="updateTitle()">确认修改</button>
            <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
            <%--<button type="button" class="btn btn-primary" onclick="updateCustomer()">保存修改</button>--%>
        </div>
    </div>
</div>
</div>
</body>
</html>
