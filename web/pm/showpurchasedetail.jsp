<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="java.util.Map"%>
<%@page import="com.erp.service.pm.purchaseorderservice"%>
<%@page import="java.util.List"%>

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
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>|
  	<%  List<Map<String,Object>> list=(List)request.getAttribute("list");
   		String id=(String)request.getAttribute("purchaseId");
   		String pageItem=(String)request.getAttribute("pageItem");
    	int pageItem2=Integer.parseInt(pageItem);
    	int pageItem3=pageItem2;
    	if(pageItem3==0)
    	{
    		pageItem3=1;
    	}
   	%>

<div class="container-fluid">
	<div class="row-fluid">
		<div class="span12">
			<h2 class="text-info text-center">
			<a href="<%=request.getContextPath()%>/purchaseordergetdetail.do?purchasedetailInsert=3&purchaseId=<%=id%>">
				<button class="btn btn-primary" type="button">增加详情</button>
				</a>
				采购订单详情
				<a href="<%=request.getContextPath()%>/purchaseorderservlet.do?pageItem=0">
				<button type="submit" class="btn" onclick="javascript:window.location.href='showpurchaseorder.jsp';">返回</button>
				</a>
			</h2>
			<center>
			<table class="table table-bordered" style="width:1000px;height:100px">
				<thead>
					<tr>
						<th>
							采购单编号
						</th>
						<th>
							原料编号
						</th>
						<th>
							原料数量
						</th>
						<th>
							原料单价
						</th>
						<th>
							运输费用
						</th>
						<th>
							操作
						</th>
					</tr>
				</thead>
				<tbody>
				<% 
					for (int i=pageItem2*10;i<list.size()&&i<pageItem2*10+10;i++){ 
						Map<String ,Object> map=list.get(i);
					%>
					<tr class="info">
						<td>
							<%=map.get("purchaseId") %>
						</td>
						<td>
							<%=map.get("matId") %>
						</td>
						<td>
							<%=map.get("qty") %>
						</td>
						<td>
							<%=map.get("price") %>
						</td>
						<td>
							<%=map.get("transpCosts") %>
						</td>
						<td>
						<a href="<%=request.getContextPath()%>/deleteservlet.do?&type=2&purchaseId=<%=map.get("purchaseId") %>&pageItem=<%=pageItem2%>&matId=<%=map.get("matId") %>">
						<button class="btn" type="submit">删除</button>
						</a>
						</td>
					</tr>
					<%}%>
				</tbody>
			</table>
			</center>
			<div class="panel-footer ">
				<center>
				<ul class="pagination ">
					<li>
						<a href="<%=request.getContextPath()%>/pagechange?pageItem=<%=pageItem3-1%>&type=purchaseorderdetail&purchaseId=<%=id%>">上一页</a>
					</li>
					<li>
						<a href="<%=request.getContextPath()%>/pagechange?pageItem=0&type=purchaseorderdetail&purchaseId=<%=id%>">1</a>
					</li>
					<li>
						<a href="<%=request.getContextPath()%>/pagechange?pageItem=1&type=purchaseorderdetail&purchaseId=<%=id%>">2</a>
					</li>
					<li>
						<a href="<%=request.getContextPath()%>/pagechange?pageItem=2&type=purchaseorderdetail&purchaseId=<%=id%>">3</a>
					</li>
					<li>
						<a href="<%=request.getContextPath()%>/pagechange?pageItem=3&type=purchaseorderdetail&purchaseId=<%=id%>">4</a>
					</li>
					<li>
						<a href="<%=request.getContextPath()%>/pagechange?pageItem=4&type=purchaseorderdetail&purchaseId=<%=id%>">5</a>
					</li>
					<li>
						<a href="<%=request.getContextPath()%>/pagechange?pageItem=<%=pageItem2+1%>&type=purchaseorderdetail&purchaseId=<%=id%>">下一页</a>
											
					</li>
				</ul>
				</center>
			</div>
		</div>
	</div>
</div>

</body>
</html>