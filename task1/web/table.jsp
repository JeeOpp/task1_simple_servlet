<%--
  Created by IntelliJ IDEA.
  User: DNAPC
  Date: 09.11.2017
  Time: 13:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8">
    <title>Table</title>
    <style type="text/css">
        table {
            width: 500px;
            border-collapse: collapse;
        }
        td, th {
            border: 1px solid black;
        }
    </style>
</head>
<body>
   <table>
       <tr>
           <th>Name</th>
           <th>Surname</th>
           <th>Phone Number</th>
           <th>e-mail</th>
       </tr>
       <tr>
           <th><%= request.getAttribute("name")%> </th>
           <th><%= request.getAttribute("surname")%> </th>
           <th><%= request.getAttribute("phone")%> </th>
           <th><%= request.getAttribute("email")%> </th>
       </tr>
   </table>
</body>
</html>
