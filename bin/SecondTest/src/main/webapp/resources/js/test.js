/**
 * 
 */
function checkAndMove(path) {
	if(path == 'doSignup') {
		if(checkErr(path)) {
			var obj = document.signinForm;
			var path = path;
			
			obj.method = "post";
			obj.action = path;
			obj.submit();
		}
	} else if(path == 'getCustList') {
		var obj = document.custListForm;
		var path = path;
		
		obj.method = "get";
		obj.action = path;
		obj.submit();
	} else if(path == 'getRcvapplList') {
		var obj = document.rcvapplListForm;
		var path = path;
		
		obj.method = "get";
		obj.action = path;
		obj.submit();
	}
}

function checkErr(path) {
	if(path = 'doSignup') {
		var frm = document.signinForm;
		var szKor = frm.hg_nm.value;
		var szEng = frm.eng_nm.value;
		var szNum = frm.scrt_no.value;
	
		if(szKor == "") {
			alert( "한글을 입력해주세요" )
			frm.hg_nm.value="";
			frm.hg_nm.focus();
		
			return false;
		} else {
			var kor_check = /([^가-힣ㄱ-ㅎㅏ-ㅣ\x20])/i;
			
			if (kor_check.test(szKor)) {
				alert("한글만 입력할 수 있습니다.");
				frm.hg_nm.value="";
				frm.hg_nm.focus();
				
				return false;
			}
		}
		
		if(szEng == "") {
			alert( "영어를 입력해주세요" )
			frm.eng_nm.value="";
			frm.eng_nm.focus();
		
			return false;
		} else {
			var eng_check = /^[A-za-z]/g;
			
			if (!eng_check.test(szEng)) {
				alert("영어만 입력할 수 있습니다.");
				frm.eng_nm.value="";
				frm.eng_nm.focus();
				
				return false;
			}
		}
		
		if(szNum == "") {
			alert("비밀번호를 입력하세요.");
			frm.scrt_no.value="";
			frm.scrt_no.focus();
			
			return false;
		} else {
			var cnt = 0;
			var cnt2 = 0;
			var tmp = "";
			var tmp2 = "";
			var tmp3 = "";
			var tmp4 = "";
	
			for(i=0; i<szNum.length; i++){
				tmp = szNum.charAt(i);
				tmp2 = szNum.charAt(i+1);
				tmp3 = szNum.charAt(i+2);
				tmp4 = szNum.charAt(i+3);
				
				if(tmp.charCodeAt(0) - tmp2.charCodeAt(0) == 1 && tmp2.charCodeAt(0) - tmp3.charCodeAt(0) == 1 && tmp3.charCodeAt(0) - tmp4.charCodeAt(0) == 1){
					cnt = cnt + 1;
				}
		
				if(tmp.charCodeAt(0) - tmp2.charCodeAt(0) == -1 && tmp2.charCodeAt(0) - tmp3.charCodeAt(0) == -1 && tmp3.charCodeAt(0) - tmp4.charCodeAt(0) == -1){
					cnt2 = cnt2 + 1;
				}
				
				if(cnt > 0 || cnt2 >0) {
					frm.scrt_no.value="";
					frm.scrt_no.focus();
					
					return false;
				} else {
					return true;
				}
			}				
		}
	}
}

function checkChanges() {
	var ssn = document.getElementById("ssn").value;
	var f_birth_d = ssn.substring(0, 1);
	var s_birth_d = ssn.substring(0, 2);
	var birth_d = ssn.substr(0, 6);
	
	if(s_birth_d > 21) {
		birth_d = "19" + birth_d;
		document.getElementById("birth_d").setAttribute("value", birth_d);
	} else {
		birth_d = "20" + birth_d;
		document.getElementById("birth_d").setAttribute("value", birth_d);
	}
}
