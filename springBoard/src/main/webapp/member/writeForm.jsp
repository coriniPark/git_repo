<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<style type="text/css">
th {
	font-size: 0.9em;
	width: 100px;
	background: mistyrose;
}
td {
	background: #FAE0D4;
}
#button {
	background: aliceblue;
	font-color: white;
}
</style>
<script type="text/javascript" src="../script/memberScript.js?v=1"></script>
</head>
<body>
<form action="write.do" name="writeForm" method="post" >
<table border="0">
	<tr>
		<th width="80" align="center" bgcolor="mistyrose">이름</th>
		<td><input type="text" name="name" size="10" placeholder="이름 입력"></td>
	</tr>
	<tr>
		<th align="center">아이디</th>
		<td><input type="text" name="id" size="10"> 
			<input  id="button" type="button" value="중복 확인" onclick="checkId()">
		</td>
	</tr>
	<tr>
		<th align="center">비밀번호</th>
		<td><input type="password" name="pwd" maxlength="12" size="15"></td>
	</tr>
	<tr>
		<th align="center">비밀번호 확인</th>
		<td>
			<input type="password" name="repwd" maxlength="12" size="15">
		</td>
	</tr>
	<tr>
		<th align="center">성별</th>
		<td>
			<input type="radio" name="gender" value="0" checked="checked">남
			<input type="radio" name="gender" value="1">여
		</td>
	</tr>
	<tr>
		<th align="center">이메일</th>
		<td><input type="text" name="email1">@
			<select	name="email2" style="width: 100px;">
				<option value="naver.com">naver.com</option>
				<option value="daum.net">daum.net</option>
				<option value="gmail.com">gmail.com</option>
				<option value="hanmail.net">hanmail.net</option>
			</select>	
		</td>
	</tr>
	<tr>
		<th align="center">핸드폰</th>
		<td>
			<select name="tel1" style="width: 55px;">
				<option value="010">010</option>
				<option value="011">011</option>
				<option value="019">019</option>
			</select>-
			<input type="text" name="tel2" maxlength="4" size="4">-
			<input type="text" name="tel3" maxlength="4" size="4">
		</td>
	</tr>
	<tr>
		<th align="center">주소</th>
		<td><input type="text" name="addr" size="50"></td>
	</tr>
	<tr >
		<td colspan="2" align="center">
			<input type="button" value="회원 가입" onclick="checkWrite()">
			<input type="reset" value="다시 작성"> 
		</td>
	</tr>

</table>
</form>
<br>
<a href="../main/index.do">메인화면으로</a>
</body>
</html>