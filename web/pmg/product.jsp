<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%

    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
　	
	<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">  
   <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
   <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<title>产品</title>

<script type="text/javascript">

	var allData;
	var currentBtn;
//在页面加载的时候就获取所有产品数据
$(document).ready(function(){
	
	$.ajax({
			
			url:"<%=basePath%>productServlet",
			dataType:"json",
			data:{"oper":"getAllProduct"},
			success:function(data){
				allData = data;
				//表头渲染
				var thead = "<tr>";
				for(i=0;i<data[0].length;i++){
					thead +="<th style=\"text-align:center\">"+data[0][i]+"</th>";
				}
				thead += "<th style=\"text-align:center\">操作</th>";
				thead +="</tr>";
				$("#thead").html(thead);
				
				//数据渲染
				var tbody = "";
				for(i=1;i<data.length;i++){
					tbody += "<tr>"+"<td>"+data[i].productId+"</td>"+
													"<td>"+data[i].productName+"</td>"+
													"<td>"+data[i].brand+"</td>"+
													"<td>"+data[i].type+"</td>"+
													"<td>"+data[i].level+"</td>"+
													"<td>"+data[i].gram+"</td>"+
													"<td>"+data[i].productSpec+"</td>"+
													"<td>"+data[i].unit+"</td>"+
													"<td>"+data[i].productPrice+"</td>"+
													"<td style=\"width:140px\">"+"<button id=\"update\" class=\"btn btn-success\" onclick=\"showUpdateProductInfo(this)\" data-toggle=\"modal\" data-target=\"#myModal\">修改</button>"+
													"<button  class=\"btn btn-danger\" onclick=\"deleteProduct(this)\">删除</button>"+"</td>"+
							"</tr>";
				}
				$("#tbody").html(tbody);
				
			},
			error:function(){
				console.log("请求失败!");
			}
			
		})

	})
	//显示模态框
		function showUpdateProductInfo(dataNode){
			
		var model_body = ""; 
		currentBtn = dataNode.id;
		if(dataNode.id == "update"){
			
			var thead_tr = $("#thead")[0].childNodes[0];
			var data = dataNode.parentNode.parentNode;
			var theadLen = thead_tr.childNodes.length;
			model_body +="<div class=\"input-group\">"+
							"<span class=\"input-group-addon\">"+thead_tr.childNodes[0].innerHTML+"</span>"+
							"<input readonly=\"readonly\" id=\""+thead_tr.childNodes[0].innerHTML+"\""+" type=\"text\" class=\"form-control\" value=\""+data.childNodes[0].innerHTML+"\">"+
						 "</div>"+
						"<br>";	
			 for(i=1;i<theadLen-1;i++){
		
				model_body +="<div class=\"input-group\">"+
								"<span class=\"input-group-addon\">"+thead_tr.childNodes[i].innerHTML+"</span>"+
								"<input id=\""+thead_tr.childNodes[i].innerHTML+"\""+" type=\"text\" class=\"form-control\" value=\""+data.childNodes[i].innerHTML+"\">"+
							 "</div>"+
							"<br>";	
			}
			 $("#submit")[0].value="update"; 
		}
		if(dataNode.id == "add"){
			var thead_tr = $("#thead")[0].childNodes[0];
			var theadLen = thead_tr.childNodes.length;

			 for(i=0;i<theadLen-1;i++){
				model_body +="<div class=\"input-group\">"+
								"<span class=\"input-group-addon\">"+thead_tr.childNodes[i].innerHTML+"</span>"+
								"<input id=\""+thead_tr.childNodes[i].innerHTML+"\""+" type=\"text\" class=\"form-control\">"+
							 "</div>"+
							"<br>";	
			}
			 
			 $("#submit")[0].value="add"; 
		}
		 $("#modal-body").html(model_body);
		
	}
	function isLegal(){
		
		console.log($("#modal-body")[0].childNodes[0].childNodes[0].innerHTML);
		var str;
		var inputId;
		var regu = "^[ ]+$";
		var re = new RegExp(regu);
		 for(i=0;i<$("#modal-body")[0].childNodes.length;i+=2)
		{
			str = $("#modal-body")[0].childNodes[i].childNodes[1].value
			  if(typeof str == "undefined" || str == null || str == "" || re.test(str)){
				  inputId = $("#modal-body")[0].childNodes[i].childNodes[0].innerHTML;
				  	alert(inputId+"不能为空！");
			        return false;
			    }
		} 
		 if(currentBtn != "update")
		 for(i=0;i<allData.length;i++){
			if($("#产品编号")[0].value == allData[i].productId){
				alert("产品编号重复，添加失败！");
				return false;
			}
		}
		
		if(!isNumber($("#克重")[0].value)){
			alert("克重必须为数字！");
			return false;
		}
		if(!isNumber($("#单价")[0].value)){
			alert("单价必须为数字！");
			return false;
		} 
		return true;
	}
	//模态框提交请求函数
	function submitProductInfo(){
		//在每一次修改前进行合法性判断。
		if(!isLegal()){
			return ;
		}
		
		 var oper = "";
		if($("#submit")[0].value == "add"){
			oper = "addProduct";
		}
		if($("#submit")[0].value == "update"){
			oper = "updateProduct";
		}
			
		var len1 = $("#modal-body")[0].childNodes.length;
		var divnode = $("#modal-body")[0];
		var product = {}; 
		
		product.productId=divnode.childNodes[0].childNodes[1].value;
		product.productName=divnode.childNodes[2].childNodes[1].value;
		product.brand=divnode.childNodes[4].childNodes[1].value;
		product.type=divnode.childNodes[6].childNodes[1].value;
		product.level=divnode.childNodes[8].childNodes[1].value;
		product.gram=divnode.childNodes[10].childNodes[1].value;
		product.productSpec=divnode.childNodes[12].childNodes[1].value;
		product.unit=divnode.childNodes[14].childNodes[1].value;
		product.productPrice=divnode.childNodes[16].childNodes[1].value;
	
	 	  	 $.ajax({
				url:"<%=basePath%>productServlet",
				dataType:"text",
				data:{"oper":oper,"product":JSON.stringify(product)},
				success:function(data){
					console.log("请求成功！");
					location.reload();
				},
				error:function(){
					console.log("请求失败！");
				}
		});  
	}
	//请求删除函数
	function deleteProduct(dataNode){
		
		var data = dataNode.parentNode.parentNode;
		var productId = data.childNodes[0].innerHTML;
		$.ajax({
			url:"<%=basePath%>productServlet",
			dataType:"text",
			data:{"oper":"deleteProduct","productId":productId},
			success:function(){
				console.log("请求成功！");
				location.reload();
			},
			error:function(){
				console.log("请求失败！");
			}
		})
		
	}
	//判断val是否为数字，如果是返回true，否则返回false
	function isNumber(val) {
	    var regPos = /^\d+(\.\d+)?$/; //非负浮点数
	    var regNeg = /^(-(([0-9]+\.[0-9]*[1-9][0-9]*)|([0-9]*[1-9][0-9]*\.[0-9]+)|([0-9]*[1-9][0-9]*)))$/; //负浮点数
	    if(regPos.test(val) || regNeg.test(val)) {
	        return true;
	        } else {
	        return false;
	        }
	    }
</script>

</head>
<body>

<center>
	<div style="width:80%">
		<table class="table table-bordered" style="text-align: center">
		
			<thead id="thead">
			
			</thead>
			<tbody id="tbody">
			
			</tbody>
		</table>
	</div>
	<button class="btn btn-warning" id="add" data-toggle="modal" data-target="#myModal" onclick="showUpdateProductInfo(this)">添加产品</button>
</center>



<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
				</button>
				<h4 style="text-align:center"class="modal-title" id="myModalLabel">
					产品管理
				</h4>
			</div>
			<div id="modal-body" class="modal-body">
				
	      	
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭
				</button>
				<button value="" id="submit" type="button" class="btn btn-primary" onclick="submitProductInfo()">
					提交
				</button>
			</div>
		</div><!-- /.modal-content -->
	</div><!-- /.modal -->
</div>
</body>
</html>