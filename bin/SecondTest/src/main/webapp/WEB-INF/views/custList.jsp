<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>crdList.jsp</title>
<link rel="stylesheet" type="text/css" href="<c:url value="/css/main.css" />"/>
<script src="<c:url value="/js/test.js" />"></script>
<style>
table, th, td {
	border: 1px solid black;
	margin: auto;
}
</style>
</head>
<body>
<h1><a href="/form">홈으로</a></h1> 
<form name="custListForm">
	<table>
		<thead>
			<tr>
				<th colspan="3">성명 <input type="text" name="hg_nm" /></th>
				<th colspan="2">생년월일 <input type="text" name="birth_d" /></th>
				<th colspan="2">핸드폰 번호 <input type="text" name="hdp_no" /> <input type="button" value="조회" onclick="checkAndMove('getCustList')" /></th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<th colspan="7"><label for="rcv_d">조회결과</label></th>
			</tr>
			<tr>
				<th>주민번호</th>
				<th>성명(한글)</th>
				<th>생년월일</th>
				<th>핸드폰번호</th>
				<th>결제 은행</th>
				<th>결제 계좌</th>
				<th>주소</th>
			</tr>
			<c:forEach items="${ custList }" var="custList">
				<tr>
					<th>${ custList.ssn }</th>
					<th><a href="crdList?ssn=${ custList.ssn }">${ custList.hg_nm }</a></th>
					<th>${ custList.birth_d }</th>
					<th>${ custList.hdp_no }</th>
					<th>${ custList.bnk_cd }</th>
					<th>${ custList.stl_act }</th>
					<th>${ custList.bbill_adr1}</th>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</form>
	<div class="btns">
		<input type="button" value="초기화" onclick="" />		
		<input type="button" value="닫기" onclick="" />
	</div>
</body>
</html>