<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Question</title>
    <link rel="stylesheet" type="text/css" href="static/style.css">
</head>
<body>
<div class="container">
    <header class="header">
        <h1>${question.getQuestion()}</h1>
    </header>
    <main class="main-content">
        <form action="/quest" method="get">
            <div class="option-container">
                <input type="radio" id="option1" name="answer" value="1" required>
                <label for="option1">${question.getOption1()}</label>
            </div>
            <div class="option-container">
                <input type="radio" id="option2" name="answer" value="2" required>
                <label for="option2">${question.getOption2()}</label>
            </div>
            <div>
                <button type="submit" class="submit-button">Answer</button>
            </div>
        </form>
    </main>
    <div class="statistics">
        <h2>Statistics</h2>
        <p>Counter: ${counter}</p>
        <p>Session ID: ${ID}</p>
    </div>
</div>
</body>
</html>
