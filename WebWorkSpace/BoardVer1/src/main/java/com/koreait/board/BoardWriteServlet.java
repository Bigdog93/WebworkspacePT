package com.koreait.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/write")
public class BoardWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// a태그로 들어올때, get방식으로 요청을 받는다.
		request.getRequestDispatcher("/WEB-INF/jsp/write.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// form 태그를 통해 post 방식으로 받으면 이 메소드를 실행한다.
		
		request.setCharacterEncoding("UTF-8"); // Post방식 한글 안깨지게 방지
		String title = request.getParameter("title");
		String ctnt = request.getParameter("ctnt");
		// 클라이언트에서 뭐가 넘어온거 받을때는 '무조건' request.getParameter()로 받는다.
		
		BoardVO vo = new BoardVO();
		vo.setTitle(title);
		vo.setCtnt(ctnt);
		
//		List<BoardVO> refList = Database.getlist();
//		refList.add(vo);
		Database.getlist().add(vo);
		
		response.sendRedirect("/list"); // Get방식으로 주소이동쓰~~
		// R은 보통 두가지. 리스트와 디테일. 추후에 리스트 말고 디테일로 갈 수도 있다.(내가 쓴글 보기)
	}

}
