<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page import="com.cis.app.project.utility.DBConnection" %>
<%@ page import="com.cis.app.project.dao.BlogDao" %>
<%@ page import="com.cis.app.project.model.Blog" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    BlogDao bd = new BlogDao(DBConnection.createDBConnection());
    List<Blog> blogs = bd.getAllProducts();
%>
<!DOCTYPE html>
<html>
<%@include file="/includes/head.jsp" %>
<body>
    <%@include file="/includes/navbar.jsp" %>
    <%--    <h1><%= "Hello World!" %></h1><br/><a href="hello-servlet">Hello Servlet</a>--%>

    <div class="container">
        <h4><small>RECENT POSTS</small></h4>
        <div class="row">
        <%
            if (!blogs.isEmpty()) {
                for (Blog blog : blogs) {
        %>

            <div class="col-sm-12">
                <div class="card">
                    <h3><%=(blog.getTitle()) %></h3>
                    <small>
                        <i class="fa fa-clock-o" aria-hidden="true"></i>
                        Post by <%=(blog.getAuthor()) %>,
                        <%=(blog.getTimestamp()) %>
                    </small><br>
                    <p><%=(blog.getContent())%></p>
                </div>
            </div>
            <%
                    }
                }
            %>
        </div>
    </div>
        <%@include file="/includes/footer.jsp" %>
</body>
</html>