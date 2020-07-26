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
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/money/css/normalize.css"/>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/money/css/demo.css"/>

<!--必要样式-->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/money/css/component.css"/>
<script type="text/javascript">


</script>

</head>
<body>
	<div class="container demo-1">
		<div class="content">
			<div id="large-header" class="large-header">
				<canvas id="demo-canvas"></canvas>
				<h1 class="main-title">总营业额：<span class="thin">${priceSum}</span></h1>
			</div>
		</div>
	</div><!-- /container -->
	<script src="<%=request.getContextPath()%>/static/money/js/TweenLite.min.js"></script>
	<script src="<%=request.getContextPath()%>/static/money/js/EasePack.min.js"></script>
	<script src="<%=request.getContextPath()%>/static/money/js/rAF.js"></script>
	<script src="<%=request.getContextPath()%>/static/money/js/demo-1.js"></script>
</body>
</html>