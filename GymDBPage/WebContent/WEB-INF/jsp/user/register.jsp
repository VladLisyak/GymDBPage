<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Being Java Guys | Spring DI Hello World</title>
    <style type="text/css">
        #layer1 {
            position:absolute;
            top:0;
            right:0;
            width:300px;
        }

        body {
            background-image: url(http://www.allfons.ru/pic/201206/1600x900/allfons.ru-14832.jpg);
            font-size: 20px;
            color: teal;
            font-family: Calibri;
        }
    </style>
    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link href="http://getbootstrap.com/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="http://getbootstrap.com/dist/css/bootstrap-responsive.min.css" rel="stylesheet">
</head>
<body>
	<center>
		<br /> <br /> <br /> <b>Being Java Guys | Registration Form </b>
		<br />
		<div>
			<form:form method="post" action="insert" modelAttribute="user">
				<table>
					<tr>
						<td>
                            <form:label path="firstName">First Name: </form:label>
                            <form:input path="firstName" class="form-control"/><br/>
                        </td>
					</tr>
					<tr>
						<td>
                            <form:label path="lastName">Last Name: </form:label>
                            <form:input path="lastName" class="form-control"/><br/>
                        </td>
					</tr>
                    <tr>
                        <td>
                        <form:label path="money">Money payed</form:label>
                        <form:input path="money" class="form-control"/><br/></td>
                    </tr>
					<tr>
                        <td>
                        <form:label path="tr_name">Trainer</form:label>
						<form:select path="tr_name" class="form-control" items="${map.trainersList}"/><br/></td>
					</tr>
                    <tr>
                        <td>
                            <form:label path="gender">Gender: </form:label>
                            <form:radiobuttons path="gender" items="${map.genderList}" /></td>
                    </tr>
					<tr align="center">
						<td><button type="submit" class="btn btn-primary">Save</button></td>
					</tr>
				</table>
			</form:form>
		</div>
	</center>
<div id="layer1">
    <br/>
        <td colspan="2"><a href="getList" style="color: black">Click Here to See User List</a></td></br>
        <td>
            <a href="/menu/showMenu" style="color: black">Show main menu</a>
        </td></br>
    </tr>
    <tr>
        <td>
            <c:url value="/j_spring_security_logout" var="logoutUrl" />
            <a href="${logoutUrl}" style="color: black">Log Out</a>
        </td></br>
    </tr>
</div>
</body>
</html>