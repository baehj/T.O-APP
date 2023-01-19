<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	td, th {
	    padding: 14px 0px;
	}
</style>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script type="text/javascript">
	
	/*
	function login() {
		var chk = '';
		$.ajaxSetup({async:false});
		$.post('login', {email: frm.email.value, pw: frm.pw.value }, function(data) {
			chk = data;
		});
		
		if(chk=='1'){ 
			alert("승인권자의 승인이 필요합니다.");
			return false;
		} else if(chk=='2'){
			return true;
		} else {
			$('#chk').html("로그인 실패");
			return false;
		}
	}*/
	
	
	function login() {
		var chk = '';
		$.ajaxSetup({async:false});
		$.post('login', {email: frm.email.value, pw: frm.pw.value }, function(data) {
			chk = data;
		});
		
		if(chk=='y'){
			return true;
		}else {
			$('#chk').html("로그인 실패");
			return false;
		}
	}
	
</script>
</head>
<body>
<div class="container" align="center">
<form action="toAdd" method="post" name="frm">
<h2 class="title">L O G I N</h2>
<table class="join">
	<tr><td><div id="chk"></div></td></tr>
	<tr>
		<td class="col-md-4">이메일</td>
		<td class="chk_value">
			<input type="text" name="email" required="required" autofocus="autofocus">
		</td>
	</tr>
	<tr>
		<td class="col-md-4">암호</td>
		<td class="chk_value"><input type="password" name="pw" required="required"></td>
	</tr>
	<tr>
		<td class="container_submit" colspan="2" align="center">
			<button type="submit" value="확인" class="lbtn" onclick="return login()">확인</button>
		</td>
	</tr>
</table>
</form>
	<a href="findFormId.do" class="btn">아이디 찾기</a>
	<a href="findFormPw.do" class="btn">비밀번호 찾기</a>
	<a href="joinForm.do" class="btn">회원 가입</a>
</div>
</body>
</html>