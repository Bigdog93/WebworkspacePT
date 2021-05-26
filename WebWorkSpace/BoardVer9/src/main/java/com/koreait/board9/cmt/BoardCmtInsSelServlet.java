package com.koreait.board9.cmt;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.koreait.board9.MyUtils;


@WebServlet("/board/cmtInsSel")
public class BoardCmtInsSelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	// 리스트 방식
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int iboard = MyUtils.getParamInt("iboard", request);
		System.out.println("iboard : " + iboard);
		BoardCmtEntity param = new BoardCmtEntity();
		param.setIboard(iboard);
		List<BoardCmtDomain> cmtlist = BoardCmtDAO.selBoardCmtList(param);
		/*
		리스트가 JSON이 되는 형태 :
		[
			{
				"icmt":22,
				"cmt":"아리랑스리랑",
				"regdt":"2021-05...",
				"iuser":5,
				"writerNm":"이름"
			},
			{
				"icmt":23,
				"cmt":...
				....
			}
		]
		직접 안만들꺼다...
		 */
		/*
		String json = "[";
		for(int i = 0; i < cmtlist.size(); i++) {
			String item = "{";
			BoardCmtDomain vo = cmtlist.get(i);
			item += "\"icmt\":";
			item += vo.getIcmt();
			item += "\"iboard\":";
			item += vo.getIboard();
			item += "},";
			json += item;
		}
		json += "]";
		*/
		
		Gson gson = new Gson();
		String json = gson.toJson(cmtlist);
		
		response.getWriter().append(json);
	}

	// 등록
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int iboard = MyUtils.getParamInt("iboard", request);
		String cmt = request.getParameter("cmt");
		int iuser = MyUtils.getLoginUserPk(request);
		
		BoardCmtEntity param = new BoardCmtEntity();
		param.setIboard(iboard);
		param.setCmt(cmt);
		param.setIuser(iuser);
		int result = BoardCmtDAO.insBoardCmt(param);
		
		response.getWriter().append("{\"result\":")
		.append(String.valueOf(result))
		.append("}").flush();
	}
	

}
