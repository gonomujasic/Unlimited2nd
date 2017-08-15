<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<!-- 발생오류 :  약관동의 하지 않았는데 탈퇴처리가 됨 -->
<!-- 원인 : 이름이 agree인 배열의 첫번째요소가 체크 되었는지로 확인하는데 -->
<!-- 배열이 아니라 문제생긴것같음 -->
<!-- 해결방안 : 동의하지 않는 부분도 넣어서 배열처리함 -->

<!-- 발생오류 : 화면에서 사용하고 있는 아이디가 노출이안됨 -->
<!-- 원인 : loginDTO.id로 호출했는데 해당 값이 없었음 -->
<!-- 해결방안 : sessionScope.id 로 세션에 있는 아이디를 불러들임 -->
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min
.css">
<script type="text/javascript">
	//약관 동의 여부 확인
	function checkValue() {
		var form = document.userInfo;
		if (!form.agree[0].checked) {
			alert("약관에 동의하셔야 탈퇴가 진행됩니다.");
			return false;
		}
	}

	//취소 버튼 클릭시 메인화면으로 이동
	function goMainForm() {
		location.href = "./MemberInfoList";
	}
</script>
<style type="text/css">
.strong {
	color: red;
}

.a {
	margin-top: 10px;
}
</style>
</head>
<body>

	<form action="./MemberDelete" method="post"
		onsubmit="return checkValue()" name="userInfo">
		<table class="table">
			<tr>
						<br><br><br><br><br>
				<td class="info"><strong>사용하고 계신 아이디 <strong
						class="strong">"<c:out value="${sessionScope.id}" />"
					</strong>는 탈퇴할 경우 재사용 및 복구가 불가능합니다.
				</strong></td>
			</tr>
			<tr>
				<td class="info"><strong>탈퇴 후 회원정보 및 개인형 서비스 이용기록은 모두
						삭제됩니다. </strong></td>
			</tr>
			<tr>
				<td>삭제될내용들 ~~~~~</td>
			</tr>
			<tr>
				<td class="info"><strong>탈퇴 후에도 게시판형 서비스에 등록한 게시물은 그대로
						남아 있습니다.. </strong></td>
			</tr>
			<tr>
				<td>예를들어 Q&A</td>
			</tr>
			<tr>
				<td class="info"><strong>멘토 회원일 경우 멘토 정보와 일반 회원 탈퇴가
						동시에 이루어집니다. </strong></td>
			</tr>
			<tr>

			</tr>
			<tr>
				<td><input type="radio" value="동의" name="agree">안내 사항을
					모두 확인하였으며, 이에 동의합니다.<input type="radio"
						name="agree" value="미동의" class="checkbox-inline">동의하지
						않습니다</td>
			</tr>
		</table>
		<input type="submit" value="확인" class="btn btn-default" > <input
			type="button" value="취소" onclick="goMainForm()" class="btn btn-default">
	</form>

</body>
</html>