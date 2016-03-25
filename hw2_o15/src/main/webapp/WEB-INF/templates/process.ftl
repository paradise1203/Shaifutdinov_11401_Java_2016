<html>
    <head>
        <title>Process</title>
    </head>
    <body>
    <form action="/process" method="post">
        <label for="text">Enter your text here:</label>
        <textarea name="text" id="text" cols="30" rows="10"></textarea> <br>
        <label>
            Choose operation:
            <select name="operation">
                <option value="0">Количество символов</option>
                <option value="1">Количество слов</option>
                <option value="2">Количество предложений</option>
                <option value="3">Количество абзацев</option>
            </select>
        </label> <br>
        <input type="submit" value="Process">
    </form>
    </body>
</html>