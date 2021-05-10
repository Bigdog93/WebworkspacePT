package com.koreait.board6;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyUtils {
	
	public static void openJSP(String fileNm, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String jsp = String.format("/WEB-INF/view/%s.jsp", fileNm);
		request.getRequestDispatcher(jsp).forward(request, response);
	}
	
	public static int parseStringToInt(String str) {
		try {
			return Integer.parseInt(str);
		} catch (Exception e) {
			System.out.println(e);
			return 0;
		}
	}
	
	public static int getParamInt(String key, HttpServletRequest request) {
		return parseStringToInt(request.getParameter(key));
	}
}
