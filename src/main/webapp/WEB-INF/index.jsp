<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp" />
</head>
<body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />


    <div class="container-fluid row">
        <div class="d-none d-md-block p-3 col-4 ">
            <h2>Categories</h2>
            <ul class="navbar-nav">
                <c:foreach var="ad" items="${ads}" >
                    <jsp:include page="/WEB-INF/partials/categoryItem.jsp">
                        <jsp:param name="price" value="${ad.price}" />
                    </jsp:include>
                </c:foreach>
                
            </ul>
        </div>

        <div class="col-8 pt-3 d-flex flex-wrap" id="adBoxes">
            
            <c:forEach var="ad" items="${ads}">
                <jsp:include page="/WEB-INF/partials/adbox.jsp">
                    <jsp:param name="imageurl" value="${ad.images[0].url}" />
                    <jsp:param name="title" value="${ad.title}" />
                    <jsp:param name="price" value="${ad.price}" />
                </jsp:include>
            </c:forEach>
        </div>
    </div>
</body>
</html>
