<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Quiz Questions</title>
</head>
<body>
    <h1>Quiz Questions</h1>
    
    <c:forEach var="question" items="${quiz}">
        <div>
            <p>${question.questionStatement}</p>
            <ul>
                <c:forEach var="option" items="${question.options}">
                    <li>${option}</li>
                </c:forEach>
            </ul>
            <p>Correct Answer: ${question.correctAnswer}</p>
        </div>
    </c:forEach>
</body>
</html>
