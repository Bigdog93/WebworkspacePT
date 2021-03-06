package com.koreait.board4;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/detail")
public class BoardDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int no = MyUtils.getParamInt("no", request);
		
		BoardVO vo = BoardDAO.selectBoard(no);
		
		List<CmtVO> cvo_list = BoardDAO.cmtSelect(vo);
		
		request.setAttribute("data", vo);
		request.setAttribute("cmt_data", cvo_list);
		
		MyUtils.openJSP("detail", request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
