<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8"  name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="resources/css/styles2.css" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<title>Sheffield Cloudbase Platform</title>
</head>

<body >

 <div class="toptab">
 	
 	<a class="active" href="index">DashBoard</a>
 	<%
	String username=(String)session.getAttribute("loginName");
	String role=(String)session.getAttribute("role");
	System.out.println("role is:" +role);
	if(role==null){
	%>
	<a href="reg_form">Registration</a>
	<a href="get_login">Login</a>
	<% 
	}
	else{			        
	if(role.equals("ROLE_USER")){
	%> 
  	<a href="viewAccount">Peanut Account</a>
  	<a href="logout">Logout</a>
							 
	<%
	}
	else if(role.equals("ROLE_ISV")){
	%>
  	<a href="viewAccount">Peanut Account</a>
	<a href="upload">Upload</a>
	<a href="logout">Logout</a>
							 
	<%
	}
	else if(role.equals("ROLE_ADMIN")){
	%>
  	<a href="viewAccount">Peanut Account</a>
  	<!-- <a href="viewAllTransactions">View All Transactions</a> -->
  	<a href="upload">Upload</a>
  	<a href="logout">Logout</a>
  	
  	<%
	}
}
%>	
</div>		
<table id="table2" align="center">
  
  <tr>
    <td> <button class="btnn" title="This app provides details about the status of the books at the library and view readers reviews" onClick="func1()"><img src="resources/img/libraryapp.png" width="100px" height="100px">Library App</button>
 	<script type="text/javascript" language="JavaScript">
                  function func1()
            {	
              		
                	  <c:if test="${sessionScope.userId == null}"> 
                	  <%-- User is not yet logged in --%>
                	  window.location = 'index_login'
                	  </c:if>
                	  
                	  <c:if test="${sessionScope.userId != null}"> 
                	  window.location = 'checkout'
                	  </c:if>
              

            }
    </script></td>
    
    <td ><button class="btnn" title="This application helps students to get their doubts solved. Its the application where you can share and learn." onClick="func2()"><img src="resources/img/studentforum.png" width="100px" height="100px">Ask</button>
 	<script type="text/javascript" language="JavaScript">
                  function func2()
            {

                	  <c:if test="${sessionScope.userId == null}"> 
                	  <%-- User is not yet logged in --%>
                	  window.location = 'index_login'
                	  </c:if>
                	  
                	  <c:if test="${sessionScope.userId != null}"> 
                	  window.location = 'checkout'
                	  </c:if>

            }
    </script>
    </td>			
  </tr>
			
			
</table>

</body>
</html>