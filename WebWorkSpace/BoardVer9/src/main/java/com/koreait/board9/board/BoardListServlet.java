package com.koreait.board9.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board9.MyUtils;


@WebServlet("/board/list")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//페이징 처리
		final int recordCnt = 5;
		int cPage = MyUtils.getParamInt("cPage", request);
		cPage = (cPage != 0) ? cPage :  1;
		int startIdx = (cPage-1) * recordCnt;
		BoardDTO param = new BoardDTO(startIdx, recordCnt);
		
		 //검색 담당
		int searchType = MyUtils.getParamInt("searchType", request);
		String searchText = request.getParameter("searchText");
		
		if(searchType != 0 && searchText != null && !searchText.equals("")) {
			param.setSearchText(searchText);
			param.setSearchType(searchType);
		}
		
		
		request.setAttribute("cPage", cPage);
		request.setAttribute("maxPage", BoardDAO.maxPage(param));
		request.setAttribute("list", BoardDAO.selBoardList(param));
		MyUtils.openJSP("LIST", "board/boardList", request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
