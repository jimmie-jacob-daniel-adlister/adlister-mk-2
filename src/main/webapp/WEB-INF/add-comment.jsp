<%--
  Created by IntelliJ IDEA.
  User: daniel
  Date: 3/18/21
  Time: 10:03 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add-Comment</title>
</head>
<body>
<div class="container">
    <h2>Add a comment</h2>
    <h2>${ad.title}</h2>
    <p>${ad.description}</p>
    <div>Comments</div>
    <c:forEach var="category" items="${ad.categories}">
        <div class="col-md-6">
            <p>${category.getCategory()}</p>
        </div>
    </c:forEach>

    <c:forEach var="image" items="${ad.images}">
        <div class="col-md-6">
            <h2>${image.description}</h2>
            <img src="${image.url}"></img>
        </div>
    </c:forEach>
    <c:forEach var="comment" items="${ad.comments}">
        <div class="col-md-6">
            <h2>${comment.userId}</h2>
            <p>${comment.content}</p>
        </div>
    </c:forEach>
    <div class="card container">
        <form action="/create-comment" method="POST">
            <div class="form-group">
                <label for="content">Add Comment here. Be civil or else.</label>
                <textarea name="content" id="content" cols="30" rows="10" placeholder="I think that...."
                          class="form-control"></textarea>
            </div>
        </form>
    </div>
</div>
<%--<div class="card container">--%>
<%--    <h2>New ad</h2>--%>
<%--    <form action="/ads/create" method="POST">--%>
<%--        <div class="form-group">--%>
<%--            <label for="title">Title:</label>--%>
<%--            <input type="text" name="title" id="title" class="form-control">--%>
<%--        </div>--%>


<%--        <div class="form-group">--%>
<%--            <label for="description">Description:</label>--%>
<%--            <textarea name="description" id="description" cols="30" rows="10" class="form-control"></textarea>--%>
<%--        </div>--%>

<%--        <div class="form-group">--%>
<%--            <label for="imageURL">Image URL:</label>--%>
<%--            <input type="text" id="imageURL" name="imageURL" class="form-control">--%>
<%--        </div>--%>

<%--    </form>--%>
<%--</div>--%>
</body>
</html>
