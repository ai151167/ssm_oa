var pageSize = 3;
var orgOper;
var totalCount;
$(function(){
	loadOrgPageInfo(0);
	orgOper = new OrgOper();
	$("#queryButton").bind("click",function(){
		loadOrgPageInfo(0);
	});
	$("#resetButton").bind("click",function(){
		$("#qry_orgName").val('');
		$("#qry_state").val('');
		$("#qry_orgParentId").val('');
		$("#qry_orgParentName").val('');
		loadOrgPageInfo(0);
	});
});

function loadOrgPageInfo(startPage){
	var param = new Object();
	param.startIndex = startPage*pageSize;
	param.orgName = $("#qry_orgName").val();
	param.state = $("#qry_state").val();
	param.orgParentId = $("#qry_orgParentId").val();
	param.pageSize = pageSize;
	$.ajax({
		url:"/org/queryOrgList",
		async:true,
		data:param,
		type:"GET",
		success:function(response){
			if(response!=null){
				$("#pageListContainer").empty();
				$("#pageListContainer").html(response);
				loadOrgPageNumber(0);
			}
		}
	});
	
function loadOrgPageNumber(startPage){
	var param = new Object();
	param.startIndex = startPage*pageSize;
	param.pageSize = pageSize;
	param.totalCount = totalCount;
	$.ajax({
		url:"/org/getPageNumber",
		async:true,
		data:param,
		type:"GET",
		success:function(response){
			if(response!=null){
				$("#pageNumberToolBar").empty();
				$("#pageNumberToolBar").html(response);
			}
		}
	});
}
}