package com.cis.app.project.dao;

import com.cis.app.project.model.Blog;
import com.cis.app.project.model.UserLogin;
import com.cis.app.project.utility.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BlogDao {
    Connection connection = null;
    private String query;
    private PreparedStatement pst;
    private ResultSet rs;

    public BlogDao() {
    }

    public List<Blog> getAllProducts() throws ClassNotFoundException {
        connection = DBConnection.createDBConnection();
        List<Blog> blogList = new ArrayList<>();
        try {

            query = "select * from blog order by timestamp desc";
            pst = this.connection.prepareStatement(query);
            rs = pst.executeQuery();

            while (rs.next()) {
                Blog row = new Blog();
                row.setBlogID(rs.getInt("blogID"));
                row.setUserID(rs.getInt("userID"));
                row.setTitle(rs.getString("title"));
                row.setSubtitle(rs.getString("subtitle"));
                row.setContent(rs.getString("content"));
                row.setAuthor(rs.getString("author"));
                row.setTimestamp(rs.getTimestamp("timestamp"));

                blogList.add(row);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return blogList;
    }

    public String createBlog(Blog blog) throws SQLException, ClassNotFoundException {
        String status = "";
        connection = DBConnection.createDBConnection();
        if(blog.getUserID()!= null) {
            String query = "INSERT INTO blog(blogID, userID,title,subtitle, content, author, timestamp) VALUES (NULL,?,?,?,?,?,?)";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, blog.getUserID());
            stmt.setString(2, blog.getTitle());
            stmt.setString(3, blog.getSubtitle());
            stmt.setString(4, blog.getContent());
            stmt.setString(5, blog.getAuthor());
            stmt.setTimestamp(6, blog.getTimestamp());
            stmt.executeUpdate();
            status = "SUCCESS";
        }else{
            status = "FAIL";
        }
        return status;
    }

    public List<Blog> getAllProductsById(int userID) throws ClassNotFoundException {
        connection = DBConnection.createDBConnection();
        List<Blog> blogList = new ArrayList<>();
        try {

            query = "select * from blog where userID= "+userID+" order by timestamp desc";
            pst = this.connection.prepareStatement(query);
            rs = pst.executeQuery();

            while (rs.next()) {
                Blog row = new Blog();
                row.setBlogID(rs.getInt("blogID"));
                row.setUserID(rs.getInt("userID"));
                row.setTitle(rs.getString("title"));
                row.setSubtitle(rs.getString("subtitle"));
                row.setContent(rs.getString("content"));
                row.setAuthor(rs.getString("author"));
                row.setTimestamp(rs.getTimestamp("timestamp"));

                blogList.add(row);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return blogList;
    }

    public String deleteBlog(int userID) throws SQLException, ClassNotFoundException {
        String status;
        connection = DBConnection.createDBConnection();
        Statement stmt = connection.createStatement();
        String sql = "DELETE FROM blog where userID="+userID;
        int count = stmt.executeUpdate(sql);
        if(count==1) {
            status = "SUCCESS";
        }
        else {
            status = "FAIL";
        }
        return status;
    }
}
