var pageSize = 5;
var count;
var page;
var userOper;
$(function(){
	loadUserPage(1);
	userOper = new UserOper();
	$("#queryButton").click(function(){
		loadUserPage(1);
	});
	$("#resetButton").click(function(){
		$("#qry_orgId").val("");
		$("#qry_orgName").val("");
		$("#qry_userChName").val("");
		$("#qry_mobilePhone").val("");
		$("#qry_provinceId").val("");
		$("#qry_cityId").val("");
		$("#qry_countryId").val("");
		loadUserPage(1);
	});
	$("#qry_provinceId").click(function(){
		var areaParentId = "CHN";
		loadProvinceInfo(areaParentId,'1');
	});
	$("#qry_cityId").click(function(){
		var areaParentId = $("#qry_provinceId").val();
		loadProvinceInfo(areaParentId,'2');
	});
	$("#qry_countryId").click(function(){
		var areaParentId = $("#qry_cityId").val();
		loadProvinceInfo(areaParentId,'3');
	});
});

function loadUserPage(startPage){
	var param = new Object();
	param.startIndex = (startPage-1)*pageSize;
	param.pageSize = pageSize;
	param.orgId=$("#qry_orgId").val();
	param.userChName=$("#qry_userChName").val();
	param.mobilePhone=$("#qry_mobilePhone").val();
	param.provinceId=$("#qry_provinceId").val();
	param.cityId=$("#qry_cityId").val();
	param.countryId=$("#qry_countryId").val();
	$.ajax({
		url : "/user/userList",
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
	    	loadUserPage(num);
	    }
	});
}

function loadProvinceInfo(areaParentId,state){
	var param = new Object();
	param.areaParentId=areaParentId;
	$.ajax({
		url : "/area/getBaseArea",
		async : true,
		type : "POST",
		data: param,
		success:function(data){
			if(data!=null){
				var sb = "";
				$.each(data,function(i,area){
					sb +="<option value='"+area.areaId+"'>"+area.areaName+"</option>";
				})
				if(state=='1'){
					$("#qry_provinceId").html(sb);
				}else if(state=='2'){
					$("#qry_cityId").html(sb);
				}else if(state=='3'){
					$("#qry_countryId").html(sb);
				}
				
			}
		}
	});
}