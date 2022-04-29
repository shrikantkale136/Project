<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page import="com.cis.app.project.model.UserLogin" %>
<%@ page import="com.cis.app.project.utility.DBConnection" %>
<%@ page import="com.cis.app.project.model.Blog" %>
<%@ page import="java.util.List" %>
<%@ page import="com.cis.app.project.dao.UserDao" %>
<%@ page import="com.cis.app.project.dao.BlogDao" %><%--
  Created by IntelliJ IDEA.
  User: shrikantkale
  Date: 28/04/22
  Time: 1:01 AM
  To change this template use File | Settings | File Templates.
--%>
<%--<%--%>
<%--    BlogDao bd = new BlogDao();--%>
<%--    int userID = (int) session.getAttribute("userId");--%>
<%--    List<Blog> blogsList;--%>
<%--    try {--%>
<%--        blogsList = bd.getAllProductsById(userID);--%>
<%--    } catch (ClassNotFoundException e) {--%>
<%--        throw new RuntimeException(e);--%>
<%--    }--%>
<%--%>--%>
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
                    <div class="card-body py-5 text-center">
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
        <hr>
        <div class="container-fluid">
            <div class="text-center"><h4>My Blogs</h4></div>
            <div class="row gutters">
                <%
                    List<Blog> Lists = (List)request.getAttribute("blogsList");
                    if (!Lists.isEmpty()) {
                        for (Blog blog : Lists) {
                %>

                <div class="col-sm-12">
                    <div class="card">
                        <div class="row">
                            <div class="col-10">
                                <h3><%=(blog.getTitle()) %></h3>
                                <small>
                                    <i class="fa fa-clock-o" aria-hidden="true"></i>
                                    Post by <%=(blog.getAuthor()) %>,
                                    <%=(blog.getTimestamp()) %>
                                </small><br>
                                <p><%=(blog.getContent())%></p>
                            </div>
                            <div class="col-2">
                                <button type="button" class="close" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
                <%
                        }
                    }
                %>
            </div>
        </div>
    </div>
    <%@include file="/includes/footer.jsp"%>
</body>
</html>
