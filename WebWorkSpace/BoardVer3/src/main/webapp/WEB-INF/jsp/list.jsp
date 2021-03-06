<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- jstl 쓰기 위한 import. 모든 jsp에 들어간다고 생각하면 됨 
jstl을 쓰면 스크립트릿을 쓸일이 거의 없다. 편하고, 가독성이 좋기때문에 뿅뿅 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리스트</title>
</head>
<body>
	<div>
		<h1>글 목록</h1>
		<a href="write"><button>글쓰기</button></a> <!-- 경로에 /안붙이면 끝의 주소만 바뀐다. (예: aaaa/ssss/dddd 일 경우, aaaa/ssss/write 이런식으로 -->
	</div>
	<div>
		<c:forEach var="i" begin="1" end="5" step="1"> <!-- pageContext에 setAttribute("i", 1)했다는 말
		변수=i, 1부터 5까지, 1씩 증가, 나중에 paging 처리 할때 쓸꼬얌-->
		<span>${i}</span>
		</c:forEach>
		<table>
			<tr>
				<th>no</th>
				<th>제목</th>
			</tr>
			<c:forEach var="item" items="${database}" varStatus="status"> <!-- varStatus : for문 돌때의 상태값 -->
			<!-- java for~each문 처럼 items에 들어온 배열객체에서 순서대로 뽑아네 item에 담아줌 -->
				<tr>
					<td>${status.count}</td>  <!-- 0부터 세아려준다.(count는 1부터) -->
					<!-- status. 
						current : 현재아이템
						index : 0부터의 순서
						count : 1부터의 순서
						first : 현재 루프가 처음인지 반환
						last : 현재 루프가 마지막인지 반환
						begin : 시작값
						end : 끝값
						step : 증가값 -->
					<td><a id="word${status.index}" href="/detail?no=${status.index}">${item.title}</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>