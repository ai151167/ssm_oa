<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<#assign base=request.contextPath />
<base id="base" href="${base}">
<!-- jQuery框架 -->
<script type="text/javascript"  src="${base}/js/static/plugin/jquery/jquery-3.2.1.min.js"></script>
<!-- 弹出框插件 -->
<script type="text/javascript" src="${base}/js/static/plugin/layer/layer.min.js"></script>
<!--树  -->
<link rel="stylesheet" href="${base}/js/static/plugin/zTree/css/zTreeStyle/zTreeStyle.css" type="text/css">
<script type="text/javascript" src="${base}/js/static/plugin/zTree/js/jquery.ztree.core.js"></script>
<script type="text/javascript" src="${base}/js/static/page/authorization/authorizationMana.js"></script>
<script type="text/javascript" src="${base}/js/static/page/authorization/authorizationOrg.js"></script>
<script type="text/javascript" src="${base}/js/static/page/authorization/authorizationUser.js"></script>
<script type="text/javascript" src="${base}/js/static/page/authorization/authorizationMenu.js"></script>
<script type="text/javascript" src="${base}/js/static/page/authorization/menuTree.js"></script>
<script type="text/javascript" src="${base}/js/static/page/authorization/orgTree.js"></script>
<script type="text/javascript" src="${base}/js/static/page/authorization/userTree.js"></script>
<script type="text/javascript" src="${base}/js/static/plugin/paging/paging.js"></script>


<body style="background-color: #DCDCDC;">

	<table border="1" width="100%" >
		<tr height="100px">
			<td>
				<table border="1" width="100%" height="90px" >
					<tr height="30px">
						
						<td width="30%">角色名称：
						<select id="qry_roleId"  width="100"  style="width:140px;">
						</select></td>

						<td width="30%">授权类型：
						<select id="qry_authorizationObjType" onclick="AuthorizationValidate();" width="100"  style="width:140px;">
						<option value=''>请选择</option>
						<option value='1'>组织</option>
						<option value='2'>个人</option>
						<option value='3'>菜单</option>
						</select></td>
						<td width="30%"></td>
					</tr>
					<tr  height="30px">
					   <td width="30%"></td>
					   <td width="30%"></td>
						<td width="30%" style="text-align:center;">
						<button onclick="QueryAuthorizationInfo();">查询</button>					
					</tr>
						<tr  height="30px">
					    <td width="100%" colspan="3" style="text-align:left;">	
					    <button  id="addMenuRelButtonId"  onclick="javascript:MenuTreeLayer();">授权菜单</button>				
					    <button id="addOrgRelButtonId" onclick="javascript:OrgTreeLayer();">授权组织</button>
					    <button  id="addOrgUserRelButtonId" onclick="javascript:UserTreeLayer();">授权人员</button>
					    </td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td ><div id="pageListContainer" ></div></td>
		</tr>
		<tr height="50px">
			<td><div id="pageNumberToolBar" height="40px" style="text-align:center;"></div></td>
		</tr>
	</table>

</body>
</html>