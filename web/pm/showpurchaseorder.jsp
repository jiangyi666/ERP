<%@page import="com.erp.service.pm.purchaseorderservice"%>
<%@page import="java.util.Map"%>

<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
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
	<Script Language="JavaScript">
		function page(){
			window.open('addpurchaseorder.jsp');;
		}
	</Script>
</head>
<body>
	<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
  <%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
  %>|
  <%		
  		List<Map<String,Object>> list=(List)request.getAttribute("list");
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
				采购订单
				<a href="<%=request.getContextPath()%>/selectservlet.do?pageItem=<%=pageItem%>">
				<button class="btn btn-primary" type="button">新建订单</button>
				</a>
			</h2>
			
			<p>
				​
			</p>
			<center>
			<form class="form-search" role="form" action="<%=basePath%>searchservlet.do?pageItem=0"
			method="post">
				<p>
					<input class="input-medium search-query" name="purchaseId" type="text" /><button class="btn" type="submit">查找</button>
				</p>
			</form>
			</center>
			<center>
			<table class="table table-bordered" style="width:1000px;height:100px">
				<thead>
					<tr>
						<th>
							采购订单编号
						</th>
						<th>
							采购员编号
						</th>
						<th>
							供应商编号
						</th>
						<th>
							采购金额
						</th>
						<th>
							采购时间
						</th>
						<th>
							是否入库
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
							<%=map.get("employeId") %>
						</td>
						<td>
							<%=map.get("peeId") %>
						</td>
						<td>
							<%=map.get("purchaseSum") %>
						</td>
						<td>
							<%=map.get("purchaseDate") %>
						</td>
						<td>
							<%=map.get("ifStorage") %>
						</td>
						<td>
						
							<a href="<%=request.getContextPath()%>/purchaseordergetdetail.do?pageItem=0&purchasedetailInsert=1&purchaseId=<%=map.get("purchaseId") %>">
								<button type="button" class="btn btn-info">查看</button>
							</a>
							<a href="<%=request.getContextPath()%>/deleteservlet.do?&type=1&pageItem=<%=pageItem %>&purchaseId=<%=map.get("purchaseId") %>">
							<button  type="button"  class="btn" type="submit">删除</button>
							</a>
						</td>
					</tr>
					<%}%>
				</tbody>
			</table>
			</center>
		</div>
	</div>
	<div class="panel-footer ">
	<center>
			<ul class="pagination ">
					<li>
						<a href="<%=request.getContextPath()%>/pagechange?pageItem=<%=pageItem3-1%>&type=purchaseorder">上一页</a>
					</li>
					<li>
						<a href="<%=request.getContextPath()%>/pagechange?pageItem=0&type=purchaseorder">1</a>
					</li>
					<li>
						<a href="<%=request.getContextPath()%>/pagechange?pageItem=1&type=purchaseorder">2</a>
					</li>
					<li>
						<a href="<%=request.getContextPath()%>/pagechange?pageItem=2&type=purchaseorder">3</a>
					</li>
					<li>
						<a href="<%=request.getContextPath()%>/pagechange?pageItem=3&type=purchaseorder">4</a>
					</li>
					<li>
						<a href="<%=request.getContextPath()%>/pagechange?pageItem=4&type=purchaseorder">5</a>
					</li>
					<li>
						<a href="<%=request.getContextPath()%>/pagechange?pageItem=<%=pageItem2+1%>&type=purchaseorder">下一页</a>
											
					</li>
				</ul>
				</center>
			</div>
</div>
</body>
</html>
