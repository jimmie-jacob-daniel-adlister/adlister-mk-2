<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="carousel-item active" style="overflow: hidden; height: 300px;">
    <div class="w-100" style="background: url('${param.url}') 100% 50% / cover; z-index: -3; height: 300px; filter: blur(8px);"></div>
    <img class="d-block m-auto" src='${param.url}' style="height: 300px; position: relative; transform: translate(0%, -100%);" title="">
    <c:if test="${not empty param.description}">
        <div class="mx-auto text-white p-2" style="height: 80px; width: 300px; background-color: rgba(0, 0, 0, 0.4); position: relative; transform: translate(30%, -480%);">
            <!-- Info card -->
            <a href="${param.id}" class="nav-link text-white p-0">
                <h3><c:out value = "${item.title}"/></h3>
            </a>
            <p>
                <c:out value = "${param.description}"/>
            </p>
        </div>
    </c:if>
    
</div>
