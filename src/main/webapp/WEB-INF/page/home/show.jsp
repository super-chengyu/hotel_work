<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/static/layer/layui-v2.5.6/layui/css/layui.css"  media="all">
<script type="text/javascript" src = "<%=request.getContextPath()%>/static/js/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src = "<%=request.getContextPath()%>/static/layer/layer-v3.1.1/layer/layer.js"></script>



<script type="text/javascript">
	var level = ${user.userLevel}
	
	$(function(){
		search(1);
	})

	function search(pageNo){
		$.post("<%=request.getContextPath()%>/home/showHome",
				$("#fm").serialize(),
				function(data){
				var html = "";
				var pageInfo = "";
				for(var i=0; i<data.data.homeList.length; i++){
					var home = data.data.homeList[i];
					html+="<tr>"
					html+="<td>"+home.homeName+"</td>"
					html+="<td>"+home.homeStatus+"</td>"
					html+="</tr>"
				}
				pageInfo += "<button type='button' class='layui-btn' onclick = 'page(0, "+data.data.pages+")'><i class='layui-icon'></i></button>";
				pageInfo += "<button type='button' class='layui-btn' onclick = 'page(1, "+data.data.pages+")'><i class='layui-icon'></i></button>";
				$("#tbd").html(html);
				$("#pageInfo").html(pageInfo);
		})
	}
	
	//分页
	function page(status, pages){
		var index = layer.load(1,{shade:0.3});
		var page = $("#pageNo").val();
		if(status == 0){
			page--;
			if(page < 1){
				layer.msg("已是首页");
				layer.close(index);
				return;
			}
		}
		if(status == 1){
			page++;
			if(page > pages){
				layer.msg("已是尾页");
				layer.close(index);
				return;
			}
		}
		$("#pageNo").val(page);
		layer.close(index);
		search();
	}
	
</script>

<!-- 去除超链接的下划线 -->
<style type="text/css">
	.a{
		color: red;
	}
	a{text-decoration:none} 
	a:hover{text-decoration:none}
</style>

</head>
<body>
	<c:if test="${user.userLevel == 2}">
		<fieldset class="layui-elem-field layui-field-title" style="margin-top: 10px;">
  			<legend>选择座位</legend>
		</fieldset>
	</c:if>
	<c:if test="${user.userLevel == 3}">
		<fieldset class="layui-elem-field layui-field-title" style="margin-top: 10px;">
			<legend>选择包间或座位</legend>
		</fieldset>
	</c:if>
	<div id = "wirte">
		<button class="layui-btn layui-btn-normal" type="button" onclick = "wirte()">填写报销单</button>
	</div><br/>
	<form id = "fm">
		<input type = "hidden" value = "1" id = "pageNo" name = "pageNo"/>
			<div class="layui-form">
			  <table class="layui-table">
			    <colgroup>
			      <col width="200">
			      <col width="150">
			    </colgroup>
			    <thead>
			      <tr>
			        <th>座位名</th>
					<th>当前状态</th>
			      </tr> 
			    </thead>
			<tbody id = "tbd">
			
			</tbody>
			<tr>
				<td colspan="7" align = "center">
					<div id = "pageInfo">
					</div>
				</td>
			</tr>
		</table>
		</div>
	</form>
</body>
</html>