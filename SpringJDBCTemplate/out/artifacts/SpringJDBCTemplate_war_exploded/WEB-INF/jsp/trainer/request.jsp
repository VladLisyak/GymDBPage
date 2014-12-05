<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Влад
  Date: 23.11.2014
  Time: 14:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <style>

    </style>
</head>
<body>
<div style="text-align: center;">
    <br/>
    <br/>
    <br/>
    <br/>
    <br/>
<form:form method="post" action="search" modelAttribute="searchForm">
    <p>${searchForm.word}</p>
    <label>
        <input path="word"/><br/>

        <input type="radio" name="parameter" value="ID" checked="true">ID
        <input type="radio" name="parameter" value="NAME_TR">Name
        <input type="radio" name="parameter" value="rank">Rank
        <input type="radio" name="parameter" value="salary">Salary
        <input type="radio" name="parameter" value="client">Client<br/>
    </label>
    <input type="submit" value="Search!" />
</form:form>
</div>
</body>
</html>
