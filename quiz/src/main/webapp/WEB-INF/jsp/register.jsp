<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>

<html lang="en">

<head>

    <meta charset="UTF-8">

    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>User Registration</title>

</head>

<body>

    <h1>User Registration</h1>

    <form action="register-api" method="POST">

        <label for="username">Username:</label>

        <input type="text" id="username" name="username" required>

        <br><br>

        

        <label for="password">Password:</label>

        <input type="password" id="password" name="password" required>

        <br><br>

        

        <label>You are:</label>

        <input type="radio" id="student" name="usertype" value="student">

        <label for="student">Student</label>

        <input type="radio" id="teacher" name="usertype" value="teacher">

        <label for="teacher">Teacher</label>

        <br><br>

        

        <label for="registerButton"></label>

        <input type="submit" id="registerButton" value="Register">


    </form>

</body>

</html>