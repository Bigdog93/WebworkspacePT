function delCmt(iboard, icmt) {
	console.log('iboard : ' + iboard);
	console.log(`iboard : ${iboard}, icmt : ${icmt}`); // 얘는 자바스크립트 문법이야. jsp에서 쓰면 EL식으로 인식함.
	if(confirm('삭제하시겠습니까?')) {
		location.href = `/board/cmt?icmt=${icmt}&iboard=${iboard}`;
	}
}

function moveToBack() {
	window.history.back();
}