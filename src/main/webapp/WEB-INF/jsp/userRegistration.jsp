<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<html lang="en">
<head>
  <title>Customer Information</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
 <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script> 
  <script src="/js/userRegistration.js" ></script>
  <link rel="stylesheet" href="/css/main.css" />
</head>
<script>
$(function() {
	   $("#dob").datepicker({
	   dateFormat: 'dd/mm/yy',
	   maxDate:0
	   }
	   );
	 });
</script>

<body>
<header>
<center><h1>Policy Management System</h1></center>
</header>

<nav>
<ul>
  <li><a href="/">Home</a></li>
 </ul>
</nav>


<div class="container">
  <h2>Customer Information</h2>
  <form:form class="form-horizontal" action="/saveUser" modelAttribute="userDetail" method="post">
  
    <c:if test="${not empty showMessage}">
    <c:if test="${showMessage =='saved'}">
    <section>
    <p>User Successfully Saved. Your Generated User id is <b><c:out value="${userDetail.userId}" /> </b>..Click <a href="/login">Login</a></p>
  </section>
    </c:if>
    
    <c:if test="${showMessage =='notSaved'}">
    <section>
   <p>User Not Saved.. Possible reason that user is already exist!</p>
  </section>
    </c:if>
</c:if>
    <div class="form-group">
      <label class="control-label col-sm-2" for="fname">First Name*</label>
      <div class="col-sm-10">
        <form:input type="text" class="form-control" id="fname" placeholder="Enter First Name" name="fname" path="firstName" onkeydown="javascript:checkContents(this)"/>
      </div>
    </div>
	
    <div class="form-group">
      <label class="control-label col-sm-2" for="lname">Last Name*</label>
      <div class="col-sm-10">          
        <form:input type="text" class="form-control" id="lname" placeholder="Enter Last Name" name="lname" path="lastName" onkeydown="javascript:checkContents(this)" />
      </div>
	  </div>
	 
	   <div class="form-group">
      <label class="control-label col-sm-2" for="dob">Date Of Birth*</label>
      
	  <div class="col-sm-10">          
        <form:input type="text" class="form-control" id="dob" placeholder="Enter DOB" name="dob" path="dob" />
      </div>
    </div>
	
	<div class="form-group">
      <label class="control-label col-sm-2" for="add">Address*</label>
      
	  <div class="col-sm-10">          
        <form:input type="text" class="form-control" id="add" placeholder="Enter Address" name="add" path="address"/>
      </div>
    </div>
	
	<div class="form-group">
      <label class="control-label col-sm-2" for="contact">Contact No*</label>
      
	  <div class="col-sm-10">          
        <form:input type="text" class="form-control" id="contact" placeholder="Enter Contact No" name="contact" path="contactNo" onkeydown="javascript:checkContact(this)" />
      </div>
    </div>
	
	<div class="form-group">
      <label class="control-label col-sm-2" for="email">Email Address*</label>
      
	  <div class="col-sm-10">          
        <form:input type="email" class="form-control" id="email" placeholder="Enter Email" name="email" path="emailAdd" />
      </div>
    </div>
	
	<div class="form-group">
      <label class="control-label col-sm-2" for="pwd">Password:</label>
      <div class="col-sm-10">          
        <form:input type="password" class="form-control" id="pwd" placeholder="Enter password" name="pwd" path="password" />
      </div>
    </div>
	
	<div class="form-group">
      <label class="control-label col-sm-2" for="cpwd">Confirm Password:</label>
      <div class="col-sm-10">          
        <form:input type="password" class="form-control" id="cpwd" placeholder="Confirm password" name="cpwd" path="confPassword" />
      </div>
    </div>
	
      
	 <div class="row">
  		<div class="col-md-6">
            <button type="button" class="btn btn-primary custom-button-width" onClick="reset1()">Reset</button>
        </div>
        <div class="col-md-6 text-right">
    		<button type="button" class="btn btn-danger custom-button-width .navbar-right" onClick="submitUserRegsitration()">Submit</button>
    	</div>
  </div>
  </form:form>
</div>


</body>
</html>
