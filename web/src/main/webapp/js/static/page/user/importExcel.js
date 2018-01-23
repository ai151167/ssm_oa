function importUserExcel() {
	var htmlStr = "";
	htmlStr += '<div style="width:600px;" >';
	htmlStr += '<div style="display:block; padding-bottom:20px;" align="center" >';
	htmlStr += '<form  id = "userExcelFileFormId" action="/uploadExcel" method="post" enctype="multipart/form-data">';
	htmlStr += '<input type="file" id="userExcelFile" name="userExcelFile"  onchange="ValidateFileType()" >';
	htmlStr += ' <input type="submit"  value="导入"  />  ';
	htmlStr += '</form>';
	htmlStr += '</table>';
	htmlStr += '</div>';
	htmlStr += '</div>';

	$.layer({
		type : 1,
		title : '导入用户',
		area : [ 'auto', 'auto' ],
		page : {
			html : htmlStr
		}
	});
	
	
	submitForm();

}

/**
 * 检验是不是execl文档 xls,xlst
 */
function ValidateFileType(){
	var array = new Array();
	//员工.xls
	var fileName = $("#userExcelFile").val();
	array=fileName.split(".");
	var suffix = array[array.length-1];
	if(suffix!="xls" && suffix!="xlsx"){
		alert("您选择不是execl文档，请选择execl文档!");
		var file = document.getElementById("userExcelFile");
		file.value= "";
		/*$("#userExcelFile").val('');*/
	}
}

function submitForm(){
	var options={
		beforeSubmit:showRequest,	//表单提交之前做的事情 
		success:showResponse,//表单提交成功之后做的事情 
		resetFrom:true,//表单提交成功后是否要进行重置
		dataType:"json"
	}
	
	$("#userExcelFileFormId").submit(function(){
		//ajax来提交表单
		$(this).ajaxSubmit(options);
		
		//清除表单默认的提交方式
		return false;
	});
}

function showRequest(){
	
}

function showResponse(responseText){
	if(responseText.isSuccess==true){
		alert("导入成功");
		window.location="/user/userMana";//刷新 
	}
}