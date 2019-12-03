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
	  <script type="text/javascript" src="<%=basePath%>commons/js/handlebars.min-v4.5.3.js"></script>
	  <script src="http://libs.baidu.com/jquery/1.9.0/jquery.js"></script>
	  <script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/2.0.0/handlebars.js"></script>
</head>

<body>
 
  <div class="mytitle">
  		物料出仓管理
  </div>
  <div class="x-body">
  	<div class="layui-row">
	    <form class="layui-form layui-col-md12 x-so">
        
	      <div>
	        <input class="layui-input" placeholder="出库时间" name="start" id="start">
	      </div><br>
	      <div class="layui-input-inline" id="layui-input-inline1">
	        <select name="contrller" id="employee" class="layui-form" lay-filter="test">
	          <option value="">操作人员</option>
	        </select>
	      </div>
	    </form>
    </div>
    <table class="layui-table" id="table1">
      <thead>
        <tr>
          <th>原材料库存编号</th>
          <th>原材料编号</th>
          <th>原材料名称</th>
          <th>原材料规格</th>
          <th>剩余材料</th>
          <th>进仓时间</th>
          <th>最低库存</th>
          <th>操作</th>
        </tr>
      </thead>

      <tbody id="hhh">

      </tbody>
    </table>


  </div>
  <script type="text/template" id="product-list-tepl">

	{{#each this}}
        <tr>	
            <td>{{matStoreDetId}}</td>
            <td>{{matId}}</td>
            <td>{{matName}}</td>
            <td>{{matSpec}}</td>
            <td>{{amount}}</td>
            <td>{{date}}</td>
            <td>{{min}}</td>
			<td>
				<a title="编辑"  onclick="matout('编辑','{{matId}}','{{amount}}',600,500)" href="javascript:;">
                	<i class="layui-icon">&#xe642;</i>
           		</a>
			</td>
        </tr>
    {{/each}}
     
    </script>
  <script>

    layui.use(['laydate', 'form', 'table', 'layer'], function () {
      var laydate = layui.laydate;
      var form = layui.form;
      var table = layui.table;
      var layer = layui.layer;
      //执行一个laydate实例
      laydate.render({
        elem: '#start' //指定元素
      });
      //执行一个laydate实例
      laydate.render({
        elem: '#end' //指定元素
      });

      if ($("#employee").children().length === 1) {
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
                  $('#employee').append(option);
                }            
                layui.form.render('select');
              }
            });        
      }

      $.ajax({
        url: "<%=basePath%>Test",
        type: "Get",
        dataType: "json",
        success: function (data) {
          var tpl = $("#product-list-tepl").html();
          var template = Handlebars.compile(tpl);
          var html = template(data);
          $('#hhh').html(html);
        }
      });
    });

    function matout(title, matId, amount, w, h) {
      x_admin_show(title, '<%=basePath%>erm/matoutedit.jsp?matId=' + matId + '&amount=' + amount, w, h);
    }

    function checked() {
      console.log("adf");
      var hhh = $(this).value;
      console.log(hhh);

    }

  </script>
</body>
</html>