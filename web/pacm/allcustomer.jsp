<%@ page import="com.erp.Utils.PageModel" %>
<%@ page import="com.erp.pojo.crm.Employee" %>
<%@ page language="java" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%		
    	PageModel pm = (PageModel)request.getAttribute("pageModel");
    	String customerName = (String)session.getAttribute("name1");
    	int rs = (Integer)session.getAttribute("tr");
    	int ns = pm.getTotalRecords();
    	Employee e = (Employee)session.getAttribute("employee");
    	int power = e.getPrivilege();
    %>
<html>
<head>
<meta charset="UTF-8">
<title>客户管理</title>
<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">  
	<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
	<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script type="text/javascript">
	var power = <%=power%>;
	function test_(){		
				if(power!=1&&power!=3) {		  		
					alert('没有权限！');	 		
					return false;
					}	else {
						return true;
					}	
				}
	var ns = <%=ns%>;
	var rs = <%=rs%>;
	var power = <%=power%>;
	if(ns<rs){
	function topPage(){
		window.location.href = "<%=basePath%>customerone?name1=<%=customerName%>&pageNo=<%=pm.getTopPage()%>"
	}

	function previousPage(){
		window.location.href = "<%=basePath%>customerone?name1=<%=customerName%>&pageNo=<%=pm.getPreviousPage() %>"
	}

	function nextPage(){
		window.location.href = "<%=basePath%>customerone?name1=<%=customerName%>&pageNo=<%=pm.getNextPage() %>"
	}

	function lastPage(){
		window.location.href = "<%=basePath%>customerone?name1=<%=customerName%>&pageNo=<%=pm.getLastPage() %>"
	}
	}else{
	function topPage(){
		window.location.href = "<%=basePath%>customerall?pageNo=<%=pm.getTopPage() %>"
	}

	function previousPage(){
		window.location.href = "<%=basePath%>customerall?pageNo=<%=pm.getPreviousPage() %>"
	}

	function nextPage(){
		window.location.href = "<%=basePath%>customerall?pageNo=<%=pm.getNextPage() %>"
	}

	function lastPage(){
		window.location.href = "<%=basePath%>customerall?pageNo=<%=pm.getLastPage() %>"
	}
	
	}
	
	
	</script>
	<style>
	.button {
    background-color: #4CAF50;
    border: none;
    color: white;
    padding: 15px 15px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 10px;
    margin: 4px 2px;
    cursor: pointer;
	border-radius: 8px;
}
	
	</style>
</head>
<body>
<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<nav class="navbar navbar-default">
			  <div class="container-fluid">
			    <!-- Brand and toggle get grouped for better mobile display -->
			
			      <div style="text-align: center;background-color: gainsboro"><font style="text-align: center;color: black;font-size: xx-large"><b>纸业销售ERP系统</b></font></div>

	<div margin: 0 auto>
		<div margin: 0 auto >
			<div class="panel panel-default" >
			  <div class="panel-heading" >
			  	<div class="row" >
			    <h3  style="text-align:center;"><a href="<%=basePath%>customerall">客户列表</a><a href="<%=basePath%>pacm/newcustomer.jsp" class="button" onClick="return test_();">添加客户</a></h3>
			    <br/>
			    <form action="<%=basePath%>customerone" method="post" style="text-align:center;">
			    查询客户：<input type="text" name="customername"  placeholder="输入部分名称"/><button class="btn btn-default" id="check1" type="submit">查询</button>
			    </form>
			    <input style="margin-top:20px" class="col-md-5" type="text"  id="exampleInputEmail1" placeholder="Email" hidden>
			  	</div>
			  </div>
			  <div class="panel-body" id="showdiv" style="text-align:center;">
			   <table class="table">
				<thead>
					<tr>
						<th>
							编号
						</th>
						<th>
							客户名称
						</th>
						<th>
							电话号码
						</th>
						
					</tr>
				</thead>
					
				
				<tbody>
				  	<% for (int i=0;i<pm.getCuList().size();i++){ 				
					%>
					<tr >
						
						<td>
							<%=pm.getCuList().get(i).getCustomerId() %>
						</td>
						<td>
							<%=pm.getCuList().get(i).getCustomerName()%>
							
						</td>
						<td>
						<%=pm.getCuList().get(i).getTelephone()%>
							
						</td>
						<td>
							<a href="<%=basePath%>pacm/altercustomer.jsp?customerid=<%=pm.getCuList().get(i).getCustomerId() %>
							&customername=<%=pm.getCuList().get(i).getCustomerName() %>
							&telephone=<%=pm.getCuList().get(i).getTelephone() %>" onClick="return test_();">修改</a>
						</td>
						<td>
							<a href="<%=basePath%>delcustomer?customerid=<%=pm.getCuList().get(i).getCustomerId()%>" onClick="return test_();">删除</a>
						</td>
					</tr>
					
					<%} %>
				</tbody>
	
			</table>
			  </div>
			  <div class="panel-footer">
			  <ul class="pagination">
				<li>
					 <input type="button" value="首页" onclick="topPage()"/>
				</li>
				<li>
					 <input type="button" value="上一页" onclick="previousPage()"/>
				</li>
				<li>
					<input type="button" value="下一页" onclick="nextPage()"/>
				</li>
				<li>
					<input type="button" value="尾页" onclick="lastPage()"/>
				</li>
				<li>
					当前第<%=pm.getPageNo() %>页/总共<%=pm.getTotalPages() %>页
				</li>
			</ul>
			  </div>
			</div>
		
			
			
		</div>
	</div>
</div>
</body>
</html>


