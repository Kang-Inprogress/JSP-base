function fn_validate() {
	var fl = document.formlogin;
	var pw = fl.user_pw.value; 
	
	// 비밀번호 유효성 체크
	if(pw != null && pw.length != 0) {
		fl.method = "post";
		fl.action = "../loginTest";
		fl.submit();
		console.log("success");
	} else {
		// servlet으로 보내는 코드
		alert("올바르지 않은 비밀번호 입니다!");
		console.log("fail");
	}
}	