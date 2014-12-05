<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>"Altius Fortius Citius" Gym DB</title>
    <style>
        body {
            font-size: 40px;
            color: black;
            font-family: "Helvetica Neue", Arial, "Lucida Grande", sans-serif;
        }

        td {
            color: black;
            width: 300px;
            height: 40px;
            text-align: center;
            font-size: 28px;
            font-family: "Helvetica Neue", Arial, "Lucida Grande", sans-serif;
            background-color: azure;
        }
        .heading {
            font-size: 18px;
            color: white;
            font: bold;
            background-color: aquamarine;
            border: thick;
        }
    </style>
</head>
<body>
<center>
    <br /> <br /> <br /> <b>Menu</b><br /> <br />



    <table border="1">
        <tr>
            <td class="heading">Trainer</td>
            <td class="heading">User</td>

        </tr>
            <tr>
                <td>
                    <a href="${pageContext.request.contextPath}/trainer/register">Register new trainer</a>
                </td>
                <td>
                    <a href="${pageContext.request.contextPath}/user/register">Register new user</a>

                </td>
            </tr>
        <tr>
            <td>
                <a href="${pageContext.request.contextPath}/trainer/getList">See trainers List</a>
            </td>
            <td>
                <a href="${pageContext.request.contextPath}/user/getList">See users List</a>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <c:url value="/j_spring_security_logout" var="logoutUrl" />
                <a href="${logoutUrl}">Log Out</a>
            </td>
        </tr>
    </table>
</center>
</body>
</html>
