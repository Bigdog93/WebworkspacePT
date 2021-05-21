package com.koreait.board8.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board8.Const;
import com.koreait.board8.MyUtils;


@WebServlet("/board/list")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String search = request.getParameter(Const.SEARCH);
		if(search == null) { search = ""; }
		
		int page = MyUtils.getParamInt("page", request);
		if(page == 0) { page = 1; } // 쿼리스트링 없이 접근했을때
		
		int recordCnt = 10;
		
		int sIdx = (page - 1) * recordCnt;
		
		BoardVO param = new BoardVO();
		param.setsIdx(sIdx);
		param.setPage(recordCnt);
		param.setSearch(search);
		
		request.setAttribute("totalPage", BoardDAO.getAllPage(param));
		request.setAttribute("boardlist", BoardDAO.selBoardList(param));
		
		MyUtils.openJSP("list", "board/boardlist", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
