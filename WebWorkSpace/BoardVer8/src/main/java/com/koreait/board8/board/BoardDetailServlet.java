package com.koreait.board8.board;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.koreait.board8.MyUtils;


@WebServlet("/board/detail")
public class BoardDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MyUtils.openJSP("", "board/boarddetail", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int iboard = MyUtils.getParamInt("iboard", request);
		BoardVO param = new BoardVO();
		param.setIboard(iboard);
		
		BoardDAO.selectBoard(param);
		
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter pw = response.getWriter();
		Gson gson = new Gson();
		String json = gson.toJson(param);
		pw.append(json);
		
		/*
		pw.append("{\"iboard\":")
		.append(String.valueOf(param.getIboard()))
		.append(", \"unm\":\"")
		.append(param.getUnm())
		.append("\"")
		.append(", \"title\":")
		.append("\"")
		.append(param.getTitle())
		.append("\", \"ctnt\" : \"")
		.append(param.getCtnt())
		.append(", \"regdt\":\"")
		.append(param.getRegdt())
		.append("\"}");
		*/
		
		
//		{"iboard": 28, "title":"안녕", "ctnt":"반갑습니다."}
	}

}
