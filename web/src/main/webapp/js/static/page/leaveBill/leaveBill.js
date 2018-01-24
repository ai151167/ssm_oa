$(function(){
	var cookies =  document.cookie;
	var cookieList = cookies.split(";");
	var userId = "";
	for(var i=0;i<cookieList.length;i++){
		var cookie = cookieList[i].split("=");
		if(cookie[0]=="userInfo"){
			userId=cookie[1].split("_")[0].substring(1);
		}
	}
	if(userId == ""){
		alert("登录后才能完成此功能！");
	}else{
		$("#user_id").val(userId);
	}
});