
<%@ page language="java" contentType="text/html; charset=utf-8" import="java.util.*"
	pageEncoding="utf-8"%>
<%@ page import="com.erp.pojo.logistic.DeliveryBill" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>|
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title></title>
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
 
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
 
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<%  request.setCharacterEncoding("utf-8");%>
	<form class="form-horizontal" action="<%=basePath%>DeliveryServlet" method="post" onsubmit="return validate()">
	<div class="row-fluid">
		<div class="span12">
		<%
		
		 
		%>
			<h2>
				<em><em>查询成功</em></em>
			</h2>
			<table class="table table-striped">
				<thead>
					<tr>
						<th>
							订单号
						</th>
						<th>
							客户
						</th>
						<th>
							电话
						</th>
						<th>
							订购日期
						</th>
						<th>
							物流状态
						</th>
					</tr>
				</thead>
				<tbody>
			<% 
				List l=(List)request.getAttribute("delivery");
				
				for(int i=0;i<l.size();i++){
					DeliveryBill db=(DeliveryBill)l.get(i);
					%>
						<tr class="success">
						<th>
						    <%=db.getOrderId() %>
						</th>
						<th>
						    <%=db.getCustomerName() %>
						</th>
						<th>
						    <%=db.getTelephone() %>
						</th>
						<th>
						    <%=db.getDate() %>
						</th>
						<td>
							<a href="<%=basePath%>StatusServlet?id=<%=db.getOrderId() %>">修改物流状态</a>
						</td>
						<td>
						 	<a href="<%=basePath%>DetailServlet?id=<%=db.getOrderId() %>">详情</a>
						</td>
					</tr>
					<% 
				}
				%>		</tbody>		
						 <div class="form-group">
					<div class="col-sm-offset-2 col-sm-10" style="padding-left:500px" >
						 <button type="submit" class="btn btn-default" >返回</button>
					</div>
				</div>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>
	</form>
</body>

 
</html>

