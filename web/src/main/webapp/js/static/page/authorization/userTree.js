function UserTreeLayer() {

	var flag = AuthorizationValidate();
	if (flag == false) {
		alert("请先选择角色！");
		return;
	}

	var htmlStr = "";
	htmlStr += '<div style="width:300px;height:200px" >';
	htmlStr += '<div style="display:block; padding-bottom:5px;" align="center"  >';
	htmlStr += '<div><table><tr><td><input type="hidden" id="tmp_userId" width="50px"/><input type="text" id="tmp_userName" width="50px"><button onclick="AddRoleUserRelFunc();">添加</button></td></tr></table></div>';
	htmlStr += '<div id="userTree" class="ztree"></div>';
	htmlStr += '</div>';
	htmlStr += '</div>';

	$.layer({
		type : 1,// 1：页面 2：frame
		title : "菜单",
		area : [ 'auto', '300px' ],
		page : {
			html : htmlStr
		}
	});

	LoadUserTree();

}

function LoadUserTree() {
	var setting = {
		data : {
			simpleData : {
				enable : true
			// 使用简单 Array格式的数据
			}
		},
		async : {
			enable : true, // 开启异步加载处理
			url : "/userTree/userSubList",
			autoParam : [ "id", "name" ],
			dataType : "json",// 默认text
			type : "get"// 默认post
		},
		callback : {
			onClick : ClickQueryUserTreeNodeFunc
		}
	};

	var zNodes = [];

	var zTreeObj = $.fn.zTree.init($("#userTree"), setting, zNodes);

}

//点击树的目录时得到点击目录的名称
function ClickQueryUserTreeNodeFunc(event, treeId, treeNode, clickFlag) {
	
	$("#tmp_userId").val(treeNode.id);
	$("#tmp_userName").val(treeNode.name);
}


function AddRoleUserRelFunc(){
	var param = new Object();
	param.roleId = $("#qry_roleId").val();
	param.userId = $("#tmp_userId").val();
	
	$.ajax({
		url:"/authorization/addRoleUserRel",
		async:true,
		type:"POST",
		data:param,
		success:function(response){
			if(response==true){
				var alerts = layer.alert("授权用户成功!",1,function(){
					layer.closeAll();
					queryAuthUser(0);//刷新页面
				});
			}else{
				var alerts = layer.alert("授权用户失败!",5,function(){
					layer.closeAll();
				});
			}
		}
	})
}
