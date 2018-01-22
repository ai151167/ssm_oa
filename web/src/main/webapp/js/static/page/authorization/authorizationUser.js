function queryAuthUser(startPage){
	
	/**
	 * 加载授权的组织分页信息
	 */
	var param = new Object();
	param.startIndex = (startPage-1)*pageSize;
	param.pageSize = pageSize;
	param.roleId = $("#qry_roleId").val();
	param.auth = "user";
	$.ajax({
		url:"/authorization/queryAuthUser",
		async:true,
		data:param,
		type:"POST",
		success:function(response){
			if(response!=''){
				$("#pageListContainer").empty();
				$("#pageListContainer").html(response);
				//加载页码
				LoadAuthUserNumber(startPage);
			}
		}
	});
}

function LoadAuthUserNumber(startPage){
	$("#pageNumberToolBar").empty();
	$("#pageNumberToolBar").paging({
	    pageNo:startPage,
	    totalPage: page,
	    totalSize: count,
	    callback: function(num) {
	    	queryAuthUser(num);
	    }
	});
}

/**
 * 删除授权组织
 * @param orgId
 */
function DeleteAuthorizationUser(userId){
	var param = new Object();
	param.userId = userId;
	param.roleId = $("#qry_roleId").val();
	
	$.ajax({
		url:"/authorization/delRoleUserRel",
		async:true,
		data:param,
		type:"POST",
		success:function(response){
			if(response.isOk==true){
				var alerts = layer.alert("删除授权组织成功!",1,function(){
					layer.closeAll();
					queryAuthOrg(1);//刷新页面
				});
			}else{
				var alerts = layer.alert("删除授权组织失败!",5,function(){
					layer.closeAll();
				});
			}
		}
	})
}