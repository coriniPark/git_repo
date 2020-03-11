<%@page import="member.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ID 중복 확인</title>
<script type="text/javascript">
	function checkIdClose() {
		// opener 내장객체: 현재 브라우저 기준로 부모 브라우저를 관리하는 객체
		opener.modifyForm.id.value = "${id}";
		window.close();
		opener.modifyForm.pwd.focus();
	}
	function checkId() {
		if(!document.checkForm.id.value){
			alert("ID를 입력하세요");
			document.checkForm.id.focus();
		} else {
			document.checkForm.submit();
		}
	}
</script>
</head>
<body>
<form action="checkId2.do" method="post" name="checkForm">
	<c:if test="${exist}">
		${id}은(는) 사용중입니다.<br>
		ID: <input type="text" name="id">
			<input type="button" value="중복체크" onclick="checkId()">
	</c:if>
	<c:if test="${!exist}">
		${id}는 사용가능합니다.
		<input type="button" value="사용" onclick="checkIdClose()"><br><br>
		ID: <input type="text" name="id">
			<input type="button" value="중복체크" onclick="checkId()">
	</c:if>
</form>
</body>
</html>








