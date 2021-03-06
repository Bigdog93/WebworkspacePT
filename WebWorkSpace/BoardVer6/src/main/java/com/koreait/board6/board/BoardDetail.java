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
import com.koreait.board6.coment.ComentDAO;
import com.koreait.board6.coment.ComentVO;
import com.koreait.board6.user.UserVO;


@WebServlet("/board/detail")
public class BoardDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		UserVO uvo = (UserVO)session.getAttribute("loginUser");
		if(uvo == null) {
			response.sendRedirect("/user/login");
			return;
		}
		int iboard = MyUtils.getParamInt("iboard", request);
		
		BoardVO bvo = new BoardVO();
		bvo.setIboard(iboard);
		List<ComentVO> cmt_list = ComentDAO.selectCmtList(bvo);
		BoardDAO.selectBoard(bvo);
		
		request.setAttribute("data", bvo);
		request.setAttribute("cmts", cmt_list);
		
		MyUtils.openJSP("board/detail", request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
