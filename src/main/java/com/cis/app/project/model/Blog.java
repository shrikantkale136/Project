package com.cis.app.project.model;

import java.sql.Timestamp;

public class Blog {

    private Integer blogID;
    private Integer userID;
    private String title;
    private String subtitle;
    private String content;
    private String author;
    private Timestamp timestamp;

    public Blog() {
    }

    public Blog(Integer blogID, Integer userID, String title, String subtitle, String content, String author, Timestamp timestamp) {
        this.blogID = blogID;
        this.userID = userID;
        this.title = title;
        this.subtitle = subtitle;
        this.content = content;
        this.author = author;
        this.timestamp = timestamp;
    }

    public Integer getBlogID() {
        return blogID;
    }

    public void setBlogID(Integer blogID) {
        this.blogID = blogID;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}