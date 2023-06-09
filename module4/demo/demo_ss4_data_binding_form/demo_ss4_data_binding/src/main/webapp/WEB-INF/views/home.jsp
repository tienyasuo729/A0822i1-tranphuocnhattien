<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: vanna
  Date: 13/04/2023
  Time: 4:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <h1>List Song</h1>
    <a href="/create">Add new</a>
</div>
<table>
    <thead>
    <th>Name</th>
    <th>Artist</th>
    <th>Genre</th>
    <th>Link</th>
    </thead>
    <tbody>
    <c:forEach items="${res}" var="e">
        <tr>
            <td><c:out value="${e.name}"</td>
            <td>${e.artist}</td>
            <td>${e.genre}</td>
            <td>
                <img src="<c:url value="${e.link}"/> " style="width: 50px;height: 50px" alt=""/>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
