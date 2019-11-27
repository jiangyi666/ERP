<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>no power</title>
<script type="text/javascript">	
	
layui.use('layer',function(){
var layer = layui.layer;
    layer.ready(function(){

      layer.msg('没有权限！');

    });  
});
</script>
  </head>
  
  <body>
  
  </body>
</html>
