<%--
  Created by IntelliJ IDEA.
  User: ttqld
  Date: 11/24/2020
  Time: 11:36 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>Home</title>
  </head>
  <body>
  <h2 style="color: blue">${message}</h2>
  <table border="1px">
    <tr>
      <td>Id</td>
      <td>Name</td>
      <td>Contact Number</td>
    </tr>
    <c:forEach var="employee" items="${employeeList}">
      <tr>
        <td>${employee.id}</td>
        <td>${employee.name}</td>
        <td>${employee.contactNumber}</td>
      </tr>
    </c:forEach>
  </table>

  <a href="/create">Create new Employee</a>
  </body>
</html>
