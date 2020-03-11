<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<script type="text/javascript" src="../script/memberScript.js?v=1235"></script>
</head>
<body>
<form action="login.do" name="loginForm" method="post">
	<table border="1">
		<tr>
			<th width="70px" align="center">아이디</th>
			<td><input type="text" name="id" size="28"></td>
		</tr>
		<tr>
			<th width="70px" align="center">비밀번호</th>
			<td><input type="password" name="pwd" size="28"> </td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="button" value="로그인" onclick="checkLogin()">
				<input type="button" value="회원가입" onclick="location.href='writeForm.do'">
			</td>
		</tr>
	</table>
</form>
<br>
<a href="../main/index.do">메인화면으로</a>
</body>
</html>