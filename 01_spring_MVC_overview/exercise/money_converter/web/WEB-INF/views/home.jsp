<%--
  Created by IntelliJ IDEA.
  User: ttqld
  Date: 11/20/2020
  Time: 4:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Homepage</title>
</head>
<body>
<form method="get" action="converter">
    <h2>Please input the amount of USD</h2>
    <input type="text" name="amount" value="${amount}" ${amount == null? '':'readonly'}>
    <input type="text" name="unit" value="USD">
    <button type="submit">Convert</button>
</form>
${result == null ? '<h2>Please re-enter the unit</h2>': '<h2>Result:</h2>'}
<h2>${result}</h2>

</body>
</html>
