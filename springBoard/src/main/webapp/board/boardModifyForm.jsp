<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 수정</title>
<script type="text/javascript" src="../script/boardScript.js?v=1">
	
</script>
</head>
<body>
<form action="boardModify.do" name="boardModifyForm" method="post">
	<input type="hidden" name="seq" value="${boardDTO.seq}">
	<input type="hidden" name="pg" value="${pg}">
	<table border="1">
		<tr>
			<th width="50">제목</th>
			<td width="300">
				<input type="text" name="subject" size="60" placeholder="제목"
				 value="${ boardDTO.subject}">	
			</td>
		</tr>
		<tr>
			<th>내용</th>
			<td width="300" height="300">
				<textarea name="content" rows="20" cols="61">${boardDTO.content}</textarea>
				<!-- textarea 밖으로 <pre> tag 붙여줘도 됨 -->
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="button" value="수정하기" onclick="checkBoardModify()">
				<input type="reset" value="다시 작성">
			</td>
		</tr>
	</table>
</form>
<a href="../main/index.do">메인으로</a>
</body>
</html>