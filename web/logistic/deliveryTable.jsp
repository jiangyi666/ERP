<%@ page language="java" contentType="text/html; charset=utf-8" import="java.util.*"
	pageEncoding="utf-8"%>
<%@ page import="com.erp.pojo.logistic.DeliveryBill" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>|
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title></title>
<!-- 新 Bootstrap 核心 CSS 文件 -->
<link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
 
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
 
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script type="text/javascript">

	function find(){
		$.post("<%=basePath%>Search",{"id":$("#inputEmail3").val()},function success(data){
			if(data=="false")
				{
				alert("没有该订单！")
				}
		})
	}
	
</script>

</head>
<body>
<center>
	<%//response.setContentType("text/html;charset=utf-8");
	request.setCharacterEncoding("utf-8");
	 %>
	 <form action="<%=basePath%>Search" method="post" "form-horizontal" role="form">
	 <div class="form-group">
					 <label for="inputEmail3" class="col-sm-2 control-label">查询条件：</label>
					<div class="col-sm-10">
						<input type="text" required class="form-control" id="inputEmail3"  name="id"/>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						 <button type="submit" class="btn btn-default" onclick="find()">查询</button>
					
					</div>
				</div>	
	 </form>
	<form action="<%=basePath%>DeliveryServlet" method="post" "form-horizontal" role="form">
	
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
				<tbody id="table1"><%
				List l=(List)request.getAttribute("DeliveryBill");
//				DeliveryBill Db=(DeliveryBill)l.get(0);
					DeliveryBill Db;
					if(l.size()!=0){
						Db=(DeliveryBill)l.get(0);
					}else{
						Db=new DeliveryBill();
						Db.setPageCount(0);
					}

					for(int i=0;i<l.size();i++){
					DeliveryBill db=(DeliveryBill)l.get(i);
					%>
						<tr class="success">
						<td>
							<%=db.getOrderId() %>
						</td>
						<td>
							<%=db.getCustomerName() %>
						</td>
						<td>
							<%=db.getTelephone() %>
						</td>
						<td>
							<%=db.getDate() %>
						</td>
						<td>
							<%=db.getStatus() %>
						</td>
						<td>
							<a href="<%=basePath%>StatusServlet?id=<%=db.getOrderId() %>">修改物流状态</a>
						</td>
						<td>
						 	<a href="<%=basePath%>DetailServlet?id=<%=db.getOrderId() %>">详情</a>
						</td>
					</tr>
					<% 
				}
				%>				
				</tbody>
			</table>
			<div class="pagination pagination-centered">
				<ul>
				<%="总页数:"+ Db.getPageCount() %>
				<%="当前页:"+ request.getAttribute("now") %>
			<div class="form-group">
					 <label for="inputEmail3" class="col-sm-2 control-label">跳转页</label>
					<div class="col-sm-10">
						<input type="text" required class="form-control" id="inputEmail3" name="pageNow"/>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						 <button type="submit"  class="btn btn-default">跳转</button>
					</div>
				</div>	
				
				</ul>
			</div>
		</div>
	</div>
</div>
</form>
</center>
<script>
	
	
</script>
</body>
</html>