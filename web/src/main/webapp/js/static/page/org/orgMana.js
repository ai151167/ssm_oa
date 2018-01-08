var pageSize = 3;
var orgOper;
var totalCount;
$(function(){
	loadOrgPageInfo(0);
	
	$("#queryButton").bind("click",function(){
		loadOrgPageInfo(0);
	});
});

function loadOrgPageInfo(startPage){
	var param = new Object();
	param.startIndex = startPage*pageSize;
	param.orgName = $("#qry_orgName").val();
	param.state = $("#qry_state").val();
	param.orgParentId = $("#qry_orgParentId").val();
	
	$.ajax({
		url:"/org/queryOrgList",
		async:true,
		data:param,
		type:"GET",
		success:function(response){
			if(response!=null){
				$("#pageListContainer").empty();
				$("#pageListContainer").html(response);
			}
		}
	});
}