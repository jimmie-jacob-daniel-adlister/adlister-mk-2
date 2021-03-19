<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp" />
</head>
<body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" >
        <jsp:param name="loggedin" value="" />
    </jsp:include>

    <c:if test="${not empty error}">
        <div class="alert alert-danger" role="alert">
            <c:out value = "${error}"/>
          </div>
    </c:if>

    <div id="carouselTop" class="carousel slide" data-bs-ride="carousel">
        <div class="carousel-inner" id="slider">
            <!-- generate here -->
            <c:forEach items="${post.images}" var="image">
                <jsp:include page="/WEB-INF/partials/carousel.jsp" >
                    <jsp:param name="url" value='${image.url}'/>
                </jsp:include>
            </c:forEach>
        </div>
        <button class="carousel-control-prev" type="button" data-bs-target="#carouselTop"  data-bs-slide="prev">
          <span class="carousel-control-prev-icon" aria-hidden="true"></span>
          <span class="visually-hidden">Previous</span>
        </button>
        <button class="carousel-control-next" type="button" data-bs-target="#carouselTop"  data-bs-slide="next">
          <span class="carousel-control-next-icon" aria-hidden="true"></span>
          <span class="visually-hidden">Next</span>
        </button>
    </div>

    <!-- User info hides at lg-->
    <div class="bg-white rounded m-3 p-3 border d-none d-lg-block" style="z-index:3;position:absolute; right:0 ;transform: translate(0,-160px); width:300px">
        <div class="d-flex">
            <img class="rounded my-2" style="width:70px" src="img/profile.webp" alt="profile-img">
            <h4 class="my-2 p-3">Username</h4>
        </div>
        <button class="w-100 my-2 btn btn-primary">
            Profile
        </button>
        <button class="w-100  btn btn-secondary">
            Contact
        </button>
    </div>

    

    <div class="container m-auto p-4" >
        <h2 class="px-2">${post.title}</h2>
        <hr>
        <h5 class="px-2">
            ${post.price}
        </h5>
        <p class="py-4 px-2">
            ${post.description}
        </p>
        <h3>Categories</h3>
        <div>
        <c:forEach var="category" items="${post.categories}">
            ${category.category}
        </c:forEach>
        </div>
        <h3>Comments</h3>

        <c:forEach var="comment" items="${post.comments}">
            <div>${comment.username}: ${comment.content}</div>
        </c:forEach>
        <c:if test="${sessionScope.user.id!=null}">
        <form class="form-inline" action="/add-comment" method="POST">
            <div class="form-group mx-sm-3 mb-2">
                <input type="text" class="form-control" name="content" id="content" placeholder="Leave a comment...">
                <input type="hidden" name="postId" value="${post.id}" />
                <input type="hidden" name="userId" value="${sessionScope.user.id}" />
            </div>
            <button type="submit" class="btn btn-primary mb-2">Comment</button>
        </form>
        </c:if>


    </div>
</body>
</html>
