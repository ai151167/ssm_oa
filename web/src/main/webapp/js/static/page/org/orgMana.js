var pageSize =5;
var orgOper;
$(function() {
	loadOrgPageInfo(0);
	orgOper = new OrgOper();
	$("#queryButton").bind("click", function() {
		loadOrgPageInfo(0);
	});
	$("#resetButton").bind("click", function() {
		$("#qry_orgName").val('');
		$("#qry_state").val('');
		$("#qry_orgParentId").val('');
		$("#qry_orgParentName").val('');
		loadOrgPageInfo(0);
	});
	console.log('totalCount:' + totalCount + '     totalPages:'
			+ totalPages);
});

function loadOrgPageInfo(startPage) {
	var param = new Object();
	param.startIndex = startPage * pageSize;
	param.orgName = $("#qry_orgName").val();
	param.state = $("#qry_state").val();
	param.orgParentId = $("#qry_orgParentId").val();
	param.pageSize = pageSize;
	getCountAndPage(param);
	$.ajax({
		url : "/org/queryOrgList",
		async : true,
		data : param,
		type : "GET",
		success : function(response) {
			if (response != null) {
				$("#pageListContainer").empty();
				$("#pageListContainer").html(response);
				loadOrgPageNumber();
			}
		}
	});
}
	function loadOrgPageNumber(totalCount,page) {
		$("#pageNumberToolBar").empty();
		/* $("#pageNumberToolBar").html(response); */
		/*
		 * var GG = { "kk":function(mm){ alert(mm); } }
		 * $("#page").initPage(71,1,GG.kk);
		 */
		$("#pageNumberToolBar").pagination(
				{
					// 可选，每页显示条数下拉框，默认下拉框5条/页(默认)、10条/页、15条/页、20条/页
					pageSizeOpt : [ {
						'value' : 5,
						'text' : '5条/页',
						'selected' : true
					}/*, {
						'value' : 10,
						'text' : '10条/页'
					}, {
						'value' : 15,
						'text' : '15条/页'
					}, {
						'value' : 20,
						'text' : '20条/页'
					} */],
					// 可选，css设置，可设置值：css-1，css-2，css-3，css-4，css-5，默认css-1，可自定义样式
					css : 'css-2',
					// 可选，总页数
					totalPage : page, // 可选，展示页码数量，默认5个页码数量
					showPageNum : pageSize, // 可选，首页按钮展示文本，默认显示文本为首页
					firstPage : '首页', // 可选，上一页按钮展示文本，默认显示文本为上一页
					previousPage : '上一页', // 可选，下一页按钮展示文本，默认显示文本为下一页
					nextPage : '下一页', // 可选，尾页按钮展示文本，默认显示文本为尾页
					lastPage : '尾页', // 可选，跳至展示文本，默认显示文本为跳至
					skip : '跳至', // 可选，确认按钮展示文本，默认显示文本为确认
					confirm : '确认', // 可选，刷新按钮展示文本，默认显示文本为刷新
					refresh : '刷新', // 可选，共{}页展示文本，默认显示文本为共{}页，其中{}会在js具体转化为数字
					totalPageText : '共{}页', // 可选，是否展示首页与尾页，默认true
					isShowFL : false, // 可选，是否展示每页N条下拉框，默认true
					isShowPageSizeOpt : true, // 可选，是否展示跳到指定页数，默认true
					isShowSkip : false, // 可选，是否展示刷新，默认true
					isShowRefresh : false, // 可选，是否展示共{}页，默认true
					isShowTotalPage : true, // 可选，是否重新设置当前页码及总页数，当请求服务器返回数据时，默认false
					isResetPage : false, // 必选，回掉函数，返回参数：第一个参数为页码，第二个参数为每页显示N条
					callBack : function(currPage, pageSize) {
						loadOrgPageInfo(currPage-1);
						console.log('currPage:' + currPage + '     pageSize:'
								+ pageSize);
					}
				});
}

	function getCountAndPage(param){
		$.ajax({
			url : "/org/getCountAndPage",
			async : true,
			data : param,
			type : "GET",
			success : function(response) {
				if (response != null) {
					var totalCount = response.count;
					var page = response.page;
					loadOrgPageNumber(totalCount,page); 
				}
			}
		});
	}