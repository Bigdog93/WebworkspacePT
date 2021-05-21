package com.sleepyaog.board7.common;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyUtils {
	public static void openJSP(String filenm, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = String.format("/WEB-INF/view/%s.jsp", filenm);
		request.getRequestDispatcher(url).forward(request, response);
	}
	
	public static int getParamInt(String param, HttpServletRequest request) {
		String str = request.getParameter(param);
		try {
			int result = Integer.parseInt(str);
			return result;
		} catch (Exception e) {
			return 0;
		}
	}
	
	
}
