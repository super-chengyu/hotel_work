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
    var level = ${user.userLevel}
    if(level == 2){
        layer.confirm("您是否想成为会员，如果想点击确认，如果不想点击取消，是否去处理", {icon: 3, title:'提示'}, function(index){
            layer.open({
                type: 2,
                title: '手机号验证',
                shadeClose: true,
                shade: 0.8,
                area: ['380px', '90%'],
                content: '<%=request.getContextPath()%>/user/toUpdateUserLevel3', //iframe的url
            });
            layer.close(index);
        });
    }
</script>
<style>
    .error{
        color:red;
    }
</style>
<body>
</body>
</html>