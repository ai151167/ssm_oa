<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<script type="text/javascript" src="../../../js/static/plugin/jquery/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="../../../js/static/plugin/layer/layer.min.js"></script>
<!--树  -->
<link rel="stylesheet" href="../../../js/static/plugin/zTree/css/zTreeStyle/zTreeStyle.css" type="text/css">
<script type="text/javascript" src="../../../js/static/plugin/zTree/js/jquery.ztree.core.js"></script>
<script type="text/javascript" src="../../../js/static/page/org/orgMana.js"></script>
<script type="text/javascript" src="../../../js/static/page/org/orgOper.js"></script>


<body style="background-color: #DCDCDC;">

	<table border="1" width="100%" >
		<tr height="100px">
			<td>
				<table border="1" width="100%" height="90px" >
					<tr height="30px">
					
					    <td width="30%">
					           父组织：<input type="text" id="qry_orgParentName" readonly="readonly">
					           <input type="hidden" id="qry_orgParentId">
					           <button  onclick="QueryOrgTreeLayer();">选择</button>
					           </td>
						<td width="30%">组织名称：<input type="text" id="qry_orgName"></td>
						<td width="30%">状态：
						<select id="qry_state"  width="100"  style="width:140px;">
						<option value=''>请选择</option>
						<option value='1'>可用</option>
						<option value='2'>不可用</option>
						</select></td>
						
					</tr>
					<tr  height="30px">
					   <td width="30%"></td>
					   <td width="30%"></td>
						<td width="30%" style="text-align:center;">
						<button id="queryButton">查询</button>
						   &nbsp;&nbsp;&nbsp;
						<button id="resetButton">重置</button></td>
					</tr>
						<tr  height="30px">
					    <td width="100%" colspan="3" style="text-align:left;">
					    <button  onclick="javascript:orgOper.addOrg();">新增</button>
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