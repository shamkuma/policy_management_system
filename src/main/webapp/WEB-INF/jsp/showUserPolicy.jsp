<!DOCTYPE html>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<html lang="en">
<head>
  <title>User Policy</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="/css/main.css" />
</head>
<style type="text/css" >
footer {
            color: white;
            background-color: black;
            width: 100%;
            bottom: 0;
            position: relative;
        } 
</style>
<body>
<header>
<center><h1>Policy Management System</h1></center>
</header>
<section>
<nav>
<ul>
  <li><a href="/">Logout</a></li>
  </ul>
</nav>
</section>
<body>
 </body>
<div class="container">
 
  <form:form class="form-horizontal"  id="showUserPolicy" method="post" modelAttribute="user">
  
  <div>
  <p>welcome <b><c:out value="${ user.userId}" /></b></p>
  
  </div>
   <section>
   			<p>Available Policy </p>
   			<table cellpadding="0" cellspacing="0" border="0" class="datatable table table-striped table-bordered">
					<thead>
						<tr>
							<th>S No.</th>
							<th>Policy Name</th>
							<th>Policy Details</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach var="policyData" items="${user.policyDataList}" varStatus="position">
					   <tr>
					   <td><c:out value="${position.index+1 }" /></td>
					   <td><c:out value="${policyData.policyName}" /></td>
					   <td><c:out value="${policyData.policyDetail}" /></td>
					   
					   </tr>
					
					</c:forEach>
					
					
					</tbody>
		</table>
   </section>
   
   <section>
   <p><b><c:out value="${ user.userId}" /></b> Policy Details</p>
   			<table cellpadding="0" cellspacing="0" border="0" class="datatable table table-striped table-bordered">
					<thead>
						<tr>
							<th>S No.</th>
							<th>Policy Name</th>
							<th>Amount Paid</th>
							<th>Policy End Date</th>
							<th>Valid</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach var="userPolicyData" items="${user.userPolicyDataList}" varStatus="position">
					   <tr>
					   <td><c:out value="${userPolicyData.policyNo }" /></td>
					   <td><c:out value="${userPolicyData.policyName}" /></td>
					   <td><c:out value="${userPolicyData.amountPaid}" /></td>
					   <td><c:out value="${userPolicyData.strPolicyEndDate}" /></td>
					   
					   <c:if test="${userPolicyData.valid}">
					   <td><c:out value="YES" /></td>
					   </c:if>
					    <c:if test="${!userPolicyData.valid}">
					   <td><c:out value="NO" /></td>
					   </c:if>
					   </tr>
					
					</c:forEach>
					
					
					</tbody>
		</table>
   </section>
   
  </form:form>
</div>


<footer>
<p>&copy; 2018 Policy Management System. All rights reserved.</p>
</footer>

</body>
</html>
