<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" href="/res/css/userMypage.css">
${sessionScope.loginUser.profileImg}
<div> 
	<!-- c:set은 var=""의 키값으로 value="" 값을 pageContext에 저장한다. -->
	<c:choose>
		<c:when test="${empty sessionScope.loginUser.profileImg }">
			<c:set var="img" value="/res/img/defaultprofile.jpg"/>
		</c:when>
		<c:otherwise>
			<c:set var="img" value="/res/img/user/${sessionScope.loginUser.iuser}/${sessionScope.loginUser.profileImg}"/>
		</c:otherwise>
	</c:choose>
</div>
<div>
	<!-- 파일 업로드의 경우 get방식 사용 불가. 무조건 post로 보내야 한다. -->
	<form action="mypage" method="post" enctype="multipart/form-data" id="frm" onsubmit="return imgChk();"> <!-- 파일을 서버한테 보낸다면 form에 무조건 enctype 줘야한다. -->
		이미지 변경 : <input type="file" name="profileImg" accept="image/*" multiple="multiple"> <!-- OS상에서 이미지로 분류된 파일만 허용. multiple="multiple" 속성은 다중으로 파일을 업로드 되게 해줌. 배열로 넘어감 -->
		<input type="submit" value="이미지 업로드"> <!-- 보내면 byte 폼으로 날아감 -->
	</form>
</div>
<div>
	<div><img src="${img}"></div>
	<div>회원번호 : ${sessionScope.loginUser.iuser}</div>
	<div>ID : ${sessionScope.loginUser.uid}</div>
	<div>Name : ${sessionScope.loginUser.unm}</div>
</div>

<script>
function imgChk() {
	var frmElem = document.querySeletor('#frm');
	if(frmElem.profileImg.files.length === 0) {
		alert('이미지를 선택해 주세요.');
		return false;
	}
	return true;
}
</script>