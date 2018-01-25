<!DOCTYPE html>
<html>
<#assign base=request.contextPath />
<base id="base" href="${base}">
<head>
	<script type="text/javascript" src="${base}/js/static/plugin/jquery/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="${base}/js/navbar.js"></script>
	<link type="text/css" rel="stylesheet" href="${base}/css/public.css"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>任务管理</title>
</head>
<body>
	<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
		  <tr>
		    <td height="30"><table width="100%" border="0" cellspacing="0" cellpadding="0">
		      <tr>
		        <td height="24" bgcolor="#353c44"><table width="100%" border="0" cellspacing="0" cellpadding="0">
		          <tr>
		            <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
		              <tr>
		                <td width="6%" height="19" valign="bottom"><div align="center"><img src="/images/tb.gif" width="14" height="14" /></div></td>
		                <td width="94%" valign="bottom"><span class="STYLE1">个人任务管理列表</span></td>
		              </tr>
		            </table></td>
		            <td><div align="right"><span class="STYLE1">
		              </span></div></td>
		          </tr>
		        </table></td>
		      </tr>
		    </table></td>
		  </tr>
		  <tr>
		    <td><table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#a8c7ce" onmouseover="changeto()"  onmouseout="changeback()">
		      <tr>
		        <td width="15%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">任务ID</span></div></td>
		        <td width="25%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">任务名称</span></div></td>
		        <td width="20%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">创建时间</span></div></td>
		        <td width="20%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">办理人</span></div></td>
		        <td width="20%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">操作</span></div></td>
		      </tr>
		      <#if taskList??>
		      	<#list taskList as task>
		 	
		      		<tr>
				        <td height="20" bgcolor="#FFFFFF" class="STYLE6"><div align="center"><#if task.id??>${task.id}</#if></div></td>
				        <td height="20" bgcolor="#FFFFFF" class="STYLE19"><div align="center"><#if task.name??>${task.name}</#if></div></td>
				        <td height="20" bgcolor="#FFFFFF" class="STYLE19">
				        <div align="center">
				        <#if task.createTime??>${task.createTime?string("yyyy-MM-dd HH:mm:ss")}</#if>
				        <td height="20" bgcolor="#FFFFFF" class="STYLE19"><div align="center"><#if task.assignee??>${task.assignee}</#if></div></td>
				        <td height="20" bgcolor="#FFFFFF"><div align="center" class="STYLE21">
				        	<a href="/workflow/viewTaskForm?taskId=<#if task.id??>${task.id}</#if>">办理任务</a>
							<a target="_blank" href="/workflow/viewCurrentProcessImage?taskId=<#if task.id??>${task.id}</#if>">查看当前流程图</a>
				        </div></td>
				    </tr> 		      
		      	</#list>
		        </#if>
		      
		    </table></td>
		  </tr>
	</table>
</body>
</html>