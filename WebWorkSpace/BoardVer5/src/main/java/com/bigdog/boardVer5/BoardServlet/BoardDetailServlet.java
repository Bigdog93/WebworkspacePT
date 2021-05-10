package com.bigdog.boardVer5.BoardServlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bigdog.boardVer5.BoardDAO.BoardDAO;
import com.bigdog.boardVer5.BoardDAO.BoardVO;
import com.bigdog.boardVer5.BoardDAO.ComentVO;


@WebServlet("/detail")
public class BoardDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strNo = request.getParameter("iboard");
		int iboard = Integer.parseInt(strNo);
		
//		int iboard = MyUtils.getParamInt("iboard", request);
		
		BoardVO vo = new BoardVO();
		vo.setIboard(iboard);
		vo = BoardDAO.selBoard(vo);
		BoardDAO.viewCount(vo);
		List<ComentVO> cmts = BoardDAO.readCmts(vo);
		
		request.setAttribute("cmt_list", cmts);
		request.setAttribute("data", vo);
		
		String jsp = "/WEB-INF/jsp/detail.jsp";
		request.getRequestDispatcher(jsp).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strNo = request.getParameter("iboard");
		int iboard = Integer.parseInt(strNo);
		String cmt = request.getParameter("cmt");
		String cmtID = request.getParameter("cmtID");
		ComentVO cvo = new ComentVO(iboard, cmt, cmtID);
		int test = BoardDAO.writeComent(cvo);
		
		response.sendRedirect("/rdetail?iboard=" + iboard);
	}

}
