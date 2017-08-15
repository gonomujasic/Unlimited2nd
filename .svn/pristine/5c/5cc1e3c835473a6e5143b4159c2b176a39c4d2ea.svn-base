<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="./boot/css/bootstrap.min.css" rel="stylesheet" />
<script type="text/javascript" src="./boot/js/bootstrap.min.js"></script>
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
<style type="text/css">
.rank-simple {
	/* 	clear: both; */
	position: absolute;
	top: 150px;
	right: 100px;
	/*  	margin-right: 100px;  */
	/* 	text-align: center; */
}

.rank-simple .rank-img {
	width: 30px;
	height: 30px;
}

.rank-simple .rank-title {
	width: 180px;
	height: 50px;
}

#lectureList{
	clear: both;
}
</style>
</head>
<body>
	<div class="container">
		<form action="ChattingServlet" method="post" style="width: 50%;">
			<table class="table">
				<tr>
					<td><input type="hidden" name="command" value="searchlist">
						<label for="language">언어:</label> <select name="language">
							<option value="영어">영어</option>
							<option value="중국어">중국어</option>
							<option value="일본어">일본어</option>
							<option value="한국어">한국어</option>
							<option value="기타">기타</option>
					</select> &nbsp; <label for="nationality">국가:</label> <select
						name="nationality">
							<option value="미국">미국</option>
							<option value="호주">호주</option>
							<option value="영국">영국</option>
							<option value="필리핀">필리핀</option>
							<option value="중국">중국</option>
							<option value="일본">일본</option>
							<option value="한국">한국</option>
							<option value="기타">기타</option>
					</select> &nbsp; <label for="studytime">시간:</label> <select name="studytime">
							<option value="10">10분</option>
							<option value="20">20분</option>
							<option value="30">30분</option>

					</select></td>
				</tr>
				<br>
				<tr>
					<td><label for="studypoint">10분당 포인트:</label> <select
						name="studypoint">
							<option value="1000">0~1000 POINT</option>
							<option value="2000">1001~2000 POINT</option>
							<option value="3000">2001~3000 POINT</option>
							<option value="3001">3001 POINT 이상</option>
					</select></td>
				</tr>
				<br>
				<tr>
					<td><input type="submit"
						value="                    검         색                     "
						class="btn btn-default"></td>
				</tr>
			</table>
		</form>


		<div class="rank-simple">
			<table>
				<tr>
					<td><img class="rank-title" src="../resources/ranking.jpg">
						<br> <br></td>
				</tr>

				<c:forEach items="${ranklist}" var="rankdto" end="4">
					<tr>
						<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <c:if
								test="${rankdto.rank == 1}">
								<img class="rank-img" src="../resources/no1.jpg" />
								<font color="gold" size="">${rankdto.rank}&nbsp;&nbsp;&nbsp;&nbsp;${rankdto.mentor_id}<br></font>
							</c:if> <c:if test="${rankdto.rank == 2}">
								<img class="rank-img" src="../resources/no2.jpg" />
								<font color="silver">${rankdto.rank}&nbsp;&nbsp;&nbsp;&nbsp;${rankdto.mentor_id}<br></font>
							</c:if> <c:if test="${rankdto.rank == 3}">
								<img class="rank-img" src="../resources/no3.jpg" />
								<font color="brown">${rankdto.rank}&nbsp;&nbsp;&nbsp;&nbsp;${rankdto.mentor_id}<br></font>
							</c:if> <c:if test="${rankdto.rank == 4}">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${rankdto.rank}&nbsp;&nbsp;&nbsp;&nbsp;${rankdto.mentor_id}<br>
							</c:if> <c:if test="${rankdto.rank == 5}">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${rankdto.rank}&nbsp;&nbsp;&nbsp;&nbsp;${rankdto.mentor_id}<br>
							</c:if>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>



	<div class="lectureList">
		<div>

			<h1>강의 리스트</h1>
		</div>

		<hr>
		<c:forEach var="chatRoom" items="${chatRoomsList }">
			<!-- session 아이디 설정해줘야 함. -->

			<table class="chatroom table" id="chatroom"
				style="text-align: center;">
				<tr class="success">
					<th class="text-center">&nbsp;강의실 번호&nbsp;</th>
					<th class="text-center">&nbsp;제목&nbsp;</th>
					<th class="text-center">&nbsp;국적&nbsp;</th>
					<th class="text-center">&nbsp;언어&nbsp;</th>
					<th class="text-center">&nbsp;강의 시간&nbsp;</th>
					<th class="text-center">&nbsp;10분당 포인트&nbsp;</th>
				</tr>
				<tr>
					<td class="text-center con">${chatRoom.chatRoomNum }</td>
					<td class="text-center">${chatRoom.roomTitle }</td>
					<td class="text-center">${chatRoom.nationality }</td>
					<td class="text-center">${chatRoom.language }</td>
					<td class="text-center">${chatRoom.studytime }</td>
					<td class="text-center">${chatRoom.studypoint }</td>
				</tr>
			</table>

			<input type="hidden" class="roomNum" value="${chatRoom.chatRoomNum}">
			<input type="hidden" class="title" value="${chatRoom.roomTitle }">
			<input type="hidden" class="nationality"
				value="${chatRoom.nationality }">
			<input type="hidden" class="language" value="${chatRoom.language }">
			<input type="hidden" class="studytime" value="${chatRoom.studytime }">
			<input type="hidden" class="studypoint"
				value="${chatRoom.studypoint }">
			<hr>
		</c:forEach>

		<hr>
		<div>
			<button id="newchat" class="btn btn-default">새 강의</button>
		</div>
		</div>
	</div>
	<script>
		$("#newchat")
				.on(
						'click',
						function(event) {

							var mentorCheck = function() {

								var url = 'chattingRoomPopUp';
								var makePopup = window
										.open(url, 'popup01',
												'width=400, height=900, scrollbars= 0, toolbar=0, menubar=no');

								/* $.ajax({
									url : 'ChattingServlet?command=mentorCheck',
									type : 'GET',
									dataType : 'json',
									success : function(data) {

										if (data.answer != "@") {

										alert("멘토회원만이 강의를 만들 수 있습니다.");

										} else if (data.answer == "@") {

											function makeRoom() {

												makePopup.location.href = url;}}
									}
								}); */

							}

							mentorCheck();
						});

		$(".chatroom")
				.on(
						'click',
						function(evnet) {
							var roomNum = $(this).next().val();
							var title = $(this).next().next().val();
							var nationality = $(this).next().next().next()
									.val();
							var language = $(this).next().next().next().next()
									.val();
							var studytime = $(this).next().next().next().next()
									.next().val();
							var studypoint = $(this).next().next().next()
									.next().next().next().val();

							var url = "enterChattingRoom?roomNumber=" + roomNum;

							var popup = window
									.open(url, 'popup02',
											'width=400,height=900,scrollbars=0,toolbar=0,menubar=no');

							var enterServlet = function(roomNum) {

								/* 				$.ajax({
								 url : 'ChattingServlet?command=enterchat&chatRoomNum='+ roomNum,
								 type : 'GET',
								 dataType : 'json',
								 success : function(data) {

								 var answer = data.answer;

								 if (answer == "!") {
								 alert("현재 강의 중입니다.");
								 } else if (answer == "@") {
								 alert("회원이 아닙니다. 로그인을 해주세요.");
								 } else if (answer == "#") {
								 alert("이미 입장했습니다.");
								 } else if (answer == "$") {

								 function enterRoom() {

								 popup.location.href = url;

								 }

								 }
								 }

								 }); */

							}

							enterServlet(roomNum);

						});
	</script>
</body>
</html>