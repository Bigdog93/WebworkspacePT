package com.koreait.board9.user;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.koreait.board9.MyFileUtils;
import com.koreait.board9.MyUtils;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


@WebServlet("/user/mypage")
public class UserMypageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserEntity loginUser = MyUtils.getLoginUser(request);
		if(loginUser == null) {
			response.sendRedirect("/user/login");
			return;
		}
		MyUtils.openJSP("마이페이지", "user/userMypage", request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uploadPath = request.getServletContext().getRealPath("/res/img");
		// 어플리케이션으로 부터 가져오는 것
		// .getRealPath() 메소드 : 현재 톰캣이 돌아가고 있는 실제 경로(wtpwebapp폴더)를 문자열로(C:단위부터) 가져오는 메소드. 괄호안에 문자열은 뒤에 덧붙이는것
		int maxFileSize = 10_485_765; // 10* 1024 * 1024 (10mb) byte단위로 계산결과를 써주는게 좋아
		try {
		MultipartRequest multi = new MultipartRequest(request, uploadPath + "/temp", maxFileSize, "UTF-8", new DefaultFileRenamePolicy());
		// cos.jar 에 들어있는 객체
		// request, 업로드 경로, 최대사이즈, 인코딩타입, ...
		// 파일이 실려있는 모든 애들, 어디 저장할래?, 최대사이즈, 인코딩 타입, 
		// 만약에 중복된 이름이 있으면 그 이름에 1 붙인 다음에 저장해주는 객체
		// 실제로 패킷들로 나눠서 request에 실려온 애들을 실제 파일로 만들어주는 애
		// 패킷으로 보내는 이유 : 서버를 많은 사람이 쓸 경우, 큰 덩치 째로 보내면 점유가 되어버리기 때문에 시분할이 되도록 패킷단위로 나눠서 보내는 것.
		// 망형태로 퍼진 경로를 따라 뿔뿔이 흩어져서 온다. (망 사이사이에 설치된 라우터가 길을 알려줌) 모두가 목적지에 도착하면 업로드가 끝남
		
		
//		multi.getOriginalFileName("profileImg"); 바뀌기 전 원래 이름 요청. 쓸일 없음
		String fileNm = multi.getFilesystemName("profileImg");
		// 위에 DefaultFileRenamePolicy()로 바뀐 이름을 요청하는 메소드
		// 괄호안에 '키값'은 input type='file'의 name이 가진 키값이다.
		
		if(fileNm == null) {
			doGet(request, response);
			return;
		}
		
		
		int loginUserPk = MyUtils.getLoginUserPk(request);
		
		String targetFolder = uploadPath + "/user/" + loginUserPk;
		// 실제로 우리가 파일을 위치시켜야 하는 '폴더'의 주소
		
		File folder = new File(targetFolder); // 파일 객체
		// File 객체 : 디렉토리를 만들 수 있다.(윈도우에게 요청을 보냄)
		
//		folder.delete(); 폴더를 지우려고 하면 안에 파일이 있을경우 안지워진다.
		MyFileUtils.delFolder(targetFolder); // 만들어둔 메소드 for문 돌면서 안에 파일까지 다 지워줌
		
		// if(!folder.exists()) { // .exists() : 해당 경로의 폴더(또는 파일)가 있으면 true, 없으면 false
		folder.mkdirs(); // mkdir : 한 깊이만 가능. mkdirs : 경로상의 모든 폴더 만들어줌
		// } // ** 이지만, 어차피 mkdirs() 메소드 안에서 존재하는지 검사해주기 때문에 if문은 필요가 없다.
		
		System.out.println("fileNm: " + fileNm);
		
		int lastDotIdx = fileNm.lastIndexOf("."); // 오른쪽에서부터 찾아서 그 index를 반환 (index는 항상 0부터 시작)
		String ext = fileNm.substring(lastDotIdx); // 그 위치로 부터 끝까지 잘라줌(.jpg 이런식). 비파괴 메소드. (어디서부터, 어디'전'까지) OR (여기부터 끝까지)
		// 확장자 명을 가져오는 방법
		
		String newFileNm = UUID.randomUUID().toString() + ext;
		// UUID : 문자열 랜덤으로 만들어줌
		
		File imgFile = new File(uploadPath + "/temp/" + fileNm);
		imgFile.renameTo(new File(targetFolder + "/" + newFileNm)); // 위치/파일명을 바꿔주는 메소드(파일객체로 넣어줘야한다.)
//		imgFile.renameTo(new File("C:\\Git\\WebworkspacePT\\WebWorkSpace\\BoardVer9\\src\\main\\webapp\\res\\img\\user/" + loginUserPk + "/" + newFileNm));
		
		UserEntity param = new UserEntity();
		param.setIuser(loginUserPk);
		param.setProfileImg(newFileNm);
		UserDAO.updUser(param);
		
		MyUtils.getLoginUser(request).setProfileImg(newFileNm);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		response.sendRedirect("mypage");
	}

}
