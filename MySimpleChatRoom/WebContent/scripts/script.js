$(document).ready(function() 
{                        
        $('#submit').click(function(event) {  
            var messageContent=$('#message').val();
            var senderLogin=$('#senderLogin').val();
            var receiverLogin=$('#receiverField').val();
            
        	$.get('SendingServlet',{message:messageContent, sender:senderLogin, receiver:receiverLogin},function(responseText)
        	{ 
                $('#conversationArea').text(responseText);         
            });
        });
});
