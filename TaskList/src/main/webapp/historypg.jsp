<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import ="java.io.*" %>
<%@ page import ="java.util.*" %>
<%@page import="com.task.Class.FileInterface" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>History</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
<script src="view.js"></script>
<link rel="stylesheet" href="history.css">
</head>
<body>
<%HashSet<String> historySet=FileInterface.getSetFromHistory();%>
<h2>Your task History <a href="ToDo.html" type="button" class="btn btn-secondary btn"><i class="bi bi-arrow-return-left"></i></a>
	<button class="btn btn-secondary btn" type="button" data-bs-toggle="modal" data-bs-target="#clearHistoryConfirm"><i class="bi bi-trash"></i></button>
</h2>
<div id="history" class="box">
<ul>
<% for(String history:historySet){ %>
	<li><%=history%></li>
	<% }%>
</ul>
</div>
<div class="modal fade" id="clearHistoryConfirm" tabindex="-1" aria-labelledby="clearHistoryLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h1 class="modal-title fs-5" id="clearHistoryLabel">Confirm clear history </h1>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        Are you sure to clear the History?
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel</button>
        <a onclick="history()" type="button" class="btn btn-danger btn" data-bs-dismiss="modal">Sure</a>
      </div>
    </div>
  </div>
</div>
</body>
</html>