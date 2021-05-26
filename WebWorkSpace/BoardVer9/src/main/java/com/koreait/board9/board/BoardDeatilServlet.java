package com.koreait.board9.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board9.MyUtils;


@WebServlet("/board/detail")
public class BoardDeatilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int iboard = MyUtils.getParamInt("iboard", request);
		BoardDTO param = new BoardDTO();
		param.setIboard(iboard);
		
		request.setAttribute("data", BoardDAO.selBoard(param));
		
		MyUtils.openJSP("글제목", "board/boarddetail", request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
