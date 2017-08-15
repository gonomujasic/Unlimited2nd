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
<p class="h2 text-muted">포인트 관리자 페이지</p>

<!-- <button onclick="location.href='./'"> 회원 포인트  </button> 관리자 맘대로 포인트 회수하고 주고 하는 기능인데 2차때 하기로-->
<button class="btn btn-default" onclick="location.href='./getSellHistory'"> 회원 포인트 내역 보기  </button>
<button class="btn btn-default" onclick="location.href='./getRefundRequestList'"> 환전 요청 리스트  </button>
<!-- <button class="btn btn-default" onclick="location.href='./PointMain.Point'"> 포인트 메인  </button> -->
</div> 
</body>
</html>