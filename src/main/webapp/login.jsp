<%--
  Created by IntelliJ IDEA.
  User: ironicsushi
  Date: 10/17/17
  Time: 2:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Adlister</title>
    <jsp:include page="partials/styles.jsp">
        <jsp:param name="title" value="Login" />
    </jsp:include>
    <%@ include file="partials/viewport.jsp"%>
    <link rel="stylesheet" href="css/login.css">
</head>
<body>
<%@ include file="partials/navbar.jsp"%>
<form method="POST" action="login.jsp">
<h1>Login Page</h1>
    <div class="login-container">
        <div class="form-group">
            <label for="email">Email address</label>
            <input type="email" class="form-control email" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email" name="email">
            <small id="email" class="form-text text-muted">We'll never share your email with anyone else.</small>
        </div>
        <div class="form-group">
            <label for="password">Password</label>
            <input type="password" class="form-control password-input" id="password" name="password" placeholder="Password">
        </div>
        <button type="submit" class="btn btn-primary login">Login</button>
    </div>
</form>
 <c:if test="${param.email == 'admin@email.com' && param.password == 'password'}">
     <% response.sendRedirect("profile.jsp"); %>
 </c:if>

<%@ include file="partials/scripts.jsp"%>
</body>
</html>
