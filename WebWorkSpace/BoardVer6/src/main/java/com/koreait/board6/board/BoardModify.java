package com.koreait.board6.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board6.MyUtils;


@WebServlet("/board/modify")
public class BoardModify extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int iboard = MyUtils.getParamInt("iboard", request);
		BoardVO bvo = new BoardVO();
		bvo.setIboard(iboard);
		BoardDAO.selectBoard(bvo);
		request.setAttribute("data", bvo);
		MyUtils.openJSP("board/modify", request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int iboard = MyUtils.getParamInt("iboard", request);
		int iuser = MyUtils.getLoginUserPk(request);
		String title = request.getParameter("title");
		String ctnt = request.getParameter("ctnt");
		
		BoardVO bvo = new BoardVO();
		bvo.setIboard(iboard);
		bvo.setIuser(iuser);
		bvo.setTitle(title);
		bvo.setCtnt(ctnt);
		int test = BoardDAO.modifyBoard(bvo);
		
		response.sendRedirect("detail?iboard="+iboard);
	}

}
