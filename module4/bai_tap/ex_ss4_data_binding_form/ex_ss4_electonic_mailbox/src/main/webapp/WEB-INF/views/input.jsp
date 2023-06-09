<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Electonic Mailbox</title>
    <style>
        #id {
            width: 200px;
            height: 50px;
            border: 2px solid #ccc;
            border-radius: 5px;
            padding: 5px;
            font-size: 16px;
        }
    </style>
</head>
<body>
<%--@elvariable id="mail" type=""--%>
<form:form method="post" action="showForm" modelAttribute="mail">
    <b>Settings</b>
    <strong>Languages</strong>
    <form:select path="language">
        <form:options items="${language}"/>
    </form:select>
    <div>
        <strong>Page Size: </strong>
        <a>Show</a><form:select path="size"> <form:options items="${size}"/></form:select><a>emails per page</a>
    </div>

    <strong>Spams filter: </strong>
    <form:radiobutton path="spam" value="Enable spams filter"/><a>Enable spams filter</a>
    <br>
    <strong>Signature: </strong>
    <label>
        <form:input type="text" path="signature" id="id"/>
    </label>
    <br>
    <button type="submit" style="background: lightskyblue">Update</button>
    <button type="button" onclick="clearForm()">Cancel</button>
</form:form>
</body>
<script>
    function clearForm() {
        document.getElementById("id").value = "";
        document.querySelector("form").reset();
    }
</script>
</html>
