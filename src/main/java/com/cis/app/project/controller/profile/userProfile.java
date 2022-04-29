package com.cis.app.project.controller.profile;

import com.cis.app.project.dao.BlogDao;
import com.cis.app.project.dao.UserDao;
import com.cis.app.project.model.Blog;
import com.cis.app.project.model.UserLogin;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/userProfile")
public class userProfile extends HttpServlet {
    private static final long serialVersionUID = 1L;
    UserDao userDAO = new UserDao();
    BlogDao blogDao = new BlogDao();
    public userProfile() {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().append("Served at: ").append(req.getContextPath());
        try {
            handleRequestForLogin(req, resp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }


    private void handleRequestForLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException, ClassNotFoundException {
        UserLogin user = userDAO.getUser(req.getParameter("userName"));
        List<Blog> blogsList = blogDao.getAllProductsById(user.getUserID());
        req.setAttribute("blogsList",blogsList);
        req.setAttribute("user", user);
        RequestDispatcher dispatcher = req.getRequestDispatcher("views/dashboard/profile.jsp");
        dispatcher.forward(req, resp);
    }
}
