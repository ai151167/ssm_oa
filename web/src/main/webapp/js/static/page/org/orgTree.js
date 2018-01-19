function QueryOrgTreeLayer(state){
	var htmlStr = "";
	htmlStr += '<div style="width:300px;height:200px" >';
	htmlStr += '<div style=" line-height:30px; text-indent:10px; margin-bottom:20px; background-color:#eee; position:relative;">组织</div>';
	htmlStr += '<div style="display:block; padding-bottom:5px;" align="center"  >';
	htmlStr += '<div><table><tr><td><input type="hidden" id="tmp_orgId" width="50px"/><input type="text" id="tmp_orgName" width="50px"><button onclick="SetQueryOrgTreeParam('+state+');">确定</button></td></tr></table></div>';
	htmlStr += '<div id="QueryOrgTree" class="ztree"></div>';
	htmlStr += '</div>';
	htmlStr += '</div>';
	$.layer({
		type:1,
		title:false,
		area: ['auto', '300px'],
		page:{
			html:htmlStr
		}
	});
	LoadOrgTree();
}

function LoadOrgTree(){
	var url = "/orgTree/getOrgTreeList";
	var setting={
		data:{
			simpleData:{
				enable:false,
			}
		},
		async:{
			url:url,
			type:"get",
			dataType:"json",
			autoParam:["id","name"],
			enable:true,
		},
		callback:{
			onClick:ClickQueryOrgTreeNodeFunc
		}
		
	};
	
	var zNodes= [] ;
	var zTreeObj = $.fn.zTree.init($("#QueryOrgTree"), setting, zNodes);
}
function ClickQueryOrgTreeNodeFunc(event, treeId, treeNode, clickFlag){
	$("#tmp_orgId").val(treeNode.id);
	$("#tmp_orgName").val(treeNode.name);
}

function SetQueryOrgTreeParam(state){
	if(state=='1'){
		$("#qry_orgParentId").val($("#tmp_orgId").val());
		$("#qry_orgParentName").val($("#tmp_orgName").val());
	}
	if(state=='2'){
		$("#orgParentId").val($("#tmp_orgId").val());
		$("#orgParentName").val($("#tmp_orgName").val());
	}
	if(state=='3'){
		$("#qry_orgId").val($("#tmp_orgId").val());
		$("#qry_orgName").val($("#tmp_orgName").val());
	}
	if(state=='4'){
		$("#orgId").val($("#tmp_orgId").val());
		$("#orgName").val($("#tmp_orgName").val());
	}
	var index = layer.index;
	 layer.close(index);
}