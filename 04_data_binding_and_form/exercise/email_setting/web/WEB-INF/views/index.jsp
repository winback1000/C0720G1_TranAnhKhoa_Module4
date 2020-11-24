<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Setting Email</title>
  </head>
  <body>
  <form:form action="/save" method="post" modelAttribute="setting">
    <h3>Language</h3>
    <form:select path="language" items="${languageList}"></form:select> <br>
    <h3>Page size</h3>
    <form:select path="pageSize" items="${pageList}"></form:select> <br>
    <h3>Spams filter:</h3>
    <form:checkbox path="spamsFilter"></form:checkbox>Enable Spams Filter<br>
    <h3>Signature</h3>
    <form:textarea path="signature"></form:textarea><br>
    <hr>
    <form:button>Save</form:button>
  </form:form>
  </body>
</html>
