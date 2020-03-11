<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	if(${ su > 0 }) {
		alert("회원 가입 성공");
		location.href="loginForm.do";
	} else {
		alert("회원 가입 실패");
		location.href="writeForm.do";
	}
</script>
</head>
<body>
<%-- 
	<%if(su>0) { %>
		<p>회원 가입 성공</p>
		<a href="loginForm.jsp">로그인 화면으로 이동</a>
	<% } else { %>
		<p>회원 가입 실패</p>
		<a href="writeForm.jsp">회원가입 화면으로 이동</a>
	<% } %>
--%>	
<%-- 이름: <%= name %><br>
	ID: <%= id %><br>
	비밀번호: <%= pwd %><br>
	성별: <%= gender %>&nbsp;(0:남자, 1:여자)<br>
	E-mail: <%= email1 %>@<%= email2 %><br>
	핸드폰: <%= tel1 %>-<%= tel2 %>-<%= tel3 %><br>
	주소: <%= addr %> --%>
</body>
</html>