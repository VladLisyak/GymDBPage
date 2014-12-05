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
        tr {
            align-content: center;
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
        <form:form method="post" action="insert" modelAttribute="trainer">
            <table>
                <tr>
                    <td><br/>
                        <form:label path="NAME_TR">Trainers Name: </form:label>
                        <form:input path="NAME_TR" class="form-control"/><br/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <form:label path="rank">Trainers rank: </form:label>
                        <form:select path="rank" items="${map.rankList}" class="form-control"/><br/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <form:label path="salary">Trainers salary: </form:label>
                        <form:input path="salary" class="form-control"/>
                    </td>
                </tr>
                <tr align="center">
                    <td><br/><input type="submit" value="Save" align="center" class="btn btn-primary"/></td>
                </tr>
            </table>
        </form:form>
    </div>
</center>
<div id="layer1">
    <br/>
    <td colspan="2"><a href="getList" style="color: black">Click Here to See Trainers List</a></td></br>
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