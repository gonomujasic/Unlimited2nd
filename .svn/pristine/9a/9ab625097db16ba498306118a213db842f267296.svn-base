<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
  <head>
  <meta charset="UTF-8">
<!--     <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'> -->
<!--     Bootstrap 3.3.4 -->
<!--     <link href="../resources/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" /> -->
<!--     Font Awesome Icons -->
<!--     <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" type="text/css" /> -->
<!--     Ionicons -->
<!--     <link href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css" rel="stylesheet" type="text/css" /> -->
<!--     Theme style -->
<!--     <link href="../resources/dist/css/AdminLTE.min.css" rel="stylesheet" type="text/css" /> -->
<!--     AdminLTE Skins. Choose a skin from the css/skins 
<!--          folder instead of downloading all of them to reduce the load. --> -->
<!--     <link href="../resources/dist/css/skins/_all-skins.min.css" rel="stylesheet" type="text/css" /> -->
<!--     </head> -->
<!--     jQuery 2.1.4 -->
<!--     <script src="../resources/plugins/jQuery/jQuery-2.1.4.min.js"></script> -->
<!--     <script type="text/javascript" src="../resources/js/upload.js"></script> -->
<!--    <style type="text/css"> -->
<!-- /*     .popup {position: absolute;} */ -->
<!-- /*     .back { background-color: gray; opacity:0.5; width: 100%; height: 300%; overflow:hidden;  z-index:1101;} */ -->
<!-- /*     .front {  */ -->
<!-- /*        z-index:1110; opacity:1; boarder:1px; margin: auto;  */ -->
<!-- /*       } */ -->
<!-- /*      .show{ */ -->
<!-- /*        position:relative; */ -->
<!-- /*        max-width: 1200px;  */ -->
<!-- /*        max-height: 800px;  */ -->
<!-- /*        overflow: auto;        */ -->
<!-- /*      }  */ -->
  	
<!--     </style> -->
    <body>

<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
<!-- Main content -->
  
 <div class='popup back' style="display:none;"></div>
    <div id="popup_front" class='popup front' style="display:none;">
     <img id="popup_img">
    </div>
<section class="content">
	<div class="row">
		<!-- left column -->
		<div class="col-md-12">
			<!-- general form elements -->
			<div class="box box-primary">
				<div class="box-header">
				<br><br><br><br><br>
					<h3 class="box-title">공지사항 글보기</h3>
				</div>
				<!-- /.box-header -->

				<form role="form" action="modifyPage" method="post">

					<input type='hidden' name='notice_number' value="${noticeDTO.notice_number}"> <input
						type='hidden' name='page' value="${cri.page}"> <input
						type='hidden' name='perPageNum' value="${cri.perPageNum}">
					<input type='hidden' name='searchType' value="${cri.searchType}">
					<input type='hidden' name='keyword' value="${cri.keyword}">

				</form>

				<div class="box-body">
					<div class="form-group">
						<label for="exampleInputEmail1">Title</label> <input type="text"
							name='notice_title' class="form-control" value="${noticeDTO.notice_title}"
							readonly="readonly">
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1">Content</label>
						<textarea class="form-control" name="notice_contents" rows="3"
							readonly="readonly">${noticeDTO.notice_contents}</textarea>
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">Writer</label> <input type="text"
							name="id" class="form-control" value="${noticeDTO.id}"
							readonly="readonly">
					</div>
				</div>
				<!-- /.box-body -->
<div class="box-footer">
    <div><hr></div>
    <ul class="mailbox-attachments clearfix uploadedList">
    </ul>
			  <div class="box-footer">
			    <c:if test="${id == 'admin'}">
			    <button type="submit" class="btn btn-warning" id="modifyBtn">Modify</button>
			    <button type="submit" class="btn btn-danger" id="removeBtn">REMOVE</button>
			    </c:if>
			    <button type="submit" class="btn btn-primary" id="goListBtn">GO LIST </button>
			  </div>



			</div>
			<!-- /.box -->
		</div>
		<!--/.col (left) -->

	</div>
	<!-- /.row -->



	<div class="row">
		<div class="col-md-12">

			<div class="box box-success">
				<div class="box-header">
					<h3 class="box-title">ADD NEW REPLY</h3>
				</div>
<!-- 				<div class="box-body"> -->
<!-- 					<label for="exampleInputEmail1">Writer</label> <input -->
<!-- 						class="form-control" type="text" placeholder="USER ID" -->
<!-- 						id="newReplyWriter"> <label for="exampleInputEmail1">Reply -->
<!-- 						Text</label> <input class="form-control" type="text" -->
<!-- 						placeholder="REPLY TEXT" id="newReplyText"> -->

<!-- 				</div> -->
<!-- 				/.box-body -->
<!-- 				<div class="box-footer"> -->
<!-- 		  <button type="submit" class="btn btn-primary" id="replyAddBtn">ADD REPLY</button> -->
<!-- 		</div> -->
<!-- 로그인 처리 -->
<c:if test="${not empty id}">
		<div class="box-body">
					<label for="exampleInputEmail1">Writer</label> <input
						class="form-control" type="text" id="newReplyWriter" value="${id}" readonly="readonly"> <label for="exampleInputEmail1">Reply
						Text</label> <input class="form-control" type="text"
						placeholder="REPLY TEXT" id="newReplyText">

				</div>
				<!-- /.box-body -->
				<div class="box-footer">
		  <button type="submit" class="btn btn-primary" id="replyAddBtn">ADD REPLY</button>
		</div>
		</c:if>
			</div>


			<!-- The time line -->
			<ul class="timeline">
				<!-- timeline time label -->
				<li class="time-label" id="repliesDiv"><span class="bg-green">
						Replies List </span></li>
			</ul>

			<div class='text-center'>
				<ul id="pagination" class="pagination pagination-sm no-margin ">

				</ul>
			</div>

		</div>
		<!-- /.col -->
	</div>
	<!-- /.row -->


          
<!-- Modal -->
<div id="modifyModal" class="modal modal-primary fade" role="dialog">
  <div class="modal-dialog">
    <!-- Modal content-->
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title"></h4>
      </div>
      <div class="modal-body" data-rno>
        <p><input type="text" id="notice_reply_contents" class="form-control"></p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-info" id="replyModBtn">Modify</button>
        <button type="button" class="btn btn-danger" id="replyDelBtn">DELETE</button>
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>      
	
	
</section>
<!-- /.content -->
<script id="templateAttach" type="text/x-handlebars-template">
<li data-src='{{fullName}}'>
  <span class="mailbox-attachment-icon has-img"><img src="{{imgsrc}}" alt="Attachment"></span>
  <div class="mailbox-attachment-info">
	<a href="{{getLink}}" class="mailbox-attachment-name">{{fileName}}</a>
	</span>
  </div>
</li>                
</script>  
<!-- <script id="template" type="text/x-handlebars-template"> -->
<!-- {{#each .}} -->
<!-- <li class="replyLi" data-notice_reply_number={{notice_reply_number}}> -->
<!-- <i class="fa fa-comments bg-blue"></i> -->
<!--  <div class="timeline-item" > -->
<!--   <span class="time"> -->
<!--     <i class="fa fa-clock-o"></i>{{prettifyDate notice_reply_wdate}} -->
<!--   </span> -->
<!--   <h3 class="timeline-header"><strong>{{notice_reply_number}}</strong> -{{notice_reply_id}}</h3> -->
<!--   <div class="timeline-body">{{notice_reply_contents}} </div> -->
<!--     <div class="timeline-footer"> -->
<!--      <a class="btn btn-primary btn-xs"  -->
<!-- 	    data-toggle="modal" data-target="#modifyModal">Modify</a> -->
<!--     </div> -->
<!--   </div>			 -->
<!-- </li> -->
<!-- {{/each}} -->
<!-- </script> -->
<!-- 로그인 처리 -->
<script id="template" type="text/x-handlebars-template">
				{{#each .}}
	         <li class="replyLi" data-notice_reply_number={{notice_reply_number}}>
             <i class="fa fa-comments bg-blue"></i>
             <div class="timeline-item" >
                <span class="time">
                  <i class="fa fa-clock-o"></i>{{prettifyDate notice_reply_wdate}}
                </span>
                <h3 class="timeline-header"><strong>{{notice_reply_number}}</strong> -{{notice_reply_id}}</h3>
                <div class="timeline-body">{{notice_reply_contents}} </div>
								<div class="timeline-footer">
								{{#eqReplyer notice_reply_id }}
                  <a class="btn btn-primary btn-xs" 
									data-toggle="modal" data-target="#modifyModal">Modify</a>
								{{/eqReplyer}}
							  </div>
	            </div>			
           </li>
        {{/each}}
</script>
<script>
// 로그인 처리
Handlebars.registerHelper("eqReplyer", function(notice_reply_id, block) {
	var accum = '';
	if (notice_reply_id == '${id}') {
		accum += block.fn();
	}
	return accum;
});

	Handlebars.registerHelper("prettifyDate", function(timeValue) {
		var dateObj = new Date(timeValue);
		var year = dateObj.getFullYear();
		var month = dateObj.getMonth() + 1;
		var date = dateObj.getDate();
		return year + "/" + month + "/" + date;
	});

	var printData = function(replyArr, target, templateObject) {

		var template = Handlebars.compile(templateObject.html());

		var html = template(replyArr);
		$(".replyLi").remove();
		target.after(html);

	}

	var notice_number = ${noticeDTO.notice_number};
	
	var replyPage = 1;

	function getPage(pageInfo) {

		$.getJSON(pageInfo, function(data) {
			printData(data.list, $("#repliesDiv"), $('#template'));
			printPaging(data.pageMaker, $(".pagination"));

			$("#modifyModal").modal('hide');

		});
		
		
	}

	var printPaging = function(pageMaker, target) {

		var str = "";

		if (pageMaker.prev) {
			str += "<li><a href='" + (pageMaker.startPage - 1)
					+ "'> << </a></li>";
		}

		for (var i = pageMaker.startPage, len = pageMaker.endPage; i <= len; i++) {
			var strClass = pageMaker.cri.page == i ? 'class=active' : '';
			str += "<li "+strClass+"><a href='"+i+"'>" + i + "</a></li>";
		}

		if (pageMaker.next) {
			str += "<li><a href='" + (pageMaker.endPage + 1)
					+ "'> >> </a></li>";
		}

		target.html(str);
	};

	$("#repliesDiv").on("click", function() {

		if ($(".timeline li").size() > 1) {
			return;
		}
		getPage("../noticereplies/" + notice_number + "/1");

	});
	

	$(".pagination").on("click", "li a", function(event){
		
		event.preventDefault();
		
		replyPage = $(this).attr("href");
		
		getPage("../noticereplies/"+notice_number+"/"+replyPage);
		
	});
	

	$("#replyAddBtn").on("click",function(){
		 var replyerObj = $("#newReplyWriter");
		 var replytextObj = $("#newReplyText");
		 var notice_reply_id = replyerObj.val();
		 var notice_reply_contents = replytextObj.val();
		
		  
		  $.ajax({
				type:'post',
				url:'../noticereplies/',
				headers: { 
				      "Content-Type": "application/json",
				      "X-HTTP-Method-Override": "POST" },
				dataType:'text',
				data: JSON.stringify({notice_number:notice_number, notice_reply_id:notice_reply_id, notice_reply_contents:notice_reply_contents}),
				success:function(result){
					console.log("result: " + result);
					if(result == 'SUCCESS'){
						alert("등록 되었습니다.");
						replyPage = 1;
						getPage("../noticereplies/"+notice_number+"/"+replyPage );
						replyerObj.val("");
						replytextObj.val("");
					}
			}});
	});


	$(".timeline").on("click", ".replyLi", function(event){
		
		var reply = $(this);
		
		$("#notice_reply_contents").val(reply.find('.timeline-body').text());
		$(".modal-title").html(reply.attr("data-notice_reply_number"));
		
	});
	
	

	$("#replyModBtn").on("click",function(){
		  
		  var notice_reply_number = $(".modal-title").html();
		  var notice_reply_contents = $("#notice_reply_contents").val();
		  
		  $.ajax({
				type:'put',
				url:'../noticereplies/'+notice_reply_number,
				headers: { 
				      "Content-Type": "application/json",
				      "X-HTTP-Method-Override": "PUT" },
				data:JSON.stringify({notice_reply_contents:notice_reply_contents}), 
				dataType:'text', 
				success:function(result){
					console.log("result: " + result);
					if(result == 'SUCCESS'){
						alert("수정 되었습니다.");
						getPage("../noticereplies/"+notice_number+"/"+replyPage );
					}
			}});
	});

	$("#replyDelBtn").on("click",function(){
		  
		  var notice_reply_number = $(".modal-title").html();
		  var notice_reply_contents = $("#notice_reply_contents").val();
		  
		  $.ajax({
				type:'delete',
				url:'../noticereplies/'+notice_reply_number,
				headers: { 
				      "Content-Type": "application/json",
				      "X-HTTP-Method-Override": "DELETE" },
				dataType:'text', 
				success:function(result){
					console.log("result: " + result);
					if(result == 'SUCCESS'){
						alert("삭제 되었습니다.");
						getPage("../noticereplies/"+notice_number+"/"+replyPage );
					}
			}});
	});
	
</script>


<script>
$(document).ready(function(){
	
	var formObj = $("form[role='form']");
	
	console.log(formObj);
	
	$("#modifyBtn").on("click", function(){
		formObj.attr("action", "./modifyPage");
		formObj.attr("method", "get");		
		formObj.submit();
	});
	
	$("#removeBtn").on("click", function(){
		
		var arr = [];
		$(".uploadedList li").each(function(index){
			 arr.push($(this).attr("data-src"));
		});
		
		if(arr.length > 0){
			$.post("/noticedeleteAllFiles",{files:arr}, function(){
				
			});
		}
		formObj.attr("action", "./removePage");
		formObj.submit();
	});
	
	$("#goListBtn ").on("click", function(){
		formObj.attr("method", "get");
		formObj.attr("action", "./list");
		formObj.submit();
	});

var notice_number = ${noticeDTO.notice_number};
var template = Handlebars.compile($("#templateAttach").html());
// js 부분 가져다 써버림
function getFileInfo(fullName){
	
	var fileName,imgsrc, getLink;
// 	alert("여기 오긴하니?");
	var fileLink;
	
	if(checkImageType(fullName)){
		imgsrc = "../noticedisplayFile?fileName="+fullName;
		fileLink = fullName.substr(14);
		
		var front = fullName.substr(0,12); // /2015/07/01/ 
		var end = fullName.substr(14);
		
		getLink = "../noticedisplayFile?fileName="+front + end;
		
	}else{
		imgsrc ="../resources/dist/img/file.png";
		fileLink = fullName.substr(12);
		getLink = "../noticedisplayFile?fileName="+fullName;
	}
	fileName = fileLink.substr(fileLink.indexOf("_")+1);
	
	return  {fileName:fileName, imgsrc:imgsrc, getLink:getLink, fullName:fullName};
	
}

$.getJSON("./getAttach/"+notice_number,function(list){
// 	alert("ddd");
	$(list).each(function(){
		
		var fileInfo = getFileInfo(this);
// 		alert("ㅇㅇㅇ");
		var html = template(fileInfo);
		
		 $(".uploadedList").append(html);
		
	});
});


$(".uploadedList").on("click", ".mailbox-attachment-info a", function(event){
	mailbox-attachment-infomailbox-attachment-info
	var fileLink = "notice"+$(this).attr("href");
	
	if(checkImageType(fileLink)){
		
		event.preventDefault();
				
		var imgTag = $("#popup_img");
		imgTag.attr("src", fileLink);
		
		console.log(imgTag.attr("src"));
				
		$(".popup").show('slow');
		imgTag.addClass("show");		
	}	
});

$("#popup_img").on("click", function(){
	
	$(".popup").hide('slow');
	
});
});
</script>






<!-- Bootstrap 3.3.2 JS -->
<!--     <script src="../resources/bootstrap/js/bootstrap.min.js" type="text/javascript"></script> -->
    <!-- FastClick -->
    <script src='../resources/plugins/fastclick/fastclick.min.js'></script>
    <!-- AdminLTE App -->
    <script src="../resources/dist/js/app.min.js" type="text/javascript"></script>
    <!-- AdminLTE for demo purposes -->
    <script src="../resources/dist/js/demo.js" type="text/javascript"></script>
    </body>
    </html>
