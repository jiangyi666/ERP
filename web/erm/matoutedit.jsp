<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>|
<!DOCTYPE html>
<html>
  
  <head>
    <meta charset="UTF-8">
    <title>欢迎页面-X-admin2.0</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">

    <link rel="stylesheet" href="<%=basePath%>commons/css/font.css">
    <link rel="stylesheet" href="<%=basePath%>commons/css/xadmin.css">
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>commons/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="<%=basePath%>commons/js/xadmin.js"></script>
    <script src="http://libs.baidu.com/jquery/1.9.0/jquery.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/2.0.0/handlebars.js"></script>    
  </head>
  
  <body>
    <div class="x-body">
       <form class="layui-form" id="matform">          
       </form>
    </div>
    
    <script type="text/template" id="product-list-tepl">
        
	{{#each this}}
		 <div class="layui-form-item">
              <label for="matId" class="layui-form-label">
                  		物料编号
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="matId" name="matId" value="{{matId}}" lay-verify="matId"
                  autocomplete="off" class="layui-input">
              </div>
          </div>

        <div class="layui-form-item">
              <label for="matname" class="layui-form-label">
                  		物料名称
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="matname" name="matname" value="{{matName}}" lay-verify="matname"
                  autocomplete="off" class="layui-input">
              </div>
          </div>
          <div class="layui-form-item">
              <label for="brand" class="layui-form-label">
                       	品牌
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="brand" name="" value="{{brand}}" lay-verify="brand"
                  autocomplete="off" class="layui-input">
              </div>
          </div>
           
          <div class="layui-form-item">
              <label for="matSpec" class="layui-form-label">
                       	规格
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="matSpec" name="matSpec" value="{{matSpec}}"
                  autocomplete="off" class="layui-input">
              </div>
          </div>
        
		 <div class="layui-form-item">
              <label for="gram" class="layui-form-label">
                       	克重
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="gram" name="gram" value="{{gram}}"
                  autocomplete="false" class="layui-input">
              </div>
          </div>
          
          <div class="layui-form-item">   
			  <label for="outqty" class="layui-form-label">
			    	   出货数量
			  </label>
              <div class="layui-input-inline">
                  <input type="text" id="outqty" name="outqty"
                  autocomplete="off" class="layui-input">
              </div>
          </div>
           <div class="layui-form-item">
              <label for="L_repass" class="layui-form-label">
              </label>
              <button  class="layui-btn" lay-filter="add" id="L_repass" lay-submit="">
              		确认
              </button>
          </div>
    {{/each}}
     
    </script>
    
    <script>
      layui.use(['form','layer','table'], function(){
          $ = layui.jquery;
          var table=layui.table;
		  var form = layui.form;
		  var layer = layui.layer;
		  
		   var params={};
		   params=GetRequest();
	       var matId=params['matId'];
	       var amount=params['amount'];
	 
		
        $.ajax({
        	url:"<%=basePath%>getmaterriel",
        	type:"Get",
        	dataType:"json",
        	data:{"matId":matId},
        	success:function(data){
        		var tpl=$("#product-list-tepl").html();
        		var template=Handlebars.compile(tpl);
        		var html=template(data);
        		$("#matform").html(html);
        	}
        		
        });
        //获取等号后面的值
     	 function GetRequest() {
			var url = location.search;
			var theRequest = new Object();
			if (url.indexOf("?") != -1) {
			var str = url.substr(1);
			strs = str.split("&");
			for (var i = 0; i < strs.length; i++) {
			  theRequest[strs[i].split("=")[0]] = decodeURI(strs[i].split("=")[1]);
				}
			}
	          return theRequest;
	     } 
       
        //监听提交
        form.on('submit(add)', function(data){
          
	     	console.log(data.field);	
			data.field.amount=amount;
			console.log(data.field);
			var mess=data.field;
	          //发异步，把数据提交给php
	          $.ajax({
	        	  url:"<%=basePath%>matoutstor",
	        	  type:"Get",
	        	  data:data.field,
	        	  success:function(data){
	        		  // 获得frame索引
	        		  
	        		  if(data){
	        			  layer.alert("出仓成功", {icon: 6},function () {
	        				 var index = parent.layer.getFrameIndex(window.name);
		                      //关闭当前frame
		                  
		                     parent.layer.close(index);
		                      
		                  });
	        		  }else{
	        			  alert("出仓失败！");
	        		  }
	        	  }
	          });         
	          
        	 return false;
        });
        
      });
  </script>
  </body>

</html>