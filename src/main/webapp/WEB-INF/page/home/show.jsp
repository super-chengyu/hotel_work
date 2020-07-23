<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/res/layui-v2.5.6/layui/css/layui.css"  media="all">
<script type="text/javascript" src = "<%=request.getContextPath()%>/res/js/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src = "<%=request.getContextPath()%>/res/layer-v3.1.1/layer/layer.js"></script>



<script type="text/javascript">
	var level = ${user.userLevel}
	
	
	
	$(function(){
		search(1);
	})
	

	
	
  	//填写
	function wirte(){
		layer.open({
			  type: 2,
			  title: '填写报销单',
			  shadeClose: false,
			  shade: 0.3,
			  area: ['380px', '90%'],
			  content: '<%=request.getContextPath()%>/exp/toAdd?token=${token}' //iframe的url
			}); 	
	}
	
	//审批
	function upda(id){
		layer.open({
			  type: 2,
			  title: '审核报销单',
			  shadeClose: true,
			  shade: 0.3,
			  area: ['380px', '90%'],
			  content: '<%=request.getContextPath()%>/exp/toUpdate/?id='+id+'&token=${token}' //iframe的url
			}); 
	}
	
	//支付
	function upda(id){
		layer.open({
			  type: 2,
			  title: '支付报销单',
			  shadeClose: true,
			  shade: 0.3,
			  area: ['380px', '90%'],
			  content: '<%=request.getContextPath()%>/exp/toUpdate/?id='+id+'&token=${token}' //iframe的url
			}); 
	}
	
	//置顶
	function toTop(isTop, id){
		var index = layer.load(1,{shade:0.3});
		$.post("<%=request.getContextPath()%>/exp/updateTop",
				{"isTop":isTop , "id":id , "token":'${token}'},
				function (data){
					layer.close(index);
					if (data.code == 200){
						layer.msg(data.msg, {icon: 6}); 
						window.location.href = "<%=request.getContextPath()%>/exp/toShow?token=${token}"
						return;
					}
		})
	}
	
	function search(pageNo){
		$.post("<%=request.getContextPath()%>/home/showHome",
				$("#fm").serialize(),
				function(data){
				var html = "";
				var pageInfo = "";
				for(var i=0; i<data.data.homeList.length; i++){
					var home = data.data.homeList[i];
					html+="<tr>"
					html+="<td>"+home.homeName+"</td>"
					html+="<td>"+home.homwStatus+"</td>"
					html+="</tr>"
				}
				pageInfo += "<input type = 'button' value = '上一页' onclick = 'page(0, "+data.data.pages+")'/>";
				pageInfo += "<input type = 'button' value = '下一页' onclick = 'page(1, "+data.data.pages+")'/>";				$("#pageInfo").html(pageInfo);
				$("#tbd").html(html);
				$("#pageInfo").html(pageInfo);
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
	<fieldset class="layui-elem-field layui-field-title" style="margin-top: 10px;">
  		<legend>报销数据表</legend>
	</fieldset>
	<div id = "wirte">
		<button class="layui-btn layui-btn-normal" type="button" onclick = "wirte()">填写报销单</button>
	</div><br/>
	<form id = "fm">
		<input type = "hidden" value = "1" id = "pageNo" name = "pageNo"/>
			<div class="layui-form">
			  <table class="layui-table">
			    <colgroup>
			      <col width="200">
			      <col width="150">
			    </colgroup>
			    <thead>
			      <tr>
			        <th>座位名</th>
					<th>当前状态</th>
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