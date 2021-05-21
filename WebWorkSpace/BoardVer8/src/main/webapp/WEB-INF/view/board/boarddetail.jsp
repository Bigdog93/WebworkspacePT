<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h1 id="title">
		
	</h1>
	<div>
		<div id="ctnt"></div>
	</div>
	<div>글번호 : <span id="iboard"></span></div>
	<div>글쓴이 : <span id="unm"></span></div>
	<div>작성일시 : <span id="regdt"></span></div>
	<button onclick="moveToList()">목록</button>
	
<script>
	function ajax(iboard) {
		console.log('iboard : ' + iboard);
		
		
		
		const param = { iboard }
		
		/* 이걸로 body에 저거 실어서 POST방식으로 실행 */
		const init = {
				method: 'POST',
				body: new URLSearchParams(param)
		}
		
		fetch('/board/detail', init)
		.then(function(res) {
			return res.json();
		})
		.then(function(myJson) {
			setData(myJson);
		});
	}
	
	function setData(data) {
		var title = document.querySelector('#title');
		var iboard = document.querySelector('#iboard');
		var unm = document.querySelector('#unm');
		var regdt = document.querySelector('#regdt');
		var ctnt = document.querySelector('#ctnt');
		
		iboard.innerText = data.iboard;
		title.innerHTML = data.title;
		unm.innerHTML = data.unm;
		regdt.innerHTML = data.regdt;
		ctnt.innerHTML = data.ctnt;
	}
	
	ajax(${param.iboard});
</script>