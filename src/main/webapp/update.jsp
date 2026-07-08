<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page isELIgnored="false" %>



<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Instrument</title>
</head>

<body>

<h1>Update Instrument Portal</h1>

<form action="<%= request.getContextPath() %>/UpdateServlet" method="post">

    Instrument Name:
    <input type="text" name="in_name" value="${name}" readonly><br><br>

    Category:
    <input type="text" name="in_class" value="${category}"><br><br>

    Description:
    <textarea name="in_desc">${desc}</textarea><br><br>

    Update Date:
    <input type="date" name="in_UpdateDate" value="${updateDate}"><br><br>

    <input type="submit" value="Update">
</form>

</body>
</html>
