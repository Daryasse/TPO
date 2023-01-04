<html>
<head>
    <title>Task 6</title>
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script type="text/javascript"  src="apps.js"></script>
</head>
<body>
<form id="calculator2" action="servlet" method="get">
    <p><input name="component1">
        <input name="component2"></p>
    <p>GET: <span id="result2">${sum}</span></p>
</form>
<form id="calculator" action="servlet" method="post">
    <p><input name="component1">
        <input name="component2"></p>
    <p>POST: <span id="result">${sum}</span></p>
</form>
</body>
</html>