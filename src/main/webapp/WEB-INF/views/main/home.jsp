<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">

.carousel-inner > .item > img {
      top: 0;
      left: 0;
      min-width: 100%;
      min-height: 200px;
    } 
    
.notice-simple{
/* 	clear: both; */
 	float: left; 
 	margin-left: 100px; 
/* 	text-align: center; */
}


</style>
</head>
<body>
	<div class="wrapper">
		<div class="header header-filter"
			style="background-image: url('../resources/assets/img/bg2.jpeg');">
			<!-- 	<div style="background-image: url('../resources/main_bg2.png');"> -->
			<div class="container">
				<div class="row">
					<div class="col-md-8 col-md-offset-2">
						<div class="brand">
							<h1>Gift Gifts</h1>
							<h3>언어재능 교환 플랫폼</h3>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="main main-raised">
			<div class="section section-basic">
				<div class="container">
					<div class="title">
						<!-- Carousel Card -->
						<div class="card card-raised card-carousel">
							<div id="carousel-example-generic" class="carousel slide"
								data-ride="carousel">
								<div class="carousel slide" data-ride="carousel">

									<!-- Indicators -->
									<ol class="carousel-indicators">
										<li data-target="#carousel-example-generic" data-slide-to="0"
											class="active"></li>
										<li data-target="#carousel-example-generic" data-slide-to="1"></li>
										<li data-target="#carousel-example-generic" data-slide-to="2"></li>
									</ol>

									<!-- Wrapper for slides -->
									<div class="carousel-inner">
										<div class="item active">
											<img src="../resources/japan01.jpg"
												alt="Awesome Image">
										</div>
										<div class="item">
											<img src="../resources/duch01.jpg"
												alt="Awesome Image">
										</div>
										<div class="item">
											<img src="../resources/ital01.jpg"
												alt="Awesome Image">
										</div>
										
									</div>

									<!-- Controls -->
									<a class="left carousel-control"
										href="#carousel-example-generic" data-slide="prev"> <i
										class="material-icons">keyboard_arrow_left</i>
									</a> <a class="right carousel-control"
										href="#carousel-example-generic" data-slide="next"> <i
										class="material-icons">keyboard_arrow_right</i>
									</a>
								</div>
							</div>
						</div>
						<!-- End Carousel Card -->

					</div>
					<br>
					<hr>
					<br>
					
					
					<div class="notice-simple">
					<fieldset>
					<table>
					<tr>
					<td>
					<font color="purple" size="5px">Recent Notice</font><br>
					</td>
					</tr>
					<ul>
					<tr>
					<td style="text-align:center; margin-left: 20px;">
						<c:forEach items="${noticelist}" var="noticeDTO" end="4">
						<li><a href="../snotice/readPage?notice_number=${noticeDTO.notice_number}">${noticeDTO.notice_title}</a> &nbsp;&nbsp;<p class="text-muted test-xs">${noticeDTO.write_date}</p></li>
						</c:forEach>
					<td>
					<tr>
					</ul>
					</table>
					</fieldset>
					</div>
					
					<div class="notice-simple">
					<fieldset>
					<table>
					<tr>
					<td>
					<font color="purple" size="5px">Recent StudyBoard</font><br>
					</td>
					</tr>
					<ul>
					<tr>
					<td style="text-align:center; margin-left: 20px;">
						<c:forEach items="${studylist}" var="studyDTO" end="4">
						<li><a href="../sstudy/readPage?study_number=${studyDTO.study_number}">${studyDTO.study_title}</a> &nbsp;&nbsp;<p class="text-muted test-xs">${studyDTO.write_date}</p></li>
						</c:forEach>
					<td>
					<tr>
					</ul>
					</table>
					</fieldset>
					</div>
					
					
				</div>
			</div>
		</div>
	</div>

</body>
</html>