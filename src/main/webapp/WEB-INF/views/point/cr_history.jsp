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
		
		<form action="./crHistorySearch" method="post">
			<fieldset>
				<legend>내역 검색</legend>
				<label for="id">id : </label> 
				<input type="text" name="id" id="id" /> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<label for="why"> 거래내용 : </label>
				<select name="why">
				<option value="">거래내용 선택</option>
				<option value="충전">충전</option>
				<option value="환전">환전</option>
				</select>
				<br>
				<label for="검색 시작일">검색 시작일</label>
				<input type="date" name="from" placeholder="검색 시작일"> ~ 
				<label for="검색 종료일">검색 종료일</label>
				<input type="date" name="to" placeholder="검색 종료일"><br>
				<input type="submit" class="btn btn-default btn-sm" value="검색">
			</fieldset>
		</form>
		
		
		<div id="hiscontainer">
			<table style="text-align: center" class="table">
				<caption>충전/환전 내역</caption>

				<tr>
					<td>번호</td>
					<td>아이디</td>
					<td>거래포인트</td>
					<td>거래전 포인트</td>
					<td>거래후 포인트</td>
					<td>거래일</td>
				</tr>
				<c:forEach var="crHistory" items="${list}">
					<tr>
						<%-- <c:forEach var="sellHistoryDTO" items="${sellHistory}"> --%>

						<td>${crHistory["no"]}</td>
						<td>${crHistory["id"]}</td>
						<td>${crHistory["dealing_point"] }</td>
						<td>${crHistory["point_before"]}</td>
						<td>${crHistory["point_after"]}</td>
						<td>${crHistory["dealing_date"]}</td>

						<%-- </c:forEach> --%>
					</tr>
				</c:forEach>
			</table>

		</div>
		<div class="paging">
			<c:forEach var="i" begin="${paging.startPage}"
				end="${paging.endPage}">
				<a href="./getCRHistory?page=${i}">[${i}]</a>
			</c:forEach>
		</div>
		<button class="btn btn-default"
			onclick="location.href='./pointAdmin'">포인트 관리 페이지로</button>
	</div>


</body>
</html>