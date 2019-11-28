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
<title>仓库信息</title>


<script type="text/javascript">

	var allData;//所有数据
	var currentBtn;//当前触发模态框按钮的id
//在界面加载是就查村出所有物料资料
$(document).ready(function(){
	
$.ajax({
		
		url:"<%=basePath%>GoodsLocationServlet",
		dataType:"json",
		data:{"oper":"getAllGoodsLocation"},
		success:function(data){
			
	
			allData = data;
			console.log(allData);
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
				tbody += "<tr>"+"<td style=\"width:40%\">"+data[i].location+"</td>"+
												"<td style=\"width:40%\">"+data[i].goodsType+"</td>"+
												
												"<td style=\"width:25%\">"+"<button id=\"update\" class=\"btn btn-success\" onclick=\"showUpdateGoodsLocationInfo(this)\" data-toggle=\"modal\" data-target=\"#myModal\">修改</button>"+
												"<button  class=\"btn btn-danger\" onclick=\"deleteGoodsLocation(this)\">删除</button>"+"</td>"+
						"</tr>";
			}
			$("#tbody").html(tbody);
			
		},
		error:function(){
			console.log("请求失败!");
		}
		
	})

})

	function showUpdateGoodsLocationInfo(dataNode){
			
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
				if($("#仓库编号")[0].value == allData[i].location){
					alert("物料编号重复，添加失败！");
					return false;
				}
			}
		 
		return true;
	}
	function submitGoodsLocationInfo(){
		
		if(!isLegal()){
			return ;
		}
	
		var oper = "";
		if($("#submit")[0].value == "add"){
			oper = "addGoodsLocation";
		}
		if($("#submit")[0].value == "update"){
			oper = "updateGoodsLocation";
		}
			
		var len1 = $("#modal-body")[0].childNodes.length;
		var divnode = $("#modal-body")[0];
		var goodsLocation = {}; 
		
		goodsLocation.location=divnode.childNodes[0].childNodes[1].value;
		goodsLocation.goodsType=divnode.childNodes[2].childNodes[1].value;

	
	 	  	 $.ajax({
				url:"<%=basePath%>GoodsLocationServlet",
				dataType:"text",
				data:{"oper":oper,"goodsLocation":JSON.stringify(goodsLocation)},
				success:function(data){
					console.log("请求成功！");
					location.reload();
				},
				error:function(){
					console.log("请求失败！");
				}
		}); 
	}
	function deleteGoodsLocation(dataNode){
		
		var data = dataNode.parentNode.parentNode;
		var location = data.childNodes[0].innerHTML;
		$.ajax({
			url:"<%=basePath%>GoodsLocationServlet",
			dataType:"text",
			data:{"oper":"deleteGoodsLocation","location":location},
			success:function(){
				console.log("请求成功！");
				window.location.reload();
			},
			error:function(){
				console.log("请求失败！");
			}
		})
		
	}
</script>

</head>
<body>
		<div style="text-align: center;background-color: gainsboro;margin-bottom:70px"><font style="text-align: center;color: black;font-size: xx-large"><b>纸业销售ERP系统</b></font></div>
<center>
	<div style="width:60%;text-align:center">
		<table class="table table-bordered">
		
			<thead id="thead">
			
			</thead>
			<tbody id="tbody">
			
			</tbody>
		</table>
	</div>
	<button class="btn btn-warning" id="add" data-toggle="modal" data-target="#myModal" onclick="showUpdateGoodsLocationInfo(this)">添加仓库</button>
</center>


<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
				</button>
				<h4 class="modal-title" id="myModalLabel">
					仓库管理
				</h4>
			</div>
			<div id="modal-body" class="modal-body">
				
	      	
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭
				</button>
				<button value="" id="submit" type="button" class="btn btn-primary" onclick="submitGoodsLocationInfo()">
					提交
				</button>
			</div>
		</div><!-- /.modal-content -->
	</div><!-- /.modal -->
</div>
</body>
</html>