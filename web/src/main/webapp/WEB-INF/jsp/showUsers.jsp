<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users</title>
    <link rel="stylesheet" href="../../bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <script src="../../bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>
<body>
<div style="text-align: center;">
    <ul class="nav nav-pills">
        <li role="presentation"><a href="#">Accounts</a></li>
        <li role="presentation"><a href="#">Entries</a></li>
        <li role="presentation"><a href="#">Households</a></li>
        <li role="presentation" class="active"><a href="#">Users</a></li>
    </ul>
</div>

<table class="table table-condensed">
    <tr>
        <td>
            <!--Empty row-->
        </td>
        <td>
            <b>User Name</b>
        </td>
        <td>
            <b>Email</b>
        </td>
        <td>
            <b>Household</b>
        </td>
    </tr>
    <c:forEach var="user" items="${allUsers}">
        <tr>
            <td>
                <c:out value="Number"/>
            </td>
            <td>
                <c:out value="${user.userName}"/>
            </td>
            <td>
                <c:out value="${user.email}"/>
            </td>
            <td>
                <c:out value="${user.household.householdName}"/>
            </td>
        </tr>
    </c:forEach>
</table>
<nav aria-label="...">
    <ul class="pager">
        <li><a href="#">Previous</a></li>
        <li><a href="#">Next</a></li>
    </ul>
</nav>
</body>
</html>
