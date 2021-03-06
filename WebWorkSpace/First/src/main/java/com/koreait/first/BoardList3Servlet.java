package com.koreait.first;
/*
쿼리 스트링(QueryString)
	- get 방식으로 서버 요청을 보낼 때 같이 보내는 Date
	
	- 시작 : ?, 구분 : &, 구성 : 키=값
	
	예) 이름, 나이 정보를 보낸다.(서버에서 원한다.)
	/주소?name=홍길동&age=20  이게 바로 쿼리스트링!!
		쿼리스트링의 구성처럼 키와 값으로 이루어져 있는 것이 map. 배열과는 달리 순서는 없다.
	
 */
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/list3")
public class BoardList3Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name"); // get이든 post든 이렇게 받을 꺼야. 리턴타입은 무조건 String임.
		String age = request.getParameter("age");
		
		System.out.println("name : " + name);
		System.out.println("age : " + age);
		
		String jsp = "/WEB-INF/jsp/list3.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(jsp);
		rd.forward(request, response); // 포워딩 : 응답이 온 것을 다른 리소스로 보내는 메소드
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
