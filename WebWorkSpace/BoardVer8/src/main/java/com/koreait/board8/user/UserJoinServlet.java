package com.koreait.board8.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board8.MyUtils;


@WebServlet("/user/join")
public class UserJoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MyUtils.openJSP("JOIN", "user/userJoin", request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uid = request.getParameter("uid");
		String upw = request.getParameter("upw");
		String unm = request.getParameter("unm");
		int gender = MyUtils.getParamInt("gender", request);
		
		System.out.println("uid : " + uid);
		System.out.println("upw : " + upw);
		System.out.println("unm : " + unm);
		System.out.println("gender : " + gender);
		
		//int result = UserDAO.join(객체)
		int result = 1;
		
		PrintWriter pw = response.getWriter();
		pw.append(String.format("{\"result\": %d}", result)); 
		// append : 문자열 덧붙이기
		// myJson에 담을애를 객체 형태로
		// {"result": 1}
		// JSON의 문자열 멤버필드는 무조건 "" 여야한다.
	}

}