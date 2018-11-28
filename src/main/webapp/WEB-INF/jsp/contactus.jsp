<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html lang="en">
<head>
<title>Contacts Us</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="/css/bootstrap.min.css">
<script src="/css/jquery.min.js"></script>
<script src="/css/popper.min.js"></script>
<script src="/js/userRegistration.js"></script>
<link rel="stylesheet" href="/css/main.css" />
</head>


<body>
	<header>
		<center>
			<h1>Policy Management System</h1>
		</center>
	</header>

	<nav>
		<ul>
			<li><a href="/">Home</a></li>
		</ul>
	</nav>


	<div class="container">
		<h2>Contact Us</h2>
		<form action="//submit.form" id="ContactUs100" method="post"
			onsubmit="return ValidateForm(this);">
			<script type="text/javascript">
				function ValidateForm(frm) {
					if (frm.Name.value == "") {
						alert('Name is required.'); frm.Name.focus(); return false;
					}
					if (frm.FromEmailAddress.value == "") {
						alert('Email address is required.'); frm.FromEmailAddress.focus(); return false;
					}
					if (frm.FromEmailAddress.value.indexOf("@") < 1 || frm.FromEmailAddress.value.indexOf(".") < 1) {
						alert('Please enter a valid email address.'); frm.FromEmailAddress.focus(); return false;
					}
					if (frm.Comments.value == "") {
						alert('Please enter comments or questions.'); frm.Comments.focus(); return false;
					}
					return true;
				}
			</script>
			<table style="width: 550px; border: 0;" cellpadding="8"
				cellspacing="0">
				<tr>
					<td><label for="Name">Name*:</label></td>
					<td><input name="Name" type="text" maxlength="60"
						style="width: 250px;" /></td>
				</tr>
				<tr>
					<td><label for="PhoneNumber">Phone number:</label></td>
					<td><input name="PhoneNumber" type="text" maxlength="43"
						style="width: 250px;" /></td>
				</tr>
				<tr>
					<td><label for="FromEmailAddress">Email address*:</label></td>
					<td><input name="FromEmailAddress" type="text" maxlength="90"
						style="width: 250px;" /></td>
				</tr>
				<tr>
					<td><label for="Comments">Comments*:</label></td>
					<td><textarea name="Comments" rows="7" cols="40"
							style="width: 350px;"></textarea></td>
				</tr>
				<tr>
					<td>* - required fields</td>
					<td>
						<div style="float: right">
							
						</div> <input name="skip_Submit" type="submit" value="Submit" /> 
					</td>
				</tr>
			</table>
		</form>
	</div>


</body>
</html>
