<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Adding form</title>
    <style>
        body {
            font-size: 20px;
            color: teal;
            font-family: Calibri;
        }

        td {
            font-size: 15px;
            color: black;
            width: 100px;
            height: 22px;
            text-align: center;
        }
        .heading {
            font-size: 18px;
            color: white;
            font: bold;
            background-color: orange;
            border: thick;
        }
    </style>
</head>
<body>
<center>
    <br /> <br /> <br /> <b>Trainer
    List | Gym BD </b><br /> <br />

    <table border="1">
        <tr>
            <td class="heading">Trainer Id</td>
            <td class="heading">Name</td>
            <td class="heading">Rank</td>
            <td class="heading">Salary</td>
            <td class="heading">Clients</td>

            <td class="heading">Edit</td>
            <td class="heading">Delete</td>
        </tr>
        <c:forEach var="trainer" items="${map.trainersList}">
            <tr>
                <td>${trainer.trainerId}</td>
                <td>${trainer.NAME_TR}</td>
                <td>${trainer.rank}</td>
                <td>${trainer.salary}</td>
                <td><c:forEach items='${trainer.users}' var='userName'>
                  <p align="justify"><a href="/user/edit?id=${userName.userId}">* ${userName}</a><br></p>
                </c:forEach></td>
                <td><a href="edit?id=${trainer.trainerId}">Edit</a></td>
                <td><a href="delete?id=${trainer.trainerId}">Delete</a></td>
            </tr>
        </c:forEach>
        <tr><td colspan="8"><a href="register">Add New Trainer</a></td></tr>
        <tr>
            <td colspan="8">
                <a href="/menu/showMenu">Show main menu</a>
            </td>
        </tr>
        <tr>
            <td colspan="8">
                <c:url value="/j_spring_security_logout" var="logoutUrl" />
                <a href="${logoutUrl}">Log Out</a>
            </td>
        </tr>

    </table>

</center>
</body>
</html>