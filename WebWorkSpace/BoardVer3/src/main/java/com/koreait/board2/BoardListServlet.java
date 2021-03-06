package com.koreait.board2;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/list")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("database", Database.getList());
		
		String url = "/WEB-INF/jsp/list.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
/*
JSTL, EL식 > 내장객체
( 얘네 tomcat이 각자 생성되는 타이밍에 new로 객체 생성해줌
	1. pageContext : 하루살이 느낌. jsp파일이 (forwarding돼서)열렸을때 살고, jsp파일 응답 끝나면 죽는다.(request랑 비슷)
	2. request : 요청을 보낼 때마다 살고, 요청이 끝나면 죽는다.
	3. session : 브라우저를 키면 새로 생성되고, 특정시간동안 요청이 없으면(브라우저를 끄면) 죽는다.(브라우저별로 따로 생긴다)
	4. application : 톰캣을 킬때 살고, 톰캣을 끄면 죽는다. (웬만하면 안쓴다. 메모리 잡아먹어서)
)
네개다 setAttribute, getAttribute 하는건데 life cycle이 다르다.
위가 가장 짧고 아래가 가장 길다.

위에 세개는 클라이언트용, application은 서버용

EL식에서 사용하는건 1, 2번에서 setAttribute 해준걸로 쓴다.(주로)

doGet 메소드가 호출됐을때는 1번 빼고 다 살아있다.
*/