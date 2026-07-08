<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Add Instrument Portal</h1>


<form action="AddServlet" method="post">


Enter The Instrument Name:
<input type="text" name="in_name" required="required">
<br>
<br>
Enter The Instrument Category :
<input type="text" name="in_class" required="required">
<br>
<br>
Enter The Instrument Description :
<input type="text" name="in_desc"required="required">
<br>
<br>
Enter The Date :
<input type="date" name="in_AddDate" required="required">
<br>
<br>
<input type="submit">





</form>


</body>
</html>