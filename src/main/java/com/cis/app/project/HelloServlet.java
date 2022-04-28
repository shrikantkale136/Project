package com.cis.app.project;

import com.cis.app.project.utility.DBConnection;

import java.io.*;
import java.sql.Connection;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        Connection con = null;

        try {
            con = DBConnection.createDBConnection();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}