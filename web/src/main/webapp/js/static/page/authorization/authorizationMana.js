var pageSize = 3;
var count=0;
var page =1;
$(document).ready(function() {
	InitRoleList();
});

function InitRoleList() {
	var param = new Object();
	var roleSelect = $("#qry_roleId");

	$.getJSON("/authorization/getRoleList", param, function(data) {
		roleSelect.append("<option value=''>请选择:</option>");
		$.each(data, function(key, items) {
			roleSelect.append("<option value='" + items.roleId + "'>"
					+ items.roleName + "</option>");
		});
	})

}

/**
 * 检验在选择授权类型时，是否已经选择角色
 */
function AuthorizationValidate(){
	var qry_role = $("#qry_roleId").val();
	if(!qry_role){
		alert("请先选择角色！");
		return false;
	}
	return true;
}

/**
 * 点击查询时，检验有没有选择角色或授权类型
 */
function QueryAuthorizationInfo(){
	var qry_role = $("#qry_roleId").val();
	if(!qry_role){
		alert("请先选择角色！");
		return false;
	}
	
	var auth_type = $("#qry_authorizationObjType").val();
	if(!auth_type){
		alert("请选择授权类型!");
		return false;
	}
	
	if(auth_type==1){
		//查询授权的组织信息
		queryAuthOrg(1);
	}
	
	if(auth_type==2){
		//查询授权的个人信息
		queryAuthUser(1);
	}
	
	if(auth_type==3){
		//查询授权的菜单信息
		queryAuthMenu(1);
	}
	
}