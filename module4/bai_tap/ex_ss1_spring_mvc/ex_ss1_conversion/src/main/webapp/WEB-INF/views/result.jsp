<%--
  Created by IntelliJ IDEA.
  User: vanna
  Date: 08/04/2023
  Time: 1:15 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post">
    <input type="text" name="input" value="${param.input}">
    <button type="submit">Change</button>
</form>
<p>Result: <fmt:formatNumber value="${result}" pattern="###,###"/></p>
</body>
</html>
