<%--
  Created by IntelliJ IDEA.
  User: shrikantkale
  Date: 28/04/22
  Time: 1:01 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                                <h5 class="user-name">Shrikant Kale</h5>
                                <h6 class="user-email">stk7220@ucmo.edu</h6>
                            </div>
                            <div class="about">
                                <h5>About</h5>
                                <p>I'm Yuki. Full Stack Designer I enjoy creating
                                    user-centric, delightful and human experiences.</p>
                                <button class="btn btn-edit">Edit Profile</button>
                            </div>

                        </div>
                    </div>
                </div>
            </div>
            <div class="col-xl-8 col-lg-8 col-md-12 col-sm-12 col-12">
                <div class="profile-card h-100">
                    <div class="card-body">
                        <div class="block">
                            <h4>Create post</h4>
                            <form action="" method="POST">
                                <div class="form-group has-error">
                                    <label for="slug">Title <span class="require">*</span></label>
                                    <input type="text" class="form-control" id="slug" name="slug" />
                                </div>

                                <div class="form-group">
                                    <label for="title">Subtitle <span class="require">*</span></label>
                                    <input id="title"type="text" class="form-control" name="title" />
                                </div>

                                <div class="form-group">
                                    <label for="description">Category <span class="require">*</span></label>
                                    <input id="description"type="text" class="form-control" name="title" />
                                </div>

                                <div class="form-group">
                                    <label for="description">Description <span class="require">*</span></label>
                                    <textarea rows="5" class="form-control" name="description"
                                              cols=""></textarea>
                                </div>


                                <div class="form-group py-2">
                                    <button type="submit" class="btn btn-primary">Create</button>
                                    <button class="btn btn-danger">Cancel</button>
                                </div>

                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <%@include file="/includes/footer.jsp"%>
</body>
</html>
