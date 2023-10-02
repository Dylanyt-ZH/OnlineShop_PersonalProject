function change(img){
	img.src="getcode?"+new Date().getTime();
}

function FocusItem(obj){
	
	if($(obj).attr("name")=="veryCode"){
		$(obj).next().next('span').html("").removeClass("error");
	}
	else{
		$(obj).next("span").html("").removeClass("error");
	}
	
	
}

var flag=true;

function CheckItem(obj){
	var msgbox=$(obj).next("span");
	switch($(obj).attr("name")){
	case "userName":
		if(obj.value==''){
			msgbox.html("用户名不能为空");
			msgbox.addClass("error");
			flag=false;
		}
		else{
			var url='usernamecheck?username='+encodeURI($(obj).val())+"&"+new Date().getTime();
			
			//从servlet接收从数据库的返回值，true代表此用户名可用，false代表不可用
			$.get(url,function(data){
				if(data=="false"){
					msgbox.html('该用户已被注册，请使用其他用户名');
					msgbox.addClass('error');
					flag=false;
				}
				else{
					msgbox.html("该用户名可以使用！");
					msgbox.addClass('right');
					flag=true;
				}
			});
		}
		break;
		
	case "name":
		if(obj.value==''){
			msgbox.html("用户姓名不能为空");
			msgbox.addClass("error");
			flag=false;
		}else{
			flag=true;
		}
		break;
		
	case "password":
		if(obj.value==''){
			msgbox.html("密码不能为空");
			msgbox.addClass("error");
			flag=false;
		}else{
			flag=true;
		}
		
		break;
		
	case "address":
		if(obj.value==''){
			msgbox.html("收获地址不能为空");
			msgbox.addClass("error");
			flag=false;
		}else{
			flag=true;
		}
		
		break;
		
	case "repassword":
		if(obj.value==''){
			msgbox.html("确认密码不能为空");
			msgbox.addClass("error");
			flag=false;
		}
		else if($(obj).val()!=$('input[name="password"]').val() ){
			msgbox.html("两次密码输入不一致，请检查后重新输入");
			msgbox.addClass("error");
			flag=false;
		}
		else{
			flag=true;
		}
		break;
	
	case "veryCode":
		var numshow =$(obj).next().next("span");
		if(obj.value==''){
			numshow.html("验证码不能为空");
			numshow.addClass("error");
			flag=false;
		}else{
			var url="checkusernum?num="+encodeURI($(obj).val())+"&"+new Date().getTime();
			$.get(url,function(numdata){
				if(numdata=="false"){
					numshow.html('验证码输入有误，请重新输入');
					numshow.addClass("error");
					flag=false;
				}else{
					numshow.html("验证码输入正确");
					numshow.addClass('right');
					flag=true;
				}
					
			});
		}
		break;
	
	}
}


function checkform(form){
	var els=form.getElementsByTagName('input');
	
	//onblur根据此属性进行验证
	for(var i=0;i<els.length;i++){
		if(els[i]!=null){
			if(els[i].getAttribute("onblur")){
				CheckItem(els[i]);
			}
		}
	}
	
	return flag;
}