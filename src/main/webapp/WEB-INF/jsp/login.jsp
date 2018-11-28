<!DOCTYPE html>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<html lang="en">
<head>
  <title>Login</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="/css/main.css" />
</head>

<script >
function formCheck(){
	var userid=document.getElementById( 'userid' ).value;
	var pwd=document.getElementById( 'pwd' ).value; 
	
	if(userid==''){
		alert("Please Enter userId");
		return false;
	}
		
	if(pwd==''){
		alert("Please Enter password");
		return false;
	}
	
	
	document.forms[0].action="/submitlogin";
	document.forms[0].submit();
	return true;
	
}

</script>
<body>
<header>
<center><h1>Policy Management System</h1></center>
</header>

<nav>
<ul>
  <li><a href="/register">Register</a></li>
  <li><a href="/">About Us</a></li>
  <li><a href="/contactus">Contact Us</a></li>
</ul>
</nav>




<section >
</section>
<article></article>
<div class="container">
  <h2>Welcome to the Site</h2>
  <form:form class="form-horizontal" action="" id="login" method="post" modelAttribute="user">
  
   <c:if test="${adminLoginFailed}">
    <section>
    <p>Contact Admin Service</p>
  </section>
    </c:if>
     <c:if test="${userLoginFailed}">
    <section>
    <p>You are a not registered User. Register to login.. Click <a href="/login">Login</a></p>
  </section>
    </c:if>
    <div class="form-group">
      <label class="control-label col-sm-2" for="userid">User ID:</label>
      <div class="col-sm-10">
        <form:input type="text" class="form-control" id="userid" placeholder="Enter userid" name="userid" path="userId"/>
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="pwd">Password:</label>
      <div class="col-sm-10">          
        <form:input type="password" class="form-control" id="pwd" placeholder="Enter password" name="pwd" path="password" />
      </div>
    </div>
      <div class="form-group">        
      <div class="col-sm-offset-2 col-sm-10">
        <button type="button" class="btn btn-danger custom-button-width .navbar-right" onClick="formCheck()">Login</button>
      </div>
    </div>
  </form:form>
</div>
<footer>
<p>&copy; 2018 Policy Management System. All rights reserved.</p>
</footer>
</body>
</html>
