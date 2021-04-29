<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<input type="text" id = "num1" value="123"> <!-- HTML 객체에는 메소드가 없다. 속성(type, id, value같은 애들)만 가짐 -->
		<input type="number" id = "num2"> <!-- value = "입력하기 전 기본값" -->
		<button onclick="sum()">더하기</button>
		<button onclick="minus()">빼기</button>
	</div>
	<div>
		<input type="number" id="result">
	</div>
	
	<script>
		var num1Elem = document.getElementById('num1'); // 옛날엔 이걸 많이 썼다. 아래가 없었으니까
		var num2Elem = document.querySelector('#num2'); // 이게 더 조아 이거 써 #(id), .(클래스) CSS 선택자와 같음
		var resultElem = document.querySelector('#result'); //참고로 HTML에서 가져오면 다 문자열로 가져온다
		//  html 안의 요소들과 '주소를 가져와 연결'시키는것. 가지고있는 '값을 가져오는' 것이 아니다.
		// 사실 이렇게 안가져오고 밑에서 걍 id값.value만 해도 알아서 가져온데 ㄷㄷ 근데 추천하진 않음
		
		function sum() {
			var num1 = parseInt(num1Elem.value);
			var num2 = parseInt(num2Elem.value);
			console.log('num1 : %s', num1);
			
			resultElem.value = num1 + num2; // 이 엘리먼트에 있는.이것을 = 이걸로 바꾼다.
		}
		function minus() {
			var num1 = parseInt(num1Elem.value);
			var num2 = Number(num2Elem.value);
			resultElem.value = num1 - num2;
		}
	</script>
</body>
</html>