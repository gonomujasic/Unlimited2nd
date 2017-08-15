<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%@page import="java.net.URLDecoder"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link href="../resources/assets/css/bootstrap.min.css" rel="stylesheet" />
<script src="../resources/assets/js/bootstrap.min.js" type="text/javascript"></script>
<script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>

</head>
<body >
<hr>
<hr>
<div style="background:#ad1baa; ">
	<form action="./makingChattingRoom" method="post">
		<table class="table">
			<tr>
				<td><label for="title">커뮤니케이션 제목</label></td>
				<td><input type="text" name="title" required></td>

			</tr>
			<tr>
				<td><label for="nationality">국적</label></td>
				<td><input type="text" name="nationality" id="nationality"
				value="${mentorInfo.nation }"
					readonly="readonly"></td>
			</tr>
			<tr>
				<td><label for="language">언어</label></td>
				<td><input type="text" name="language" id="language"
				value="${mentorInfo.edu_language1 }"
					readonly="readonly">
				<td>
			</tr>
			<tr>
				<td><label for="studytime">시간</label></td>
				<td><input type="radio" name="studytime" value="10" required>10
					<input type="radio" name="studytime" value="20">20 <input
					type="radio" name="studytime" value="30">30</td>
			</tr>
			<tr>
				<td><label for="studypoint">10분당 포인트</label> </td><td><input
					type="number" name="studypoint" required></td>
			</tr>

			<tr>
				<td><input type="submit" class="btn btn-default"></td>
			</tr>
		</table>
	</form>
	</div>
	<hr>
	
</body>
</html>