<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Brainy Quiz</title>
</head>
<body>
	<div class="quiz-container" id="quiz">
		<div class="quiz-header">
			<p>${quiz}</p>
			<form action="submitQuiz.jsp" method="post">

				 <c:forEach var="question" items="${quiz}">
					<p>${quiz.question}</p>
				</c:forEach>
				<ul>
					<li><input type="radio" name="answer" id="a" class="answer">
						<label for="a" id="a_text">Answers</label></li>

					<li><input type="radio" name="answer" id="b" class="answer">
						<label for="b" id="b_text">Answer</label></li>

					<li><input type="radio" name="answer" id="c" class="answer">
						<label for="c" id="c_text">Answer</label></li>

					<li><input type="radio" name="answer" id="d" class="answer">
						<label for="d" id="d_text">Answer</label></li>
				</ul>
				<input type="submit" value="Submit Quiz">
			</form>
		</div>
		<!--  <div id="showScore" class="scoreArea"></div> -->
	</div>
	<!--  <script src="quizjs.js"></script> -->
</body>
</html>
<!--  

<div class="container mt-5">
        <div class="d-flex justify-content-center row">
            <div class="col-md-10 col-lg-10">
                <div class="border">
                    <div class="question bg-white p-3 border-bottom">
                        <div class="d-flex flex-row justify-content-between align-items-center mcq">
                            <h4>MCQ Quiz</h4><span>(5 of 20)</span></div>
                    </div>
                    <div class="question bg-white p-3 border-bottom">
                        <div class="d-flex flex-row align-items-center question-title">
                            <h3 class="text-danger">Q.</h3>
                            <h5 class="mt-1 ml-2">Which of the following country has largest population?</h5>
                        </div><div class="ans ml-2">
<label class="radio"> <input type="radio" name="brazil" value="brazil"> <span>Brazil</span>
</label>    
</div><div class="ans ml-2">
<label class="radio"> <input type="radio" name="Germany" value="Germany"> <span>Germany</span>
</label>    
</div><div class="ans ml-2">
<label class="radio"> <input type="radio" name="Indonesia" value="Indonesia"> <span>Indonesia</span>
</label>    
</div><div class="ans ml-2">
<label class="radio"> <input type="radio" name="Russia" value="Russia"> <span>Russia</span>
</label>    
</div></div>
                    <div class="d-flex flex-row justify-content-between align-items-center p-3 bg-white"><button class="btn btn-primary d-flex align-items-center btn-danger" type="button"><i class="fa fa-angle-left mt-1 mr-1"></i>&nbsp;previous</button><button class="btn btn-primary border-success align-items-center btn-success" type="button">Next<i class="fa fa-angle-right ml-2"></i></button></div>
                </div>
            </div>
        </div>
    </div>


-->
