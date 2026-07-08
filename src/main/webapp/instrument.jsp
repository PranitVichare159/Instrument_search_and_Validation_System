<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.instrument.model.Instrument_details" %>

<!DOCTYPE html>
<html>
<head>
    <title>Instrument List</title>

    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f7f9fc;
            margin: 30px;
        }

        h2 {
            text-align: center;
            color: #333;
        }

        table {
            border-collapse: collapse;
            width: 95%;
            margin: auto;
            background-color: #ffffff;
            border: 1px solid #ccc;
        }

        th {
            background-color: #2c3e50;
            color: white;
            padding: 10px;
        }

        td {
            padding: 8px;
            text-align: center;
        }
    </style>
</head>

<body>



<br><br>
<br>
<br>

<h2>Instrument Details</h2>

<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Category</th>
        <th>Description</th>
        <th>Added Date</th>
        <th>Updated Date</th>
        <th>Operations </th>
    </tr>

<%
List<Instrument_details> list = (List<Instrument_details>) request.getAttribute("instrumentList");

    if (list != null && !list.isEmpty()) {
        for (Instrument_details ins : list) {
%>
    <tr>
        <td><%= ins.getIns_Id() %></td>
        <td><%= ins.getIns_Name() %></td>
        <td><%= ins.getIns_Category() %></td>
        <td><%= ins.getIns_desc() %></td>
        <td>
            <%= ins.getIns_Added_Date() != null ? ins.getIns_Added_Date() : "N/A" %>
        </td>
        <td>
            <%= ins.getIns_Updated_Date() != null ? ins.getIns_Updated_Date() : "N/A" %>
        </td>
        <td>
    <form action="DeleteServlet" method="post">
        <input type="hidden" name="in_name" value="<%= ins.getIns_Name() %>">

        <button type="submit">Delete</button>
    </form>
    |
    <a href="<%= request.getContextPath() %>/EditInstrument?in_name=<%= ins.getIns_Name() %>"> <button>Edit</button>
</a>


</td>
        
        
    </tr>
<%
        }
    } else {
%>
    <tr>
        <td colspan="6" style="text-align:center;">No records found</td>
    </tr>
<%
    }
%>

</table>
 
 <br>
  <br>
  <br>
  <a href="addinstrument.jsp"><button>Add New Instrument</button>  </a>
    <a href="index.jsp"><button>Back To Login</button>  </a>
  
 

</body>
</html>
