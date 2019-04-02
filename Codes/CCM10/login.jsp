<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="styles2.css" />
<link rel="stylesheet" href="styles.css" />
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>TOY APP</title>
</head>
<body class="main">

  <div class="toptab">
<a href = "index.jsp" > Home </a>
<a href = "app.jsp" > Apps </a>
<a href = "reg.jsp" > Register </a>
<a href = "viewusers.jsp" > View All Registered Users </a>
<a class="active" href = "login.jsp" > Login </a>
  </div>
<u><h1><font color="white">Log In</font></h1></u>
<form action="server.jsp" method = "post" id="loginform">
<div class="form-group">
  
    <label for="exampleInputEmail1"><font size="5" color="white">Username</font> </label>
    <input type="text" class="form-control" id="exampleInputEmail1" name="username" placeholder="Enter Username">
    
  </div>
<input type="submit" class="btn btn-primary" value ="submit">
</form>

</body>
</html>
