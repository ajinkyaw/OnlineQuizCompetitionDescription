<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.Map"
	import="java.util.ArrayList"%>
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
        <%
        
        Map<String, Integer> userAnswers = (Map<String, Integer>) request.getAttribute("userAnswers");
        ArrayList<String> userSelectedAnswers = (ArrayList<String>) request.getAttribute("userSelectedAnswers");
        ArrayList<String> correctAnswers = (ArrayList<String>) request.getAttribute("correctAnswers");
        ArrayList<String> questionTexts = (ArrayList<String>) request.getAttribute("questionTexts");
        Integer score = (Integer) request.getAttribute("totalScore");
        
        for (String userSelectedAnswer : userSelectedAnswers) {
			System.out.println("testing userSelectedAnswer: " + userSelectedAnswer);
		}
        
        for (int i = 0; i < questionTexts.size(); i++) {
            String question = questionTexts.get(i);
            String userAnswer = userSelectedAnswers.get(i);
            String correctAnswer = correctAnswers.get(i);
		%>
                <tr>
                    <td><%=question%></td>
                    <td><%=correctAnswer%></td>
                    <td><%=userAnswer%></td>
                </tr>
        </tbody>
        <%
        }
        %>
    </table>
    <h2>Total Score: <%=score%></h2>
</body>
</html>