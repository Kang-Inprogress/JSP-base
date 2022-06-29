function fn_valid() {
	var objectGopsem = document.gu9dan;
	var D4n = objectGopsem.dan.value;
	
	if(D4n === "" || D4n == null) {
		alert("유효한 값이 아님!");
	} else {
		objectGopsem.method="get";
		objectGopsem.action="/proj06/99dan"
		objectGopsem.submit();
	}
}