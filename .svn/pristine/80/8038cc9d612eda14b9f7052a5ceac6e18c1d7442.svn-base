<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="http://cdnjs.cloudflare.com/ajax/libs/sockjs-client/0.3.4/sockjs.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>
	<script type="text/javascript" src="../resources/js/jquery-1.12.4.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<input id="roomNumber" type="text" readonly="readonly" value="1">
	<textarea id="messageWindow" rows="30" cols="55" readonly="readonly"></textarea>
	<input id="inputMessage" type="text" />
	<input type="submit" value="send" onclick="send()" />
	<input id="from" type="text" value="test" readonly="readonly">
	
	<script type="text/javascript">
		var stompClient = null;
		var roomNumber = $('#roomNumber').val();
		connect();
		
		/* function setConnected(connected) {
			document.getElementById('connect').disabled = connected;
			document.getElementById('disconnect').disabled = !connected;
			document.getElementById('calculationDiv').style.visibility = connected ? 'visible'
					: 'hidden';
			document.getElementById('calResponse').innerHTML = '';
		} */

		function connect() {
			var socket = new SockJS('http://localhost:8080/Unlimited2nd/chatEndpoint/');
			
			stompClient = Stomp.over(socket);
			stompClient.connect({}, function(frame) {
				console.log("여기ㄴ 옴?");
				/* setConnected(true); */
				console.log('Connected: ' + frame);
				stompClient.subscribe('/subscribe/room/' + roomNumber, function(
						message) {
					showResult(JSON.parse(message.body));
				});
			});
		}

		function disconnect() {
			stompClient.disconnect();
			setConnected(false);
			console.log("Disconnected");
		}

		function showResult(message) {
			var messageWindow = document.getElementById('messageWindow');
			var str = message.from+": "+message.message;
			messageWindow.value += str + "\n";
		}
		
		function send() {
			stompClient.send("/app/chat/" + roomNumber, {}, JSON.stringify({
				from : $("#from").val(),
				text : $('#inputMessage').val()
			}));
		}
	</script>
</body>
</html>