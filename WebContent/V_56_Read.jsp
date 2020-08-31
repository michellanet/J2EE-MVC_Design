<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<title>Display Friends</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.3/modernizr.min.js"></script>
        <script>
            function confirmGo(m,u) {
                if ( confirm(m) ) {
                    window.location = u;
                }
            }
        </script>
</head>
<body>
 <div class="container">
	<table class="table table-striped">
<tr><th>Name</th><th>Email</th><th>Age</th><th>Favorite Color</th></tr>
<c:forEach items="${requestScope.friends}" var="friend"> 
      <tr>
        <input type="hidden" value= "${friend.getId()}" />
        <td>${friend.getName()}</td>
        <td>${friend.getEmail()}</td>
        <td>${friend.getAge()}</td>
        <td>${friend.getColor()}</td>
        <td><a href="C_56_Update?id=<c:out value="${friend.getId()}"/>">Update</a></td>
        <td><a href="javascript:confirmGo('Sure to delete this record?','C_56_Delete?id=<c:out value="${friend.getId()}"/>')">Delete</a></td>
      </tr>
     </c:forEach>
</table> 
<a href="V_56_Add.jsp">Add Friend</a>
</div>
</body>
</html>