<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
>>>>>>> branch 'development' of https://github.com/ajinkyaw/OnlineQuizCompetitionDescription.git
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Quiz Questions</title>
</head>
<body>
<<<<<<< HEAD
    <h1>Quiz Questions</h1>
    
    <c:forEach var="question" items="${quiz}">
        <div>
            <p>${question.questionStatement}</p>
            <ul>
=======
    <h1>Quiz</h1>
    
    <form action="submitQuiz.jsp" method="post">
        <c:forEach var="question" items="${quiz}">
            <div class="question">
                <p>${question.text}</p>
>>>>>>> branch 'development' of https://github.com/ajinkyaw/OnlineQuizCompetitionDescription.git
                <c:forEach var="option" items="${question.options}">
                    <li>${option}</li>
                </c:forEach>
            </ul>
            <p>Correct Answer: ${question.correctAnswer}</p>
        </div>
    </c:forEach>
</body>
<<<<<<< HEAD
</html>
=======
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
<script>
    function updateHiddenInput(questionIndex, optionIndex) {
        // Get the selected option's value
        var selectedValue = document.querySelector('input[name="answers' + questionIndex + '"]:checked').value;
        
        // Update the corresponding hidden input field
        var hiddenInput = document.querySelector('input[name="selectedAnswers' + optionIndex + '"]');
        hiddenInput.value = selectedValue;
        console.log(hiddenInput.value);
    }
</script>

</head>

<body>

	<h1>Quiz</h1>

	<form action="takeQuiz-api" method="post">

		<%
		ArrayList<Question> questions = (ArrayList<Question>) request.getAttribute("questions");
		System.out.println(questions);

		for (int i = 0; i < questions.size(); i++) {

			Question question = questions.get(i);
			System.out.println(question);
		%>

		<h2>
			<input type="hidden" name="questions<%=i%>" value="<%=question.getQuestionStatement()%>">	
			<%=i + 1 + ". " + question.getQuestionStatement()%>
			
		</h2>

		<ul style="list-style-type: none">

			<%
			for (int j = 0; j < question.getOptions().size(); j++) {

				String option = question.getOptions().get(j);
			%>

			<li><input type="radio" name="answers<%=i%>" value="<%=j%>" onchange="updateHiddenInput(<%=i%>, '<%=j%>')"/>

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