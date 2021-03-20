<%@ page import="com.codeup.adlister.models.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% User user = (User) request.getSession().getAttribute("user"); %>
<nav class="navbar navbar-expand-sm navbar-light bg-light py-3">
    <div class="container-fluid d-flex d-flex-lg justify-content-between">
        <a href="#" class="navbar-brand">Adlister</a>
        <form action="/search" class="d-flex">
            <input class="form-control" type="text" name="term" placeholder="Search"/>
            <button class="btn btn-primary ms-2">
<%--                <i class="fas fa-search"></i>--%>
                Search
            </button>
        </form>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
    </div>
</nav>
<div class="navbar-expand-sm">
    <div class="collapse navbar-collapse w-100" id="navbarText">
        <div class="bg-dark w-100">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0 d-flex flex-row ">
                <li class="nav-item px-2 ">
                    <a class="nav-link text-white active " aria-current="page" href="/">Home</a>
                </li>
                <!-- Test if logged in -->
<%--                <c:if test="${empty param.loggedin}">--%>
<%--                    --%>
<%--                </c:if>    --%>
                <c:if test="${not empty param.loggedin}">
                    <li class="nav-item px-2">
                        <a class="nav-link text-white" href="/profile">Profile</a>
                    </li>
                </c:if>

                <c:choose>
                    <c:when test="${ sessionScope.user.id != null }">
<%--                        <p class="nav-link text-white ">You logged in baby</p>--%>
                        <li class="nav-item px-2">
                            <a class="nav-link text-white" href="/profile">Profile</a>
                        </li>
                        <li class="nav-item px-2">
                            <a class="nav-link text-white" href="/logout">Logout</a>
                        </li>
                    </c:when>
                    <c:otherwise>
<%--                        <p class="nav-link text-white ">You ain't logged in baby</p>--%>
                        <li class="nav-item px-2">
                            <a class="nav-link text-white" href="/login">Login</a>
                        </li>
                    </c:otherwise>
                </c:choose>


            </ul>
        </div>
    </div>
</div>