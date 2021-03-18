<%--
  Created by IntelliJ IDEA.
  User: daniel
  Date: 3/18/21
  Time: 10:03 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Add a comment</h2>
<div class="card container">
    <form action="/create-comment" method="POST">
        <div class="form-group">
            <label for="content">Add Comment here. Be civil or else.</label>
            <textarea name="content" id="content" cols="30" rows="10" placeholder="I think that...." class="form-control"></textarea>
        </div>
    </form>
</div>

<div class="card container">
    <h2>New ad</h2>
    <form action="/ads/create" method="POST">
        <div class="form-group">
            <label for="title">Title:</label>
            <input type="text" name="title" id="title" class="form-control">
        </div>


        <div class="form-group">
            <label for="description">Description:</label>
            <textarea name="description" id="description" cols="30" rows="10" class="form-control"></textarea>
        </div>

        <div class="form-group">
            <label for="imageURL">Image URL:</label>
            <input type="text" id="imageURL" name="imageURL" class="form-control">
        </div>

    </form>
</div>
</body>
</html>
