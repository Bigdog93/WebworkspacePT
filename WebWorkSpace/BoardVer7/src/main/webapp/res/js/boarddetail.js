function delCmt(iboard, icmt) {
	console.log('iboard : ' + iboard);
	console.log(`iboard : ${iboard}, icmt : ${icmt}`); // 얘는 자바스크립트 문법이야. jsp에서 쓰면 EL식으로 인식함.
	if(confirm('삭제하시겠습니까?')) {
		location.href = `/board/cmt?icmt=${icmt}&iboard=${iboard}`;
	}
}

function modCmt(iboard, icmt) {
	location.href = `/board/cmt?icmt=${icmt}&iboard=${iboard}`;
}

function moveToList() {
	location.href="/board/list";
}

var insFrmElem = document.querySelector('#insFrm'); /* id값이 insFrm인 태그에 접근할 수 있는 주소값 */
var updFrmElem = document.querySelector('#updFrm');

// 댓글 수정
function updCmt(icmt, cmt) {
	console.log('icmt : %d', icmt);
	console.log('cmt : %s', cmt);
	
	updFrm.icmt.value = icmt;
	updFrm.cmt.value = cmt;
	// 자바스크립트에서 .은 속성뿐 아니라 하위개체에 접근할 때도 쓴다. 같은 이름의 속성이 없으면 하위 개체중 name으로 접근
	insFrm.className = 'hidden';
	updFrm.className = '';
	
}

function showInsFrm() {
	insFrm.className = '';
	updFrm.className = 'hidden';
}