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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/*
* Servlet to update user information
*
* */
@WebServlet("/UpdateUser")
public class UpdateUserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    UserDao userDAO = new UserDao();
    BlogDao blobDao = new BlogDao();
    public UpdateUserServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
        try {
            handleRequestForUpdateUser(request, response);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    private void handleRequestForUpdateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
        UserLogin user = new UserLogin();
        user.setFirstName(request.getParameter("firstName"));
        user.setLastName(request.getParameter("lastName"));
        user.setAddress(request.getParameter("address"));
        user.setUserName(request.getParameter("userName"));
        user.setPassword(request.getParameter("password"));
        user.setEmail(request.getParameter("email"));
        user.setAbout(request.getParameter("about"));

        HttpSession session = request.getSession();
        List<Blog> blogsList = blobDao.getAllProductsById((Integer) session.getAttribute("userID"));
        request.setAttribute("blogsList",blogsList);

        RequestDispatcher dispatcher;
        request.setAttribute("user", user);
        String status = userDAO.updateUser(user);
        String s = "Data Updated Successfully!!";

        if(status == "SUCCESS") {
            request.setAttribute("Update", user);
            dispatcher = request.getRequestDispatcher("views/dashboard/profile.jsp");
            dispatcher.forward(request, response);
        }

    }
}
