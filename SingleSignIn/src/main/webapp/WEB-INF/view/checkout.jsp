<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %> 

<!DOCTYPE html>
<html>
<title>Checkout</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel='stylesheet' href='https://use.fontawesome.com/releases/v5.7.0/css/all.css' integrity='sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ' crossorigin='anonymous'>
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

label{
  font-size: 18px;
  text-align: center;

}
</style>
<body>

<ul>
  <li><a class="active" href="index">Dashboard</a></li>
</ul>

<!-- <form action="paymentSuccessful" class="w3-container w3-card-4 w3-light-grey w3-text-pink"> -->
<f:form action="paymentSuccessful" modelAttribute="command" class="w3-container w3-card-4 w3-light-grey w3-text-pink" enctype="multipart/form-data" method="POST">
<div class="w3-center">
  <h2>Checkout</h2>
</div>
 
<div class="w3-row w3-section">
  
  <div class="w3-col" style="width:200px"> <label><b>Available Balance</b></label></div>
    <div class="w3-rest">
    
      <input class="w3-input w3-border" name="${available_balance}" type="text" placeholder="1000" disabled>
    </div>
</div>

<div class="w3-row w3-section">
  <div class="w3-col" style="width:200px"> <label><b>Application Cost</b></label></div>
    <div class="w3-rest">
      <input class="w3-input w3-border" name="Application Cost" type="text" placeholder="5" disabled>
    </div>
</div>

<p class="w3-center">
<button  class="w3-button w3-section w3-pink w3-ripple" formaction="/SingleSignIn/paymentSuccessful"> Confirm Payment </button>
<button  class="w3-button w3-section w3-pink w3-ripple" formaction="/SingleSignIn/index"> Cancel Payment </button>

</p>
</f:form>

</body>
</html>