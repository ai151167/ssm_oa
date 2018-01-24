<!DOCTYPE html>
<html>
<#assign base=request.contextPath />
<base id="base" href="${base}">
<head>
	<script type="text/javascript" src="${base}/js/static/plugin/jquery/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="${base}/js/navbar.js"></script>
	<script type="text/javascript" src="${base}/js/static/page/leaveBill/leaveBill.js"></script>
	<link type="text/css" rel="stylesheet" href="${base}/css/public.css"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>请假管理</title>
</head>
<body>
 	<form action="/leaveBill/saveLeaveBill" method="POST">
 		<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
		  <tr>
		    <td height="30"><table width="100%" border="0" cellspacing="0" cellpadding="0">
		      <tr>
		        <td height="24" bgcolor="#353c44"><table width="100%" border="0" cellspacing="0" cellpadding="0">
		          <tr>
		            <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
		              <tr>
		                <td width="6%" height="19" valign="bottom"><div align="center"><img src="/images/tb.gif" width="14" height="14" /></div></td>
		                <td width="94%" valign="bottom">
		                	<span class="STYLE1">
		                			新增/修改请假申请
		                	</span>
		                	</td>
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
		   <#if lb??>
		    <td>
		    	<div align="left" class="STYLE21">
		
		    		<input type="hidden" name="id" value="<#if lb.id??>${lb.id}</#if>" />
		    		<input type="hidden" name="userId" value="<#if lb.userId??>${lb.userId}</#if>" /> 
			 		请假天数:<input type="text" name="days" value="<#if lb.days??>${lb.days}</#if>" style="width: 200px;"/><br/>
			 		请假原因:<input type="text" name="content" value="<#if lb.content??>${lb.content}</#if>" style="width: 800px;"/><br/>
			 		备&emsp;&emsp;注:
			 		<textarea name="remark" cols="50" rows="5" ><#if lb.remark??>${lb.remark}</#if></textarea><br/>
			 		<input type="submit" value="提交" class="button_ok"/>

				</div>
		    </td>
		    <#else>
		     <td>
		   	 <div align="left" class="STYLE21">
		    		<input type="hidden" name="id"/>
		    		<input type="hidden" id="user_id" name="userId" /> 
			 		请假天数:<input type="text" name="days" style="width: 200px;"/><br/>
			 		请假原因:<input type="text" name="content" style="width: 800px;"/><br/>
			 		备&emsp;&emsp;注:
			 		<textarea name="remark" cols="50" rows="5" ></textarea><br/>
			 		<input type="submit" value="提交" class="button_ok"/>
				</div>
				</td>
		    </#if>
		  </tr>	 
	</table>
	 	
	</form>
</body>
</html>