<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Question</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<div class="container">
    <header class="header">
        <h1>${question}</h1>
    </header>
    <main class="main-content">
        <form action="submitAnswer" method="post">
            <div class="option-container">
                <input type="radio" id="option1" name="answer" value="option1">
                <label for="option1">${option1}</label>
            </div>
            <div class="option-container">
                <input type="radio" id="option2" name="answer" value="option2">
                <label for="option2">${option2}</label>
            </div>
            <div>
                <button type="submit" class="submit-button">Відповісти</button>
            </div>
        </form>
    </main>
    <div class="statistics">
        <h2>Statistics</h2>
        <p>IP Address: 0:0:0:0:0:0:0:1</p>
        <p>Nicknames: Seismology</p>
        <p>Game counter: 55</p>
    </div>
</div>
</body>
</html>
