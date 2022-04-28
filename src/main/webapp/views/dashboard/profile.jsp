<%@ page import="com.cis.app.project.model.UserLogin" %>
<%@ page import="com.cis.app.project.utility.DBConnection" %>
<%@ page import="com.cis.app.project.model.Blog" %>
<%@ page import="java.util.List" %>
<%@ page import="com.cis.app.project.dao.UserDao" %><%--
  Created by IntelliJ IDEA.
  User: shrikantkale
  Date: 28/04/22
  Time: 1:01 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<%@include file="/includes/head.jsp"%>
<body>
    <%@include file="/includes/navbar.jsp"%>
    <div class="container">
        <div class="row gutters">
            <div class="col-xl-4 col-lg-4 col-md-12 col-sm-12 col-12">
                <div class="profile-card h-100">
                    <div class="card-body">
                        <div class="account-settings block">
                            <div class="user-profile">
                                <div class="user-avatar">
                                    <img src="https://bootdey.com/img/Content/avatar/avatar7.png"
                                         alt="Maxwell Admin">
                                </div>
                                <h5 class="user-name">${user}</h5>
                                <h6 class="user-email">${user.email}</h6>
                            </div>
                            <div class="about">
                                <h5>About</h5>
                                <p>I'm ${user.userName}, ${user.about}</p>
                                <button class="btn btn-edit" onclick="showProfile(1)">Edit Profile</button>
                            </div>
                        </div>
                    </div>
                    <div class="card-body text-center">
                        <button class="btn btn-edit" onclick="showProfile(2)">Create Blog</button>
                    </div>
                </div>
            </div>
            <div class="col-xl-8 col-lg-8 col-md-12 col-sm-12 col-12">
                <div class="profile-card h-100">
                    <div class="card-body">
                        <div class="block">
                            <div id="edit-profile" style="display: none"> <%@include file="edit-profile.jsp" %> </div>
                            <div id="create-blog" > <%@include file="create-blog.jsp"%> </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <%@include file="/includes/footer.jsp"%>
</body>
</html>
