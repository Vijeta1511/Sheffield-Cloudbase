<%@ include file = "db.jsp" %>
 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*,java.util.*"%>

<%
String user=request.getParameter("username");
boolean userFound=false;

try {
					ArrayList<String> a1=new ArrayList<String>();
                    String sql = "select * from users";
                    ResultSet r1= s1.executeQuery("select * from users");
                    while (r1.next()) {
           a1.add(r1.getString("username"));
                }
					for(int i=0;i<a1.size();i++){
            if((a1.get(i).equals(user))){
				userFound=true;
			}
        }


                    conn.close();
                } catch (Exception e) {
					%> <p>Error</p> <%
                    e.printStackTrace();
                }
				
					if(user.equals("admin")|| userFound)  {
		session.setAttribute("username",user);
		response.sendRedirect("index.jsp");
   
        }
		
	
       	else {
			%>
			<script>
			alert("Wrong Username!!!");
			window.location.href = "login.jsp";
			</script>
			<%
        }
				
				

%>