<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>欢迎光临芙蓉大酒楼</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/static/layer/layui-v2.5.6/layui/css/layui.css"  media="all">
    <script type="text/javascript" src ="<%=request.getContextPath() %>/static/js/jquery-1.12.4.min.js" ></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/static/validate/jquery.validate.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/static/layer/layer-v3.1.1/layer/layer.js"></script>
    <script type="text/javascript">
        //自定义手机号验证
        jQuery.validator.addMethod("isphoneNum", function(value, element) {
            var length = value.length;
            var mobile = /^1[3|5|8]{1}[0-9]{9}$/;
            return this.optional(element) || (length == 11 && mobile.test(value));
        }, "请正确填写您的手机号码");

        $().ready(function() {
            // 在键盘按下并释放及提交后验证提交表单
            $("#fm").validate({
                rules: {
                    userName: {
                        required: true,
                        minlength: 2
                    },
                    userPwd: {
                        required: true,
                        minlength: 3
                    },
                    userPhone: {
                        required: true,
                        maxlength:11,
                        maxlength:11,
                        isphoneNum:true
                    },
                    userEmail:{
                        required : true,
                        email : true,
                        remote: {//ajax验证。server result:{"valid",true or false} 向服务发送当前input name值，获得一个json数据。例表示正确：{"valid",true}
                            type: 'POST',
                            url: "<%=request.getContextPath()%>/user/getEmail",
                            data:{
                                phone:function() {
                                    return $("#email").val();
                                },
                                dataType:"json",
                                dataFilter:function(data,type){
                                    if (data == 'true'){
                                        return true;
                                    } else {
                                        return false;
                                    }
                                }
                            }
                        }
                    }
                },
                messages: {
                    userName: {
                        required: "请输入厨师名",
                        minlength: "用户名至少由两个字符组成"
                    },
                    userPwd: {
                        required: "请输入密码",
                        minlength: "密码长度不能小于 3 个字符"
                    },
                    userPhone: {
                        required: "请输入手机号",
                        maxlength:"*请填写11位的手机号",
                        minlength:"*请填写11位的手机号",
                        isphoneNum:"请填写正确的手机号码"
                    },
                    userEmail:{
                        required: "请输入邮箱号",
                        email : "请输入正确格式的邮箱",
                        remote: "该邮箱已存在"
                    }
                }
            })
        });

        $.validator.setDefaults({
            submitHandler: function() {
                var index = layer.load(1, {shade: 0.3})
                $.post("<%=request.getContextPath() %>/user/insertUserLevel5",
                    $("#fm").serialize(),
                    function(data){
                        if(data.code != 200){
                            layer.msg(data.msg, {icon: 5});
                            layer.close(index);
                            return;
                        }
                        layer.msg(data.msg, {
                            icon: 6,
                            time: 2000 //2秒关闭（如果不配置，默认是3秒）
                        }, function(){
                            layer.close(index);
                            parent.location.href = "<%=request.getContextPath() %>/user/toShowUserLevel5"
                        });
                    })
            }
        });
    </script>
</head>
<style>
    .error{
        color:red;
    }
</style>
<body>
<form id = "fm">
    厨师名:<input type="text" name = "userName" id="userName"/><br/>
    密码:<input type="text" name = "userPwd"/><br/>
    手机号:<input type="text" name = "userPhone"/><br/>
    邮箱:<input type="text" name="userEmail" id="email"/><br/>
    <input type="hidden" name="userLevel" value="5"/>
    <input type="hidden" name="isDel" value="0"/>
    <button class='layui-btn layui-btn-normal' type='submit'>注册</button>
</form>
</body>
</html>