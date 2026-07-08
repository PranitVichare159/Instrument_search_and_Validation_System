<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
    String error = request.getParameter("error");
    if ("InvalidCredentials".equals(error)) {
%>
    <div style="color:red; font-weight:bold; text-align:center;">
       <h2> Invalid Username or Password</h2> 
    </div>
<%
    }
%>



<h1>Admin Login Portal</h1>
<form action="AdminLogin"method="post">
Enter the Your Username:
<input type="text" name="username" required="required">
<br>
<br>
Enter The Password:
<input type="text" name="password" required="required">
<br>
<br>
<input type="submit" value="login">
</form>
<br>
<a href="index.jsp"><button>Back To Login</button></a>


</body>
</html>