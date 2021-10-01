<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>signup.jsp</title>
<link rel="stylesheet" type="text/css" href="<c:url value="/css/main.css" />"/>
<script src="<c:url value="/js/test.js" />"></script>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" />
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>
<script type="text/javascript">
$(function() {
	$( "#appl_d" ).datepicker({
		dateFormat: "yymmdd",
        showOn: "both",
        buttonImage: "button.png",
        buttonImageOnly: true,
        changeMonth: true,
        changeYear: true,
        nextText: '다음 달',
        prevText: '이전 달'
	});
});
</script>
</head>
<body>
	<h1><a href="/form">홈으로</a></h1>
	<p class="titleStr">
		회원 입회 신청
	</p>
	<form name="signinForm">
		<div class="centerBox">
			<label for="ssn">주민번호 :</label> <input type="text" id="ssn" name="ssn" value="${ rcvappl.ssn }" onchange="checkChanges()" />&nbsp;&nbsp;&nbsp;
			<!-- 현재년도 -->
			<c:set var="now" value="<%=new java.util.Date()%>" />
			<c:set var="sysYear"><fmt:formatDate value="${now}" pattern="yyyyMMdd" /></c:set> 
			<label for="rcv_d">접수일자 :</label> <input type="text" name="rcv_d" value="<c:out value="${sysYear}" />" />&nbsp;&nbsp;&nbsp;
			<label for="rcv_seq_no">접수 일련번호 :</label> <input type="text" value="${ rcvappl.rcv_seq_no }" />
			<input type="button" value="조회" onclick="" /><br/>
			<hr/>
			<label for="appl_d">신청일자 : </label><input type="text" id="appl_d" name="appl_d" value="<c:out value="${sysYear}" />" />&nbsp;&nbsp;&nbsp;
			<label for="appl_clas">신청구분 :</label>
			<select name="appl_clas" style="width:180px;height:21.5px;">
			<c:forEach items="${ c007 }" var="c007">
				<option value="${ c007.code }" 
        		<c:if test="${rcvappl.appl_clas == c007.code}">selected</c:if>>${ c007.code_nm }</option>
			</c:forEach>
			</select>&nbsp;&nbsp;&nbsp;
			<label for="brd">브랜드:</label>
			<select name="brd" style="width:180px;height:21.5px;">
			<c:forEach items="${ c004 }" var="c004">
				<option value="${ c004.code }"
				<c:if test="${rcvappl.brd == c004.code}">selected</c:if>>${ c004.code_nm }</option>
			</c:forEach>
			</select>
			<br/><br/>
			<label for="hg_nm">성명(한글) :</label> <input type="text" name="hg_nm" value="${ rcvappl.hg_nm }" />&nbsp;&nbsp;&nbsp;
			<label for="eng_nm">성명(영문) :</label> <input type="text" name="eng_nm" value="${ rcvappl.eng_nm }" />&nbsp;&nbsp;&nbsp;
			<label for="birth_d">생년월일 :</label> <input type="text" id="birth_d" name="birth_d" value="${ rcvappl.birth_d }" placeholder="19911123" />
			<br/><br/>
			<label for="stl_dd">결제일자 :</label>
			<select name="stl_dd" style="width:180px;height:21.5px;">
			<c:forEach items="${ c009 }" var="c009">
				<option value="${ c009.code }"
				<c:if test="${rcvappl.stl_dd == c009.code}">selected</c:if>>${ c009.code_nm }</option>
			</c:forEach>
			</select>
			&nbsp;&nbsp;&nbsp;
			<label for="stl_mtd">결제방법 :</label>
			<select name="stl_mtd" style="width:180px;height:21.5px;">
			<c:forEach items="${ c002 }" var="c002">
				<option value="${ c002.code }"
				<c:if test="${rcvappl.stl_mtd == c002.code}">selected</c:if>>${ c002.code_nm }</option>
			</c:forEach>
			</select>&nbsp;&nbsp;&nbsp;
			<label for="bnk_cd">결제은행 :</label>
			<select name="bnk_cd" style="width:180px;height:21.5px;">
			<c:forEach items="${ c003 }" var="c003">
				<option value="${ c003.code }"
				<c:if test="${rcvappl.bnk_cd == c003.code}">selected</c:if>>${ c003.code_nm }</option>
			</c:forEach>
			</select>&nbsp;&nbsp;&nbsp;
			<br/><br/>
			<label for="stl_act">결제계좌 : </label><input type="text" name="stl_act" value="${ rcvappl.stl_act }" style="width:260px" />
			<input type="button" value="..." onclick="" />&nbsp;&nbsp;&nbsp;
			<label for="stl_act_conf">결제계좌 확인여부 : </label> <input type="text" name="stl_act_conf" style="width:260px" readonly="readonly" />
			<br/><br/>
			<label for="stmt_snd_mtd">청구서 발송방법 : </label>
			<select name="stmt_snd_mtd" style="width:150px;height:21.5px;">
			<c:forEach items="${ c006 }" var="c006">
				<option value="${ c006.code }"
				<c:if test="${rcvappl.stmt_snd_mtd == c006.code}">selected</c:if>>${ c006.code_nm }</option>
			</c:forEach>
			</select>&nbsp;&nbsp;&nbsp;	
			<label for="billadr_zip">우편번호 : </label><input type="text" name="billadr_zip" value="${ rcvappl.billadr_zip }" style="width:140px" />
			<input type="button" value="..." onclick="" />&nbsp;<input type="text" name="billadr_adr1" value="${ rcvappl.billadr_adr1 }" style="width:250px" />
			<br/><pre>							<input type="text" name="billadr_adr2" value="${ rcvappl.billadr_adr2 }" style="width:440px;" /></pre>
			<br/>
			<label for="email_adr">이메일 :</label> <input type="text" name="email_adr" value="${ rcvappl.email_adr }" />&nbsp;&nbsp;&nbsp;
			<label for="hdp_no">핸드폰 번호 :</label> <input type="text" name="hdp_no" value="${ rcvappl.hdp_no }" />&nbsp;&nbsp;&nbsp;
			<label for="scrt_no">비밀번호 :</label> <input type="password" name="scrt_no" value="${ rcvappl.scrt_no }" />
			<br/><br/>
			<c:if test="${rcvappl.impsb_clas == 1}">
				<label for="impsb_clas">불능 구분 :</label> <input type="text" name="impsb_clas" value="불능" readonly="readonly" />&nbsp;&nbsp;&nbsp;
			</c:if>
			<c:forEach items="${ c001 }" var="c001">
				<c:if test="${rcvappl.impsb_cd == c001.code}">
					<label for="impsb_cd">불능 사유명 :</label> <input type="text" name="impsb_cd" value="${ c001.code_nm }" readonly="readonly" style="width:450px" />&nbsp;&nbsp;&nbsp;
				</c:if>
			</c:forEach>
			<hr/>
			<div class="btns">
				<input type="button" value="등록" onclick="checkAndMove('doSignup', 'signinForm')" />
				<input type="button" value="수정" onclick="" />
				<input type="button" value="초기화" onclick="" />		
			</div>
		</div>
	</form>	
</body>
</html>