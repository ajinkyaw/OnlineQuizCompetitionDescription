<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>

<html>

<head>

<meta charset="ISO-8859-1">

<title>Online Quiz Competition ${message}</title>


</head>

<body>

	<h1>Do You want to add more questions? ${message}</h1>
<!-- 	  <form action="/generateQuestion"> -->


      <form method="get">
        <button type="submit" formaction="/generateQuestion">YES</button>
        <button type="submit" formaction="/exit">NO</button>
    </form>
</body>
</html>
    
	  
<!--         <button type="button">Yes</button> -->
