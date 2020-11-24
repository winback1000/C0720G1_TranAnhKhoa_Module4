<%--
  Created by IntelliJ IDEA.
  User: ttqld
  Date: 11/24/2020
  Time: 3:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Create New Employee</title>
</head>
<body>
    <form:form action="/create" method="post" modelAttribute="employee">
        <form:label path="name">Name</form:label>
        <form:input path="name"></form:input>
        <br>
        <form:label path="contactNumber">Contact Number</form:label>
        <form:input path="contactNumber"></form:input>
        <br>
        <hr>
        <form:button>Save</form:button>
        <a href="/employee"><button type="button">Cancel</button></a>
    </form:form>

</body>
</html>
