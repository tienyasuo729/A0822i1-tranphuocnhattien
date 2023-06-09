<%--
  Created by IntelliJ IDEA.
  User: vanna
  Date: 13/04/2023
  Time: 10:01 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Select</title>
</head>
<body>
<h1>SandWitch Condiments</h1>
<form method="post" action="/SandWitch">
    <label>
        <input type="checkbox" name="choose" value="Lettuce"/><strong>Lettuce</strong>
        <input type="checkbox" name="choose" value="Tomato"/><strong>Tomato</strong>
        <input type="checkbox" name="choose" value="Mustard"/><strong>Mustard</strong>
        <input type="checkbox" name="choose" value="Sprouts"/><strong>Sprouts</strong>
    </label><br>
    <button type="submit">Save</button>
</form>
</body>
</html>
