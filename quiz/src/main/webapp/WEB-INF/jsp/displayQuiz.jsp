<%-- <%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.ArrayList" %>
<%@ page import="com.demo.model.Question" %>

<html>
<head>
    <title>Questions</title>
</head>
<body>
    <h1>Questions</h1>
    <form action="submitQuiz.jsp" method="post">
    <%
        ArrayList<Question> questions = (ArrayList<Question>) request.getAttribute("questions");
        for (int i = 0; i < questions.size(); i++) {
            Question question = questions.get(i);
    %>
        <h2><%= i + 1 + ". " + question.getQuestionStatement() %></h2>
        <ul>
            <%
                for (int j = 0; j < question.getOptions().size(); j++) {
                    String option = question.getOptions().get(j);
            %>
                <li>
                    <input type="radio" name="answers[${i}]" value="${j}" id="option${i}${j}" required>
                    <label for="option${i}${j}"><%= option %></label>
                </li>
            <%
                }
            %>
        </ul>
        <br>
    <%
        }
    %>
    <button type="submit">Submit Quiz</button>
    </form>
</body>
</html>
 --%>
 
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.ArrayList" %>
<%@ page import="com.demo.model.Question" %>
 
 <form action="submitQuiz.jsp" method="post">
    <%
        ArrayList<Question> questions = (ArrayList<Question>) request.getAttribute("questions");
        for (int i = 0; i < questions.size(); i++) {
            Question question = questions.get(i);
    %>
        <h2><%= i + 1 + ". " + question.getQuestionStatement() %></h2>
        <ul>
            <%
                for (int j = 0; j < question.getOptions().size(); j++) {
                    String option = question.getOptions().get(j);
            %>
                <li>
                    <input type="checkbox" name="answers[${i}][${j}]" value="${j}" id="option${i}${j}">
                    <label for="option${i}${j}"><%= option %></label>
                </li>
            <%
                }
            %>
        </ul>
        <br>
    <%
        }
    %>
    <button type="submit">Submit Quiz</button>
</form>

 