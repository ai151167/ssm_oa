function UserOper() {

	this.addUser = function() {

		// 初始化弹出框html代码
		var htmlStr = userOper.initHtml();

		$.layer({
			type : 1,
			title : false,
			area : [ 'auto', 'auto' ],
			page : {
				html : htmlStr
			}
		});

		CascadeArea(null, null, null, "provinceId", "cityId", "countryId");
		// 初始化日期
		InitDate();
	}

	this.insertUser = function() {
		var param = new Object();
		var userId = $("#userId").val();
		if (userId !== null) {
			param.userId = userId;
		}

		param.orgId = $("#orgId").val();
		param.userChName = $("#userChName").val();
		param.userSex = $('input[name="userSex"]:checked').val();
		var year = $("#year").val();
		var month = $("#month").val();
		var day = $("#day").val();
		
		param.userBirthday = new Date(year,month,day); 
		param.mobilePhone = $("#mobilePhone").val();
		param.email = $("#email").val();
		param.userName = $("#userName").val();
		param.userPassword = $("#userPassword").val();
		param.provinceId = $("#provinceId").val();
		param.cityId = $("#cityId").val();
		param.countryId = $("#countryId").val();

		if (param.provinceId) {
			param.provinceName = $("#provinceId").find("option:selected")
					.text();
		}
		if (param.cityId) {
			param.cityName = $("#cityId").find("option:selected").text();
		}
		if (param.countryId) {
			param.contryName = $("#countryId").find("option:selected").text();
		}

		var url = "/user/addUser";
		var desc = "新增";
		if (userId) {
			url = "/user/updateUser";
			desc = "修改";
		} else {
			url = "/user/addUser";
			desc = "新增";
		}

		$.ajax({
			url : url,
			async : true,
			type : "POST",
			data : param,
			success : function(data) {
				if (data == "SUCCESS") {
					var alerts = layer.alert(desc + "成功", 1, function() {
						layer.close(alerts);
						location.reload();
					});
				} else {
					var alerts = layer.alert(desc + "失败", 5, function() {
						layer.close(alerts);
					});
				}
			}
		});
	}

	this.showUser = function(userId) {
		// 初始化弹出框html代码
		var htmlStr = userOper.initHtml();

		$.layer({
			type : 1,
			title : false,
			area : [ 'auto', 'auto' ],
			page : {
				html : htmlStr
			}
		});

		var param = new Object();
		param.userId = userId;

		$.getJSON("/user/queryUser", param, function(data) {
			$("#userId").val(data.userId);
			$("#orgName").val(data.orgName);
			$("#orgId").val(data.orgId);
			$("#userChName").val(data.userChName);
			$("#mobilePhone").val(data.mobilePhone);
			$("#email").val(data.email);
			$("#userName").val(data.userName);
			$("#userPassword").val(data.userPassword);
			$("input[name='userSex'][value=" + data.userSex + "]").attr(
					"checked", true);

			var birthday_temp = data.userBirthday;
			var date = new Date(birthday_temp);

			var year = date.getFullYear();
			var month = date.getMonth() + 1;
			var day = date.getDate();

			InitDate();

			if (month < 10) {
				month = "0" + month;
			}

			if (day < 10) {
				day = "0" + day;
			}
			
			$("#year").val(year);
			$("#month").val(month);
			$("#day").val(day);

			var provinceId = data.provinceId;
			var cityId = data.cityId;
			var countryId = data.countryId;

			CascadeArea(provinceId, cityId, countryId, "provinceId", "cityId",
					"countryId");

			$("#provinceId").val(provinceId);
			$("#cityId").val(cityId);
			$("#countryId").val(countryId);

			$("#saveButton").hide();
		})

	}

	this.editUser = function(userId) {
		// 初始化弹出框html代码
		var htmlStr = userOper.initHtml();

		$.layer({
			type : 1,
			title : false,
			area : [ 'auto', 'auto' ],
			page : {
				html : htmlStr
			}
		});

		var param = new Object();
		param.userId = userId;

		$.getJSON("/user/queryUser", param, function(data) {
			$("#userId").val(data.userId);
			$("#orgName").val(data.orgName);
			$("#orgId").val(data.orgId);
			$("#userChName").val(data.userChName);
			$("#mobilePhone").val(data.mobilePhone);
			$("#email").val(data.email);
			$("#userName").val(data.userName);
			$("#userPassword").val(data.userPassword);
			$("input[name='userSex'][value=" + data.userSex + "]").attr(
					"checked", true);

			var birthday_temp = data.userBirthday;
			var date = new Date(birthday_temp);
			var year = date.getFullYear();
			var month = date.getMonth() + 1;
			var day = date.getDate();

			InitDate();

			if (month < 10) {
				month = "0" + month;
			}

			if (day < 10) {
				day = "0" + day;
			}
			$("#year").val(year);
			$("#month").val(month);
			$("#day").val(day);

			var provinceId = data.provinceId;
			var cityId = data.cityId;
			var countryId = data.countryId;

			CascadeArea(provinceId, cityId, countryId, "provinceId", "cityId",
					"countryId");

			$("#provinceId").val(provinceId);
			$("#cityId").val(cityId);
			$("#countryId").val(countryId);
		})
	}
	
	this.deleteUser = function(userId){
		var param = new Object();
		param.userId = userId;
		
		$.ajax({
			url:"/user/delete",
			async:true,
			type:"GET",
			data:param,
			success:function(response){
				if(response=="SUCCESS"){
					var alerts = layer.alert("删除成功",1,function(){
						layer.close(alerts);
						location.reload();
					});
				}else{
					var alerts = layer.alert("删除失败",5,function(){
						layer.close(alerts);
					});
				}
			}
		});
	}
	
	
	this.sendEmail = function(email){
		var htmlStr = userOper.emailHtml();

		$.layer({
			type : 1,
			title : false,
			area : [ 'auto', 'auto' ],
			page : {
				html : htmlStr
			}
		});
		
		$("#toEmail").val(email);
		$("#fromEmail").val(fromEmail);
	}

	this.emailHtml = function() {
		var htmlStr = '';
		htmlStr += '<div style="width:600px;" >';
		htmlStr += '<div style=" line-height:30px; text-indent:10px; margin-bottom:20px; background-color:#eee; position:relative;">发送邮件</div>';
		htmlStr += '<div style="display:block; padding-bottom:20px;" align="center"  >';

		htmlStr += '<table border="0" >';

		htmlStr += '<tr>';
		htmlStr += '<td>';
		htmlStr += '<span>收件人:</span>';
		htmlStr += '</td>';
		htmlStr += '<td>';
		htmlStr += '<input type="text"  id="toEmail" style="width:370px;">';
		htmlStr += '</td>';
		htmlStr += '</tr>';

		htmlStr += '<tr>';
		htmlStr += '<td>';
		htmlStr += '<span>主题:</span>';
		htmlStr += '</td>';
		htmlStr += '<td>';
		htmlStr += '<input type="text"  id="title" style="width:370px;">';
		htmlStr += '</td>';
		htmlStr += '</tr>';
		
		htmlStr += '<tr>';
		htmlStr += '<td>';
		htmlStr += '<span>正文:</span>';
		htmlStr += '</td>';
		htmlStr += '<td>';
		htmlStr += '<textarea rows="3" cols="50"></textarea>';
		htmlStr += '</td>';
		htmlStr += '</tr>';

		htmlStr += '<tr>';
		htmlStr += '<td>';
		htmlStr += '<span>发件人:</span>';
		htmlStr += '</td>';
		htmlStr += '<td>';
		htmlStr += '<input type="text"  id="fromEmail" style="width:370px;">';
		htmlStr += '</td>';
		htmlStr += '</tr>';
		
		htmlStr += '<tr id="saveUserTr"><td colspan="2" align="center">';
		htmlStr += '<input id="saveButton" name="" type="button"  onclick="userOper.send();" value="发送"  />';
		htmlStr += '</td></tr>';
		htmlStr += '</table>';
		htmlStr += '</div>';
		htmlStr += '</div>';

		return htmlStr;

	}
	this.initHtml = function() {
		var htmlStr = '';
		htmlStr += '<div style="width:600px;" >';
		htmlStr += '<div style=" line-height:30px; text-indent:10px; margin-bottom:20px; background-color:#eee; position:relative;">添加用户</div>';
		htmlStr += '<div style="display:block; padding-bottom:20px;" align="center"  >';

		htmlStr += '<table border="0" >';

		htmlStr += '<tr style="display:none">';
		htmlStr += '<td colspan="2">';
		htmlStr += '<span>用户ID:</span>';
		htmlStr += '<input type="text"  id="userId" style="width:240px;">';
		htmlStr += '</td>';
		htmlStr += '</tr>';

		htmlStr += '<tr>';
		htmlStr += '<td>';
		htmlStr += '所属组织：';
		htmlStr += '<input type="text" id="orgName"  style="width:110px;" readonly="readonly" >';
		htmlStr += '<input type="hidden" id="orgId">';
		htmlStr += '<button onclick="QueryOrgTreeLayer(\'4\');">选择</button>';
		htmlStr += '</td>';
		htmlStr += '<td>';
		htmlStr += '<span>姓名:</span>';
		htmlStr += '<input type="text"  id="userChName" style="width:240px;">';
		htmlStr += '</td>';
		htmlStr += '</tr>';

		htmlStr += '<tr>';
		htmlStr += '<td>';
		htmlStr += '性别：<input type="radio" name="userSex"  value="1">男';
		htmlStr += '<input type="radio" name="userSex"   value="2">女';
		htmlStr += '<input type="radio" name="userSex"   value="3">保密';
		htmlStr += '</td>';
		htmlStr += '<td>';
		htmlStr += '生日： <select id="year"  name="year"></select>年';
		htmlStr += '<select id="month" name="month"></select>月';
		htmlStr += '<select id="day"  name="day"></select>日';
		htmlStr += '</td>';
		htmlStr += '</tr>';

		htmlStr += '<tr>';
		htmlStr += '<td>';
		htmlStr += '<span>电话:</span>';
		htmlStr += '<input type="text"  id="mobilePhone" style="width:240px;">';
		htmlStr += '</td>';
		htmlStr += '<td>';
		htmlStr += '<span>邮件:</span>';
		htmlStr += '<input type="text"  id="email" style="width:240px;">';
		htmlStr += '</td>';
		htmlStr += '</tr>';

		htmlStr += '<tr>';
		htmlStr += '<td>';
		htmlStr += '<span>用户名:</span>';
		htmlStr += '<input type="text"  id="userName" style="width:240px;">';
		htmlStr += '</td>';
		htmlStr += '<td>';
		htmlStr += '<span>密码:</span>';
		htmlStr += '<input type="text"  id="userPassword" style="width:240px;">';
		htmlStr += '</td>';
		htmlStr += '</tr>';

		htmlStr += '<tr>';
		htmlStr += '<td>';
		htmlStr += '<span>省份:</span>';
		htmlStr += '<select id="provinceId" style="width:240px;">';
		htmlStr += '</select>';
		htmlStr += '</td>';
		htmlStr += '<td>';
		htmlStr += '<span>地市:</span>';
		htmlStr += '<select id="cityId" style="width:240px;">';
		htmlStr += '</select>';
		htmlStr += '</td>';
		htmlStr += '</tr>';

		htmlStr += '<tr>';
		htmlStr += '<td>';
		htmlStr += '<span>区县:</span>';
		htmlStr += '<select id="countryId" style="width:240px;">';
		htmlStr += '</select>';
		htmlStr += '</td>';
		htmlStr += '<td>';
		htmlStr += '</td>';
		htmlStr += '</tr>';

		htmlStr += '<tr id="saveUserTr"><td colspan="2" align="center">';
		htmlStr += '<input id="saveButton" name="" type="button"  onclick="userOper.insertUser();" value="保存"  />';
		htmlStr += '</td></tr>';
		htmlStr += '</table>';
		htmlStr += '</div>';
		htmlStr += '</div>';

		return htmlStr;

	}

}

function InitDate() {
	var date = new Date();
	// 2017
	var year = date.getFullYear();
	// 1927
	var lowYear = year - 90;
	var yearOption = $("#year");
	for (var y = lowYear; y <= year; y++) {
		yearOption.append("<option value='" + y + "'>" + y + "</option>");
	}

	var monthOption = $("#month");
	for (var m = 1; m <= 12; m++) {
		if (m < 10) {
			m = '0' + m;
		}
		monthOption.append("<option value='" + m + "'>" + m + "</option>");
	}

	var dayOption = $("#day");
	for (var d = 1; d <= 31; d++) {
		if (d < 10) {
			d = '0' + d;
		}
		dayOption.append("<option value='" + d + "'>" + d + "</option>");
	}
}
