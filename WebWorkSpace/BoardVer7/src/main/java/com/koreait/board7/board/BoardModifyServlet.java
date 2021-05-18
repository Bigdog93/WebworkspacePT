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


@WebServlet("/board/modify")
public class BoardModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int iboard = MyUtils.getParamInt("iboard", request);
		BoardVO bvo = new BoardVO();
		bvo.setIboard(iboard);
		int iuser = bvo.getIboard();
		HttpSession session = request.getSession();
		UserVO user = (UserVO) session.getAttribute("loginUser");
		if(user.getIuser() != iuser) {
			response.sendRedirect("/board/list");
		}
		
		
		BoardDAO.selBoard(bvo);
		request.setAttribute("data", bvo);
		MyUtils.openJSP("/board/boardmodify", request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String ctnt = request.getParameter("ctnt");
		int iboard = MyUtils.getParamInt("iboard", request);
		BoardVO bvo = new BoardVO();
		bvo.setTitle(title);
		bvo.setCtnt(ctnt);
		bvo.setIboard(iboard);
		int test = BoardDAO.updBoard(bvo);
		
		response.sendRedirect("detail?iboard=" + iboard);
	}

}
