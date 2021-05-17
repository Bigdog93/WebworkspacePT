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

@WebServlet("/board/delete")
public class BoardDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!(MyUtils.loginChk(request))) {
			response.sendRedirect("/user/login");
			return;
		}
		int iboard = MyUtils.getParamInt("iboard", request);
		int iuser = MyUtils.getParamInt("iuser", request);
		HttpSession session = request.getSession();
		UserVO user = (UserVO) session.getAttribute("loginUser");
		if(user.getIuser() != iuser) {
			response.sendRedirect("/board/list");
		}
		BoardVO bvo = new BoardVO();
		bvo.setIboard(iboard);
		
		int test = BoardDAO.delBoard(bvo);
		response.sendRedirect("/board/list");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
