package com.koreait.board7.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.koreait.board7.MyUtils;
import com.koreait.board7.user.UserVO;


@WebServlet("/board/write")
public class BoardWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		UserVO uvo = (UserVO)session.getAttribute("loginUser");
		if(uvo == null) {
			response.sendRedirect("/user/login");
		}
		MyUtils.openJSP("board/boardwrite", request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String ctnt = request.getParameter("ctnt");
		HttpSession session = request.getSession();
		UserVO uvo = (UserVO) session.getAttribute("loginUser");
		int iuser = uvo.getIuser();
		BoardVO bvo = new BoardVO(title, ctnt, iuser);
		
		int test = BoardDAO.insBoard(bvo);
		response.sendRedirect("/board/list");
	}

}
