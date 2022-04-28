package com.cis.app.project.dao;

import com.cis.app.project.model.Blog;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BlogDao {
    private Connection con;
    private String query;
    private PreparedStatement pst;
    private ResultSet rs;

    public BlogDao(Connection con) {
        super();
        this.con = con;
    }
    public List<Blog> getAllProducts() {
        List<Blog> blogList = new ArrayList<>();
        try {

            query = "select * from blog";
            pst = this.con.prepareStatement(query);
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
}
