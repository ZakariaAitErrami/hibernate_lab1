<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Formulaire d'autentification</title>
</head>
<body>
     <FORM action = "ServiceServlet" method ="post">
     <TABLE >
		<TR>
			<TD> <b>Email </b>  </TD>
			<TD> <input type="text"  name="email" style="width:300px"> </TD>
		</TR>
		<TR>
			<TD> <b>Mot de passe </b>  </TD>
			<TD> <input type="text"  name="passWord"   style="width:300px"> </TD>
		</TR>
		
		<TR> 
			<TD  colspan =2 align=center >
			<INPUT type ="submit" name="login" value="OK"> 
			<a href="inscription.jsp">S'inscrire ... </a>
			</TD>
		</TR>
	</TABLE>
	
    </FORM>
</body>
<% session.setAttribute("page","login");
	String error= (String) request.getAttribute("error");
	   if (error!=null ){
	        	out.print(error);
	   }
%>
</html>

