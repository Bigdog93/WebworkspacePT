package com.koreait.board6.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board6.MyUtils;


@WebServlet("/user/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MyUtils.openJSP("user/login", request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uid = request.getParameter("uid");
		String upw = request.getParameter("upw");
		
		UserVO uvo = new UserVO();
		uvo.setUid(uid);
		uvo.setUpw(upw);
		
		int result = UserDAO.loginUser(uvo);
		switch(result) {
		case 1:
			response.sendRedirect("/board/list");
			break;
		default:
			doGet(request, response); // 이렇게 하면 request 와 response를 다 보내주기 때문에 편함
//			response.sendRedirect("login"); // request가 새로 시작되기 때문에 쿼리스트링으로 보내주는 방법 뿐
			break;
		}
	}

}
