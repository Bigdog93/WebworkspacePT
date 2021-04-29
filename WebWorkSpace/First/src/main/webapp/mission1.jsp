<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% 
	// java파일로 만들어질때 이 문서 전체가 메소드 안에 들어가기 때문에, 메소드정의를 해줄 수 없다. 그러나..
%>

<%!
	// 앞에 !를 붙이면 메소드 안이 아니라, 메소드밖(전역)에 소스를 위치시켜 주기 때문에, 전역변수나, 메소드 정의시 이렇게 해줄 수 있다.
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mission1</title>
</head>
<body>
	<div>스크립틀릿 이해를 하였는가?</div>
	<div>for문을 이용하여 1 ~ 10 세로방향으로 찍히도록 해주세요.</div>
	<div>각 숫자들은 div로 감싸주세요.</div>
	<% for(int i = 1; i < 11 ; i++) {
		%><div><%=i %></div><%} %>

</body>
</html>