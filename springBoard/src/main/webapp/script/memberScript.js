

function checkWrite() {
	if(!document.writeForm.name.value) { // 입력값이 없으면
		alert("이름을 입력하세요");
		document.writeForm.name.focus();
	} else if(!document.writeForm.id.value) { // 입력값이 없으면
		alert("ID를 입력하세요");
		document.writerForm.id.focus();
	} else if(!document.writeForm.pwd.value) { // 입력값이 없으면
		alert("비밀번호를 입력하세요");
		document.writeForm.pwd.focus();
	} else if(document.writeForm.pwd.value != document.writeForm.repwd.value) {
		alert("비밀번호가 일치하지 않습니다.");
		document.writeForm.pwd.focus();
	} else {
		document.writeForm.submit();
	}
}

function checkLogin() {
	if(!document.loginForm.id.value) {
		alert("ID를 입력하세요");
		document.loginForm.id.focus();
	} else if(!document.loginForm.pwd.value) {
		alert("비밀번호를 입력하세요");
		document.loginForm.pwd.focus();
	} else {
		document.loginForm.submit();
	}
}

function checkId () {
	var sId = document.writeForm.id.value;
	if(sId==""){
		alert("ID를 입력하세요");
		document.writeForm.id.focus();
	} else {
		window.open("checkId.do?id="+sId,"","width=700 height=350 left=500 top=200");
	}
}

function checkModify() {
	if(!document.modifyForm.name.value) { // 입력값이 없으면
		alert("이름을 입력하세요");
		document.modifyForm.name.focus();
	} else if(!document.modifyForm.id.value) { // 입력값이 없으면
		alert("ID를 입력하세요");
		document.modifyForm.id.focus();
	} else if(!document.modifyForm.pwd.value) { // 입력값이 없으면
		alert("비밀번호를 입력하세요");
		document.modifyForm.pwd.focus();
	} else if(document.modifyForm.pwd.value != document.modifyForm.repwd.value) {
		alert("비밀번호가 일치하지 않습니다.");
		document.modifyForm.pwd.focus();
	} else if(!document.modifyForm.email1.value) {
		alert("이메일 주소를 입력하세요.");
		document.modifyForm.email1.focus();
	} else if(!document.modifyForm.email2.value) {
		alert("도메인을 선택하세요.");
		document.modifyForm.email2.focus();
	} else if(!document.modifyForm.tel1.value) {
		alert("연락처를 입력하세요.");
		document.modifyForm.tel1.focus();
	} else if(!document.modifyForm.tel2.value) {
		alert("연락처를 입력하세요.");
		document.modifyForm.tel2.focus();
	} else if(!document.modifyForm.tel3.value) {
		alert("연락처를 입력하세요.");
		document.modifyForm.tel3.focus();
	} else if(!document.modifyForm.addr.value) {
		alert("주소를 입력하세요.");
		document.modifyForm.addr.focus();
	} else document.modifyForm.submit();
}

function checkId2 () {
	var sId = document.modifyForm.id.value;
	if(sId==""){
		alert("ID를 입력하세요");
		document.modifyForm.id.focus();
	} else {
		window.open("checkId2.do?id="+sId,"","width=700 height=350 left=500 top=200");
	}
}





