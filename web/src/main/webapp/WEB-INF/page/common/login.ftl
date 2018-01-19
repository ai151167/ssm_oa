<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录</title>


</head>
 <#if data??>
			      员工：<#if data??>${data}</#if>
</#if>
<body   style="text-align:center;" >
<div align="center"  >
<form  method="post"  action="/login/loginCheck"  style="margin:150px;" >
<table>
<tr><td style="text-align:right;">用户名：</td><td><input type="text" name="userName"/></td></tr>
<tr><td style="text-align:right;">密码：</td><td><input type="password" name ="userPassword"/></td></tr>
<tr><td>&nbsp;</td><td></td></tr>
<tr><td></td><td style="text-align:right;"><input type="submit" value="登录"></td></tr>
</table>
</form>
</div>
</body>
</html>