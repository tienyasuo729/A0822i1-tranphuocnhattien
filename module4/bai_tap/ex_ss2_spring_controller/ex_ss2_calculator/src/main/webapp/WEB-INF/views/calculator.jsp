<%--
  Created by IntelliJ IDEA.
  User: vanna
  Date: 13/04/2023
  Time: 12:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Calculator</h1>
<%--@elvariable id="number" type=""--%>
<form:form method="post" modelAttribute="number">
    <label>
        <form:input type="text" path="numberFirst" value="${param.numberFirst}"/>
        <form:input type="text" path="numberSecond" value="${param.numberSecond}"/>
    </label><br>
    <form:button name="button" value="add">Addition(+)</form:button>
    <form:button name="button" value="sub">Subtraction(-)</form:button>
    <form:button name="button" value="mul">Multiplication(X)</form:button>
    <form:button name="button" value="div">Division(/)</form:button>
<%--    <form:button name="" --%>
</form:form>
<c:if test="${result != null}">
    <h1>Result: ${result}</h1>
</c:if>
</body>
</html>
