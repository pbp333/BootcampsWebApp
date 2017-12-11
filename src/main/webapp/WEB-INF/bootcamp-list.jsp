<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Web Bootcamp</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
          type="text/css"/>
    <!-- script references -->
    <script type="application/javascript" async
            src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <title>Web Bootcamp</title>
    <meta name="generator" content="Bootply"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link href="styles.css" rel="stylesheet">
</head>

<body>

<div class="jumbotron jumbotron-fluid">
    <div class="container">
        <%@include file="header.jsp" %>
        <h3 class="text-info">List of Bootcamps (${bootcampCount}):</h3>
        <c:if test="${not empty bootcamps}">

            <table class="table table-striped table-bordered">
                <tr>
                   <th>Id</th>
                    <th>Location</th>
                    <th>Start Date</th>
                    <th>End Date</th>
                </tr>
                <c:forEach var="bootcamp" items="${bootcamps}">
                <tr>
                    <td>${bootcamp.id}</td>
                    <td>${bootcamp.location}</td>
                    <td>${bootcamp.start}</td>
                    <td>${bootcamp.end}</td>
                </tr>
                </c:forEach>

            </table>

        </c:if>
    </div>
</div>

</body>
</html>
