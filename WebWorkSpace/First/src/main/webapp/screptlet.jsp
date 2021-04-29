<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	int a = 10;
	int b = 20;
	int c = a + b;
	
	out.print("<div>");
	out.print(c);
	out.print("<div>");
%>
<hr>
<div><%=c %></div> <!-- 표현식 : 위에 print 세줄과 같은 일. 자바변수에 담긴 값을 찍어라. -->
</body>
</html>