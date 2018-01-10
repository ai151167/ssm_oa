<#if list??>
<table width="100%" border="1" cellpadding="0" cellspacing="0">

	<tr>
		<th>组织名称</th>
		<th>组织状态</th>
		<th>显示顺序</th>
		<th>操作</th>
	</tr>

<#if list?size==0>
	<tr>
		<td colspan="4" style="text-align: center;">暂无组织信息</td>
	</tr>

<#else>
	<#list list as org>
	<tr>
		<td>
			<#if org.orgName??>${org.orgName}</#if>
		</td>
		<td>
			<#if org.state??>
				<#if org.state==1>可用</#if>
				<#if org.state==2>不可用</#if>
			</#if>
		</td>
		<td>
			<#if org.dispIndex??>${org.dispIndex}</#if>
		</td>
		<td>
			<#if org.orgParentId??>
				<#if org.orgParentId gt 0 >
					<a href="javascript:void();" style="cursor: pointer;" onclick="javascript:orgOper.updateOrg(<#if org.orgId??>${org.orgId}</#if>);">编辑</a>
					<a href="javascript:void();" style="cursor: pointer;" onclick="javascript:orgOper.showOrg(<#if org.orgId??>${org.orgId}</#if>);">查看</a> 
					<a href="javascript:void();" style="cursor: pointer;" onclick="javascript:orgOper.deleteOrg(<#if org.orgId??>${org.orgId}</#if>);">删除</a>
				
				</#if>	
			</#if>	
		</td>
	</tr>
	</#list>
</#if>
</table>
</#if>

<script type="text/javascript">
	 	totalCount = "<#if total??>${total}</#if>"; 
</script>
