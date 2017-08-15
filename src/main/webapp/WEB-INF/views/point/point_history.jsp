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
	
<div class="container">
<form action="./pointHistorySearch" method="post">
<fieldset>
<legend>내역 검색</legend>
<label for="opponent">거래상대 : </label>
<input type="text" name="opponent" id="opponent"/>
<label for="why"> 거래내용 : </label>
<select name="why">
<option value="">거래내용 선택</option>
<option value="구매">구매</option>
<option value="판매">판매</option>
<option value="충전">충전</option>
<option value="환전">환전</option>
</select>
<br>
<label for="from">검색 시작일 : </label>
<input type="date" name="from" placeholder="검색 시작일">
<label for="to">검색 종료일 : </label>
<input type="date" name="to" placeholder="검색 종료일"><br>
<input class="btn btn-default btn-sm" type="submit" value="검색">
</fieldset>
</form>

<p class="h3">${id}님의 포인트 이용 내역</p>
<table class="table">
<tr>
<td>거래 전 포인트</td>
<td>거래 포인트</td>
<td>거래 후 포인트</td>
<td>거래내용</td>
<td>상대</td>
<td>거래일</td>

</tr>
<c:forEach var="pointHistoryDTO" items="${pointHistoryList}">

<tr>

<td>${pointHistoryDTO.point_before}</td>
<td>${pointHistoryDTO.dealing_point}</td>
<td>${pointHistoryDTO.point_after}</td>
<td>${pointHistoryDTO.why}</td>
<td>${pointHistoryDTO.opponent}</td>
<td>${pointHistoryDTO.dealing_date}</td>
</tr>

</c:forEach>
</table>
<div class="paging">
<c:forEach var="i" begin="${paging.startPage}" end="${paging.endPage}">
<a href="./GetPointHistory?page=${i}&id=${id}">[${i}]</a>
</c:forEach>
</div>

<button class = "btn btn-default" onclick="location.href='./pointMain'">포인트 메인으로</button>

</div>
</body>
</html>