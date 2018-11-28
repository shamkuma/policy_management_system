function reset1(){
	document.getElementById( 'fname' ).value='';
	document.getElementById( 'lname' ).value='';
	document.getElementById( 'dob' ).value=''; 
	document.getElementById( 'add' ).value='';
	document.getElementById( 'contact' ).value='';
	document.getElementById( 'email' ).value='';
	document.getElementById( 'pwd' ).value='';
	document.getElementById( 'cpwd' ).value='';
	document.forms[0].action="/register";
	document.forms[0].submit();
	return true;
	
}


function submitUserRegsitration(){
	var fname=document.getElementById( 'fname' ).value; 
	var lname=document.getElementById( 'lname' ).value;
	var dob=document.getElementById( 'dob' ).value; 
	var add=document.getElementById( 'add' ).value;
	var contact=document.getElementById( 'contact' ).value; 
	var email=document.getElementById( 'email' ).value;
	var pwd=document.getElementById( 'pwd' ).value; 
	var cpwd=document.getElementById( 'cpwd' ).value;
	if(fname==''){
		alert("First Name is required" );
		return false;
	}
	if(lname=''){
	alert("Last Name is required");
	return false;
	}
	if(dob==''){
	alert("Date of Birth is Required");
	return false;
	}
	if(add==''){
		alert("Address is Required");
		return false;
	}
	
	if(contact==''){
		alert("Contact Number is required");
		return false;
	}
		
	if(email==''){
		alert("Email is required");
		return false;
	}
	if(email !=''){
		var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
		if(!mailformat.test(email)){
			alert("Email Not Valid");
		return false; 
		}
	}
	
	if(pwd==''){
	alert("Password is Required");
	return false;
	}
	if(cpwd==''){
		alert("Confirm Password is Required");
		return false;
		}
	if(pwd!=cpwd){
		alert("Password and Confirmed password not same");
		return false;
	}
	
	document.forms[0].action="/saveUser";
	document.forms[0].submit();
	return true;
	
}

var checkContents = function(input) {
    var text = input.value;
    if(!/[a-zA-Z]/.test(text))
       input.value = ""; 
 }

var checkContact = function(input) {
    var text = input.value;
    if(!/^[0-9]+$/.test(text))
       input.value = ""; 
 }

 
