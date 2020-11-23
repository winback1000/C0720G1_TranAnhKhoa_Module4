<%--
Created by IntelliJ IDEA.
User: ttqld
Date: 11/21/2020
Time: 9:08 AM
To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
    <title>Dictionary</title>

    </head>
    <style>
        table {
        border: 1px solid #000;
        }

        th, td {
        border: 1px dotted #555;
        }
    </style>
    <body>
<%--    There are ${customers.length()} customer(s) in list.--%>
        <table>
        <caption>Customers List</caption>
        <thead>
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Email</th>
                <th>Address</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach var="c" items="${customers}">
        <tr>
            <td>
                ${c.id}
            </td>
            <td>
               ${c.name}
            </td>
            <td>
                ${c.email}
            </td>
            <td>
                ${c.address}
            </td>
        </tr>
        </c:forEach>
        </tbody>
    </table>
</body>
</html>