<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	//String customerId = (String) request.getAttribute("customerId");
	//List<SalesReturn> sr = (List<SalesReturn>) request.getAttribute("sr");
	String path=request.getContextPath();
    String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>退货订单界面</title>
	<!-- 新 Bootstrap 核心 CSS 文件 -->
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js">
    </script>

</head>
<body>
	<h1>查找订单</h1>
	<!-- 新 Bootstrap 核心 CSS 文件 -->
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    
	<%-- <form method="post"
		action="${pageContext.request.contextPath}/SaleReturnServlet.do">
		<table>
			<tr>
				<td>退货订单编号</td>
				<td><input type="text" name="ReturnId"  id="ReturnId" required/></td>
			</tr>
			<tr>

				<td>订单编号</td>
				<td><input type="text" name="OrderId" id="OrderId" required/></td>
			</tr>
			<tr>
				<td>顾客编号</td>
				<td><input type="text" name="CustomerId" id="CustomerId" required/></td>
			</tr>
			<tr>
				<td>顾客地址</td>
				<td><input type="text" name="CustomerAddress" id="CustomerAddress" required/></td>
			</tr>
			<tr>
				<td>地址</td>
				<td><input type="text" name="Address" id="Address" required/></td>
			</tr>
			<tr>
				<td>退货日期</td>
				<td><input type="date" id="ReturnDate" name="ReturnDate" required/></td>
			</tr>
			<tr>
				<td>状态</td>
				<td><input type="text" name="Status" id="Status" required/></td>
			</tr>
		</table>
		<input type="submit" value="添加"  onclick="checkData()" required/>
	</form> --%>
	
	<form method="post"
		action="<%=basePath%>FindReturnByIdServlet.do">
		退货订单编号
		<input type="text" name="ReturnId"></br>
		退货订单${sr.returnId}的信息</br>
		<table>
			<tr>
				<td>退货订单编号</td>
				<td>${sr.returnId}</td>
			</tr>
			<tr>

				<td>订单编号</td>
				<td>${sr.orderId}</td>
			</tr>
			<tr>
				<td>顾客编号</td>
				<td>${sr.customerId}</td>
			</tr>
			<tr>
				<td>顾客地址</td>
				<td>${sr.customerAddress}</td>
			</tr>
			<tr>
				<td>地址</td>
				<td>${sr.address}</td>
			</tr>
			<tr>
				<td>退货日期</td>
				<td>${sr.returnDate}</td>
			</tr>
			<tr>
				<td>状态</td>
				<td>${sr.status }</td>
			</tr>
		</table>
	</form>
	
</body>
</html>