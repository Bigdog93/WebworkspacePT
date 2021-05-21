<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<h1>Login</h1>
<div class="err">${ errMsg }</div>
<div>
	<form id="frm">
		<div>
			<input type="text" name="uid" placeholder="ID입력">
		</div>
		<div>
			<input type="password" name="upw" placeholder="PW입력">
		</div>
		<input type="submit" value="로그인">
	</form>

	<div>
		<a href="join">join</a>
	</div>

</div>

