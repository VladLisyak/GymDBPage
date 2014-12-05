<%--
  Created by IntelliJ IDEA.
  User: Влад
  Date: 13.11.2014
  Time: 23:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title></title>
</head>
<style>
    body {
        font-size: 30px;
        color: black;
        font-family: "Warnock Pro", "Goudy Old Style", "Palatino", "Book Antiqua", Georgia, serif;
    }
</style>
<body>
<center>
     </br></br></br>Bye!</br></br>

     <c:url value="/menu/showMenu" var="loginUrl" />
     <a href="${loginUrl}">Login</a>
</center>
</body>
</html>
