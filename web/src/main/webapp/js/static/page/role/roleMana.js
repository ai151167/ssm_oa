var pageSize = 3;
var count;
var page;
var roleOper;
$(function(){
	loadRolePage(1);
	roleOper = new RoleOper();
	$("#queryButton").click(function(){
		loadRolePage(1);
	});
	$("#resetButton").click(function(){
		$("#qry_roleName").val("");
		$("#qry_state").val("");
		loadRolePage(1);
	})
});

function loadRolePage(startPage){
	var param = new Object();
	param.startIndex = (startPage-1)*pageSize;
	param.pageSize = pageSize;
	param.roleName = $("#qry_roleName").val();
	param.state = $("#qry_state").val();
	$.ajax({
		url : "/role/queryRoleList",
		async : true,
		type : "POST",
		data: param,
		success:function(data){
			if(data!=null){
				$("#pageListContainer").empty();
				$("#pageListContainer").html(data);
				loadPageInfo(startPage);
			}
		}
	});
}

function loadPageInfo(startPage){
	$("#pageNumberToolBar").empty();
	$("#pageNumberToolBar").paging({
	    pageNo:startPage,
	    totalPage: page,
	    totalSize: count,
	    callback: function(num) {
	    	loadRolePage(num);
	    }
	});
}