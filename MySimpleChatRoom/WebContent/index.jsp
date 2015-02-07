<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MySimpleCommunicator</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="./scripts/script.js"></script>
</head>
	<body>
				<input type="hidden" id="senderLogin" value="Test">
	 Receiver   <input type="text" name="fname" id="receiverField">
	 <br>
	 <br>
	 	 <textarea rows="15" cols="50" id="conversationArea"
	      style="max-height:100px;min-height:100px; resize: none"                  >                        
	     </textarea>
	<br>
	Message Content
	<br>
		  
	<form id="messageForm">
		<input type="text" id="message"/>
		<input type="button" id="submit" value="Ajax Submit"/>
	</form>
	
	</body>
</html>