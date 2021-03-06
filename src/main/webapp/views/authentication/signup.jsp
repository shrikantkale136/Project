<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: shrikantkale
  Date: 28/04/22
  Time: 12:22 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="/includes/head.jsp"%>
<body>
<%@include file="/includes/navbar.jsp"%>
<div class="container">
    <div class="card w-35 mx-auto my-5">
        <div class="text-center"><h4> Sign Up</h4></div>
        <div class="card-body">
            <c:if test="${not empty result}">
                <div class="alert alert-danger" role="alert">
                        ${result}
                </div>
            </c:if>
            <form action="AddUser" method="post" >
                <div class="form-group">
                    <label>First name</label>
                    <input type="text" name="firstName" class="form-control" placeholder="Enter first name" required>
                </div>
                <div class="form-group">
                    <label>Last name</label>
                    <input type="text" name="lastName" class="form-control" placeholder="Enter last name" required>
                </div>
                <div class="form-group">
                    <label>Address</label>
                    <input type="text" name="address" class="form-control" placeholder="Enter address" required>
                </div>
                <div class="form-group">
                    <label>Username</label>
                    <input type="text" name="userName" class="form-control" placeholder="Enter username" required>
                </div>
                <div class="form-group">
                    <label>Password</label>
                    <input type="password" name="password" class="form-control" placeholder="Enter password" required>
                </div>
                <div class="text-center">
                    <button type="submit" class="btn btn-primary">Register</button>
                </div>
            </form>
            <form action="LoginPage">
                <button class="btn" type="submit">Login</button>
            </form>
        </div>
    </div>
</div>

<%@include file="/includes/footer.jsp"%>
</body>
</html>

