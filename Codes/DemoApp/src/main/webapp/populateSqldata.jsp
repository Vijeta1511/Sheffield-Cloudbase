<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="com.practice.DB" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="javax.sql.DataSource" %>
<%@ page import="org.springframework.context.ApplicationContext" %>
<%@ page import="org.springframework.context.annotation.AnnotationConfigApplicationContext" %>
<%@ page import="org.springframework.jdbc.core.JdbcTemplate" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
 
<%@ page import="javax.sql.DataSource" %>
 
<%@ page import="org.springframework.jdbc.core.JdbcTemplate" %>
<%@ page import="org.springframework.jdbc.datasource.DriverManagerDataSource" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="populateSqldata.jsp">
<table>
<%
	ApplicationContext ctx = new AnnotationConfigApplicationContext(DB.class);
    DataSource ds = ctx.getBean(DataSource.class);
    JdbcTemplate jt = new JdbcTemplate(ds);
    String sql="select * from userdetails";
    List<Map<String, Object>> employees = jt.queryForList(sql);
    
    if (employees!=null && !employees.isEmpty()) { %>
         <tr>
 <%       for (Map<String, Object> employee : employees) { %>
             <tr>
            <% for (Iterator<Map.Entry<String, Object>> it = employee.entrySet().iterator(); it.hasNext();) {
                Map.Entry<String, Object> entry = it.next();
                String key = entry.getKey();
                Object value = entry.getValue(); %>
                
                <td> <%=key%> = <%=value%>
                </td>
                
                
            <% } %>
             
          </tr>   
        <% } %>
        </tr>
         
    <% } %>
</table>
<p>Please follow this link to return to Home page:   <a href="index.jsp">Home</a>.</p>
</form>
</body>
</html>

