function moveToDetail(iboard) {
	location.href="/board/detail?iboard="+iboard;
	console.log('board : ' + iboard);
	
}

function moveToList() {
	location.href="/board/list";
}