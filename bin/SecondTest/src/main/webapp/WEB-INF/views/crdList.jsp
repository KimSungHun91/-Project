<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>custInfo.jsp</title>
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
<h1><a href="/form">홈으로</a></h1> <h1><a href="crdDetail">카드 상세정보</a></h1>
<form name="custInfoForm" >
	<table>
		<thead>
			<tr>
				<th colspan="4">주민번호 <input type="text" name="ssn" value="${ custInfo.ssn }" /></th>
				<th colspan="5">카드번호 <input type="text" name="crd_no" /> <input type="button" value="조회" onclick="checkAndMove()" /></th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<th colspan="9"><label for="rcv_d">조회</label></th>
			</tr>
			<tr>
				<th colspan="9">
					<label for="hg_nm">성명(한글) :</label> <input type="text" name="hg_nm" value="${ custInfo.hg_nm }" />
					<label for="hdp_no">핸드폰 번호 :</label> <input type="text" name="hdp_no" value="${ custInfo.hdp_no }" />
					<label for="rcv_d">등록일자 :</label> <input type="text" name="rcv_d" value="${ custInfo.rcv_d }" />
				</th>
			</tr>
			
			<tr>
				<th colspan="9">
					<label for="stl_mtd">결제방법 :</label>
					<select name="stl_mtd" style="width:170px;height:21.5px;">
						<c:forEach items="${ c002 }" var="c002">
							<option value="${ c002.code }"
							<c:if test="${custInfo.stl_mtd == c002.code}">selected</c:if>>${ c002.code_nm }</option>
						</c:forEach>
					</select>
					<label for="bnk_cd">결제은행 :</label>
					<select name="bnk_cd" style="width:170px;height:21.5px;">
						<c:forEach items="${ c003 }" var="c003">
							<option value="${ c003.code }"
							<c:if test="${custInfo.bnk_cd == c003.code}">selected</c:if>>${ c003.code_nm }</option>
						</c:forEach>
					</select>
					<label for="stl_act">결제계좌 : </label><input type="text" name="stl_act" value="${ custInfo.stl_act }" />
				</th>
			</tr>
			
			<tr>
				<th colspan="9">
					<label for="stl_dd">결제일자 :</label>
					<select name="stl_dd" style="width:180px;height:21.5px;">
					<c:forEach items="${ c009 }" var="c009">
						<option value="${ c009.code }"
						<c:if test="${custInfo.stl_dd == c009.code}">selected</c:if>>${ c009.code_nm }</option>
					</c:forEach>
					</select>
					<label for="stmt_snd_mtd">청구서 발송방법 : </label>
					<select name="stmt_snd_mtd" style="width:150px;height:21.5px;">
					<c:forEach items="${ c006 }" var="c006">
						<option value="${ c006.code }"
						<c:if test="${custInfo.stmt_snd_mtd == c006.code}">selected</c:if>>${ c006.code_nm }</option>
					</c:forEach>
					</select>
					<label for="email_adr">이메일 :</label> <input type="text" name="email_adr" value="${ custInfo.email_adr }" />
				</th>
			</tr>
			<tr>
				<th colspan="9">
					<label for="billadr_zip">우편번호 : </label><input type="text" name="billadr_zip" value="${ custInfo.billadr_zip }" style="width:140px" />
					<input type="text" name="billadr_adr1" value="${ custInfo.billadr_adr1 }" style="width:220px" />
					<input type="text" name="billadr_adr2" value="${ custInfo.billadr_adr2 }" style="width:280px;" />
				</th>
			</tr>
		</tbody>
		<tfoot>
			<tr>
				<th>카드번호</th>
				<th>성명(영문)</th>
				<th>유효기간</th>
				<th>브랜드</th>
				<th>카드등급</th>
				<th>발행일자</th>
				<th>전 카드번호</th>
				<th>최종 카드 여부</th>
				<th>관리영업점</th>
			</tr>
			<c:forEach items="${ crdList }" var="crdList">
				<tr>
					<th>${ crdList.crd_no }</th>
					<th>${ crdList.eng_nm }</th>
					<th>${ crdList.vld_dur }</th>

					<c:choose>
						<c:when test="${ empty crdList.brd }">
							<th></th>
						</c:when>
						<c:otherwise>
							<c:forEach items="${ c004 }" var="c004">
								<c:if test="${ crdList.brd == c004.code }">
									<th>${ c004.code_nm }</th>
								</c:if>
							</c:forEach>
						</c:otherwise>
					</c:choose>
					
					<th>${ crdList.crd_grd }</th>
					<th>${ crdList.reg_d }</th>
					<th>${ crdList.bf_crd_no }</th>
					<c:if test="${ crdList.lst_crd_f == 1 }">
						<th>최종</th>
					</c:if>
					<th></th>
				</tr>
			</c:forEach>
		</tfoot>
	</table>
	<div class="btns">
		<input type="button" value="초기화" onclick="" />		
		<input type="button" value="닫기" onclick="" />
	</div>
</form>
</body>
</html>