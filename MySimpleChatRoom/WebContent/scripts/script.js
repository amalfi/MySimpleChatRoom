$(document).ready(function() 
{                        
	function getAllMessagesFromDB()
	{
		var messagesInJSON;
	    var senderLogin=$('#senderLogin').val();
	    var receiverLogin=$('#receiverField').val();
	    
		$.get('ReceivingServlet',{sender:senderLogin, receiver:receiverLogin},function(responseText)
		{ 
	        messagesInJSON = responseText;  
	        var allMessagesLines = returnMessagesLinesForConversationArea(messagesInJSON);
	        $('#conversationArea').text(allMessagesLines);  
	        //wywolanie funkcji ustawiajacej content elementu conversationArea
	    });
		setTimeout(getAllMessagesFromDB, 300);
		
	}
	getAllMessagesFromDB();
	
        $('#submit').click(function(event) {  
            var messageContent=$('#message').val();
            var senderLogin=$('#senderLogin').val();
            var receiverLogin=$('#receiverField').val();
            
        	$.get('SendingServlet',{message:messageContent, sender:senderLogin, receiver:receiverLogin},function(responseText)
        	{ 
        		console.log(responseText);     
            });
        });
        	
        setInterval(getAllMessagesFromDB(), 200); 
});


function returnMessagesLinesForConversationArea(messagesInJSON)
{
	var allConversationAreaContent="";
	for(var i=0; i<messagesInJSON.length; i++)
	{
		var currentMessage = messagesInJSON[i];
		var currentLine=currentMessage.senderLogin + ": " + currentMessage.messageContent;
		allConversationAreaContent=allConversationAreaContent+"\n"+currentLine;
	}

	return allConversationAreaContent;
}