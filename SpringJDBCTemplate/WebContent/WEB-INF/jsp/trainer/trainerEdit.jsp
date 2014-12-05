<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page session="true" %>
<html>
<head>
    <title>Being Java Guys | Spring DI Hello World</title>

</head>
<body>
<center>
    <br /> <br /> <br /> <b>Edit Trainer Details </b><br /> <br />
    <div>
        <form:form method="post" action="update" modelAttribute="wrapper">
            <table>
                <tr>
                    <td>Name :</td>
                    <td><form:input path="trainer.NAME_TR"
                                    value="${map.wrapper.trainer.NAME_TR}" />
                    </td>
                </tr>
                <tr>
                    <td>Rank :</td>
                    <td><form:input path="trainer.rank" value="${map.wrapper.trainer.rank}" />
                    </td>
                </tr>
                <tr>
                    <td>Salary :</td>
                    <td><form:input path="trainer.salary" value="${map.wrapper.trainer.salary}" />

                    </td>
                </tr>
                <tr>
                    <td>Clients :</td>
                    <td><spring:bind path="usernames">
                        <c:forEach items='${map.wrapper.usernames}' var='user'>
                           <input type="checkbox" name="usernames" value="${user}"<%--checked="checked"--%>>${user}<br>
                        </c:forEach>
                    </spring:bind>
                    </td>
                </tr>
                <tr>
                    <td>&nbsp;</td>
                    <td><input type="submit" value="Save" />
                    </td>
                </tr>
            </table>
            <form:hidden path="trainer.trainerId" value="${map.wrapper.trainer.trainerId}" />
                <c:forEach items="${map.wrapper.initClients}" var="clnt">
                    <form:hidden path="initClients" value="${clnt}"/>
                </c:forEach>

        </form:form>
        <tr>
            <td>
                <c:url value="/j_spring_security_logout" var="logoutUrl" />
                <a href="${logoutUrl}">Log Out</a>
            </td></br>
        </tr>
        <tr>
            <td>
                <a href="/menu/showMenu">Show main menu</a>
            </td>
        </tr>
    </div>
</center>
</body>
</html>