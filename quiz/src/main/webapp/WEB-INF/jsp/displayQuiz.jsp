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
    console.log(selectedValue);

    // Update the corresponding hidden input field for the selected answer
    var hiddenInput = document.querySelector('input[name="selectedAnswers' + questionIndex + '"]');
    hiddenInput.value = selectedValue;
    console.log(hiddenInput.value);

    // Update the corresponding hidden input field for the selected answer option index
    var optionHiddenInput = document.querySelector('input[id="selectAns' + questionIndex + '"]');
    optionHiddenInput.value = selectedValue;
    console.log(optionHiddenInput.value);
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

			System.out.println("In JSP page " + question);
		%>
		<h2>
			<input type="hidden" name="questions${i}" value="<%=question.getQuestionStatement()%>">
			<%=i + 1 + ". " + question.getQuestionStatement()%>
		</h2>
		<!-- Create an array to store question text -->

		<input type="hidden" name="questionTexts[]" value="<%=question.getQuestionStatement()%>">
		<ul style="list-style-type: none">
			<%
			for (int j = 0; j < question.getOptions().size(); j++) {

				String option = question.getOptions().get(j);
			%>
			<li><input type="radio" name="answers<%=i%>" value="<%=j%>" onchange="updateHiddenInput(<%=i%>, '<%=j%>')" />
			<%=option%></li>

			<%
			}
			%>
		</ul>
		<br> 
		<input name="selectedAnswers<%=i%>" value="">
		<input id="selectAns<%=i%>" name="selectAns[]" value="">
		<%
		}
		%>
		<button type="submit">Submit Quiz</button>
	</form>
</body>
</html>