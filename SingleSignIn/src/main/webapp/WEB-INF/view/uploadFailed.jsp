<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel='stylesheet' href='https://use.fontawesome.com/releases/v5.7.0/css/all.css'>
<style>

form{
  max-width:510px;
  margin: 0 auto;
  margin-top: 100px;
  height: 200px;
}
div{
  max-width:500px; 
}
input{
  margin-top: 10px;  
}
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

</style>
<title>Uploading Files</title>
</head>

<body>
<ul>
  <li><a class="active" href="index">Back</a></li>
</ul>
<form action="uploadFailed" class="w3-container w3-card-4 w3-light-grey w3-text-pink" method="POST">

	<div class="w3-center">
  		<h2>Upload Failed</h2>
  		<h2>Kindly try again.</h2>
  		<center><img src="resources/img/thumbs-down.png" class="w3-round"></center>
	</div>
	
 
</form>
</body>
</html>