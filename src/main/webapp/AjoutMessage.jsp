<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="java.util.*, Metier.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sending messages form</title>
</head>
<body>
<h2> Add a new message</h2>
     <%User user = (User) session.getAttribute("user"); %>
     <FORM action = "ServiceServlet" method ="post">
     <TABLE >
		<TD width="100" > <b>Email </b>  </TD>
			<TD> <input type="text"  name="email" style="width:300px" disabled
			      value=<%=user.getEmail() %>> </TD>
		</TR>
		<TR>
			<TD  valign="top" > <b>Message</b>  </TD>
			<TD> <textarea name="message"  
       			placeholder="Saisir un message" 
        			rows="10" cols="30"
        			style="width:400px;height:150px">
    		</textarea>   </TD>
		</TR>
	</TABLE>
	<TABLE>
		<TR> 
			<TD  align=center width="50%">
			<input type="submit" name="action" value="Send"  
			                             width="60" height="60" >
			</TD>
			<TD  align=center width="25%">			
			<input type="submit" name="action" value="See messages" 
			                            width="60" height="60">
			</TD>
			<TD  align=center valign= "middle">	
			<a href="ServiceServlet">LogOut ... </a>
			</TD>
		</TR>
	</TABLE>
    </FORM>
    <% session.setAttribute("page", "AjoutMessage");  %>
</body>
</html>