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
<title>Insert title here</title>
</head>
<body>
	<h1>添加订单</h1>

	<form method="post"
		action="<%=basePath%>AddReturnServlet.do">
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
	</form>
</body>
</html>