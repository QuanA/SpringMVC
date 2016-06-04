var seckill = {
	//秒杀相关ajax的url
	URL : {
		now : function(){
			return '/seckill/time/now';
		},
		exposer : function(seckillId){
			return '/seckill/'+seckillId+'/exposer';
		},
		execution : function(seckillId, md5){
			return '/seckill/'+seckillId+'/'+md5+'/execution';
		},
	},

	//详情页秒杀逻辑
	detail : {
		init : function(params) {
			//手机验证和登录;计时
			var killPhone = $.cookie('killPhone');
			
			if(!seckill.validatePhone(killPhone)){
				var killPhoneModel = $('#killPhoneModel');
				//显示弹出层
				killPhoneModel.modal({
					show : true,
					backdrop : 'static',
					keyboard : false
				});
				$('#killPhoneBtn').click(function(){
					var inputPhone = $('#killPhoneKey').val();
					if(seckill.validatePhone(inputPhone)){
						//刷新页面
						$.cookie('killPhone', inputPhone, {
							expires : 7,
							path : '/seckill'
						});
						window.location.reload();
					}else{
						$('#killPhoneMessage').hide().html('<label class="label label-danger">手机号错误</label>').show(300);
					}
				});
			}
			//登录，计时
			var startTime = params['startTime'];
			var endTime = params['endTime'];
			var seckillId = params['seckillId'];
			$.get(seckill.URL.now(),{},function (result){
				if(result && result['success']){
					var nowTime = result['data'];
					//时间判断
					seckill.countdown(seckillId, nowTime, startTime, endTime);
				}else{
					console.log('result='+result);
				}
			});
			
		}
	},
	
	//验证手机号
	validatePhone : function(phone) {
		if(phone && phone.length == 11 && !isNaN(phone)){
			return true;
		}else{
			return false;
		}
	},
	
	countdown : function(seckillId, nowTime, startTime, endTime){
		var seckillBox = $('#seckill-box')
		if(nowTime > endTime){
			//秒杀结束
			seckillBox.html('秒杀结束');
		}else if(nowTime < startTime){
			//秒杀未开始
			var killTime = new Date(startTime + 1000);
			seckillBox.countdown(killTime,function(event){
				var format = event.strftime('秒杀倒计时：%D天 %H时 %M分 %S秒');
				seckillBox.html(format);
			}).on('finish.countdown',function(){
				//获取秒杀地址
				seckill.handleSeckillKill(seckillId,seckillBox);
			});
		}else{
			//秒杀开始
			seckill.handleSeckillKill(seckillId,seckillBox);
		}
	},
	
	handleSeckillKill : function(seckillId,node){
		node.hide().html('<button class="btn btn-primary btn-lg" id="killBtn">开始秒杀</button>');
		$.post(seckill.URL.exposer(seckillId),{},function(result){
			if(result && result['success']){
				var exposer = result['data'];
				if(exposer['exposer']){
					//开启秒杀
					var md5 = exposer['md5'];
					var killUrl = seckill.URL.execution(seckillId, md5);
					console.log('killUrl='+killUrl);
					//绑定一次点击事件
					$('#killBtn').one('click',function(){
						//1.禁用按钮
						$(this).addClass('disabled');
						//2.发送秒杀请求,执行秒杀
						$.post(killUrl,{},function(result){
							if(result && result['success']){
								var killResult = result['data'];
								var state = killResult['state'];
								var stateInfo = killResult['stateInfo'];
								node.html('<span class="label label-success">'+stateInfo+'</span>');
							}
						});
					});
					node.show();
				} else {
					// 未开启
					var now = exposer['now'];
					var start = exposer['start'];
					var end = exposer['end'];
					seckill.countdown(seckillId, now, start, end);
				}
			}else{
				console.log('result='+result);
			}
		});
		
	},
}