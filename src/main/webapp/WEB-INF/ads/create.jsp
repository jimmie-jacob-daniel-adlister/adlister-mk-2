<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Create a new Ad" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" >
    <jsp:param name="loggedin" value="" />
</jsp:include>
<div class="container">
    
    <div class="col"> 
    <form action="/create" method="POST" class="m-3">
        <h2>${action} ad</h2>
        <div class="form-group my-2">
            <input placeholder="Title" type="text" name="title" id="title" class="form-control" value="${ad.title}">
        </div>

        <div class="form-group my-2">
            <input placeholder="Price" type="text" name="price" id="price" class="form-control" value="${ad.price}">
        </div>

        <div class="form-group my-2">
            <label for="description">Description:</label>
            <textarea name="description" id="description" cols="30" rows="10" class="form-control" >${ad.description}</textarea>
        </div>

        <div class="form-group my-2">
            <input placeholder="Image URL" type="text" id="imageURL" name="imageURL" class="form-control" value="${ad.images[0].url}">
        </div>

        <div class="form-group my-2">
            <input placeholder="Image Description" type="text" id="imageDescription" name="imageDescription" class="form-control" value="${ad.images[0].description}">
        </div>

        <div class="form-group my-2">
            <label for="categories">Category</label>
            <select class="form-select" name="categories" id="categories" multiple>
                <c:forEach var="category" items="${categories}" varStatus="loop">
                    <c:choose>
                    <c:when test="${selectedCategories.contains(category.category)}">
                        <option value="${loop.index}" selected>${category.category}</option>
                    </c:when>
                        <c:otherwise>
                            <option value="${loop.index}">${category.category}</option>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </select>
        </div>
        <input type="hidden" name="action" value="${action}" />
        <input type="hidden" name="id" value="${ad.id}" />
        <input type="hidden" name="imageId" value="${ad.images[0].id}" />
        <input type="submit" class="btn btn-block btn-primary w-100 my-2" />
    </form>
    
    </div>
    
</div>
</body>
<script> 
window.onmousedown = function (e) {
    var el = e.target;
    if (el.tagName.toLowerCase() == 'option' && el.parentNode.hasAttribute('multiple')) {
        e.preventDefault();

        // toggle selection
        if (el.hasAttribute('selected')) el.removeAttribute('selected');
        else el.setAttribute('selected', '');

        // hack to correct buggy behavior
        var select = el.parentNode.cloneNode(true);
        el.parentNode.parentNode.replaceChild(select, el.parentNode);
    }
}

</script>
</html>
