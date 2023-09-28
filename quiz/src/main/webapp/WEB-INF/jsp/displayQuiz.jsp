
<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
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
</html> --%>





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

<%-- <%@ page contentType="text/html;charset=UTF-8" language="java"
	import="java.util.ArrayList"%>
<%@ page import="com.demo.model.Question"%>

<html>
<head>
<title>Questions</title>
</head>
<body>
	<form action="takeQuiz-api" method="post">
		<%
		ArrayList<Question> questions = (ArrayList<Question>) request.getAttribute("quiz");
		for (int i = 0; i < questions.size(); i++) {
			Question question = questions.get(i);
		%>
		<h2>
			<input type="hidden" name="questions"
				value="<%=question.getQuestionStatement()%>">
			<%=i + 1 + ". " + question.getQuestionStatement()%>
		</h2>
		<ul>
			<%
			for (int j = 0; j < question.getOptions().size(); j++) {
				String option = question.getOptions().get(j);
			%>
			<li><input type="checkbox" name="options" value="${j}" id="option${i}${j}"> 
				<label for="option${i}${j}"><%=option%></label></li>
			<%
			}
			%>
		</ul>
		<br>
		<input type="hidden" name="selectedCheckboxes[${i}]" value="">
		<%
		}
		%>
		<button type="submit">Submit Quiz</button>
	</form>

</body>
</html> --%>

<%@ page contentType="text/html;charset=UTF-8" language="java"
	import="java.util.ArrayList"%>

<%@ page import="com.demo.model.Question"%>



<!DOCTYPE html>

<html>

<head>

<title>Quiz</title>

</head>

<body>

	<h1>Quiz</h1>



	<form action="takeQuiz-api" method="post">

		<%
		ArrayList<Question> questions = (ArrayList<Question>) request.getAttribute("questions");

		for (int i = 0; i < questions.size(); i++) {

			Question question = questions.get(i);
		%>

		<h2>
			<input type="hidden" name="questions"
				value="<%=question.getQuestionStatement()%>">
			<%=i + 1 + ". " + question.getQuestionStatement()%>
			
		</h2>

		<ul style="">

			<%
			for (int j = 0; j < question.getOptions().size(); j++) {

				String option = question.getOptions().get(j);
			%>

			<li><input type="radio" name="answers<%=i%>" value="${j}" />

				<%=option%></li>

			<%
			}
			%>

		</ul>
		<br>
		<input type="hidden" name="selectedAnswers<%=i%>" value="">
		<%
		}
		%>

		<button type="submit">Submit Quiz</button>

	</form>

</body>

</html>

