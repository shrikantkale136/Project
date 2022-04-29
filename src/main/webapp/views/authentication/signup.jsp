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
        <div class="text-center"><h4>--- Register ---</h4></div>
        <div class="card-body">
            <form action="AddUser" method="post">
                <div class="form-group">
                    <label>First name</label>
                    <input type="text" name="firstName" class="form-control" placeholder="Enter first name">
                </div>
                <div class="form-group">
                    <label>Last name</label>
                    <input type="text" name="lastName" class="form-control" placeholder="Enter last name">
                </div>
                <div class="form-group">
                    <label>Address</label>
                    <input type="text" name="address" class="form-control" placeholder="Enter address">
                </div>
                <div class="form-group">
                    <label>Username</label>
                    <input type="text" name="userName" class="form-control" placeholder="Enter username">
                </div>
                <div class="form-group">
                    <label>Password</label>
                    <input type="password" name="password" class="form-control" placeholder="Enter password">
                </div>
                <div class="text-center">
                    <button type="submit" class="btn btn-primary">Register</button>
                </div>
            </form>
            <form action="LoginPage">
                <button type="submit">Login</button>
            </form>
        </div>
    </div>
</div>

<%@include file="/includes/footer.jsp"%>
</body>
</html>

