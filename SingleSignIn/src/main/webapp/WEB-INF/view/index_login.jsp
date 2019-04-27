<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>  


<!DOCTYPE html>
<html>
<title>User Login</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel='stylesheet' href='https://use.fontawesome.com/releases/v5.7.0/css/all.css'>
<style>

ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
  overflow: hidden;
  background-color: #333;
}

li {
  float: left;
}

li a {
  display: block;
  color: white;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 17px;
  font-style: normal;
  font-family: "Times New Roman", Times, serif;
}

li a:hover {
  background-color: #111;
}

div{
  max-width:500px; 
}

p{
  max-width:500px; 
}

form{
  max-width:500px;
  margin: 0 auto;
  margin-top: 200px;
}

.error{
    color: #FF0000;
}
.success{
    color: #0000FF;
}

</style>

<body>

<s:url var="url_reg_form" value="/reg_form"/>
<s:url var="url_login_form" value="/get_login"/>
<s:url var="url_dashboard" value="/index"/>

<ul>
  <li><a class="active" href="${url_dashboard}">Dashboard</a></li>
  <li><a href="${url_login_form}">Login</a></li>
  <li><a href="${url_reg_form}">Registration</a></li>
</ul>

<s:url var="url_login" value="/login" />
<f:form action="${url_login}" modelAttribute="command" class="w3-container w3-card-4 w3-light-grey w3-text-pink" method="POST" enctype="application/x-www-form-urlencoded">

	<div class="w3-center">
  		<h2>Login Form</h2>
  		<c:if test = "${err!=null}">
			<p class="error" style="color:blue;"> ${err}</p>
		</c:if>
		<c:if test = "${param.act eq 'reg'}">
			<p class="success">User Registered Successfully! Welcome to Sheffield Cloudbase. Please Login.</p>
		</c:if>
	</div>
 
 
	<div class="w3-row w3-section">
  		<div class="w3-col" style="width:50px"><i class="w3-xxlarge fa fa-user"></i></div>
    	<div class="w3-rest">
      		<f:input path="loginName" class="w3-input w3-border" name="username" type="text" placeholder="User Name" />
    	</div>
	</div>

	<div class="w3-row w3-section">
  		<div class="w3-col" style="width:50px"><i class="w3-xxlarge fa fa-lock"></i></div>
    	<div class="w3-rest">
      		<f:password path="password" class="w3-input w3-border" name="password" placeholder="Password" />
    	</div>
	</div>

	<p class="w3-center">
		<button class="w3-button w3-section w3-pink w3-ripple"> LOGIN </button>
	</p>
	
</f:form>

</body>
</html>