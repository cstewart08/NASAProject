<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <!-- Add Bootstrap stuff in - styling taken from https://bootsnipp.com/snippets/PAO4l -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</head>
<body>


<div class="container">
    <div class="panel panel-default">
        <div class="panel-heading">
            <div class="clearfix"></div>
        </div>
        <c:if test="${not empty nasaList}">
        <c:forEach var="nasaEntry" items="${nasaList}">
        <div class="panel-body">
            <div class="media">
                <div class="media-left">
                    <a href="#">
                        <img class="media-object" src="${nasaEntry.thumbnailLink}" alt="Kurt">
                    </a>
                </div>
                <div class="media-body">
                    <a href="${nasaEntry.link}"><h4 class="media-heading">${nasaEntry.title}</h4></a>
                        <h5>Written By: ${nasaEntry.author}</h5>
                        <h6>Published: ${nasaEntry.datePublished}</h6>
                        ${nasaEntry.description}
                    <div class="clearfix"></div>
                </div>
            </div>
        </div>
        </c:forEach>
        </c:if>
    </div>
</div>
</body>
</html>