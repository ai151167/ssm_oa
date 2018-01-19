var pageSize =5;
var orgOper;
var count;
var page;
$(function() {
	loadOrgPageInfo(1);
	orgOper = new OrgOper();
	$("#queryButton").bind("click", function() {
		loadOrgPageInfo(1);
	});
	$("#resetButton").bind("click", function() {
		$("#qry_orgName").val('');
		$("#qry_state").val('');
		$("#qry_orgParentId").val('');
		$("#qry_orgParentName").val('');
		loadOrgPageInfo(1);
	});
});

function loadOrgPageInfo(startPage) {
	var param = new Object();
	param.startIndex = (startPage-1) * pageSize;
	param.orgName = $("#qry_orgName").val();
	param.state = $("#qry_state").val();
	param.orgParentId = $("#qry_orgParentId").val();
	param.pageSize = pageSize;
	$.ajax({
		url : "/org/queryOrgList",
		async : true,
		data : param,
		type : "GET",
		success : function(response) {
			if (response != null) {
				$("#pageListContainer").empty();
				$("#pageListContainer").html(response);
				loadOrgPageNumber(startPage);
			}
		}
	});
}
	function loadOrgPageNumber(startPage) {
		$("#pageNumberToolBar").empty();
		$("#pageNumberToolBar").paging({
		    pageNo:startPage,
		    totalPage: page,
		    totalSize: count,
		    callback: function(num) {
		    	loadOrgPageInfo(num);
		    }
		});
}