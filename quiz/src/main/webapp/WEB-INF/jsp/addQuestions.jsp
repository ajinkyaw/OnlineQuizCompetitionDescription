<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>

<html>

<head>

    <meta charset="UTF-8">

    <title>Generate Question</title>

<%--     <style type="text/css"> <%@include file="/WEB-INF/style.css" %> </style> --%>

</head>

<body>

    <h1>Generate Question</h1>

    <form action="generateQuestion-api" method="post">

    

        <label for="question">Question:</label>

        <textarea id="question" name="question" rows="4" cols="50" required></textarea><br><br>

        

        <label for="option1">Option 1:</label>

        <input type="text" id="option1" name="option1" required><br><br>

        

        <label for="option2">Option 2:</label>

        <input type="text" id="option2" name="option2" required><br><br>

        

        <label for="option3">Option 3:</label>

        <input type="text" id="option3" name="option3" required><br><br>

        

        <label for="option4">Option 4:</label>

        <input type="text" id="option4" name="option4" required><br><br>

        

        <label for="correct_answer">Correct Answer:</label>

        <select id="correct_answer" name="correct_answer" required>

            <option value="option1">Option 1</option>

            <option value="option2">Option 2</option>

            <option value="option3">Option 3</option>

            <option value="option4">Option 4</option>

        </select><br><br>

        

        <label for="quizName">Quiz:</label>

         <select id="correct_answer" name="correct_answer">

             <c:forEach items="${quizTitles}" var="title">

                <option value="${title}">${title}</option>

            </c:forEach>

        </select><br><br>

        

        

        <input type="submit" value="Add Question" name="generate_question">

    </form>

</body>

</html>