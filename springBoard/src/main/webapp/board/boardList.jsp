<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 목록</title>
<script type="text/javascript">
	function isLogin(seq) {
		if(${memId == null}) {
			alert("로그인 후 이용하세요.");
			location.href="../member/loginForm.do";
		} else { 
			location.href="boardView.do?seq="+seq+"&pg="+${pg};
		}
	}
</script>
<style type="text/css">
#subjectA:link {
	color: black;
	text-decoration: none;
}

#subjectA:visited {
	color: black;
	text-decoration: none;
}

#subjectA:hover {
	color: #C98500;
	text-decoration: none;
}

#subjectA:active {
	color: black;
	text-decoration: none;
}

.paging {
	color: #353535;
	text-decoration: none;
}

.currentPaging {
	color: #F2CB61;
	text-decoration: none;
}
th {
	color: #F2CB61;
}
</style>
</head>
<body>
	<table border="1">
		<tr bgcolor="#353535">
			<th width="70">글번호</th>
			<th width="200">제목</th>
			<th width="100">작성자</th>
			<th width="100">작성일</th>
			<th width="70">조회수</th>
		</tr>

		<c:forEach var="boardDTO" items="${list}">
			<tr bgcolor="#BDBDBD" align="center">
				<td>${boardDTO.seq}</td>
				<td><a id="subjectA" href="#" onclick="isLogin(${boardDTO.seq})"> ${boardDTO.subject}</a></td>
				<td>${boardDTO.id}</td>
				<td>${boardDTO.logtime}</td>
				<td>${boardDTO.hit}</td>
			</tr>
		</c:forEach>

		<tr>
			<!--페이징-->
			<td colspan="5" align="center"><c:if test="${startPage > 3}">
					<a class="paging" href="boardList.do?pg=${startPage - 1}">[이전]</a>
				</c:if> <c:forEach var="i" begin="${startPage}" end="${endPage}" step="1">
					<c:if test="${pg == i }">
						<a class="currentPaging" href="boardList.do?pg=${i}">[${i}]</a>
					</c:if>
					<c:if test="${pg != i}">
						<a class="paging" href="boardList.do?pg=${i}">[${i}]</a>
					</c:if>
				</c:forEach> <c:if test="${endPage < totalP }">
					<a class="paging" href="boardList.do?pg=${ endPage + 1 }">[다음]</a>
				</c:if></td>
		</tr>
	</table>
	<br>
	<c:if test="${memId == null }">
		<a href="../member/loginForm.do">로그인</a>
		<a href="../main/index.do">메인화면</a>
	</c:if>
	
	<c:if test="${memId != null }">
		<a href="boardWriteForm.do">글쓰기</a>
		<a href="../main/index.do">메인화면</a>
	</c:if>
</body>
</html>
