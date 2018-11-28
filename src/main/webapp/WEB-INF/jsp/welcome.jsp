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
  <link rel="stylesheet" href="/css/main.css" />
</head>
<body>
<header>
<center><h1>Policy Management System</h1></center>
</header>

<nav>
<ul>
  <li><a href="/register">Register</a></li>
  <li><a href="#">About Us</a></li>
  <li><a href="#">Contact Us</a></li>
</ul>
</nav>
<body>
  <section>
    <p> This a policy Management Application
  </section>
</body>
<div >
<c:if test="${not empty showMessage}">
    <c:if test="${showMessage =='saved'}">
    <section>
    <center><p>User Successfully Saved.. Click <a href="/login">Login</a></p></center>
  </section>
    </c:if>
    
    <c:if test="${showMessage =='notSaved'}">
    <section>
    <center><p>User Successfully Saved.. Click <a href="/registration">Login</a></p></center>
  </section>
    </c:if>
<section>
    <center><p> This a policy Management Application1</p></center>
  </section>
</c:if>
<div>

</div>
  
</div>
<footer>
<p>&copy; 2018 Policy Management System. All rights reserved.</p>
</footer>

</body>
</html>
