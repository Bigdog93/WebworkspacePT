<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 
	이벤트 거는 방법
	- onclick, onsubmit 등 on~속성을 통한 방법
	- 자바 스크립트를 통해
 -->
<form id="frm" action="join" method="post" onsubmit="return frmChk();"> <!-- on~ : ~이벤트가 일어날때. onsubmit : return 이 들어가야하고, false가 아니면 날아간다. -->
	<div>
		<input type="text" name="uid" placeholder="ID입력">
		<input type="button" id="btnChkId" value="중복체크">
		<div id="chkUidResult"></div>
	</div>
	<div><input type="password" name="upw" placeholder="비밀번호"></div>
	<div><input type="password" name="chkUpw" placeholder="비밀번호 확인"></div>
	<div><input type="text" name="unm" placeholder="이름"></div>
	<div>성별 : <label>남<input type="radio" name="gender" value="1" checked></label><label>여<input type="radio" name="gender" value="0"></label></div>
	<div>
		<input type="submit" value="회원가입">
		<input type="reset" value="초기화">
	</div>
</form>

<script defer src="/res/js/userJoin.js"></script>