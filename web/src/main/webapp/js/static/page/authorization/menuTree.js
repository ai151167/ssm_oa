function MenuTreeLayer() {

	var flag = AuthorizationValidate();
	if (flag == false) {
		alert("请先选择角色！");
		return;
	}

	var htmlStr = "";
	htmlStr += '<div style="width:300px;height:200px" >';
	htmlStr += '<div style="display:block; padding-bottom:5px;" align="center"  >';
	htmlStr += '<div><table><tr><td><input type="hidden" id="tmp_menuId" width="50px"/><input type="text" id="tmp_menuName" width="50px"><button onclick="AddRoleMenuRelFunc();">添加</button></td></tr></table></div>';
	htmlStr += '<div id="menuTree" class="ztree"></div>';
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

	LoadMenuTree();

}

function LoadMenuTree() {
	var setting = {
		data : {
			simpleData : {
				enable : true
			// 使用简单 Array格式的数据
			}
		},
		async : {
			enable : true, // 开启异步加载处理
			url : "/menuTree/menuDirSubList",
			autoParam : [ "id", "name" ],
			dataType : "json",// 默认text
			type : "get"// 默认post
		},
		callback : {
			onClick : ClickQueryMenuTreeNodeFunc
		}
	};

	var zNodes = [];

	var zTreeObj = $.fn.zTree.init($("#menuTree"), setting, zNodes);

}

//点击树的目录时得到点击目录的名称
function ClickQueryMenuTreeNodeFunc(event, treeId, treeNode, clickFlag) {
	if(treeNode.isParent==true){
		alert("请选择菜单！");
		return;
	}
	
	$("#tmp_menuId").val(treeNode.id);
	$("#tmp_menuName").val(treeNode.name);
}


function AddRoleMenuRelFunc(){
	var param = new Object();
	param.roleId = $("#qry_roleId").val();
	param.menuId = $("#tmp_menuId").val();
	
	$.ajax({
		url:"/authorization/addRoleMenuRel",
		async:true,
		type:"POST",
		data:param,
		success:function(response){
			if(response==true){
				var alerts = layer.alert("授权菜单成功!",1,function(){
					layer.closeAll();
					queryAuthMenu(0);//刷新页面
				});
			}else{
				var alerts = layer.alert("授权菜单失败!",5,function(){
					layer.closeAll();
				});
			}
		}
	})
}
