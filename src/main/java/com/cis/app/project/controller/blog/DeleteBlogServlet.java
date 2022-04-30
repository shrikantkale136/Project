package com.cis.app.project.controller.blog;

import com.cis.app.project.dao.BlogDao;
import com.cis.app.project.model.Blog;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/DeleteBlog")
public class DeleteBlogServlet extends HttpServlet {
    BlogDao blogDao = new BlogDao();

    public DeleteBlogServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request , HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
        try {
            handleRequestForCancelAppointment(request, response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    private void handleRequestForCancelAppointment(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, ServletException, IOException {
        HttpSession session = request.getSession();
        List<Blog> blogsList = blogDao.getAllProductsById(Integer.parseInt(request.getParameter("userID")));
        String result;
        int blogID = Integer.parseInt(request.getParameter("blogID"));
        String status = blogDao.deleteBlog(blogID);
        if(status == "SUCCESS") {
            result = "Blog "+ blogID + "Deleted";
        }
        else {
            result = "Unsuccessful deletion of blog";
        }
        request.setAttribute("result", result);
        request.setAttribute("blogsList",blogsList);
        request.setAttribute("user", session.getAttribute("user"));
        request.getRequestDispatcher("views/dashboard/profile.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
