<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.3/modernizr.min.js"></script>
</head>
<body>
<div class="container">
<div class="jumbotron">
	<form action="C_56_Add" method="post">
	<div class="class="form-group">
  <div class="row">
    <div class="col-md-4">
		<label for="name">Name:</label>
		</div>
    <div class="col-md-8">
		<input type="input" name="name"> 
		</div>
		</div>
		</div>
	<div class="class="form-group">
  <div class="row">
    <div class="col-md-4">
		<label for="email">Email :</label> 
		</div>
    <div class="col-md-8">
		<input type="input" name="email"> 
		</div>
		</div>
		</div>
	<div class="class="form-group">
  <div class="row">
    <div class="col-md-4">
		<label for="age">Age:</label> 
		</div>
    <div class="col-md-8">
		<input type="input" name="age"> 
		</div>
		</div>
		</div>
	<div class="class="form-group">
  <div class="row">
    <div class="col-md-4">
		<label for="color">Favorite Color:</label> 
		</div>
    <div class="col-md-8">
		<input type="input" name="color"> 
		</div>
		</div>
		</div>
		<input type="submit" class="class="btn btn-primary" name="add" value="Add Friend">
	</form>
	</div>
	</div>
</body>
</html>