<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.util.*, Metier.*" 
    %>
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="Style.css" />
<head>
<meta charset="ISO-8859-1">
<title>Form of displaying messages</title>
</head>
<body>
<h2> Displaying messages</h2>
 <% 
 	 User user=(User) session.getAttribute("user"); 
     ArrayList<Message> messages=
		  		ServiceMetier.getMessagesByUser(user);
  %>
 
 <TABLE >
	<TR>
		<TH >Date</TH> <TH >Email</TH>
		<TH >Message</TH>
	</TR>
	<%
	for (Message message:messages ) {
	%>
	<TR>
		<TD > <%=message.getDate() %>       </TD>
		<TD > <%=message.getUser().getEmail() %>       </TD>
		<TD > <%=message.getMessage() %>    </TD>
	
	</TR>
	<% } %>
</TABLE>
<BR><BR>
<a href="AjoutMessage.jsp">Add another messages... </a>	
<% session.setAttribute("page", "visualiserMessages");%>
</body>
</html>