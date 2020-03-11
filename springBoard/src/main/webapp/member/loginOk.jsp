<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%-- 
<script type="text/javascript">
	window.onload = function() {
		document.getElementById("result").innerHTML = "<%= name %>님이 로그인";
	} 
</script>
--%>
</head>
<body>
<p id="result">
	<img alt="가방" src="../image/ryan.jpg" width="130" height="130" onclick="location.href='../main/index.do'"
	style="cursor: pointer;"><br>${memName}님이 로그인
</p>
</body>
</html>