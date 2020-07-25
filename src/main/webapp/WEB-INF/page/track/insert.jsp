<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户点餐</title>
	<script type="text/javascript" src ="<%=request.getContextPath() %>/static/js/jquery-1.12.4.min.js" ></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/static/validate/jquery.validate.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/static/layer/layer-v3.1.1/layer/layer.js"></script>
</head>
<script type="text/javascript">
	$().ready(function() {
		$("#fm").validate({
			rules: {
				menuNum: {
					required: true,
					positiveinteger: true
				}
			},
			messages: {
				menuNum: {
					required: "请输入购买数量",
					positiveinteger: '只能是正整数'
				}
			}
		})
	})

	$.validator.setDefaults({
		submitHandler: function() {
			var index = layer.load(1,{shade:0.5});
			$.post("<%=request.getContextPath()%>/track/addTrack",
			$("#fm").serialize(),
			function (data) {
				if(data.code != 200){
					layer.msg(data.msg, {icon: 5});
					layer.close(index);
					return;
				}
					layer.msg(data.msg,{icon:6, time: 2000},function(){
					layer.close(index);
					parent.location.href="<%=request.getContextPath()%>/menu/toShow";
				})
			})
		}
	})

	// 添加自定义校验规则，校验正整数
	jQuery.validator.addMethod("positiveinteger", function(value, element) {
		var Val = parseInt(value);
		return Val > 0 && (Val + "") == value;
	}, "请输入正整数");
</script>
<style>
.error{
	color:red;
}
</style>
<body>
	<h1 align="center">点菜</h1>
	<form id="fm">
		<input type = "hidden" name = "userId" value = "${user.id}"/>
		<input type = "hidden" name = "menuId" value = "${menu.id}"/>
		<input type = "hidden" name = "recoId" value = "${recondite.id}"/>
		菜品名：${menu.menuName}<br/>
		菜品价格：<input type = "text" value = "${menu.menuPrice}" name = "menuPrice"/><br/>
		订购数量：<input type = "text" name = "menuNum"/><br />
		订单备注：<input type = "text" name = "menuConfirm"/><br />
		<input type="submit" value="提交订单" /><br />
	</form>
</body>
</html>