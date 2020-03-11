<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
<script type="text/javascript" src="../script/boardScript.js">
	
</script>
</head>
<body>
<form action="boardWrite.do" name="boardWriteForm" method="post">
	<table border="1">
		<tr>
			<th width="50">제목</th>
			<td width="300"><input type="text" name="subject" size="60"></td>
		</tr>
		<tr>
			<th>내용</th>
			<td width="300" height="300">
				<textarea name="content" rows="20" cols="61"></textarea>
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="button" value="글쓰기" onclick="checkBoardWrite()">
				<input type="reset" value="다시 작성">
			</td>
		</tr>
	</table>
</form>
<a href="../main/index.do">메인으로</a>
</body>
</html>