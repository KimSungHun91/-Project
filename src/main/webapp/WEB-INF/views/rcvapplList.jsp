<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>rcvapplList.jsp</title>
<link rel="stylesheet" type="text/css" href="<c:url value="/css/main.css" />"/>
<script src="<c:url value="/js/test.js" />"></script>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" />
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>
<style>
table, th, td {
	border: 1px solid black;
	margin: auto;
}
</style>
<script type="text/javascript">
$(function() {
	$( "#rcv_d" ).datepicker({
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
$(function() {
	$( "#rcv_d2" ).datepicker({
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
<form name="rcvapplListForm" >
	<table>
		<thead>
			<tr>
				<th colspan="4">기간 <input type="text" id="rcv_d" name="rcv_d" /> ~ <input type="text" id="rcv_d2" name="rcv_d2" /></th>
				<th colspan="3">신청구분
					<select name="appl_clas" style="width:180px;height:21.5px;">
					<c:forEach items="${ c007 }" var="c007">
						<option value="${ c007.code }">${ c007.code_nm }</option>
					</c:forEach>
					</select>
				</th>
				<th colspan="3">주민번호 <input type="text" name="ssn" /> <input type="button" value="조회" onclick="checkAndMove('getRcvapplList')" /></th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<th colspan="10"><label for="rcv_d">조회결과</label></th>
			</tr>
			<tr>
				<th>접수일자</th>
				<th>접수 일련번호</th>
				<th>주민번호</th>
				<th>성명(한글)</th>
				<th>성명(영문)</th>
				<th>신청구분</th>
				<th>브랜드</th>
				<th>핸드폰번호</th>
				<th>불능구분</th>
				<th>불능 사유명</th>
			</tr>
			<c:forEach items="${ rcvapplList }" var="rcvapplList">
				<tr>
					<th>${ rcvapplList.rcv_d }</th>
					<th><a href="goSignup?no=${ rcvapplList.rcv_seq_no }">${ rcvapplList.rcv_seq_no }</a></th>
					<th>${ rcvapplList.ssn }</th>
					<th>${ rcvapplList.hg_nm }</th>
					<th>${ rcvapplList.eng_nm }</th>
					
					<c:choose>
						<c:when test="${ empty rcvapplList.appl_clas }">
							<th></th>
						</c:when>
						<c:otherwise>
							<c:forEach items="${ c007 }" var="c007">
								<c:if test="${ rcvapplList.appl_clas == c007.code }">
									<th>${ c007.code_nm }</th>
								</c:if>
							</c:forEach>
						</c:otherwise>
					</c:choose>
					
					<c:choose>
						<c:when test="${ empty rcvapplList.brd }">
							<th></th>
						</c:when>
						<c:otherwise>
							<c:forEach items="${ c004 }" var="c004">
								<c:if test="${ rcvapplList.brd == c004.code }">
									<th>${ c004.code_nm }</th>
								</c:if>
							</c:forEach>
						</c:otherwise>
					</c:choose>
					
					<th>${ rcvapplList.hdp_no }</th>
					
					<c:choose>
						<c:when test="${ empty rcvapplList.impsb_clas }">
							<th></th>
						</c:when>
						<c:otherwise>
							<c:if test="${ rcvapplList.impsb_clas == 1 }">
								<th>불능</th>
							</c:if>
						</c:otherwise>
					</c:choose>
					
					<c:choose>
						<c:when test="${ empty rcvapplList.impsb_cd }">
							<th></th>
						</c:when>
						<c:otherwise>
							<c:forEach items="${ c001 }" var="c001">
								<c:if test="${ rcvapplList.impsb_cd == c001.code }">
									<th>${ c001.code_nm }</th>
								</c:if>
							</c:forEach>
						</c:otherwise>
					</c:choose>
					
				</tr>
			</c:forEach>
		</tbody>
	</table><hr>
		<div class="btns">
			<input type="button" value="초기화" onclick="" />		
			<input type="button" value="닫기" onclick="" />
		</div>
</form>
</body>
</html>