<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<div>
		<div>
			<form method="post"> <!-- form에 아무것도 안적으면, 본인(현재 주소)에게 get방식으로 나타남 -->
				<div><input type="text" name="uid" placeholder="아이디"></div> <!-- placeholder : 빈칸에 흐리게 나타나는 글 -->
				<div><input type="password" name="upw" placeholder="비밀번호"></div>
				<div>
					<input type="submit" value="Login">
				</div>
			</form>
		</div>
		<div>
			<a href="join">회원가입</a> <!-- 앞에 /없이 적어놓을경우, 그 경로단계에서 바뀐다. 예) user/login에서 누를경우, user/join으로 넘어간다. -->
		</div>
	</div>
</body>
</html>