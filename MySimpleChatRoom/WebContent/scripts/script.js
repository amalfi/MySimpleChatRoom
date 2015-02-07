$(document).ready(function() 
{                        
        $('#submit').click(function(event) {  
            var messageContent=$('#message').val();
        	$.get('SendingServlet',{message:messageContent},function(responseText)
        	{ 
                $('#conversationArea').text(responseText);         
            });
        });
});
 
 