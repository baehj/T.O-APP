<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
<script>
	/* datepicker */
	$( function() {
	  $( "#datepicker1" ).datepicker({ dateFormat: "yy-mm-dd" });
	} );
	$( function() {
	  $( "#datepicker2" ).datepicker({ dateFormat: "yy-mm-dd" });
	} );
	
	/* 항목추가 */
	function addRow() {

	  const table = document.getElementById("to_add");
	  var index = table.rows.length;
	  const newRow = table.insertRow(index-2);
	  const newCell1 = newRow.insertCell(0);
	  const newCell2 = newRow.insertCell(1);
	  const newCell3 = newRow.insertCell(2);
	   
	  // Cell에 텍스트 추가
	  newCell1.innerHTML = "<td class='to_add_list'><input type='text' name = 'p_plus' style='width:100px;'></td>";
	  newCell2.innerHTML = "<td class='to_add_list'><input type='file' name = 'p_plus_file' ></td>";
	  newCell3.innerHTML = "<td><img src='/resources/image/delete.png' style='width:20px;'></td>";
	}
	
	/* 전송시 p_plus 배열로 전달 */
	function getlist1(){
		var list1 = new Array();
		$("input[name=p_plus]").each(function(index,item){
			list1.push($(item).val());
		});
		$("#p_list1").val(list1);
	}
	
	/* 전송시 p_plus_file 배열로 전달 
	function getlist2(){
		var list2 = new FormData();
		$("input[name=p_plus_file]").each(function(index,item){
			list2.append($(index).val, $(item).val);
		});
		$("#p_list2").val(list2);
	}
	*/
	
	/* 전송시 p_plus_file들 ajaxㄴ 전달 
	$('#submit').on('click', function() {
		var formData = new FormData();
		$.each(uploadfiles, function(idx, file) {
			formData.append('file', file, file.name);
		});
		$.ajax({
			url:'check', data:formData, type:'post', contentType:false,
			processData:false, enctype:'multipart/form-data',
			success: function(data) {
				alert("success");
			}
		});
	}); */ 
	
	/* to_add_list td의 X버튼 누르면 table에서 삭제 */
	
</script>
</head>
<body>

<h2 class="title">인계 사항 작성</h2>
<form action="check" method="post" enctype="multipart/form-data">
<table id="to_add">
	<tr>
		<td class="col-md-4">프로젝트코드</td>
		<td class="chk_value" colspan="2">
			<input type="text" name="p_code"  autofocus="autofocus">
		</td>
	</tr>
	<tr>
		<td class="col-md-4">프로젝트명</td>
		<td class="chk_value" colspan="2">
			<input type="text" name="p_name">
		</td>
	</tr>
	<tr>
		<td class="col-md-4">프로젝트 기간</td>
		<td class="chk_value">
			<input type="text" id="datepicker1" name="p_startDate" >
			~
			<input type="text" id="datepicker2" name="p_endDate" >
		</td>
	</tr>
	<tr>
		<td class="col-md-4" >서버정보</td>
		<td class="chk_value" colspan="2"><input type="file" name="p_server" ></td>
	</tr>
	<tr>
		<td class="col-md-4">테이블명세서</td>
		<td class="chk_value" colspan="2"><input type="file" name="p_erd" ></td>
	</tr>
	<tr>
		<td class="col-md-4">화면설계서</td>
		<td class="chk_value" colspan="2"><input type="file" name="p_wireframe" ></td>
	</tr>
	<tr>
		<td class="col-md-4">비고</td>
		<td class="chk_value" colspan="2"><input type="text" name="p_note" ></td>
	</tr>
	<tr>
		<td colspan="3">
		<input type='hidden' name='p1[]' id='p_list1' value=''/>
		<input type='hidden' name='p2[]' id='p_list2' value=''/>
		<input type='button' value='행추가' onclick='addRow()'/>
       </td>
	</tr>
	<tr>
		<td class="container_submit" colspan="2" align="center">
			<input type="submit" id="submit" value="확인" class="lbtn" onclick="getlist1(); getlist2();">
		</td>
	</tr>
</table>
</form>
</body>
</html>