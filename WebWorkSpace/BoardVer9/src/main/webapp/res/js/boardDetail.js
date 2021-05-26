var cmtFrmElem = document.querySelector('#cmtFrm');

function regCmt() {

	var cmtVal = cmtFrmElem.cmt.value;
	
	var param = {
		iboard : cmtFrmElem.dataset.iboard,
		cmt : cmtVal
	};
	
	regAjax(param);
}

function regAjax(param) {
	const init = {
		method: 'POST',
		body: new URLSearchParams(param)
	}; // init은 설정해주는것.
	
	fetch('cmtInsSel', init)
	.then(function(res) {return res.json();})
	.then(function(myJson) {
		console.log(myJson);
		
		switch(myJson.result) {
			case 0:
				alert('등록실패!');
				break;
			case 1:
				cmtFrmElem.cmt.value = '';
				alert('등록성공!');
				break;
		}
	});
}


// 서버에 댓글 리스트 자료 달라고 요청하는 함수
function getListAjax() {
	var iboard = cmtFrmElem.dataset.iboard;
	
	// init 없이 쓰면 자동으로 GET 방식이다.
	fetch('cmtInsSel?iboard=' + iboard)
	.then(function(res) {
		return res.json(); // String을 객체로 만들어준다.(String 자체가 JSON형태로 날아오기 때문에 가능)
	}).then(function(myJson) {
		console.log(myJson);
	})
}

getListAjax(); // 이 파일이 임포트 되면 함수 1회 호출


