<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src = "<%=request.getContextPath()%>/static/js/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src = "<%=request.getContextPath()%>/static/layer/layer-v3.1.1/layer/layer.js"></script>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/jquery-dh/css/index.css">
<title>Insert title here</title>
</head>
<script type="text/javascript">
    $(function(){
        var thisTime;
        $('.nav-ul li').mouseleave(function(even){
            thisTime	=	setTimeout(thisMouseOut,1000);
        })

        $('.nav-ul li').mouseenter(function(){
            clearTimeout(thisTime);
            var thisUB	=	$('.nav-ul li').index($(this));
            if($.trim($('.nav-slide-o').eq(thisUB).html()) != "")
            {
                $('.nav-slide').addClass('hover');
                $('.nav-slide-o').hide();
                $('.nav-slide-o').eq(thisUB).show();
            }
            else{
                $('.nav-slide').removeClass('hover');
            }

        })

        function thisMouseOut(){
            $('.nav-slide').removeClass('hover');
        }

        $('.nav-slide').mouseenter(function(){
            clearTimeout(thisTime);
            $('.nav-slide').addClass('hover');
        })
        $('.nav-slide').mouseleave(function(){
            $('.nav-slide').removeClass('hover');
        })

    })
</script>
<body>
    <div class="nav-main">
        <div class="nav-box">
            <div class="nav">
                <ul class="nav-ul">
                    <li><a href="#" class="develop"><span>口号</span></a></li>
                    <li><a href="#" class="wechat"><span>欢迎点餐</span></a></li>
                    <li><a href="#" class="news"><span>开发人员</span></a></li>
                    <li><a href="#" class="contact"><span>关于我们</span></a></li>
                </ul>
            </div>
            <div class="nav-slide">
                <div class="nav-slide-o">
                    <li><a href="#" target="right"><span>奥利给</span></a></li>
                </div>
                <div class="nav-slide-o">
                    <ul>
                        <c:if test="${user.userLevel == 2}">
                            <li><a href="<%=request.getContextPath()%>/home/toShow" target="right"><span>挑选座位</span></a></li>
                            <li><a href="<%=request.getContextPath()%>/menu/toShow" target="right"><span>我要点餐</span></a></li>
                            <li><a href="<%=request.getContextPath()%>/track/toShow" target="right"><span>点餐记录</span></a></li>
                        </c:if>
                        <c:if test="${user.userLevel == 3}">
                            <li><a href="<%=request.getContextPath()%>/home/toShow" target="right"><span>挑选座位</span></a></li>
                            <li><a href="<%=request.getContextPath()%>/menu/toShow" target="right"><span>我要点餐</span></a></li>
                            <li><a href="<%=request.getContextPath()%>/track/toShow" target="right"><span>点餐记录</span></a></li>
                        </c:if>
                        <c:if test="${user.userLevel == 4}">
                            <li><a href="<%=request.getContextPath()%>/menu/toShow" target="right"><span>菜品展示</span></a></li>
                            <li><a href="<%=request.getContextPath()%>/user/toShow" target="right"><span>用户信息</span></a></li>
                            <li><a href="<%=request.getContextPath()%>/recondite/toShow" target="right"><span>待接单</span></a></li>
                            <li><a href="<%=request.getContextPath()%>/track/toHand" target="right"><span>总营业额</span></a></li>
                            <li><a href="<%=request.getContextPath()%>/user/toShowUserLevel5" target="right"><span>厨师管理</span></a></li>
                        </c:if>
                        <c:if test="${user.userLevel == 5}">
                            <li><a href="<%=request.getContextPath()%>/recondite/toShow" target="right"><span>商家准备</a></li>
                            <li><a href="<%=request.getContextPath()%>/menu/toShow" target="right"><span>菜品信息</span></a></li>
                        </c:if>
                    </ul>
                </div>

                <div class="nav-slide-o">
                    <ul>
                        <li><a href="#"><span>杨承雨</span></a></li>
                        <li><a href="#"><span>常  凯</span></a></li>
                        <li><a href="#"><span>成素鑫</span></a></li>
                        <li><a href="#"><span>侯鸿倩</span></a></li>
                    </ul>
                </div>
                <div class="nav-slide-o">
                    <ul>
                        <li><a href="#"><span>企业建站</span></a></li>
                        <li><a href="#"><span>企业合作</span></a></li>
                        <li><a href="#"><span>企业版权</span></a></li>
                        <li><a href="#"><span>企业规划</span></a></li>
                        <li><a href="#"><span>企业结构</span></a></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</body>
</html>