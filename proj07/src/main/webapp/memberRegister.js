function addMember() {
	var frmMember = document.frmMember;
	var id = frmMember.id.value;
	var pwd = frmMember.pwd.value;
	var name = frmMember.name.value;
	var email = frmMember.email.value;

	if (id == "" || id.length == 0) {
		alert("유효하지 않은 값");
	} else if (pwd == "" || pwd.length == 0) {
		alert("유효하지 않은 값");
	} else if (name == '' || name.length == 0) {
		alert("유효하지 않은 값");
	} else if (email == '' || email.length == 0) {
		alert("유효하지 않은 값");
	} else {
		frmMember.method = "post";
		frmMember.action = "/proj07/MR";
		frmMember.submit();
	}
}