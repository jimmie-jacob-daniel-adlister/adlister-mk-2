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
        <h1>${user.username}'s Profile</h1>
    </div>
    <c:if test="${sessionScope.user.username.equalsIgnoreCase(user.username)}">
        <div class="container">
            <p>Want to create a post?</p>
            <a href="/create" class="btn btn-primary btn-block">Yes</a>
        </div>
    </c:if>

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
            <c:if test="${sessionScope.user.username.equalsIgnoreCase(user.username)}">
                <form method="POST" action="/profile">
                    <input type="hidden" name="action" value="delete"/>
                    <input type="hidden" name="adNumber" value="${ad.id}"/>
                    <button>Delete</button>
                </form>
                <form method="POST" action="/profile">
                    <input type="hidden" name="action" value="edit"/>
                    <input type="hidden" name="adNumber" value="${ad.id}"/>
                    <button>edit</button>
                </form>
            </c:if>

        </div>
    </c:forEach>

</body>
</html>
