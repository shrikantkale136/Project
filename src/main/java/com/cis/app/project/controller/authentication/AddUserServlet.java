package com.cis.app.project.controller.authentication;

import com.cis.app.project.dao.UserDao;
import com.cis.app.project.model.UserLogin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/AddUser")
public class AddUserServlet extends HttpServlet {

    UserDao userDAO = new UserDao();

    public AddUserServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().append("Served at: ").append(req.getContextPath());
        try {
            handleRequestForInsertUser(req, resp);
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


    private void handleRequestForInsertUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException, ClassNotFoundException {
        UserLogin user = new UserLogin();
        user.setFirstName(req.getParameter("firstName"));
        user.setLastName(req.getParameter("lastName"));
        user.setAddress(req.getParameter("address"));
        user.setUserName(req.getParameter("userName"));
        user.setPassword(req.getParameter("password"));

        String result;
        String status = userDAO.insertUser(user);
        if(status == "SUCCESS") {
            result = "User Created Successfully. Please Log in";
            System.out.println("SUCCESS : " +result);
        }
        else {
            result = "User Creation Failed. Please Sign up again!";
            System.out.println("FAIL : " +result);
            req.getRequestDispatcher("views/authentication/signup.jsp").forward(req, resp);
        }
        req.setAttribute("result", result);
        req.getRequestDispatcher("views/authentication/login.jsp").forward(req, resp);
    }
}
