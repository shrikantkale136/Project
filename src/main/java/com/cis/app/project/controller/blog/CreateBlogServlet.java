package com.cis.app.project.controller.blog;

import com.cis.app.project.dao.BlogDao;
import com.cis.app.project.model.Blog;
import com.cis.app.project.model.UserLogin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

@WebServlet("/NewBlog")
public class CreateBlogServlet extends HttpServlet {
    BlogDao blogDao = new BlogDao();
    public CreateBlogServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().append("Served at: ").append(req.getContextPath());
        try {
            handleRequestForCreateBlog(req, resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    private void handleRequestForCreateBlog(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
        Calendar calendar = Calendar.getInstance();
        java.util.Date currentTime = calendar.getTime();
        long time = currentTime.getTime();
        HttpSession session = request.getSession();

        Blog blog = new Blog();
        List<Blog> blogsList = blogDao.getAllProductsById((Integer) session.getAttribute("userID"));
        blog.setUserID((Integer) session.getAttribute("userID"));
        blog.setTitle(request.getParameter("title"));
        blog.setSubtitle(request.getParameter("subtitle"));
        blog.setContent(request.getParameter("content"));
        blog.setAuthor((String) session.getAttribute("userName"));
        blog.setTimestamp(new Timestamp(time));

        String result;
        String status = blogDao.createBlog(blog);
        if (status == "SUCCESS") {
            result = "Blog Created Successfully. Please Log in";
            System.out.println("SUCCESS : " +result);
        }
        else {
            result = "User Creation Failed. Please Sign up again!";
            System.out.println("FAIL : " +result);
        }
        request.setAttribute("result", result);
        request.setAttribute("blogsList",blogsList);
        request.setAttribute("user", session.getAttribute("user"));
        request.getRequestDispatcher("views/dashboard/profile.jsp").forward(request, response);

    }
}
