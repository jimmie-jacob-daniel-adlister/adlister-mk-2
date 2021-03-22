<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${not empty error}">
        <div class="alert alert-danger" role="alert">
            <c:out value="${error}"/>
        </div>
</c:if>
<c:if test="${not empty message}">
    <div class="alert alert-success" role="alert">
        <c:out value="${message}"/>
    </div>
</c:if>