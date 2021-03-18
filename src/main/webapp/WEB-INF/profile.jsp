<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Profile" />
    </jsp:include>
</head>
<body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />

    <div class="container">
        <h1>Welcome, ${sessionScope.user.username}!</h1>
    </div>
    <c:forEach var="ad" items="${ads}">
        <div class="col-md-6">
            <h2>${ad.title}</h2>
            <p>${ad.description}</p>
            <c:forEach var="category" items="${ad.categories}">
                <div class="col-md-6">
                    <p>${category.getCategory()}</p>
                </div>
            </c:forEach>
            <div>Comments</div>
            <c:forEach var="comment" items="${ad.comments}">
                <div class="col-md-6">
                    <h2>${comment.userId}</h2>
                    <p>${comment.content}</p>
                </div>
            </c:forEach>
            <c:forEach var="image" items="${ad.images}">
                <div class="col-md-6">
                    <h2>${image.description}</h2>
                    <img src="${image.url}"></img>
                </div>
            </c:forEach>
            <button>Delete</button>

        </div>
    </c:forEach>

</body>
</html>
