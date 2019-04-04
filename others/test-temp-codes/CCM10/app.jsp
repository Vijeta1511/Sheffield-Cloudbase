<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TOY APP</title>
</head>
<body>

 <link rel="stylesheet" href="styles2.css" />
<link rel="stylesheet" href="styles.css" />
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
     <div class="toptab">
 <a href = "index.jsp" > Home </a>
<a class="active" href = "app.jsp" > Apps </a></b>
 <a href = "reg.jsp" > Register </a>
<a href = "viewusers.jsp" > View All Registered Users </a>

    </head>
	<body class="main">
  <%
        String username=(String)session.getAttribute("username");
        
        
        if(username==null){
			%>
			<script>
			alert("You have to login first!!!");
			window.location.href = "login.jsp";
			</script>
			<%
            
        }
		else {
    %>
	<a href="logout.jsp">Logout</a>
        <h3 align="center"><font color="white">Hi, <%=username %> ! </font></h3>
    <%
        }
 
       
        %>
		  </div>
		
<table id="table2" align="center">
  
  <tr>
      <td> <button class="btnn" title="To View all the applications" onClick="func1()"><img src="img/libraryapp.png" width="100px" height="100px"></i>Library App</button>
 <script type="text/javascript" language="JavaScript">
                  function func1()
            {

                window.location = 'app.jsp'

            }
             </script></td>
    <td ><button class="btnn" title="To View Your peanut bank account" onClick="func2()"><img src="img/studentforum.png" width="100px" height="100px">Student Forum/Ask</button>
 <script type="text/javascript" language="JavaScript">
                  function func2()
            {

                window.location = 'app.jsp'

            }
             </script>
            </td>
			
			
			</tr>
			<tr>
			</td>
    <td ><button class="btnn" title="To View all the transactions" onClick="func3()"><img src="img/lecturetheatre.png" width="100px" height="100px">Lecture Theatre App</button>
 <script type="text/javascript" language="JavaScript">
                  function func3()
            {

                window.location = 'app.jsp'

            }
             </script>
            </td>
			</td>
    <td ><button class="btnn" title="To monitor your app usage" onClick="func3()"><img src="img/studymgtapp.png" width="100px" height="100px">Study Management</button>
 <script type="text/javascript" language="JavaScript">
                  function func3()
            {

                window.location = 'app.jsp'

            }
             </script>
            </td>
			</tr>
			
			
			
</table>
</body>
</html>