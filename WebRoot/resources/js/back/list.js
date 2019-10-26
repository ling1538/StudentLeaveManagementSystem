/**
 * 调用后台批量删除方法
 */
function deleteBatch(basePath) {
	$("#mainForm").attr("action",basePath + "DeleteBatchServlet.action");
	$("#mainForm").submit();
}

/**
 * 修改当前页码，调用后台重新查询
 */
function changeCurrentPage(currentPage) {
	$("#currentPage").val(currentPage);
	$("#mainForm").submit();
}


function checkOrCancelAll(){
	var chElt=document.getElementById("selectAll");
	var checkedElt=chElt.checked;
	var allCheck=document.getElementsByName("checkbox_id");
	if(checkedElt){
		for(var i=0;i<allCheck.length;i++){
			allCheck[i].checked=true;
		}
	}else{
		for(var i=0;i<allCheck.length;i++){
			allCheck[i].checked=false;
		}
	}
}

