<%--
  Created by IntelliJ IDEA.
  User: dj
  Date: 2020/7/24
  Time: 15:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src = "<%=request.getContextPath()%>/static/js/jquery-1.12.4.min.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/static/validate/jquery.validate.js"></script>
    <script type="text/javascript" src = "<%=request.getContextPath()%>/static/layer/layer-v3.1.1/layer/layer.js"></script>
</head>
<script type="text/javascript">
    $().ready(function() {
        $("#fm").validate({
            rules: {
                userPhone: {
                    required: true,
                    rangelength: [9, 12],
                    positiveinteger: true
                }
            },
            messages: {
                userPhone: {
                    required: "请输入购买数量",
                    rangelength: "至少9~12位数",
                    positiveinteger: '只能是正整数'
                }
            }
        })
    })

    $.validator.setDefaults({
        submitHandler: function() {
            var index = layer.load(1,{shade:0.5});
            $.post("<%=request.getContextPath()%>/user/updateUserLevel3",
                $("#fm").serialize(),
                function (data) {
                    if(data.code != 200){
                        layer.msg(data.msg, {icon: 5});
                        layer.close(index);
                        return;
                    }
                    layer.msg(data.msg,{icon:6, time: 2000},function(){
                        layer.close(index);
                        parent.location.href="<%=request.getContextPath()%>/user/toShow";
                    })
                })
        }
    })

    // 添加自定义校验规则，校验正整数
    jQuery.validator.addMethod("positiveinteger", function(value, element) {
        var Val = parseInt(value);
        return Val > 0 && (Val + "") == value;
    }, "请输入正整数");
</script>
<style>
    .error{
        color:red;
    }
</style>
<body>
<form id = "fm">
    <input type="hidden" name="id" value="${user.id}" />
    手机号<input type="text" name="userPhone" />
    <input type = "submit" value = "输入手机号可成为会员" />
</form>
</body>
</html>
