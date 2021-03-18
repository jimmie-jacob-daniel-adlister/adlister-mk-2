<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Create a new Ad" />
    </jsp:include>
</head>
<body>
<div class="card container">
    <h2>New ad</h2>
    <form action="/ads/create" method="POST">
        <div class="form-group">
            <label for="title">Title:</label>
            <input type="text" name="title" id="title" class="form-control">
        </div>

        <div class="form-group">
            <label for="price">Price: $</label>
            <input type="text" name="price" id="price" class="form-control">
        </div>

        <div class="form-group">
            <label for="description">Description:</label>
            <textarea name="description" id="description" cols="30" rows="10" class="form-control"></textarea>
        </div>

        <div class="form-group">
            <label for="imageURL">Image URL:</label>
            <input type="text" id="imageURL" name="imageURL" class="form-control">
        </div>

        <div class="form-group">
            <label for="imageDescription">Image Description:</label>
            <input type="text" id="imageDescription" name="imageDescription" class="form-control">
        </div>

        <div class="form-group">
            <label for="category">Category</label>
            <select name="category" id="category">
                <option value="null">--</option>
                <option value="free">Free</option>
                <option value="antiques">Antiques</option>
                <option value="appliances">Appliances</option>
                <option value="arts + craft">Arts + Craft</option>
                <option value="auto Parts">auto Parts</option>
            </select>
        </div>

        <input type="submit" class="btn btn-block btn-primary" />
    </form>
</div>
</body>
</html>
