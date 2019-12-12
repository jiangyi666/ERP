<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="org.omg.PortableServer.RequestProcessingPolicy"%>
<%@ page import="com.erp.pojo.rgm.SalesReturn" %>
<%@ page import="java.util.List" %>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
	//String customerId = (String) request.getAttribute("customerId");
	//List<SalesReturn> sr = (List<SalesReturn>) request.getAttribute("sr");
	String path=request.getContextPath();
    String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
List<SalesReturn> list=(List)request.getAttribute("list");
request.getSession().setAttribute("list",list);
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post"
		action="<%=basePath%>ReturnServlet.do">
		<table align="center" width=800 border=1>
		<tr>
		<td align="center" colspan="20">退货订单信息</td>
		</tr>
		<tr align="center">
		<td>退货订单编号</td>
		<td>订单编号</td>
		<td>客户编号</td>
		<td>客户地址</td>
		<td>地址</td>
		<td>退货日期</td>
		<td>状态</td>
		<td colspan='3'>操作</td>
		</tr>
		<c:forEach items="${list}" var="i">
		<tr>
		<td>${i.getReturnId() }</td>
		<td>${i.getOrderId() }</td>
		<td>${i.getCustomerId() }</td>
		<td>${i.getCustomerAddress() }</td>
		<td>${i.getAddress() }</td>
		<td>${i.getReturnDate() }</td>
		<td>${i.getStatus() }</td>
		<td><a href='<%=basePath%>rgm/UpdateReturn.jsp'>修改</a></td>
		<td><a href='<%=basePath%>rgm/DeleteReturn.jsp'>删除</a></td>
		<td><a href='<%=basePath%>rgm/FindReturnById.jsp'>查询</a></td>
		</tr>
		</c:forEach>   
		</table>
		<table align="center">
		<td><a href='<%=basePath%>rgm/AddReturn.jsp'>添加</a></td>
		</table>
	</form>
	
</body>
</html>