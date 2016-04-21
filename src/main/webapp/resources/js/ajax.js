 
function makeAjaxCall(){
	var email = $('#email').val();
	$('#username').val(email);
	$('#username').attr("readonly",true); 
}