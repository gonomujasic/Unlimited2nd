<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


</head>
<body style="background-color: white">
	
	<div class="container">
		<h1 class="text-muted">포인트 내역</h1>
		<button class="btn btn-default" type="button" id="sellhistory"
			onclick="location.href='./getSellHistory'">판매 내역</button>
		<button class="btn btn-default" type="button" id="buyhistory"
			onclick="location.href='./getBuyHistory'">구매 내역</button>
		<button class="btn btn-default" type="button" id="crhistory"
			onclick="location.href='./getCRHistory'">충/환전 내역</button>

		<br> <br> <br>
		<form action="./sellHistorySearch" method="post">
			<fieldset>
				<legend>내역 검색</legend>
				<label for="id">id : </label> 
				<input type="text" name="id" id="id" /> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<label for="opponent">거래상대 : </label> 
				<input type="text" name="opponent" id="opponent" /> 
				<br>
				<label for="from"> 검색 시작일 </label>
				<input type="date" name="from" placeholder="검색 시작일"> ~  
				<label for="to"> 검색 종료일 </label>
				<input type="date" name="to" placeholder="검색 종료일"><br>
				<input type="submit" class="btn btn-default btn-sm" value="검색">
			</fieldset>
		</form>
		
		<div id="hiscontainer">

			<table style="text-align: center" class="table">
				<caption>판매 내역</caption>

				<tr>
					<td>판매번호</td>
					<td>판매자</td>
					<td>구매자</td>
					<td>거래포인트</td>
					<td>거래전 포인트</td>
					<td>거래후 포인트</td>
					<td>거래일</td>
				</tr>
				<c:forEach var="sellHistory" items="${list}">
					<tr>
						<%-- <c:forEach var="sellHistoryDTO" items="${sellHistory}"> --%>

						<td>${sellHistory.no}</td>
						<td>${sellHistory.id}</td>
						<td>${sellHistory.opponent}</td>
						<td>${sellHistory.dealing_point}</td>
						<td>${sellHistory.point_before}</td>
						<td>${sellHistory.point_after}</td>
						<td>${sellHistory.dealing_date}</td>

						<%-- </c:forEach> --%>
					</tr>
				</c:forEach>
			</table>
		</div>
		<div class="paging">
			<c:forEach var="i" begin="${paging.startPage}"
				end="${paging.endPage}">
				<a href="./getSellHistory?page=${i}">[${i}]</a>
			</c:forEach>
		</div>
		<button class="btn btn-default"
			onclick="location.href='./pointAdmin'">포인트 관리 페이지로</button>
	</div>







</body>
</html>