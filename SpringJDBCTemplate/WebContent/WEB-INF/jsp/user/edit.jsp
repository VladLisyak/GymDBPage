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
        <form:form method="post" action="update" modelAttribute="user">
            <table>
                <tr>
                    <td>
                        <form:label path="firstName">User Name:</form:label>
                        <form:input path="firstName" class="form-control" value="${map.user.firstName}" />
                    </td>
                </tr>
                <tr>
                    <td>Last Name :</td>
                    <td><form:input path="lastName" value="${map.user.lastName}" />
                    </td>
                </tr>
                <tr>
                    <td>Gender :</td>
                    <td><spring:bind path="gender">
                        <c:forEach items='${map.genderList}' var='genderName'>
                            <c:choose>
                                <c:when test="${genderName eq map.user.gender}">
                                    <input type="radio" name="gender" value="${genderName}"
                                           checked="checked">${genderName}
                                </c:when>
                                <c:otherwise>
                                    <input type="radio" name="gender" value="${genderName}">${genderName}
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </spring:bind>
                    </td>
                </tr>
                <tr>
                    <td>Money :</td>
                    <td><form:input path="Money" value="${map.user.money}" />
                    </td>
                </tr>
                <tr>
                    <td>Trainer :</td>
                    <td><spring:bind path="tr_name">
                        <select name="tr_name">
                            <c:forEach items='${map.trainersList}' var='trainerName'>
                                <c:choose>
                                    <c:when test="${trainerName eq map.user.trainer.NAME_TR}">
                                        <option value="${trainerName}" selected="true">${trainerName}</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="${trainerName}">${trainerName}</option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </select>
                    </spring:bind></td>
                </tr>
                <tr>
                    <td>&nbsp;</td>
                    <td><input type="submit" value="Save" />
                    </td>
                </tr>
            </table>
            <form:hidden path="userId" value="${map.user.userId}" />

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

