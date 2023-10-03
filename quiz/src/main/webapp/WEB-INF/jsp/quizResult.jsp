<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Quiz Result</title>
</head>
<body>
    <h1>Quiz Result</h1>
    <table border="1">
        <thead>
            <tr>
                <th>Question</th>
                <th>Correct Answer</th>
                <th>Your Answer</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${userAnswers}" var="entry">
                <tr>
                    <td>${entry.key}</td>
                    <td>${correctAnswers[entry.key]}</td>
                    <td>${entry.value}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <h2>Total Score: ${totalScore}</h2>
</body>
</html>