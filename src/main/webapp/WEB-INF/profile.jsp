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
<div id="cardContainer">
    <c:forEach var="ad" items="${ads}">
        <div class="card" style="width: 18rem;">
            <c:forEach var="image" items="${ad.images}">
                <img class="card-img-top" src="${image.url}" alt="Card image cap"></img>
            </c:forEach>
                <div class="card-body">
                    <h5 class="card-title">${ad.title}</h5>
                    <p>${ad.description}</p>
                    <p>
                        Categories:
                        <c:forEach var="category" items="${ad.categories}">
                            ${category.getCategory()}
                        </c:forEach>
                    </p>
                </div>
            <ul class="list-group list-group-flush">
                <li class="list-group-item">
                    Comments: ${ad.comments.size()} comments
                </li>
                <c:forEach var="comment" items="${ad.comments}">
                    <li class="list-group-item">
                            ${comment.userId} : ${comment.content}
                    </li>
                </c:forEach>
            </ul>


            <c:if test="${sessionScope.user.username.equalsIgnoreCase(user.username)}">
                <div class="card-body row">
                    <div class="col-6">
                        <form method="POST" action="/profile">
                            <input type="hidden" name="action" value="delete"/>
                            <input type="hidden" name="adNumber" value="${ad.id}"/>
                            <button>Delete</button>
                        </form>
                    </div>
                    <div class="col-6">
                        <form method="POST" action="/profile">
                            <input type="hidden" name="action" value="edit"/>
                            <input type="hidden" name="adNumber" value="${ad.id}"/>
                            <button>edit</button>
                        </form>
                    </div>
                </div>
            </c:if>

        </div>
    </c:forEach>
</div>

</body>
</html>
