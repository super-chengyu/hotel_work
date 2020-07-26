<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta http-equiv="Pragma" content="no-cache">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no"/>
		<meta name="format-detection" content="telephone=yes"/>
		<meta name="apple-mobile-web-app-capable" content="yes" />
		<meta name="apple-mobile-web-app-status-bar-style" content="black" />
		<title>绑定信息</title>
		<!-- Bootstrap core CSS-->
	 	<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
	 	<script type="text/javascript" src = "<%=request.getContextPath()%>/static/js/jquery-1.12.4.min.js"></script>
		<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
		<script type="text/javascript" src = "<%=request.getContextPath()%>/static/layer/layer-v3.1.1/layer/layer.js"></script>
		<style type="text/css">
			body{
				margin: 0;
				padding: 0; 
			}	 
			.modal_content{
				padding: 30px;
				display: flex;
				justify-content: center;
				flex-direction: column; 
			}
			
			.modal_content>div{
				margin-bottom: 20px;
			}
			.modal_content>h5:first-child{
				margin:30px 0px;
			}
			#dialog label{
				 color: #666;
			}
			#phone{
				display: block;
				width: 100%;
				height: 70px; 
				background: none;
				padding-top: 30px;	
				border: 0;
				outline:none;
				text-align: center;	
				margin-top: -30px; 
				font-size: 16px;
				border-bottom: 1px solid rgba(0,0,0,.2);
				border-radius: 0;
			}
			.code1{
				display: flex;
				flex-direction: row;
				justify-content: space-between;	
				width: 100%;
				height: 70px; 
				background: none; 
				padding-top: 30px;	
				margin-top: -30px; 
				font-size: 16px;
				border-bottom: 1px solid rgba(0,0,0,.2);
				border-radius: 0;
			}
			#code1{  
				width: calc(100% - 90px);
				height: 55px; 
				background: none; 
				padding-top: 20px;	
				border: 0;
				outline:none;
				text-align: center;	
				margin-top: -20px; 
				font-size: 16px;  
			}
			#btnSendCode1{
				width: 90px;
				height: 30px;  
				padding: 0 5px;
				margin: 0;
				font-size: 14px;
				text-align: center;
				background: transparent;
				border-radius: 30px;
				color: #a07941;
				border-color: #a07941;
				 
			}
			::-webkit-input-placeholder { /* WebKit browsers */
				font-size: 14px;
			    color:   rgba(0,0,0,.4);
			}
			:-moz-placeholder { /* Mozilla Firefox 4 to 18 */
				font-size: 14px;
			    color:   rgba(0,0,0,.4);
			}
			::-moz-placeholder { /* Mozilla Firefox 19+ */
				font-size: 14px;
			    color:  rgba(0,0,0,.4);
			}
			:-ms-input-placeholder { /* Internet Explorer 10+ */
				font-size: 14px;
			    color:   rgba(0,0,0,.4);
			}
				
			.next{
				text-align: center;
				margin: 20px 0;
			}
			.next button{
				width: 100%; 
				height: 45px;
				padding: 0;
				margin: 0;
				background: #007BFF;
				color: #fff;
				border: 0;
				outline:none;
				border-radius: 3px;
			}		
	</style>
	</head>
	<body>
				 
		<div class="modal_content">		
			<h5>密码找回!</h5>
			<form id = "fm">
			<div>
				<label for="phone1">邮箱号：</label><br />
				<input id="phone" type="text" name = "userEmail" autocomplete="off" placeholder="请输入已绑定的邮箱号"/>				
			</div> 
			<div>
				<label for="code1">验证码：</label>
				<div class="code1">
					<input id="code1" type="text" name = "userCode" autocomplete="off" placeholder="短信验证码"/>				
					<input id="btnSendCode1" type="button" class="btn btn-default" value="获取验证码" onClick="getEmailNum()" />
				</div>				
			</div>
			</form> 	
			<div class="next">  			
				<button onclick="codeLogin()">确定</button>
			</div>
		</div>	 	
		<script src="<%=request.getContextPath()%>/static/js/jquery-1.12.4.min.js"></script>
    	<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  		 
		<script>
			var phoneReg = /(^1[3|4|5|7|8]\d{9}$)|(^09\d{8}$)/;//手机号正则 
			var count = 60; //间隔函数，1秒执行
			var InterValObj1; //timer变量，控制时间
			var curCount1;//当前剩余秒数
			/*第一*/
			function getEmailNum() {
				curCount1 = count;		 		 
				/* var phone = $.trim($('#phone').val());
				if (!phoneReg.test(phone)) {
					layer.msg("请输入有效的手机号码"); 
					return false;
				} */
				//设置button效果，开始计时
				$("#btnSendCode1").attr("disabled", "true");
				$("#btnSendCode1").val( + curCount1 + "秒再获取");
				InterValObj1 = window.setInterval(SetRemainTime1, 1000); //启动计时器，1秒执行一次
				//向后台发送处理数据
				var index = layer.load(1,{shade:0.3});
				$.post("<%=request.getContextPath()%>/user/getEmailCode",
					$("#fm").serialize(),
					function(data){
						if (data.code != 200){
							layer.msg(data.msg); 
							layer.close(index);
							return;
						} else {
							layer.msg(data.msg); 
							layer.close(index);
						}
					})	 
			}
			
			function SetRemainTime1() {
				if (curCount1 == 0) {                
					window.clearInterval(InterValObj1);//停止计时器
					$("#btnSendCode1").removeAttr("disabled");//启用按钮
					$("#btnSendCode1").val("重新发送");
				}
				else {
					curCount1--;
					$("#btnSendCode1").val( + curCount1 + "秒再获取");
				}
			} 
			
			/*提交*/
			function codeLogin(){
				var index = layer.load(1,{shade:0.3});
				$.post("<%=request.getContextPath()%>/user/recovery",
						$("#fm").serialize(),
						function(data){
				            var userEmail = data.data.userEmail
							if (data.code != 200){
								layer.close(index);
								layer.msg(data.msg, {icon: 2}); 
								return;
							} else {
								layer.msg(data.msg);
								layer.close(index);
								parent.location.href = "<%=request.getContextPath()%>/user/toNewPwd?userEmail="+userEmail //iframe的url
						}

					})
			}
		</script>
	</body>
</html>
