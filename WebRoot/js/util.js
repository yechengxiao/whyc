function refresh() {
	document.getElementById("authImg").src = 'authImg?now=' + new Date();
}
//验证用户名可用
function validateName() {
	//url为xx.action
	var url = 'validateName.action';
	var params = Form.Element.serialize('name');
	var myAjax = new Ajax.Request(url, {
		method : 'post',
		parameters : params,
		onComplete : processResponse,
		asynchronous : true
	});
}
//输出用户名可用
function processResponse(request) {
	var action = request.responseText.parseJSON();
	$("tip").innerHTML = action.tip;
}
//jQuery，多选框选中。点击删除按钮，提交。
$(function() {
	//登录，用户名输入框自动定位
	$("#username").focus();
	
	//所有checkbox跟着全选的checkbox走。1。
	$("#CheckAll").click(function(){
		$("[name=chb]:checkbox").attr("checked",this.checked);
	});
	//所有checkbox跟着全选的checkbox走。2。
	$('[name=chb]:checkbox').click(function(){
		var $tmp=$('[name=chb]:checkbox');
		//用filter方法筛选出选中的复选框。并直接给CheckedAll赋值。
		$('#CheckAll').attr('checked',$tmp.length==$tmp.filter(':checked').length);
	});
	//删除Indicator
	$("#delIndi").click(function(){
		var rowFlag="";
		$chbcked=$("[name=chb]:checkbox:checked");//取选中的多选框
		
		if($chbcked.length==0){//若没有选中的多选框，则提示。
			alert("没有选项。");
		}else{//若选中多选框，则提交。
			$chbcked.each(function(){
				rowFlag+=$(this).val()+"|";
			});
			//提交参数
			$formIndi=$("form[name=formIndi]");
			$formIndi.attr("action","deleteIndi.action?rowFlag="+rowFlag);
			$formIndi.submit();
		};
	});
	//搜索栏默认内容清空
	$("#search-text").focus(function(){
		var text=$(this).val();
		if(text==this.defaultValue){
			$(this).val("");
		}
	});
	//搜索栏默认内容重新显示
	$("#search-text").blur(function(){
		var text=$(this).val();
		if(text==""){
			$(this).val(this.defaultValue);
		}
	});
	//搜索
		$("#search-submit").click(function(){
			str=$("#search-text").val();
			if(str=="搜索"){
				str="";
			}
			$formDeco=$("form[name=formDeco]");
			if($("input[name=viewAllIndis]").val()=="viewAllIndis"){
				$formDeco.attr("action","searchIndi.action?searchName="+str);
			}else if($("input[name=viewAllWcons]").val()=="viewAllWcons"){
				$formDeco.attr("action","searchWcon.action?searchContent="+str);
			}
			$formDeco.submit();
		});
	//删除Warncontent
	$("#delWCon").click(function(){
		var rowFlag="";
		$chbcked=$("[name=chb]:checkbox:checked");//取选中的多选框
		
		if($chbcked.length==0){//若没有选中的多选框，则提示。
			alert("没有选项。");
		}else{//若选中多选框，则提交。
			$chbcked.each(function(){
				rowFlag+=$(this).val()+"|";
			});
			//提交参数
			$formWCon=$("form[name=formWCon]");
			$formWCon.attr("action","deleteWCon.action?rowFlag="+rowFlag);
			$formWCon.submit();
		};
	});
	//修改功能。
	//处理任务，判断完成任务时，有无预警指标被选中。
	$("#updateWork").click(function(){
		$cbox=$("[name=chb]:checkbox:checked");
		var id=$("[name=id]:hidden").val();
		if($cbox.length!=0){
			alert("请勿选则预警指标。");
		}else{
			$formDoWork=$("form[name=formDoWork]");
			$formDoWork.attr("action","updateWorkAction.action?id="+id);
			$formDoWork.submit();
		}
	});
	$("#createWarn").click(function(){
		$cbcked=$("[name=chb]:checkbox:checked");
		var wcIds="";
		var id=$("[name=id]:hidden").val();
		
		if($cbcked.length==0){
			alert("请选择预警指标");
		}else{
			$cbcked.each(function(){
				wcIds+=$(this).val()+"|";
			});
			$formDoWork=$("form[name=formDoWork]");
			$formDoWork.attr("action","createWarnAction.action?id="+id+"&wcIds="+wcIds);
			$formDoWork.submit();
		}
	});
	
});

