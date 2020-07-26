<%@ page language="java" contentType="text/html; charset=UTF-8"
				 pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<script type="text/javascript" src ="<%=request.getContextPath() %>/static/js/jquery-1.12.4.min.js" ></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/static/validate/jquery.validate.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/static/layer/layer-v3.1.1/layer/layer.js"></script>
	<script type="text/javascript">

		function Pwd(){
			var index = layer.load(1,{shade:0.3});
			$.post("<%=request.getContextPath()%>/user/newPwd",
					$("#fm").serialize(),
					function(data){
						layer.close(index);
						if (data.code != 200){
							layer.msg(data.msg, {icon: 2});
							return;
						} else {
							layer.msg(data.msg,{icon: 6}, function(){
								parent.location.href = "<%=request.getContextPath()%>/user/toLogin"
							});
						}

					})
		}
	</script>
</head>
<body>
 <form id = "fm">
	 <input type="hidden" name="userEmail" value="${us.userEmail}"/>
	 <input type="password" placeholder="新密码" name="newPwd">
	 <input type="password" placeholder="确认密码" name="newPwdTo">
	 <input type="button" value = "确认" onclick = "Pwd()"/>
 </form>
</body>
</html>