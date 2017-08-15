<%@page import="java.util.List"%>
<%@page import="kjy.rating_history.dto.AvgDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="./resources/boot/css/bootstrap.min.css" rel="stylesheet">
<title>관리자</title>
</head>
<body>
<p>
<table class="table">
<tr>

<td>말속도</td>
<td>친절</td>
<td>발음</td>
<td>수업내용</td>
<td>재미</td>
<td>평균</td>
<td>멘토ID</td>
<td>순위</td>
</tr>

<c:forEach items="#{list}" var="avgdto">
<tr>
<td>${avgdto.avgts}</td>
<td>${avgdto.avgfr}</td>
<td>${avgdto.avgpr}</td>
<td>${avgdto.avgwoc}</td>
<td>${avgdto.avgpl}</td>
<td>${avgdto.totalavg}</td>
<td>${avgdto.mentor_id}</td>
<td>${avgdto.rank}</td>


</tr>
</c:forEach>
</table>
</body>
</html>