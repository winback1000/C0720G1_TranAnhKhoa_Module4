<%--
  Created by IntelliJ IDEA.
  User: ttqld
  Date: 11/24/2020
  Time: 8:21 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>Calculator</title>
  </head>
  <body>
  <form action="/calculate" method="get">
    <table>
      <tr>
        <th><label>First parameter</label></th>
        <th></th>
        <th><label>Second parameter</label></th>
      </tr>
      <tr>
        <td><input type="text" name="firstParameter" value="${first}"></td>
        <td>
          <label>
          <select name="action">
            <option value="plus">+</option>
            <option value="minus">-</option>
            <option value="multiple">*</option>
            <option value="divine">/</option>
          </select>
          </label>
        </td>
        <td><input type="text" name="secondParameter" value="${second}"></td>
      </tr>
    </table>
    <hr>
    <button type="submit">Result: ${result}</button>
  </form>

  </body>
</html>
