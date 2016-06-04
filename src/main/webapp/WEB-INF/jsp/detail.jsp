<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="common/tag.jsp" %>
<html>
<head>
<title>秒杀详情页</title>
	<%@include file="common/head.jsp" %>
</head>
<body>
	<div class="container">
		<div class="panel panel-default text-center">
			<div class="panel-heading">
			<h1>${seckill.name }</h1>
			</div>
		</div>
		<div class="panel-body">
			<h2 class="text-danger">
				<span class="glyphicon glyphicon-time"></span>
				<span class="glyphicon" id="seckill-box"></span>
			</h2>
		</div>
	</div>
	
	<div id="killPhoneModel" class="model fade">
		<div class="model-dialog">
			<div class="model-content">
				<div class="model-header">
					<h3 class="model-title text-center">
						<span class="glyphicon glyphicon-phone"></span>秒杀电话：
					</h3>
				</div>
				<div class="model-body">
					<div class="row">
						<div class="col-xs-8 clo-xs-offset-2">
							<input type="text" name="killPhone" id="killPhoneKey"
								placeholder="填写手机号" class="form-control"/>
						</div>
					</div>
				</div>
				
				<div class="model-footer">
					<span id="killPhoneMessage" class="glyphicon"></span>
					<button type="button" id="killPhoneBtn" class="btn btn-success">
						<span class="glyphicon glyphicon-phone"></span>
						Submit
					</button>
				</div>
			</div>		
		</div>
	</div>
</body>
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="http://apps.bdimg.com/libs/jquery/2.0.0/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="http://apps.bdimg.com/libs/bootstrap/3.3.0/js/bootstrap.min.js"></script>

<!-- jquery  cookie插件 -->
<script src="http://cdn.bootcss.com/jquery-cookie/1.4.1/jquery.cookie.min.js"></script>
<!-- jquery  倒计时插件 -->

<script src="http://cdn.bootcss.com/jquery.countdown/2.1.0/jquery.countdown.min.js"></script>

<script src="/seckill/resource/script/seckill.js" type="text/javascript"></script>

<script type="text/javascript">
	$(function(){
		seckill.detail.init({
			//使用EL表达式传入参数
			seckillId : ${seckill.seckillId},
			startTime : ${seckill.startTime.time},
			endTime : ${seckill.endTime.time}  
		}); 
	});
</script>


</html>