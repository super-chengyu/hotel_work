show.jsp<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>欢迎光临芙蓉大酒楼</title>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/static/layer/layui-v2.5.6/layui/css/layui.css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/static/loginjs/css/style.css">
	<script type="text/javascript" src="<%=request.getContextPath()%>/static/loginjs/js/vector.js"></script>
	<script type="text/javascript" src = "<%=request.getContextPath()%>/static/js/jquery-1.12.4.min.js"></script>
	<script type="text/javascript" src = "<%=request.getContextPath()%>/static/layer/layui-v2.5.6/layui/layui.all.js"></script>
	<script type="text/javascript" src = "<%=request.getContextPath()%>/static/layer/layer-v3.1.1/layer/layer.js"></script>
	<script type="text/javascript" src = "<%=request.getContextPath()%>/static/slug/jigsaw.js"></script>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/static/slug/jigsaw.css">
<script type="text/javascript">
	
	function login(){
		var index = layer.load(1,{shade:0.3});
		$.post("<%=request.getContextPath()%>/user/loginByNameAndPwd",
				$("#fm").serialize(),
				function(data){
					layer.close(index);
					if (data.code != 200){
						layer.msg(data.msg, {icon: 2});
						return;
					} else {
						layer.msg(data.msg,{icon: 6}, function(){
							parent.location.href = "<%=request.getContextPath()%>/index/toIndex"
						}); 
				}
			
		})
	}

	$(function(){
		Victor("container", "output");   //登录背景函数
		$("#entry_name").focus();
	});

	if(window.top.document.URL != document.URL){
		   //将窗口路径与加载路径同步
		   window.top.location = document.URL;
		   layer.msg("失效，即将返回登录页面", {icon: 5});
		 }

	function register(){
		layer.open({
			type: 2,
			title: '注册用户',
			shadeClose: false,
			shade: 0.3,
			area: ['380px', '90%'],
			content: '<%=request.getContextPath()%>/user/toRegisterUser' //iframe的url
		});
	}
</script>
</head>
<body>
	<div id="container">
		<div id="output">
			<div class="containerT">
			<form id = "fm">
				<input type="text" placeholder="用户名" id="entry_name" name="userName">
				<input type="password" placeholder="密码" id="entry_password" name="userPwd">
				<input type="button" value = "登录" onclick = "login()"/>
				<input type = "button" value = "没有账号？？点我注册" onclick="register()"/>
				<input type = "button" value = "忘记密码？？点我找回"/>
			</form>
			</div>
		</div>
	</div>
</body>
</html>