<%@ page import="com.codeup.adlister.models.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
        <div class="bg-dark w-100 d-flex flex-wrap">
            <ul class="navbar-nav me-auto mb-lg-0 d-flex flex-row ">
                <li class="nav-item px-2 ">
                    <a class="nav-link text-white active " aria-current="page" href="/">Home</a>
                </li>
                <%--  Tests if user is logged in --%>
                <c:if test="${empty user}">
                    <li class="nav-item px-2">
                        <a class="nav-link text-white" href="/login">Login</a>
                    </li>
                </c:if>    
                <c:if test="${not empty user}">
                    <li class="nav-item px-2">
                        <a class="nav-link text-white" href="/profile?id=<c:out value='${user.id}'/>">Profile</a>
                    </li>
                </c:if>   
            </ul>
            <ul class="navbar-nav mb-lg-0 text-right d-flex align-items-end flex-wrap justify-content-end">    
                <c:if test="${not empty user}">
                    <li class="nav-item px-2">
                        <a class="nav-link text-white" href="/create">New Post</a>
                    </li>
                    <li class="nav-item px-2">
                        <a class="nav-link text-white" href="/logout">Logout</a>
                    </li>
                </c:if>   
            </ul>
        </div>
    </div>
</div>