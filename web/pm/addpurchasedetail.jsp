<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
	<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

	<!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

	<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
	
<title>采购管理</title>
</head>
<body>
<%
	String purchaseId= (String) request.getAttribute("purchaseId");
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>|
	<center>
			<form class="form-horizontal" role="form" action="<%=basePath%>purchaseordergetdetail.do?purchasedetailInsert=2&purchaseId=<%=purchaseId %>"
					method="post">
						<label>订单编号：<%=purchaseId %>
						</label>
						<label>原料编号：<input type="text" name="matId" size=15 />
						</label> 
						<label>原料数量：<input type="text" name="qty" size=15 /> 
						</label>	
						<label>原料单价：<input type="text" name="price" size=15 /> 
						</label>	
						<label>运输费用：<input type="text" name="transpCosts" size=15 />
						</label>
						<button class="btn btn-info" type="submit">确认</button>
				</form>
				
				<a href="<%=request.getContextPath()%>/purchaseordergetdetail.do?pageItem=0&purchasedetailInsert=1&purchaseId=<%=purchaseId%>">
				<button type="submit" class="btn" onclick="javascript:window.location.href='showpurchasedetail.jsp';">返回</button>
				</a>
		</center>
</body>
</html>