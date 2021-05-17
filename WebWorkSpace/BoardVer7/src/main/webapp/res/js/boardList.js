function moveToDetail(iboard) {
	location.href="/board/detail?iboard="+iboard;
	console.log('board : ' + iboard);
	
}

function moveToBack() {
	window.history.back();
}