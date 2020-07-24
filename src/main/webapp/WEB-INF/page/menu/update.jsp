<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改菜品</title>
	<script type="text/javascript" src ="<%=request.getContextPath() %>/static/js/jquery-1.12.4.min.js" ></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/static/layer/layer-v3.1.1/layer/layer.js"></script>
</head>
<script type="text/javascript">
	function update() {
		var index = layer.load(1, {shade: 0.3})
		$.post("<%=request.getContextPath()%>/menu/updateMenu",
			$("#fm").serialize(),
			function(data){
			if(data.code != 200){
				layer.msg(data.msg, {icon: 5});
				layer.close(index);
				return;
			}
			layer.msg(data.msg, {
				icon: 6,
				time: 2000 //2秒关闭（如果不配置，默认是3秒）
			}, function(){
				layer.close(index);
				parent.location.href = "<%=request.getContextPath() %>/menu/toShow"
			});
	})
	}
</script>
<body>
	<h1 align="center">修改菜品</h1>
	<form id="fm">
		<input type="hidden" name="id" value="${menu.id}"/>
		<input type = "hidden" name = "menuStatus" value = "0"/>
		<input type = "hidden" name = "isDel" value = "0"/>
		菜品名：<input type="text" name="menuName" value="${menu.menuName}"/><br/>
		菜品价格：<input type="text" name="menuPrice" value="${menu.menuPrice}"/><br/>
		菜品介绍：<input type = "text" name = "menuNote" value="${menu.menuNote}"/><br/>
		<input type="button" value="修改" onclick="update()"/>
	</form>
</body>
</html>