<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<li class="nav-item">
    <a class="nav-link active" aria-current="page" href="/?category=${param.name}"><c:out value = "${param.name}"/> </a>
</li>