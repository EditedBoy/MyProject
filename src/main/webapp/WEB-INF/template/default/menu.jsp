<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>


<header>
    <nav id="nav" class="ry">

        <sec:authorize access="!isAuthenticated()">
        <ul id="main-menu">
            <li>
                <a href="<c:url value="/" />"><i class="fa fa-home"></i>Home</a>
            </li>
            <li>
                <a href="<c:url value="/about" />" ><i class="fa fa-user"></i>About</a>
            </li>
            <li>
                <a href="<c:url value="/contact-us" />" ><i class="fa fa-comment"></i>Contact Us</a>
            </li>
            <li>
                <a href="<c:url value="/authorization" />" ><i class="fa fa-users"></i>Authorization</a>
            </li>
        </ul>
        </sec:authorize>

        <sec:authorize access="isAuthenticated()">
        <ul id="main-menu">
            <li>
                <a href="<c:url value="/" />"><i class="fa fa-home"></i>Home</a>
            </li>
            <li>
                <a href="<c:url value="/about" />" ><i class="fa fa-user"></i>About</a>
            </li>
            <li>
                <a href="<c:url value="/contact-us" />" ><i class="fa fa-comment"></i>Contact Us</a>
            </li>
            <li>
                <a href="<c:url value="/logout" />" role="button"><i class="fa fa-reply-all"></i>Logout</a>
            </li>
        </ul>
        </sec:authorize>

    </nav>
</header>