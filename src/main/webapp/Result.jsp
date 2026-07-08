<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Info </title>
</head>
<body>
<h1 style="color:blue">Detail of Your Selected Instrument</h1>
<% 	String name =(String)request.getAttribute("Name");
String category =(String)request.getAttribute("Category");
String description =(String)request.getAttribute("Desc");
String addDate =(String)request.getAttribute("AddDate");
String updateDate =(String)request.getAttribute("UpdateDate");	 
%>

<p><H3> Instrument name is :<%

if (name != null && !name.trim().isEmpty()) {
    out.print(name);
} else {
    out.print("Instrument Not Found");
}
%> </H3> </p>
<%
if (category != null && !category.trim().isEmpty()) {
	%>
	<p><H3> Belongs to   :
	
    <%=category %>

<%} %>
</H3> </p>

<%
if (description != null && !description.trim().isEmpty()) {
	%>
	<p><H3>Here is the brief Information: 
	
    <%= description %>

<%} %>
</H3> </p>

<%
if (addDate != null && !addDate.trim().isEmpty()) {
	%>
	<p><H3>Added Date is : 
	
    <%= addDate %>

<%} %>
</H3> </p>

<%
if (updateDate != null && !updateDate.trim().isEmpty()) {
	%>
	<p><H3> Instrument was Updated at  : 
	
    <%= updateDate %>

<%} %>
</H3> </p>




<a href ="index.jsp"><button> Back To Main Page</button></a>
</body>
</html>