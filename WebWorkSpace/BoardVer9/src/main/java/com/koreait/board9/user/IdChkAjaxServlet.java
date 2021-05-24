package com.koreait.board9.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;



@WebServlet("/user/idChk")
public class IdChkAjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uid = request.getParameter("uid");
		int result = UserDAO.selIdChk(uid);
		String msg = "{\"result\": "+ result + "}";

		// String a = "a" + "b" + "c"; // 이러면 기억공간 5개 필요하데
//		StringBuilder sb = new StringBuilder();
//		sb.append("a").append("b").append("c"); // 이러면 기억공간 하나만 쓴다.
		
		PrintWriter pw = response.getWriter();
//		Gson gson = new Gson();
//		String json = gson.toJson(msg); // 자바 객체를 JSON 형태로 바꿔주는 아이
		pw.append(msg);
//		pw.println(); // 얘는 개행해주기.
//		pw.flush(); // 원래 이렇게 해야!! append로 붙여준걸 찍어준다. 안적어줘도 톰캣이 해줌
		pw.close(); // 스트림을 닫아줌
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
