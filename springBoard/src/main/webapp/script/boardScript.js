
function checkBoardWrite() {
	if(!document.boardWriteForm.subject.value) { // 입력값이 없으면
		alert("제목을 입력하세요");
		document.boardWriteForm.subject.focus();
	} else if(!document.boardWriteForm.content.value) { // 입력값이 없으면
		alert("내용을 입력하세요");
		document.boardWriteForm.content.focus();
	} else {
		document.boardWriteForm.submit();
	}
}

function checkBoardModify() {
	if(!document.boardModifyForm.subject.value) { // 입력값이 없으면
		alert("제목을 입력하세요");
		document.boardModifyForm.subject.focus();
	} else if(!document.boardModifyForm.content.value) { // 입력값이 없으면
		alert("내용을 입력하세요");
		document.boardModifyForm.content.focus();
	} else {
		document.boardModifyForm.submit();
	}
}