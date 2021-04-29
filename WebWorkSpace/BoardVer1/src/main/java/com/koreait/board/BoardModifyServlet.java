package com.koreait.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/modify")
public class BoardModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String str = request.getParameter("no");
		int no = Integer.parseInt(str);
		
		BoardVO vo = Database.getlist().get(no);
		request.setAttribute("board", vo);
		
		String url = "/WEB-INF/jsp/modify.jsp";
		request.getRequestDispatcher(url).forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String title = request.getParameter("title");
		String ctnt = request.getParameter("ctnt");
		String str = request.getParameter("no");
		int no = Integer.parseInt(str);
		
		// 1번 방법
//		BoardVO vo = new BoardVO();
//		vo.setTitle(title);
//		vo.setCtnt(ctnt);
		
		// 2번 방법
//		Database.getlist().get(no).setTitle(title);
//		Database.getlist().get(no).setCtnt(ctnt);
		
		// 2번 방법 변수이용
		BoardVO vo = Database.getlist().get(no);
		vo.setCtnt(ctnt);
		vo.setTitle(title);
		
//		List<BoardVO> refList = Database.getlist();
//		refList.add(vo);
//		Database.getlist().set(no, vo);
		
		response.sendRedirect("/detail?no=" + no); 
		// 수정 후 수정한 게시글로 바로 이동
	}

}
