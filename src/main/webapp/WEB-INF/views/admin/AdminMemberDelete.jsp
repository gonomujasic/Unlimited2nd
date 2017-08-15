
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="../resources/assets/css/bootstrap.min.css" rel="stylesheet" />
<script src="../resources/assets/js/bootstrap.min.js" type="text/javascript"></script>

<script type="text/javascript">
	function checkValue() {
		//alert("checkValue");
		var form = document.checkInfo;
		if (!form.reason.value) {
			alert("강퇴 사유를 입력하세요.");
			return false;
		}
	}
</script>
</head>
<body>
	<form action="./AdminMemberDelete" method="post"
		onsubmit="return checkValue()" name="checkInfo">
<!-- 		AdminController에서 model에 담은 id를 꺼내와서 id라는 이름으로 다시 넣어줌.  -->
<!-- 이 id라는 이름으로 서비스에 넘겨줄거임 -->
<!-- 		type을 hidden으로 두고 숨겨놈 -->
		<input type="hidden" value="${id}" name="id"/>
		<table>
			<h2>회원 강퇴시키기</h2>
			<tr>
				<td>강퇴 사유</td>
			</tr>
			<tr>
				<td><textarea name="reason"></textarea></td>
			</tr>
			<tr>
				<td><input type="submit" value="확인" class="btn btn-default"></td>
			</tr>
		</table>
	</form>
</body>
</html>