function fn_validate() {
	var frmLogin = document.formlogin;
	var id = frmLogin.user_id.value;
	var pw = frmLogin.user_pw.value; //.value: 입력란의 값 불러오는 방법 	
	
	// 아이디 입력 여부 체크
	if((id == null || id.length == 0) || (pw == null || pw.length == 0 )) {
		alert("아이디와 비밀번호는 반드시 입력해야함!");
		console.log("fail");
	} else {
		// servlet으로 보내는 코드
		frmLogin.method = "post";
		frmLogin.action = "login5";
		frmLogin.submit();
		console.log("success");
	}
}