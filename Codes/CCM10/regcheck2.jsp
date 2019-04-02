 <%@ include file = "db.jsp" %>
 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*,java.util.*"%>

<%
String user=request.getParameter("username");


try
{


int i=s1.executeUpdate("insert into users(username)values('"+user+"')");
%>
			<script>
			alert("User is added successfully!!!");
			window.location.href = "index.jsp";
			</script>
			<%
}
catch(Exception e)
{
System.out.print(e);
e.printStackTrace();
}


%> 