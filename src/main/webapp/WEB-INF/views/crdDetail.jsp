<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>	
<meta charset="UTF-8">
<title>crdDetail.jsp</title>
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
<table>
	<thead>
		<tr>
			<th colspan="4">주민번호 <input type="text" name="ssn" /></th>
			<th colspan="4">카드번호 <input type="text" name="crd_no" /> <input type="button" value="조회" onclick="" /></th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<th colspan="8"><label for="rcv_d">조회 결과</label></th>
		</tr>
		
		<tr>
			<th colspan="4">
				<label for="hg_nm">성명(한글) :</label> <input type="text" name="hg_nm" value="" />
			</th>
			<th colspan="4">
				<label for="eng_nm">성명(영문) :</label> <input type="text" name="eng_nm" value="" />
			</th>
		</tr>
		
		<tr>
			<th colspan="4">
				<label for="rcv_d">등록일자 :</label> <input type="text" name="rcv_d" value="" />
			</th>
			<th colspan="4">
				<label for="vld_dur">유효기간 :</label> <input type="text" name="vld_dur" value="" />
			</th>
		</tr>
		
		<tr>
			<th colspan="4">
				<label for="brd">브랜드 :</label> <input type="text" name="brd" value="" />
			</th>
			<th colspan="4">
				<label for="crd_grd">카드 등급 :</label> <input type="text" name="crd_grd" value="" />
			</th>
		</tr>
		
		<tr>
			<th colspan="4">
				<label for="bf_crd_no">전 카드번호 :</label> <input type="text" name="bf_crd_no" value="" />
			</th>
			<th colspan="4">
				<label for="cust_no">고객번호 :</label> <input type="text" name="cust_no" value="" />
			</th>
		</tr>
		
		<tr>
			<th colspan="4">
				<label for="hg_nm">관리 영업점 :</label> <input type="text" />
			</th>
			<th colspan="4">
				<label for="lst_crd_f">최종 카드여부 :</label> <input type="text" name="lst_crd_f" value="" />
			</th>
		</tr>
		
		<tr>
			<th colspan="4">
				<label for="fst_reg_d">최종 등록일자 :</label> <input type="text" name="fst_reg_d" value="" />
			</th>
		</tr>
	</tbody>
</table>
	<div class="btns">
		<input type="button" value="초기화" onclick="" />		
	</div>
</body>
</html>