<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
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
  <script type="text/javascript">
  	function check(purchaseId){
  		if(purchaseId == null)
  		{
  			 alert("请先输入提交订单信息");
  		}
  		 window.location.reload();
  	}
  </script>
</head>
<body>
<%
	/*Map<String, Object> map = new HashMap<String, Object>();
	map.put("purchaseId", "订单编号");
	map.put("matId", "原料编号");
	map.put("qty", "原料数量");
	map.put("price", "原料单价");
	map.put("transpCosts", "运输费用");
	list.add(map);*/
	List<String> liste=(List)request.getAttribute("liste");
	List<String> listp=(List)request.getAttribute("listp");
	String purchaseId= (String) request.getAttribute("purchaseId");
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>|
<%
    //PageResult pageResult = (PageResult) request.getAttribute("pageResult");
	//List<employee> employeeList = (List) request.getAttribute("liste");
	//List<Map<String,Object>> providerList = (List) request.getAttribute("listp");
    /*session.setAttribute("employeeList", employeeList);//拿到权限职务列表
    Map privilegeMap = (Map) request.getAttribute("privilegeMap");
    session.setAttribute("map", privilegeMap);*///把权限职务列表放进session中方便下面遍历
%>
<div class="container-fluid">
	<div class="row-fluid">
		<div class="span12">
		<center>
		<h2 class="text-info text-center">
			<a href="<%=request.getContextPath()%>/purchaseorderservlet.do?pageItem=0">
					<button type="submit" class="btn" onclick="javascript:window.location.href='showpurchaseorder.jsp';">返回</button>
			</a>
			订单信息填写
		</h2>
			<form class="form-horizontal" role="form" action="<%=basePath%>addservlet.do"
			method="post">
				<fieldset>
					 <legend class=" text-center">信息填写</legend> 
					 <label>订单编号：</label><input type="text" name="purchaseId" size=15 /> 
					 <label>
					 	采购员编号：<select class="form-control" id="employeeId" name="employeeId" style="width:150px">
                                <option value="">--请选择--</option>
                                <c:forEach items="${liste}" var="employee">
                                    <option value="${employee}">${employee}</option>
                                </c:forEach>
                     	</select>
                     </label>
					 <label>供应商编号：<select class="form-control" id="peeId" name="peeId" style="width:150px">
                                <option value="">--请选择--</option>
                                <c:forEach items="${listp}" var="provider">
                                    <option value="${provider}">${provider}</option>
                                </c:forEach>
                     </select>
					 </label>
					 <!--  <input type="text" size=15 /> -->
					 <label>采购时间：<input style="width:150px" type="date" class="form-control" id="create_orderDate" placeholder="时间" required   name="purchaseDate"/>
					 </label>
					
					 <button class="btn btn-default" name="purchaseInsert" value="1" type="submit" class="btn">提交</button>
					 <legend class=" text-center">详情填写</legend> 
				</fieldset>
			</form>
		</center>
		<center>
			<form class="form-horizontal" role="form" action="<%=basePath%>addservlet.do?purchaseId=<%=purchaseId %>"
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
						<button class="btn btn-info"  onclick="check(<%=purchaseId %>)" name="purchaseInsert" value="2" type="submit">确认</button>
				</form>
		</center>
		</div>
	</div>
</div>
</body>
</html>