<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jquery.js 설정 -->
<script type="text/javascript">
function goPrevious() {
	history.back();
}
</script>
<title>Insert title here</title>
</head>
<body>
<div>
		<table class="table">
<br><br><br><br><br>			
			<th>아이디</th>
			<th>이름</th>
			<th>닉네임</th>
			<th>생년월일</th>
			<th>전화번호</th>
			<th>이메일</th>
			<th>성별</th>
			<th>보유 포인트</th>
			<c:forEach var="list"  items="${memberAllList}" >
				<tr>
					<td><c:out value="${list.id}" /></td>
					<td><c:out value="${list.name}" /></td>
					<td><c:out value="${list.nickName}" /></td>
					<td><c:out value="${list.birth}" /></td>
					<td><c:out value="${list.hp}" /></td>
					<td><c:out value="${list.email}" /></td>
					<td><c:out value="${list.gender}" /></td>
					<td><c:out value="${list.point}" /></td>
				</tr>
			</c:forEach>

		</table>
		<input type="button" value="이전" onclick="goPrevious()" class="btn btn-default">

</body>
</html>