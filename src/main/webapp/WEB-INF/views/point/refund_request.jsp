<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body style="background-color: white">
<br><br><br><br>
	
<form action="./refundRequestSearch" method="post">
<fieldset>
<legend>내역 검색</legend>
<label for="id">id : </label>
<input type="text" name="id" id="id"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<label for="done"> 처리유무 : </label>
<select name="done">
<option value="">처리유무 선택</option>
<option value="Y">처리됨</option>
<option value="N">처리안됨</option>
</select>

<br>
<label for="from">검색 시작일</label>
<input type="date" name="from" placeholder="검색 시작일"> ~ 
<label for="to">검색 종료일</label>
<input type="date" name="to" placeholder="검색 종료일"><br>
<input type="submit" value="검색">
</fieldset>
</form>


<table style="text-align:center" class="table">
<caption> 환전 요청 내역 </caption>
<tr>
<td>요청 번호</td>
<td>요청자</td>
<td>요청 포인트</td>
<td>요청일</td>
<td>요청 은행</td>
<td>요청 계좌</td>
<td>처리유무</td>
<td>환전완료버튼</td>
</tr>
<c:forEach var="refundRequest" items="${list}">
<tr>
<%-- <c:forEach var="sellHistoryDTO" items="${sellHistory}"> --%>

<td>${refundRequest["no"]}</td>
<td>${refundRequest["id"]}</td>
<td>${refundRequest["dealing_point"] }</td>
<td>${refundRequest["request_date"]}</td>
<td>${refundRequest["refund_bank"]}</td>
<td>${refundRequest["refund_accountant"]}</td>
<td>${refundRequest["done"]}</td>
<td><c:if test='${refundRequest["done"] == "N"}'>
<button class ="btn btn-default" onclick='location.href="./pointRefundRequestCheck?id=${refundRequest["id"]}&dealing_point=${refundRequest["dealing_point"]}&no=${refundRequest["no"]}"'>환전완료</button>
 </c:if> </td>

<%-- </c:forEach> --%>
</tr>
</c:forEach>
</table>

<div class="paging">
<c:forEach var="i" begin="${paging.startPage}" end="${paging.endPage}">
<a href="./getRefundRequestList?page=${i}">[${i}]</a>
</c:forEach>
</div>

<button class ="btn btn-default" onclick="location.href='./pointAdmin'">포인트 관리 페이지로</button>
</body>
</html>