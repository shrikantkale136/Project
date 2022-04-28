package com.cis.app.project.controller.authentication;

import com.cis.app.project.dao.UserDao;
import com.cis.app.project.model.UserLogin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/LoginUser")
public class UserLoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    UserDao userDAO = new UserDao();

    public UserLoginServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        resp.getWriter().append("Served at: ").append(req.getContextPath());
        try {
            handleRequestForLoginUserdoGet(req, resp);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    private void handleRequestForLoginUserdoGet(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ClassNotFoundException, ServletException, IOException {
        String result = "";

        UserLogin user = userDAO.getUser(req.getParameter("userName"));

        if(user.getUserName() != null) {
            if(user.getPassword().equals(req.getParameter("password"))) {
                result = "User Authenticated";
                System.out.println("SUCCESS : "+result);
                req.setAttribute("user",user);
                req.setAttribute("userID", user.getUserID());
                req.setAttribute("username", req.getParameter("userName"));
                HttpSession session = req.getSession();
                session.setAttribute("authenticated", true);
                session.setAttribute("userName", req.getParameter("userName"));
                session.setAttribute("userID", user.getUserID());
                session.setAttribute("user", user);
                req.getRequestDispatcher("views/dashboard/profile.jsp").forward(req, resp);
            }
            else {
                result = "Username or Password is incorrect";
                System.out.println("FAIL : "+result);
                req.setAttribute("result", result);
                req.getRequestDispatcher("views/authentication/login.jsp").forward(req, resp);
            }
        }
        else {
            result = "User Does not exist";
            System.out.println("FAIL : "+result);
            req.setAttribute("result", result);
            req.getRequestDispatcher("views/authentication/login.jsp").forward(req, resp);
        }
    }
}
