<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src = "<%=request.getContextPath()%>/static/js/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src = "<%=request.getContextPath()%>/static/layer/layer-v3.1.1/layer/layer.js"></script>
<title>Insert title here</title>
</head>
<script type="text/javascript">

</script>
<body>
    <c:if test="${user.userLevel == 2}">
        <h2><a href="<%=request.getContextPath()%>/home/toShow" target="right">挑选座位</a></h2>
        <h2><a href="<%=request.getContextPath()%>/menu/toShow" target="right">我要点餐</a></h2>
        <h2><a href="<%=request.getContextPath()%>/track/toShow" target="right">点餐记录</a></h2>
    </c:if>
    <c:if test="${user.userLevel == 3}">
        <h2><a href="<%=request.getContextPath()%>/home/toShow" target="right">挑选座位</a></h2>
        <h2><a href="<%=request.getContextPath()%>/menu/toShow" target="right">我要点餐</a></h2>
        <h2><a href="<%=request.getContextPath()%>/track/toShow" target="right">点餐记录</a></h2>
    </c:if>
    <c:if test="${user.userLevel == 4}">
        <h2><a href="<%=request.getContextPath()%>/menu/toShow" target="right">菜品展示</a></h2>
        <h2><a href="<%=request.getContextPath()%>/recondite/toShow" target="right">待接单</a></h2>
        <h2><a href="<%=request.getContextPath()%>/track/toHand" target="right">总营业额</a></h2>
    </c:if>
    <c:if test="${user.userLevel == 5}">
        <h2><a href="<%=request.getContextPath()%>/recondite/toShow" target="right">商家准备</a></h2>
    </c:if>
</body>
</html>