<%--
  Created by IntelliJ IDEA.
  User: ttqld
  Date: 11/21/2020
  Time: 9:08 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>Dictionary</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

  </head>
  <style>
    body {
      background-image: url("image/page_bg.jpg");
      background-repeat: no-repeat;
      background-size: cover;
    }
  </style>
  <body>
  <nav class="navbar navbar-expand-lg navbar-light" style="background-color: #e3f2fd;">
    <a class="navbar-brand" href="/home">Dictionary</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav mr-auto">
          <a class="nav-link" href="/home/add">Add Vocabulary</a>
        </li>
      </ul>
      <form class="form-inline my-2 my-lg-0" method="get" action="/home/search">
        <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search" name="searchData">
        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Look Up a Word</button>
      </form>
    </div>
  </nav>

  <table  class="table table-striped table-inverse table-responsive">
    <thead class="thead-inverse">
    <tr style="width: 500px">
      <th>Word</th>
      <th>Meaning</th>
      <th>Modify</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="wordMeaning" items="${wordList}">
      <tr>
        <td scope="row">${wordMeaning.getWord()}</td>
        <td>${wordMeaning.getMeaning()}</td>
        <td>
          <button class="btn btn-outline-warning" type="button" >Edit</button>
          <button class="btn btn-outline-danger" type="button" >Delete</button>
        </td>
      </tr>
    </c:forEach>
    </tbody>
  </table>


<%--  <!-- Modal -->--%>
<%--  <div class="modal fade" id="addingStatus" tabindex="-1" role="dialog" aria-labelledby="modelTitleId" aria-hidden="true">--%>
<%--    <div class="modal-dialog" role="document">--%>
<%--      <div class="modal-content">--%>
<%--        <div class="modal-header">--%>
<%--          <h5 class="modal-title">Add New Word Status</h5>--%>
<%--          <button type="button" class="close" data-dismiss="modal" aria-label="Close">--%>
<%--            <span aria-hidden="true">&times;</span>--%>
<%--          </button>--%>
<%--        </div>--%>
<%--        <div class="modal-body">--%>
<%--          Add Vocabulary Successful!--%>
<%--        </div>--%>
<%--        <div class="modal-footer">--%>
<%--          <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>--%>
<%--        </div>--%>
<%--      </div>--%>
<%--    </div>--%>
<%--  </div>--%>
  <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

<%--  <script>--%>
<%--    if ('${addingStatus == true}') {--%>
<%--      $('#addingStatus').modal('show');--%>
<%--    }--%>
<%--  </script>--%>
  </body>
</html>
