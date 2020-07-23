<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/static/layer/layui-v2.5.6/layui/css/layui.css"  media="all">
<script type="text/javascript" src = "<%=request.getContextPath()%>/static/js/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src = "<%=request.getContextPath()%>/static/layer/layer-v3.1.1/layer/layer.js"></script>
<script type="text/javascript">

</script>	
</head>
<body style="color: red">
	<center>
	<h1>欢迎${user.userName}登录芙蓉酒楼点餐系统</h1>
	</center>
	<div id="datetime" align="right" style="color:red">
	<script>
 		setInterval("document.getElementById('datetime').innerHTML=new Date().toLocaleString();", 1000);
	</script>
	</div>
</body>
</html>