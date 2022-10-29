<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Formulaire d'inscription</title>
</head>
<body>
<h2> Ajout d'un nouveau user</h2>
     <FORM action = "ServiceServlet" method ="post">
     <TABLE >
		<TR>
			<TD> <b>NomPr</b>  </TD>
			<TD> <input type="text"  name="nomPr" style="width:300px"> </TD>
		</TR>
		<TR>
			<TD> <b>Email </b>  </TD>
			<TD> <input type="text"  name="email"    style="width:300px"> </TD>
		</TR>
		<TR>
			<TD> <b>PassWord </b>  </TD>
			<TD> <input type="text"  name="passWord"   style="width:300px"> </TD>
		</TR>
		<TR>
			<TD> <b>Statut</b>  </TD>
			<TD> <input type="radio"  name="statut"   value="Etudiant" checked > Etudiant
			     <input type="radio"  name="statut"   value="Professeur" >Professeur  
   			</TD>
		</TR>
		<TR> 
			<TD colspan =2 align=center >
			<INPUT type ="submit" name="Valider" value="valider"> 
			</TD>
		</TR>
	</TABLE>
    </FORM>
    <%session.setAttribute("page","inscription");
    String error = (String) request.getAttribute("error");
    if(error!=null){
    	out.print(error);
    }
    %>
   
</body>
</html>