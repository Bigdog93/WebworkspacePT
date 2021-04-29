package com.koreait.first;
// 책으로 치면 95p 쯤..
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/list") // 이게 없었으면, web.xml에다가 엄청 길게 적어서 이쪽으로 연결을 시켜줘야 했다.
// jsp는 경로/파일이름.jsp가 주소인데 서블릿은 이게 주소다. (문자열) 그래서 이부분이 중요해!!
// 이 주소로 요청이 들어오면 아래 메소드를 호출해주는데, Get방식이면 doGet메소드를, Post방식이면 doPost메소드를 호출해준다.(톰캣이..)
public class BoardListServlet extends HttpServlet { // 클래스이름은 1도 상관없음..
	private static final long serialVersionUID = 1L;
       
    public BoardListServlet() {
        super();
    }

    // Get 방식과 Post 방식의 차이점
    // Get : 서버에다가 자료를 보낼건데 주소에다가 담아서 보낸다. (네이버 검색시, 주소 마지막에(?뒤에) 검색어가 찍히는거 Get 방식) 비용이 적게 들고 속도가 조금 빠르다.
    // 대부분은 Get방식을 사용한다.
    // Post : 서버에다가 자료(요청)를 보내는데 숨겨서 보낸다. (보통 로그인시, 아이디와 비밀번호를 주소창에 담을 수 없기 때문에 Post 방식으로 보낸다.)
    // 같은 주소임에도 Get이냐 Post냐에 따라 다른 응답을 보낼 수도 있다.
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { // 톰캣이 이거 나중에 호출해줄꺼야(프레임워크)
		// 내가 호출해서 쓰는거는 라이브러리, 누가 호출해서 쓰는걸 프레임워크
		// request에는 어떤 클라이언트가, 어떤 IP에서 어떤 브라우저로 어떤 요청을 보냈는지에 대한 모든 정보가 다 담겨있다.
		// response에는 우리가 보내줄 응답에 대한 모든 정보를 담을 것이다.
		System.out.println("doGet");
		
		response.setCharacterEncoding("UTF-8");
		response.getWriter() // getWriter() 메소드가 리턴하는건 PrintWriter 클래스의 객체. 즉, new PrintWriter().append() 와 같다. 또는 out.print()
		.append("<html>")
		.append("<head><title>안녕</title><meta charset=\"UTF-8\"></head>")
		.append("<body>")
		.append("Served at: ") // 이렇게 쓰는걸 체인메소드 기술
		.append(request.getContextPath()) // 이렇게 servelet에서 바로 뿌려줄 수도 있다.
		.append("</body>")
		.append("</html>"); // 이런식으로 할 수 있지만 이렇게는 절대 안함..ㅡㅡ... 
		// ☆★문자열로써 응답을 보내준다는 원리를 이해할 것.(HTML파일로 읽을 수 있도록)
		// 이제 여기서 WEB-INF 안에 있는 은닉화된 jsp 파일을 응답으로 줄꺼야.
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
		doGet(request, response);
	}
	

}
