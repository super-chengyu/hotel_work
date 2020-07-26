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
		$.post("<%=request.getContextPath()%>/menu/show",
				$("#fm").serialize(),
				function(data){
				var html = "";
				var pageInfo = "";
				for(var i=0; i<data.data.menuList.length; i++){
					var menu = data.data.menuList[i];
					html+="<tr>"
					html+="<td>	<a href='#' onclick='lo("+menu.id+")'>"+menu.menuName+"</a></td>"
					html+="<td>"
					if(level == 2 || level == 3){
						html+="<button class='layui-btn layui-btn-normal' type='button' onclick = 'toAdd("+menu.id+")'>点菜</button>"
					}
					if(level == 4){
						if(menu.menuStatus == 1){
							html+="<td><button class='layui-btn layui-btn-normal' type='button' onclick = 'ups("+menu.id+")'>上架</button></td>"
						}
						if(menu.menuStatus == 0){
							html+="<td><button class='layui-btn layui-btn-normal' type='button' onclick = 'low("+menu.id+")'>下架</button></td>"
						}
					}
					if(level == 5){
						html+="<button class='layui-btn layui-btn-normal' type='button' onclick = 'upda("+menu.id+")'>修改菜品</button>"
						html+="<button class='layui-btn layui-btn-normal' type='button' onclick = 'updateZero("+menu.id+")'>删除菜品</button>"
					}
					html+="</td>"
					html+="</tr>"
				}
				html+="<td>"
				if(level == 5){
					html+="<button class='layui-btn layui-btn-normal' type='button' onclick = 'add()'>上架菜品</button>"
				}
				html+="</td>"
				pageInfo += "<button type='button' class='layui-btn' onclick = 'page(0, "+data.data.pages+")'><i class='layui-icon'></i></button>";
				pageInfo += "<button type='button' class='layui-btn' onclick = 'page(1, "+data.data.pages+")'><i class='layui-icon'></i></button>";
				$("#tbd").html(html);
				$("#pageInfo").html(pageInfo);
		})
	}

	function updateZero(id){
		var index = layer.load(1,{shade:0.5});
		$.post("<%=request.getContextPath()%>/menu/updateIsDel",
				{"id":id, "isDel":1},
				function (data){
				if(data.code != 200){
					layer.msg(data.msg, {icon: 5, time: 2000});
					return ;
				}
				layer.msg(data.msg, {icon:6, time: 2000},function(){
				layer.close(index);
				search();
				return ;
				})
		})
	}

	function ups(id){
		var index = layer.load(1,{shade:0.5});
		$.post("<%=request.getContextPath()%>/menu/upMenu",
				{"id":id, "menuStatus":0},
				function (data){
				if(data.code != 200){
					layer.msg(data.msg, {icon: 5, time: 2000});
					return ;
				}
				layer.msg(data.msg, {icon:6, time: 2000},function(){
				layer.close(index);
				search();
				return;
				})
		})
	}

	function low(id){
		var index = layer.load(1,{shade:0.5});
		$.post("<%=request.getContextPath()%>/menu/upMenu",
				{"id":id, "menuStatus":1},
				function (data){
					if(data.code != 200){
						layer.msg(data.msg, {icon: 5, time: 2000});
						return ;
					}
					layer.msg(data.msg, {icon:6, time: 2000},function(){
					layer.close(index);
					search();
					return;
				})
		})
	}

	function upda(id){
		layer.open({
		type: 2,
		title: '修改菜品',
		shadeClose: true,
		shade: 0.8,
		area: ['380px', '90%'],
		content: '<%=request.getContextPath()%>/menu/toUpdateMenu/'+id, //iframe的url
		});
	}

	function lo(id){
		layer.open({
		type: 2,
		title: '此菜品介绍',
		shadeClose: true,
		shade: 0.8,
		area: ['380px', '40%'],
		content: '<%=request.getContextPath()%>/menu/toMenuList?id='+id, //iframe的url
		});
	}

	function up(id) {
		var index = layer.load(1, {shade: 0.3})
		$.post("<%=request.getContextPath()%>/menu/upMenu",
			{"id": id, "menuStatus": 0},
			function(data){
			if(data.code != 200){
				layer.msg(data.msg, {icon: 5});
				layer.close(index);
				return;
			}
	})
	}

	function add(){
		layer.open({
		type: 2,
		title: '上架菜品',
		shadeClose: true,
		shade: 0.8,
		area: ['380px', '90%'],
		content: '<%=request.getContextPath()%>/menu/toAddMenu', //iframe的url
		});
	}


	function toAdd(mId){
		layer.open({
		type: 2,
		title: '点餐',
		shadeClose: true,
		shade: 0.8,
		area: ['380px', '90%'],
		content: '<%=request.getContextPath()%>/track/toAddMenu?mId='+mId, //iframe的url
		});
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

	function sel(){
		$("#pageNo").val(1);
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
	<div id = "wirte">
		<button class="layui-btn layui-btn-normal" type="button" onclick = "wirte()">菜品展示</button>
	</div><br/>
	<form id = "fm">
	<c:if test="${level != 5}">
		菜品名：<input type="text" name="menuName"/><br/>
		价格：<input type="text" name="minPrice"/>~<input type="text" name="maxPrice"/><br/>
		<button class="layui-btn layui-btn-normal" type="button" onclick = "sel()">搜索</button>
	</c:if>
		<input type = "hidden" value = "1" id = "pageNo" name = "pageNo"/>
			<div class="layui-form">
			  <table class="layui-table">
			    <colgroup>
			      <col width="200">
			      <col width="150">
			    </colgroup>
			    <thead>
			      <tr>
			        <th>菜品名</th>
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