<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>  

<!DOCTYPE html>
<html>
<title>User Registration</title>
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
  margin-top: 100px;
}

label{
 font-size: 20px;
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

<s:url var="url_reg" value="/register" />
<f:form action="${url_reg}" modelAttribute="command" class="w3-container w3-card-4 w3-light-grey w3-text-pink" method="POST" enctype="application/x-www-form-urlencoded">

	<div class="w3-center">
  		<h2>Registration Form</h2>
  		<c:if test = "${err!=null}">
			<p class="error" style="color:blue;"> ${err}</p>
		</c:if>
	</div>
	
	<div class="w3-center w3-row w3-section">
		<div class="w3-col" style="width:20px"><i class="w3-xxlarge fas fa-users"></i></div>	
  			<f:radiobutton path="role" value="ROLE_USER" style="width:20px" name="role"/>User 
  			<f:radiobutton path="role" value="ROLE_ISV" style="width:20px" name="role"/>ISV
	</div> 
	
	<div class="w3-row w3-section">
 		<div class="w3-col" style="width:60px"><i class="w3-xxlarge fas fa-user-tie"></i></div>
       	<div class="w3-rest">
      		<f:input path="name" class="w3-input w3-border" name="name" type="text" placeholder="Name" />
    	</div>
	</div>

	<div class="w3-row w3-section">
  		<div class="w3-col" style="width:60px"><i class="w3-xxlarge fa fa-phone"></i></div>
    	<div class="w3-rest">
      		<f:input path="phone" class="w3-input w3-border" name="phone" type="text" placeholder="Phone" />
    	</div>
	</div>

	<div class="w3-row w3-section">
  		<div class="w3-col" style="width:60px"><i class="w3-xxlarge fas fa-comment-alt"></i></div>
    	<div class="w3-rest">
      		<f:input path="email" class="w3-input w3-border" name="email" type="text" placeholder="Email" />
    	</div>
	</div>

	<div class="w3-row w3-section">
  		<div class="w3-col" style="width:60px"><i class="w3-xxlarge fas fa-address-book"></i></div>
    	<div class="w3-rest">
      		<f:input path="address" class="w3-input w3-border" name="address" type="text" placeholder="Address" />
    	</div>
	</div>

	<div class="w3-row w3-section">
  		<div class="w3-col" style="width:60px"><i class="w3-xxlarge fa fa-user"></i></div>
    	<div class="w3-rest">
      		<f:input path="loginName" class="w3-input w3-border" name="username" type="text" placeholder="User Name" />
    	</div>
	</div>

	<div class="w3-row w3-section">
  		<div class="w3-col" style="width:60px"><i class="w3-xxlarge fa fa-lock"></i></div>
    	<div class="w3-rest">
      		<f:password path="password" class="w3-input w3-border" name="password" placeholder="Password" />
    	</div>
	</div>
	
	<p class="w3-center">
		<button class="w3-button w3-section w3-pink w3-ripple"> REGISTER </button>
	</p>

</f:form>


</body>
</html>