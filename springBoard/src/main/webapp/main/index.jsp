<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
</head>
<body>
<h3 align="center">아무말 게시판</h3>
<hr>
<!-- 로그인 전후 화면 분리-->
<% if(session.getAttribute("memId")==null) {%>
	<a href="../member/writeForm.do">회원가입</a><br>
	<a href="../member/loginForm.do">로그인</a><br>
<%} else {%>
	<a href="../board/boardWriteForm.do">글쓰기</a><br>
	<a href="../member/modifyForm.do">회원정보 수정</a><br>
	<a href="../member/logout.do">로그아웃</a><br>
<% } %>
	<a href="../board/boardList.do?pg=1">글 목록</a>
</body>
</html>