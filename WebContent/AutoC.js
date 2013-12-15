
$(document).ready(function() {                        
                $('#txtName').keypress(function(event) {  
                    var username=$('#txtName').val();
                 $.get('AutoCServelet',{user:username},function(responseText) { 
                	 
                        $('#welcometext').text(responseText);       
                    });
                });
            });