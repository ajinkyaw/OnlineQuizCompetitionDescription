<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Quiz Display</title>
</head>
<body>
    <h1>Quiz</h1>
    
    <form action="submitQuiz.jsp" method="post">
        <c:forEach var="question" items="${quiz}">
            <div class="question">
                <p>${question.text}</p>
                <c:forEach var="option" items="${question.options}">
                    <input type="radio" name="q${question.id}" value="${option}">${option}<br>
                </c:forEach>
            </div>
        </c:forEach>
        <input type="submit" value="Submit Quiz">
    </form>
</body>
</html>
