
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
<script type="text/javascript">
function find(){
			alert("修改成功！")
}
</script>
<%  request.setCharacterEncoding("utf-8");%>
	<form class="form-horizontal" action="<%=basePath%>StatusServlet" method="post" onsubmit="return validate()">
	<div class="row-fluid">
		<div class="span12">
		<%
		
		 
		%>
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
				List l=(List)request.getAttribute("alterSta");
					DeliveryBill db=(DeliveryBill)l.get(0);
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
						    <%=db.getDate()%>
						</th>
						<td>
							<select name="status">
							<option value="1">待发货</option>
							<option value="2">已发货</option>
							<option value="3">已送达</option>
							</select>
						</td>
						<td><div class="col-sm-offset-2 col-sm-10">
						 <button type="submit" class="btn btn-default" onclick="find()">确定</button>
					</div></td>
					</tr>
				</tbody>		
			
					</div>
				</div>
			</form>
		</div>
	</div>
</div>
 <form action="/ERP/DeliveryServlet" method="post" "form-horizontal" role="form">
<div class="col-sm-offset-2 col-sm-10" style="padding-left:500px " >
						 <button type="submit" class="btn btn-default" >返回</button>
					</div>
					</form>
</body>

 
</html>

