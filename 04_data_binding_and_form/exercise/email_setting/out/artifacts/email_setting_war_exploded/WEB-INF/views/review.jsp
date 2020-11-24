<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Save</title>
</head>
<body>
<h2 style="color: blue">${message}</h2>
<form:form modelAttribute="setting">
    <h3>Language</h3>
    <form:input path="language" disabled="true"></form:input> <br>
    <h3>Page size</h3>
    <form:input path="pageSize" disabled="true"></form:input> <br>
    <h3>Spams filter:</h3>
    <form:input path="spamsFilter" disabled="true"></form:input><br>
    <h3>Signature</h3>
    <form:textarea path="signature" disabled="true"></form:textarea>
</form:form>
</body>
</html>
