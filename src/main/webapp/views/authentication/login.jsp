<%--
  Created by IntelliJ IDEA.
  User: shrikantkale
  Date: 28/04/22
  Time: 12:07 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="/includes/head.jsp"%>
<body>
<div class="container">
    <div class="card w-50 mx-auto my-5">
        <div class="card-header text-center">User Login</div>
        <div class="card-body">
<%--            <c:if test="${not empty result}">--%>
<%--                <div class="alert alert-danger" role="alert">--%>
<%--                        ${result}--%>
<%--                </div>--%>
<%--            </c:if>--%>
            <form action="LoginUser" method="post">
                <div class="form-group">
                    <label>Username</label>
                    <input type="text" name="userName" class="form-control" placeholder="Enter Username">
                </div>
                <div class="form-group">
                    <label>Password</label>
                    <input type="password" name="password" class="form-control" placeholder="Enter Password">
                </div>
                <div class="text-center">
                    <button type="submit" class="btn btn-primary">Login</button>
                </div>
            </form>
            <form action="SignupPage">
                <button type="submit">Register</button>
            </form>
        </div>
    </div>
</div>

<%@include file="/includes/footer.jsp"%>
</body>
</html>
