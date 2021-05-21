<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Join</title>
</head>
<body>
	<h1>JOIN</h1>
	<form method="post">
		<div>
			ID : <input type="text" name="uid" placeholder="ID">
		</div>
		<div>
			PW : <input type="password" name="upw" placeholder="PW">
		</div>
		<div>
			NAME : <input type="text" name="unm" placeholder="이름">
		</div>
		<div>
			GENDER : <label>남<input type="radio" name="gender" value="남" checked></label> <label>여<input type="radio" name="gender" value="여"> 여</label>
		</div>
		<div>
			PHONE NUMBER : <input type="text" name="ph" placeholder="전화번호">
		</div>
		<input type="submit" value="join"> <input type="reset" value="reset">
		</form>
</body>
</html>