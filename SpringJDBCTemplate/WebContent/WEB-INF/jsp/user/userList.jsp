<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true" %>
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
		<br /> <br /> <br /> <b>User
			List | Being Java Guys </b><br /> <br />
			
		

		<table border="1">
			<tr>
				<td class="heading">User Id</td>
				<td class="heading">First Name</td>
				<td class="heading">Last Name</td>
				<td class="heading">Gender</td>
                <td class="heading">Money</td>
				<td class="heading">Trainer</td>
				<td class="heading">Edit</td>
				<td class="heading">Delete</td>
			</tr>
			<c:forEach var="user" items="${userList}">
				<tr>
					<td>${user.userId}</td>
					<td>${user.firstName}</td>
					<td>${user.lastName}</td>
					<td>${user.gender}</td>
                    <td>${user.money}</td>
					<td><c:choose>
                        <c:when test="${user.trainer!=null}">
                           <a href="/trainer/edit?id=${user.trainer.trainerId}">${user.trainer}</a><br>
                        </c:when>
                        <c:otherwise>
                            Without trainer
                        </c:otherwise>
					</c:choose></td>
					<td><a href="edit?id=${user.userId}">Edit</a></td>
					<td><a href="delete?id=${user.userId}">Delete</a></td>
				</tr>
			</c:forEach>
			<tr><td colspan="8"><a href="register">Add New User</a></td></tr>
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