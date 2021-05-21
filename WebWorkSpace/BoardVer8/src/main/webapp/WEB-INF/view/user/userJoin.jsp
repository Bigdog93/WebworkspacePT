<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<h1>Login</h1>
<div>
	<div>
		<a href="login">To Login</a>
	</div>
	<form id="frm">
		<div><input type="text" name="uid" placeholder="ID입력"></div>
		<div><input type="password" name="upw" placeholder="PW입력"></div>
		<div><input type="text" name="unm" placeholder="name"></div>
		<div>
			성별 :
			<label>여성 <input type="radio" name="gender" value="0" checked></label>
			<label>남성 <input type="radio" name="gender" value="1"></label>
		</div>
	</form>
	<input type="button" value="join" onclick="join();">
	<script>
		function join() {
			var frmElem = document.querySelector('#frm');
			var uid = frmElem.uid.value; // .은 속성에게 접근하는 거지만, 속성이 없다면 자식개체의 name으로 접근
			var upw = frmElem.upw.value; // 속성 value는 input 개체 안에 적힌 값
			var unm = frmElem.unm.value;
			var gender = frmElem.gender.value;
			
			/* var param = {
					'uid' : uid, // 키를 문자열로 해도 되고 안해도 된다.
					upw : upw,
					unm : unm,
					gender : gender
			}; // 자바스크립트의 객체 */
			
			var param = { uid, upw, unm, gender };
			// 멤버필드명과 변수명이 같다면 알아서 위 처럼 만들어줌
			// 중간에 다른애 있으면 이렇게 uid, 'ddd':upw, ... 이렇게 해주면 된다.
			
			console.log(param);
			
			ajax(param);
		}
		
		function ajax(param) {
			const init = {
					method: 'POST',
					/* headers: {
					      'Content-Type': 'application/json',
				    }, */
				    // JSON.stringify(obj) : 객체를 문자열형태로 바꿔줌
				    // JSON.parse(strObj) : 문자열을 객체로 바꿔줌
				    // body: JSON.stringify(param) // 객체안에서는 ;쓰면 안된다.
				    body: new URLSearchParams(param)
			};
			
			fetch('/user/join', init) // promise 객체기 때문에 then 사용 가능
			.then(function(res) { return res.json(); }) // .json()이 객체화 시키는 애인듯
			.then(function(myJson) { // 서버에서 보낸게 여기(myJson)에 객체로 담길꺼야
				console.log(myJson);
				console.log(myJson.result); // 멤버필드에 접근
				switch(myJson.result) {
				case 0:
					alert('fail to join');
					break;
				case 1:
					location.href = '/user/login';
					break;
				}
			});
		}
	</script>
</div>