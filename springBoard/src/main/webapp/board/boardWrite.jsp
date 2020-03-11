<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<script type="text/javascript">
	window.onload = function() {
		if(${su > 0}){
			alert("작성하신 글을 저장했습니다.");
		} else { 
			alert("작성하신 글을 저장하지 못했습니다.");
		}
		location.href="boardList.do?pg=1";
	}
</script>
</head>
<body>

</body>
</html>