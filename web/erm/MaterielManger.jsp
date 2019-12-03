<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>|
<!DOCTYPE html>
<html>

<head>
  <meta charset="UTF-8">
  <title>物料进出仓管理</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <link rel="stylesheet" href="<%=basePath%>commons/css/font.css">
  <link rel="stylesheet" href="<%=basePath%>commons/css/xadmin.css">
  <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
  <script type="text/javascript" src="<%=basePath%>commons/layui/layui.js" charset="utf-8"></script>
  <script type="text/javascript" src="<%=basePath%>commons/js/xadmin.js"></script>

</head>

<body>
  <div class="mytitle">
  		物料进仓管理
  </div>
  
  <div class="x-body">
    <div class="layui-row">
      <form class="layui-form layui-col-md12 x-so">
        <input class="layui-input" placeholder="验货时间" name="start" id="start">     
        <div class="layui-input-inline"  id="layui-input-inline1">        
          <select name="contrller" id="option111" class="layui-form" lay-filter="test">
            <option value="">入库单</option>
          </select>
        </div>

        <div class="layui-input-inline" id="layui-input-inline1">
          <select name="contrller" id="option2">
            <option>入库人员</option>
          </select>
        </div>

        <div class="layui-input-inline"  id="layui-input-inline1">
          <select name="contrller" id="option3">
            <option value="">入库仓库</option>            
          </select>
        </div>    
      </form>
    </div>
    <xblock>
      <button class="layui-btn" onclick="submit()">确认入仓</button>
    </xblock>
    <table class="layui-table">
      <thead>
        <tr>
          <th>进出仓编号</th>
          <th>物料编号</th>
          <th>数量</th>
          <th>验货状态</th>
          <th>采购人员</th>
        </tr>
      </thead>
      <tbody id="hhh">
         
      </tbody>
    </table>
  </div>
  <script>
    layui.use(['laydate', 'form'], function () {
      var laydate = layui.laydate;
      var form=layui.form;      
      //执行一个laydate实例
      laydate.render({
        elem: '#start' //指定元素
      });
      //执行一个laydate实例
      laydate.render({
        elem: '#end' //指定元素
      });        
      //渲染下拉框
      if ($("#option111").children().length === 1) {
        $.ajax({
          url: "<%=basePath%>GetOptionMess",
          type: "Get",
          dataType: "json",
          traditional: true,
          success: function (data) {
            for (var i = 0; i < data.length; i++) {
              var option = document.createElement("option");
              console.log(data[i].purchaseId);
              $(option).val(data[i].purchaseId);
              $(option).text(data[i].purchaseId);
              $('#option111').append(option);
            }            
            layui.form.render('select');
          }
        });
        $.ajax({
            url: "<%=basePath%>getemployeename",
            type: "Get",
            dataType: "json",
            traditional: true,
            success: function (data) {
              for (var i = 0; i < data.length; i++) {
                var option = document.createElement("option");              
                $(option).val(data[i].employeeId);
                $(option).text(data[i].employeename);
                $('#option2').append(option);
              }            
              layui.form.render('select');
            }
          });        
        $.ajax({
            url: "<%=basePath%>getlocation",
            type: "Get",
            dataType: "json",
            traditional: true,
            success: function (data) {
              for (var i = 0; i < data.length; i++) {
                var option = document.createElement("option");
                console.log(data[i].location);
                $(option).val(data[i].location);
                $(option).text(data[i].location);
                $('#option3').append(option);
              }            
              layui.form.render('select');
            }
          });        
      }
      //
      //输出订单的详细信息
	   
		  form.on('select(test)',function(mess){    
		 		console.log(mess.value);
		 		getmessage(mess.value);
		 	}); 

      //
      
    });    
    //得到单号的详细物料信息
    function getmessage(mess){
    	var purchaseId=mess;
    	console.log(purchaseId);
    	console.log(mess);
    	$.ajax({
   	        url: "<%=basePath%>GetAllMateriel",
   	        type: "Get",
   	        dataType: "json",
   	        data:{
   	        	"purchaseId":purchaseId
   	        },
   	        success: function (data) {
   	          var html='';
   	          for (var i = 0; i < data.length; i++) {
   	        	  html +='<tr>'+'<td>'+data[i].matStoreld+'</td>'+
   	        	  		'<td>'+data[i].matId+'</td>'+
   	        	  		'<td>'+data[i].qty+'</td>'+
   	        	  		'<td>'+data[i].inspectionStatus+'</td>'+
   	        	  		'<td>'+data[i].employeeId+'</td>'+'</tr>';
   	          }
   	          $('#hhh').html(html);
   	        }
   	   });  
    }
      //提交
    function submit(){
    	var start=document.getElementById('start').value;//处理日期
    	var option1=document.getElementById('option111').value;//订单号
    	var option2=document.getElementById('option2').value;//验货人
    	var option3=document.getElementById('option3').value;//仓库
    	console.log(option3);
    	$.ajax({
    		url:"<%=basePath%>insertMatstorage",
    		type:"Get",
    		dataType:"json",
    		data:{
	    			"date":start,
	    			"purchaseId":option1,
	    			"employeeId":option2,
	    			"location":option3
    			},
    		success:function(data){
    			if(data){
    				layer.alert("进仓成功");
    						/* {icon: 6},function () {
       				 var index = parent.layer.getFrameIndex(window.name);
	                      //关闭当前frame
	                     parent.layer.table.reload("table1");
	                     parent.layer.close(index);
	                      
	                  }); */
    			}
    		}
    	});
    }
    function selectId(){
    	alert("hhh");
    	var purchaseId=document.getElementById("option111").value;
    	var pur=$("option111").children().length;
 
    }
    
 </script>
</body>
</html>