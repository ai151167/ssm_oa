
<html>
<#assign base=request.contextPath />
<base id="base" href="${base}">
<frameset rows="50,*,50">

	<frame src="${base}/js/static/common/top.html" scrolling="no">

	<frameset cols="180,*">
		<frame src="/menu/left" scrolling="no">
		<frame name="mainFrame" src="${base}/js/static/common/center.html"  scrolling="yes">
	</frameset>
	<frame src="${base}/js/static/common/bottom.html" scrolling="no">
	
</frameset>

</html>