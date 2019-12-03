<%@ page language="java" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
<head>
<meta charset="UTF-8">
<title>新增客户</title>
<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">  
	<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
	<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script type="text/javascript">
	</script>
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
			    <h3  style="text-align:center;"><a href="<%=basePath%>customerall">客户列表</a></h3>
			    <br/>
			    
			    <input style="margin-top:20px" class="col-md-5" type="text"  id="exampleInputEmail1" placeholder="Email" hidden>
			  	</div>
			  </div>
			  <div class="panel-body" id="showdiv" style="text-align:center;">
			   <form action="<%=basePath%>addcustomer" method="post" class="col-md-5" onSubmit="return test_();" style="text-align:center;">
			    客户名称：<input type="text" name="customername" style="border-radius:5px;">
			    <br/>
			    <br/>
			  	客户电话：<input type="text" name="telephone" id="mytest" style="border-radius:5px;"> 
			  	<br/>
			  	<br/>
			     <input type="submit" value="提交">
			    </form>
			  </div>
			  
			</div>
		
			
		</div>
	</div>
</div>
<script type="text/javascript">	
	function test_(){
			var theinput=document.getElementById("mytest").value;		  
			var p1=/^(13[0-9]\d{8}|15[0-35-9]\d{8}|18[0-9]\{8}|14[57]\d{8})$/;		 //(p1.test(theinput));			
				if(p1.test(theinput)==false) {		  		
					alert('请填写正确电话号码!!');	 		
					document.getElementById("mytest").value='';	
					return false;
					}	else {alert("添加成功！");
						return true;
					}	
				}
</script>

</body>
</html>
