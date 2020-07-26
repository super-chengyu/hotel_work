<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>上架菜品</title>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/static/layer/layui-v2.5.6/layui/css/layui.css"  media="all">
	<script type="text/javascript" src ="<%=request.getContextPath() %>/static/js/jquery-1.12.4.min.js" ></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/static/validate/jquery.validate.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/static/layer/layer-v3.1.1/layer/layer.js"></script>
</head>
<script type="text/javascript">

	jQuery.validator.addMethod("minNumber",function(value, element){
	var returnVal = true;
	inputZ=value;
	var ArrMen= inputZ.split(".");    //截取字符串
	if(ArrMen.length==2){
	if(ArrMen[1].length>2){    //判断小数点后面的字符串长度
		returnVal = false;
		return false;
		}
	}
		return returnVal;
	},"小数点后最多为两位");         //验证错误信息

	$().ready(function() {
		$("#fm").validate({
			rules: {
				menuName: {
					required: true,
					remote: {//ajax验证。server result:{"valid",true or false} 向服务发送当前input name值，获得一个json数据。例表示正确：{"valid",true}
						type: 'POST',
						url: "<%=request.getContextPath()%>/menu/getMenuName",
						data:{
							phone:function() {
								return $("#name").val();
							},
							dataType:"json",
							dataFilter:function(data,type){
								if (data == 'true'){
									return true;
								} else {
									return false;
								}
							}
						}
					}
				},
				menuPrice: {
					required: true,
					number: true,     //输入必须是数字
					min: 0.01,          //输入的数字最小值为0.01，不能为0或者负数
					minNumber: $("#menuPrice").val()    //调用自定义验证
				},
				menuNote: {
					required: true
				}
			},
			messages: {
				menuName: {
					required: "请输入购买数量",
					remote: "已有该菜品"
				},
				menuPrice: {
					required: "请输入菜品价格",
					number: "请正确输入金额",
					min: "输入最小金额为0.01",
					length: "输入数字最多小数点后两位"
				},
				menuNote: {
					required: "请填写菜品介绍"
				}
			}
		})
	})

	$.validator.setDefaults({
		submitHandler: function() {
			var index = layer.load(1,{shade:0.5});
			$.post("<%=request.getContextPath()%>/menu/addMenu",
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

</script>
<style>
.error{
	color:red;
}
</style>
<body>
	<h1 align="center">上架菜品</h1>
	<form id="fm">
		<input type = "hidden" name = "menuStatus" value = "0"/>
		<input type = "hidden" name = "isDel" value = "0"/>
		菜品名：<input type="text" name="menuName" id="name"/><br/>
		菜品价格：<input type="text" name="menuPrice"/><br/>
		菜品介绍：<input type = "text" name = "menuNote"/><br/>
	<button class='layui-btn layui-btn-normal' type='submit'>上架</button>
	</form>
</body>
</html>