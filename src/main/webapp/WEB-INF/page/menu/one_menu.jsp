<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form id="fm">
		<input type="hidden" name="id"/>
		菜品名：${menu.menuName}<br/>
		菜品价格：${menu.menuPrice}<br/>
		菜品介绍：${menu.menuNote}
	</form>
</body>
</html>