

function insertInfoConfirm() {

	if(document.regFrm.name.value.length == 0) {
		alert("이름을 입력해 주세요.");
		regFrm.name.focus();
		return;
	}
	
	if(document.regFrm.id.value.length == 0) {
		alert("ID를 입력해 주세요.");
		regFrm.id.focus();
		return;
	}
	
	if(document.regFrm.id.value.length < 4) {
		alert("ID는 4글자 이상이어야 합니다.");
		regFrm.id.value = "";
		regFrm.id.focus();
		return;
	}
	
	if(document.regFrm.pwd.value.length == 0) {
		alert("패스워드를 입력해 주세요.");
		regFrm.pwd.focus();
		return;
	}
	if(document.regFrm.pwd.value != document.regFrm.pwdCheck.value) {
		alert("패스워드가 일치하지 않습니다.");
		regFrm.pwd.value = "";
		regFrm.pwdCheck.value = "";
		regFrm.pwd.focus();
		return;
	}
	
	if(document.regFrm.address.value.length == 0) {
		alert("주소를 입력해 주세요.");
		regFrm.address.focus();
		return;
	}
	
	if(document.regFrm.major.value.length == 0) {
		alert("전공을 입력해 주세요.");
		regFrm.major.focus();
		return;
	}
	
	if(document.regFrm.gender.value == "") {
		alert("성별을 선택해 주세요.");
		regFrm.gender.focus();
		return;
	}
	
	document.regFrm.submit();
	
}

function updateInfoConfirm() {
	if(document.modiFrm.name.value.length == 0) {
		alert("이름을 입력해 주세요.");
		modiFrm.name.focus();
		return;
	}
	
	if(document.modiFrm.pwd.value.length == 0) {
		alert("비밀번호를 입력해 주세요.");
		modiFrm.pwd.focus();
		return;
	}
	
	if(document.modiFrm.pwd.value != document.modiFrm.pwdCheck.value) {
		alert("비밀번호가 일치하지 않습니다.");
		modiFrm.pwd.focus();
		return;
	}
	
	if(document.modiFrm.major.value.length == 0) {
		alert("전공을 입력해 주세요.");
		modiFrm.major.focus();
		return;
	}
	
	if(document.modiFrm.gender.value == "") {
		alert("성별을 선택해 주세요.");
		modiFrm.gender.focus();
		return;
	}
	
	document.modiFrm.submit();
}