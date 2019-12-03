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
    	String peeName = (String)session.getAttribute("name2");
    	int rs = (Integer)session.getAttribute("tr");
    	int ns = pm.getTotalRecords();
    	Employee e = (Employee)session.getAttribute("employee");
    	int power = e.getPrivilege();
    %>
<html>
<head>
<meta charset="UTF-8">
<title>供应商管理</title>
<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">  
	<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
	<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script type="text/javascript">
var power = <%=power%>;
	function test1(){		
				if(power!=1&&power!=5) {		  		
					alert('没有权限！');	 		
					return false;
					}	else {
						return true;
					}	
				}
				
				function test2(){		
				if(power!=1&&power!=5&&power!=2) {		  		
					alert('没有权限！');	 		
					return false;
					}	else {
						return true;
					}	
				}
				
	var ns = <%=ns%>;
	var rs = <%=rs%>;
	if(ns<rs){
	function topPage(){
		window.location.href = "<%=basePath%>providerone?name2=<%=peeName%>&pageNo=<%=pm.getTopPage()%>"
	}

	function previousPage(){
		window.location.href = "<%=basePath%>providerone?name2=<%=peeName%>&pageNo=<%=pm.getPreviousPage() %>"
	}

	function nextPage(){
		window.location.href = "<%=basePath%>providerone?name2=<%=peeName%>&pageNo=<%=pm.getNextPage() %>"
	}

	function lastPage(){
		window.location.href = "<%=basePath%>providerone?name2=<%=peeName%>&pageNo=<%=pm.getLastPage() %>"
	}
	}else{
	function topPage(){
		window.location.href = "<%=basePath%>providerall?pageNo=<%=pm.getTopPage() %>"
	}

	function previousPage(){
		window.location.href = "<%=basePath%>providerall?pageNo=<%=pm.getPreviousPage() %>"
	}

	function nextPage(){
		window.location.href = "<%=basePath%>providerall?pageNo=<%=pm.getNextPage() %>"
	}

	function lastPage(){
		window.location.href = "<%=basePath%>providerall?pageNo=<%=pm.getLastPage() %>"
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
			


	<div margin: 0 auto>
		<div margin: 0 auto >
			<div class="panel panel-default" >
			  <div class="panel-heading" >
			  	<div class="row" >
			    <h3  style="text-align:center;"><a href="<%=basePath%>providerall">供应商列表 </a><a href="<%=basePath%>pacm/newproviders.jsp" class="button" onClick="return test1();">添加供应商</a></h3>
			    <br/>
			    <form action="<%=basePath%>providerone" method="post" style="text-align:center;">
			    查询供应商：<input type="text" name="peename"  placeholder="输入部分名称"/><button class="btn btn-default" id="check1" type="submit">查询</button>
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
							供应商名称
						</th>
						<th>
							电话号码
						</th>
						<th>
							地址
						</th>
					</tr>
				</thead>
					
				
				<tbody>
				  	<% for (int i=0;i<pm.getProList().size();i++){ 				
					%>
					<tr >
						
						<td>
							<%=pm.getProList().get(i).getPeeId() %>
						</td>
						<td>
							<%=pm.getProList().get(i).getPeeName()%>
							
						</td>
						<td>
						<%=pm.getProList().get(i).getTelephone()%>
							
						</td>
						<td>
						<%=pm.getProList().get(i).getAddress()%>
							
						</td>
						<td>
							<a href="<%=basePath%>pacm/alterproviders.jsp?peeid=<%=pm.getProList().get(i).getPeeId() %>
							&peename=<%=pm.getProList().get(i).getPeeName() %>
							&telephone=<%=pm.getProList().get(i).getTelephone() %>
							&address=<%=pm.getProList().get(i).getAddress() %>" onClick="return test2();">修改</a>
						</td>
						<td>
							<a href="<%=basePath%>delprovider?peeid=<%=pm.getProList().get(i).getPeeId()%>" onClick="return test1();">删除</a>
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

