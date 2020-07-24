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

	$(function(){
		search(1);
	})

	function search(pageNo){
		$.post("<%=request.getContextPath()%>/user/show",
				$("#fm").serialize(),
				function(data){
				var html = "";
				var pageInfo = "";
				for(var i=0; i<data.data.userList.length; i++){
					var user = data.data.userList[i];
					if(user.userLevel == 3){
						html += "<tr style = 'color:red'>";
					}else{
						html += "<tr>"
					}
					html+="<td>"+user.userName+"</td>"
					html+="<td>"+user.userEmail+"</td>"
					html+="<td>"+user.userPhone+"</td>"
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

</head>
<body>
	<div id = "wirte">
		<button class="layui-btn layui-btn-normal" type="button" onclick = "wirte()">用户</button>
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
			        <th>用户姓名</th>
					<th>用户邮箱</th>
					<th>用户手机号</th>
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