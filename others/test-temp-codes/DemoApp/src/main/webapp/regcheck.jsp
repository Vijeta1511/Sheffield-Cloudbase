<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="com.practice.DB" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="javax.sql.DataSource" %>
<%@ page import="org.springframework.context.ApplicationContext" %>
<%@ page import="org.springframework.context.annotation.AnnotationConfigApplicationContext" %>
<%@ page import="org.springframework.jdbc.core.JdbcTemplate" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	String user = request.getParameter("username");
	ApplicationContext ctx = new AnnotationConfigApplicationContext(DB.class);
    DataSource ds = ctx.getBean(DataSource.class);
    JdbcTemplate jt = new JdbcTemplate(ds);
    String sql="INSERT INTO userdetails(`username`) VALUES(?)";
    Object[] param = new Object[]{user};
    jt.update(sql, param);
%>
   

<p id="demo"></p>
<script>
document.getElementById("demo").innerHTML = "User has been sucessfully registered!!";
</script>
<p>Please follow this link to register for another user:   <a href="reg.jsp">Register</a>.</p>
<p>Please follow this link to view all registered users:   <a href="populateSqldata.jsp">View All Registered Users</a>.</p>
</body>
</html>