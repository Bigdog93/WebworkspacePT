package com.koreait.board7.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board7.MyUtils;


@WebServlet("/board/list")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(!(MyUtils.loginChk(request))) {
			response.sendRedirect("/user/login");
			return;
		}
		
		List<BoardVO> boardlist = BoardDAO.selBoardList();
		
		
		request.setAttribute("boardlist", boardlist);
		
		MyUtils.openJSP("board/boardlist", request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String schWord = request.getParameter("schWord");
		BoardVO bvo = new BoardVO();
		bvo.setCtnt(schWord);
		List<BoardVO> boardlist = BoardDAO.selBoardList(bvo);
		
		request.setAttribute("boardlist", boardlist);
		
		MyUtils.openJSP("board/boardlist", request, response);
	}

}
