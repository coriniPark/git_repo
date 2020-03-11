<%@page import="member.bean.MemberDTO"%>
<%@page import="member.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 수정</title>
<script type="text/javascript" src="../script/memberScript.js?v=12"></script>
</head>
<body>
<form action="modify.do" name="modifyForm" method="post" >

<table border="1">
	<tr>
		<th width="80" align="center">이름</th>
		<td>
			<input type="text" name="name" size="50" value="${memberDTO.name}">
		</td>
	</tr>
	<tr>
		<th align="center">아이디</th>
		<td><input type="text" name="id" size="10" value="${memberDTO.id}" readonly="readonly"></td>
	</tr>	
	<tr>
		<th align="center">비밀번호</th>
		<td><input type="password" name="pwd" size="50" value="${memberDTO.pwd}"></td>
	</tr>
	<tr>
		<th align="center">비밀번호 확인</th>
		<td>
			<input type="password" name="repwd" size="50" value="${memberDTO.pwd}">
		</td>
	</tr>
	<tr>
		<th align="center">성별</th>
		<c:if test="${memberDTO.gender == '0'}">
		<td>
			<input type="radio" name="gender" value="0" checked="checked">남
			<input type="radio" name="gender" value="1">여
		</td>
		</c:if>
		<c:if test="${memberDTO.gender == '1'}">
		<td>
			<input type="radio" name="gender" value="0">남
			<input type="radio" name="gender" value="1" checked="checked">여
		</td>
		</c:if>
	</tr>
	<tr>
		<th align="center">이메일</th>
		<td><input type="text" name="email1" value="${memberDTO.email1 }">@
			<input type="text" name="email2" value="${memberDTO.email2 }">
		</td>
	</tr>
	<tr>
		<th align="center">핸드폰</th>
		<td>
			<input type="text" name="tel1" size="2" maxlength="3" value="${memberDTO.tel1}">-
			<input type="text" name="tel2" size="2" maxlength="4" value="${memberDTO.tel2}">-
			<input type="text" name="tel3" size="2" maxlength="4" value="${memberDTO.tel3 }">
		</td>
	</tr>
	<tr>
		<th align="center">주소</th>
		<td><input type="text" name="addr" size="50" value="${memberDTO.addr}"></td>
	</tr>
	<tr >
		<td colspan="2" align="center">
			<input type="button" value="정보 수정" onclick="checkModify()">
			<input type="reset" value="다시 작성"> 
		</td>
	</tr>

</table>
</form>
<br>
<a href="../main/index.do">메인화면으로</a>
</body>
</html>