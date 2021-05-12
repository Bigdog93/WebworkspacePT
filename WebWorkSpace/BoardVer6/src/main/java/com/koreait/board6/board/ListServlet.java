package com.koreait.board6.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.koreait.board6.MyUtils;
import com.koreait.board6.user.UserVO;


@WebServlet("/board/list")
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		HttpSession session = request.getSession();
//		
//		Boolean loginSuccess = (Boolean)session.getAttribute("loginSuccess");
//		System.out.println("loginSuccess : " + loginSuccess);
//		if(loginSuccess == null || loginSuccess == false) {
//			response.sendRedirect("/user/login");
//			return;
//		}
//		
//		MyUtils.openJSP("board/list", request, response);
//	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(); // set이 안돼있으면 null이 넘어간다.
		UserVO loginUser = (UserVO) session.getAttribute("loginUser");
		if(loginUser == null) { // 로그아웃 상태면 로그인 페이지로 이동
			response.sendRedirect("/user/login");
			return;
		}
		List<BoardVO> list = BoardDAO.selectLise();
		
		request.setAttribute("list", list);
		
		MyUtils.openJSP("/board/list", request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
