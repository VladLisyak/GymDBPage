<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
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
            <input name="word" required="true"/><br/>

            Gender:
            <input type="radio" name="gender" value="male">Male
            <input type="radio" name="gender" value="female">Female
            <input type="radio" name="gender" value="both" checked="true">Both<br/><br/>

            Search Param:
            <input type="radio" name="parameter" value="ID" checked="true">ID
            <input type="radio" name="parameter" value="name">Name
            <input type="radio" name="parameter" value="money">Money
            <input type="radio" name="parameter" value="tr_name">Trainer<br/>
        </label>
        <c:if test="${empty searchForm.word}"><form:hidden path="${searchForm.word}" value="empty"/></c:if>
        <input type="submit" value="Search!" />
    </form:form>
    <form:form method="post" action="emptyUsers">
        <input type="submit" value="See Users Without trainers." />
    </form:form>
</div>
</body>
</html>
