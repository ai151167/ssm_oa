function RoleOper(){
	
	this.alertaddRole =function(){
		var htmlStr = roleOper.initHtml();
		$.layer({
			  type: 1,
			  skin: 'layui-layer-rim', //加上边框
			  area: ['auto', 'auto'], //宽高
			  page:{html:htmlStr}
			});
	}

	this.saveRole = function(){
		var param = new Object();
		param.roleId = $("#roleId").val();
		param.roleName = $("#roleName").val();
		param.state = $("#state").val();
		param.roleDesc = $("#roleDesc").val();
		$.ajax({
			url : "/role/saveRole",
			async : true,
			type : "POST",
			data : param,
			success : function(data){
				if (data=="SUCCESS") {
					var alerts = layer.alert("成功", 1, function() {
						layer.close(alerts);
						location.reload();
					});
				} else {
					var alerts = layer.alert("失败", 5, function() {
						layer.close(alerts);
					});
				}
			}
		});
	}
	
	this.editRole= function(roleId){
		roleOper.alertaddRole();
		roleOper.queryRoleInfo(roleId);
	}
	
	this.queryRoleInfo = function(roleId){
		var param = new Object();
		param.roleId = roleId;
		$.ajax({
			url : "/role/getRoleInfo",
			async : true,
			type : "GET",
			data : param,
			success:function(data){
				if(data!=null){
					 $("#roleId").val(data.roleId);
					 $("#roleName").val(data.roleName);
					 $("#state").val(data.state);
					 $("#roleDesc").val(data.roleDesc);
				}
			}
		});
	}
	
	this.showRole = function(roleId){
		roleOper.alertaddRole();
		$("#saveButton").hide();
		roleOper.queryRoleInfo(roleId);
	}
	
	this.deleteRole = function(roleId){
		var param = new Object();
		param.roleId = roleId;
		$.ajax({
			url : "/role/deleteRoleById",
			async : true,
			type : "GET",
			data : param,
			success:function(data){
				if(data=="SUCCESS"){
					var alerts = layer.alert("成功", 1, function() {
						layer.close(alerts);
						location.reload();
					});
				}
			}
		});
	}
	
	this.initHtml = function(){
		var htmlStr = '';
		htmlStr += '<div style="width:600px;" >';
		htmlStr += '<div style=" line-height:30px; text-indent:10px; margin-bottom:20px; background-color:#eee; position:relative;">组织</div>';
		htmlStr += '<div style="display:block; padding-bottom:20px;" align="center"  >';
		htmlStr += '<table border="0" >';
		htmlStr += '<tr style="display:none">';
		htmlStr += '<td colspan="2">';
		htmlStr += '<span>角色ID:</span>';
		htmlStr += '<input type="text"  id="roleId" style="width:220px;">';
		htmlStr += '</td>';
		htmlStr += '</tr>';
		htmlStr += '<tr>';
		htmlStr += '<td>';
		htmlStr += '<span>角色名称:</span>';
		htmlStr += '<input type="text"  id="roleName" style="width:220px;">';
		htmlStr += '</td>';
		htmlStr += '<td>';
		htmlStr += '<span>角色状态:</span>';
		htmlStr += '<select id="state" style="width:220px;">';
		htmlStr += '<option value="">请选择</option>';
		htmlStr += '<option value="1">可用</option>';
		htmlStr += '<option value="2">不可用</option>';
		htmlStr += '</select>';
		htmlStr += '</td>';

		htmlStr += '</tr>';
		htmlStr += '<tr>';
		htmlStr += '<td colspan="2" align="center" >';
		htmlStr += '<span>角色描述:</span>';
		htmlStr += '<textarea id="roleDesc" rows="3"   style="width:500px;"></textarea>';
		htmlStr += '</td>';
		htmlStr += '</tr>';
		htmlStr += '<tr id="saveRoleTr"><td colspan="2" align="center">';
		htmlStr += '<input id="saveButton"  type="button"  onclick="javascript:roleOper.saveRole();" value="保存"  />';
		htmlStr += '</td></tr>';
		htmlStr += '</table>';
		htmlStr += '</div>';
		htmlStr += '</div>';

		return htmlStr;
	}
}