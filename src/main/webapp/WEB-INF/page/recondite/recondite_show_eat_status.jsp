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

    <script type="text/javascript">
        var level = ${user.userLevel}

            $(function(){
                search(1);
            })

        function search(pageNo){
            $.post("<%=request.getContextPath()%>/recondite/reconditeShowEatStatus",
                $("#fm").serialize(),
                function(data){
                    var html = "";
                    var pageInfo = "";
                    for(var i = 0; i < data.data.reconditeList.length; i++){
                        var recondite = data.data.reconditeList[i];
                        html+="<tr>"
                        if(recondite.eatStatus == 7){
                            html+="<td><a href='#' onclick='updateEatStatus7("+recondite.id+")'>已到店</a></td>"
                        }
                        if(recondite.eatStatus == 8){
                            html+="<td><a href='#' onclick='updateEatStatus8("+recondite.id+")'>已点餐</a></td>"
                        }
                        if(recondite.eatStatus == 9){
                            html+="<td><a href='#' onclick='updateEatStatus9("+recondite.id+")'>餐已好</a></td>"
                        }
                        if(recondite.eatStatus == 10){
                            html+="<td>订单已完成</td>"
                        }
                        html+="<td>"+recondite.userIdShow+"</td>"
                        html+="<td>"+recondite.homeNameShow+"</td>"
                        html+="<td>"+recondite.baseNameShow+"</td>"
                        html+="<td>"+recondite.startTime+"</td>"
                        html+="<td>"+recondite.endTime+"</td>"
                        html+="</tr>"
                    }
                    pageInfo += "<button type='button' class='layui-btn' onclick = 'page(0, "+data.data.pages+")'><i class='layui-icon'></i></button>";
                    pageInfo += "<button type='button' class='layui-btn' onclick = 'page(1, "+data.data.pages+")'><i class='layui-icon'></i></button>";
                    $("#tbd").html(html);
                    $("#pageInfo").html(pageInfo);
                })
        }

        //修改状态
        function updateEatStatus7(id){
            var index = layer.load(1,{shade:0.5});
            $.post("<%=request.getContextPath()%>/recondite/updateEatStatus",
                {"id":id, "eatStatus":8},
                function (data){
                    if(data.code != 200){
                        layer.msg(data.msg, {icon: 5, time: 2000});
                        return ;
                    }
                    layer.msg(data.msg, {icon:6, time: 2000},function(){
                        layer.close(index);
                        search();
                        return ;
                    })
                })
        }

        //修改状态
        function updateEatStatus8(id){
            var index = layer.load(1,{shade:0.5});
            $.post("<%=request.getContextPath()%>/recondite/updateEatStatus",
                {"id":id, "eatStatus":9},
                function (data){
                    if(data.code != 200){
                        layer.msg(data.msg, {icon: 5, time: 2000});
                        return ;
                    }
                    layer.msg(data.msg, {icon:6, time: 2000},function(){
                        layer.close(index);
                        search();
                        return ;
                    })
                })
        }

        //修改状态
        function updateEatStatus9(id){
            var index = layer.load(1,{shade:0.5});
            $.post("<%=request.getContextPath()%>/recondite/updateEatStatus",
                {"id":id, "eatStatus":10},
                function (data){
                    if(data.code != 200){
                        layer.msg(data.msg, {icon: 5, time: 2000});
                        return ;
                    }
                    layer.msg(data.msg, {icon:6, time: 2000},function(){
                        layer.close(index);
                        search();
                        return ;
                    })
                })
        }

        //分页
        function page(status, pages){
            var index = layer.load(1,{shade:0.3});
            var page = $("#pageNo").val();
            if(status == 0){
                page--;
                if(page < 1){
                    layer.msg("已是首页");
                    layer.close(index);
                    return;
                }
            }
            if(status == 1){
                page++;
                if(page > pages){
                    layer.msg("已是尾页");
                    layer.close(index);
                    return;
                }
            }
            $("#pageNo").val(page);
            layer.close(index);
            search();
        }

    </script>

    <!-- 去除超链接的下划线 -->
    <style type="text/css">
        .a{
            color: red;
        }
        a{text-decoration:none}
        a:hover{text-decoration:none}
    </style>

</head>
<body>
<form id = "fm">
    <input type = "hidden" value = "1" id = "pageNo" name = "pageNo"/>
    <div class="layui-form">
        <table class="layui-table">
            <colgroup>
                <col width="200">
                <col width="300">
            </colgroup>
            <thead>
            <tr>
                <th>订单状态</th>
                <th>用户名</th>
                <th>位置</th>
                <th>点餐状态</th>
                <th>开始时间</th>
                <th>完成时间</th>
            </tr>
            </thead>
            <tbody id = "tbd">

            </tbody>
            <tr>
                <td colspan="7" align = "center">
                    <div id = "pageInfo">
                    </div>
                </td>
            </tr>
        </table>
    </div>
</form>
</body>
</html>