package com.koreait.board6.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.koreait.board6.MyUtils;


@WebServlet("/user/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		UserVO user = (UserVO) session.getAttribute("loginUser");
		if(user != null) {
			response.sendRedirect("/board/list");
			return;
		}
		
		MyUtils.openJSP("user/login", request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uid = request.getParameter("uid");
		String upw = request.getParameter("upw");
		
		UserVO uvo = new UserVO();
		uvo.setUid(uid);
		uvo.setUpw(upw);
		
		int result = UserDAO.loginUser(uvo);
		
		if(result == 1) {
			HttpSession session = request.getSession();
			uvo.setUpw(null);
			session.setAttribute("loginUser", uvo);
			// uvo 가 가리키는 UserVO 객체는 (iuser, uid, unm값만 담고 있다)
			
			response.sendRedirect("/board/list");
			return;
		}
		
		String errMsg = null;
		switch(result) {
		case 0:
			errMsg = "에러가 발생하였습니다.";
			break;
		case 2:
			errMsg = "아이디를 확인해 주세요.";
			break;
		case 3:
			errMsg = "비밀번호를 확인해 주세요.";
			break;
		default:
			errMsg = "로그인이 필요합니다.";
		}
		request.setAttribute("errMsg", errMsg);
		doGet(request, response); // 이렇게 하면 request 와 response를 다 보내주기 때문에 편함
//		response.sendRedirect("login"); // request가 새로 시작되기 때문에 쿼리스트링으로 보내주는 방법 뿐
		
	}

}