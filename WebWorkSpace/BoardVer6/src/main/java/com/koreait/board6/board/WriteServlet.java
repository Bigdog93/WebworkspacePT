package com.koreait.board6.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.koreait.board6.MyUtils;
import com.koreait.board6.user.UserVO;


@WebServlet("/board/write")
public class WriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(); // set이 안돼있으면 null이 넘어간다.
		UserVO loginUser = (UserVO) session.getAttribute("loginUser");
		if(loginUser == null) {
			response.sendRedirect("/user/login");
			return;
		}
		MyUtils.openJSP("board/write", request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String ctnt = request.getParameter("ctnt");
		HttpSession session = request.getSession(); // 이걸 jsp에 적고 파라미터로 받아오는 행위는 never 안된다. 해킹의 단초가 됨.
		UserVO uvo = (UserVO)session.getAttribute("loginUser");
		
		BoardVO bvo = new BoardVO(title, ctnt, uvo.getIuser());
		
		int test = BoardDAO.insertBoard(bvo);
		
		response.sendRedirect("list");
	}

}