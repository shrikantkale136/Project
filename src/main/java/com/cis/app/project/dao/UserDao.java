package com.cis.app.project.dao;

import com.cis.app.project.model.UserLogin;
import com.cis.app.project.utility.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    Connection connection = null;

    public List<UserLogin> getUsers() throws SQLException, ClassNotFoundException {
        List<UserLogin> users = new ArrayList<UserLogin>();
        connection = DBConnection.createDBConnection();
        Statement stmt = connection.createStatement();
        ResultSet rs=stmt.executeQuery("select * from user");
        while(rs.next()) {
            UserLogin user = new UserLogin();
            user.setUserID(rs.getInt(1));
            user.setFirstName(rs.getString(2));
            user.setLastName(rs.getString(3));
            user.setAddress(rs.getString(4));
            user.setUserName(rs.getString(5));
            user.setPassword(rs.getString(6));
            user.setEmail(rs.getString(7));
            user.setAbout(rs.getString(8));
            users.add(user);
        }
        connection.close();
        return users;
    }


    public UserLogin getUser(String userName) throws SQLException, ClassNotFoundException {
        UserLogin user = new UserLogin();
        connection = DBConnection.createDBConnection();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery("Select * from user where userName = '"+userName+"'");
        while(rs.next()){
            user.setUserID(rs.getInt(1));
            user.setFirstName(rs.getString(2));
            user.setLastName(rs.getString(3));
            user.setAddress(rs.getString(4));
            user.setUserName(rs.getString(5));
            user.setPassword(rs.getString(6));
            user.setEmail(rs.getString(7));
            user.setAbout(rs.getString(8));
        }
        return user;
    }



    public String insertUser(UserLogin user) throws SQLException, ClassNotFoundException {
        String status = "";
        UserLogin userDB = getUser(user.getUserName());
        if(userDB.getUserName()==null) {
            connection = DBConnection.createDBConnection();
            String query = "INSERT INTO user(userID, firstName,lastName,address, userName, password, email, about) VALUES (NULL,?,?,?,?,?,?,NULL)";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, user.getFirstName());
            stmt.setString(2, user.getLastName());
            stmt.setString(3, user.getAddress());
            stmt.setString(4, user.getUserName());
            stmt.setString(5, user.getPassword());
            stmt.setString(6, user.getEmail());
            stmt.executeUpdate();
            status = "SUCCESS";
        }
        else {
            status = "FAIL";
        }
        return status;
    }



    public String updateUser(UserLogin user) throws SQLException, ClassNotFoundException {
        String status;
        connection = DBConnection.createDBConnection();
        Statement stmt = connection.createStatement();
        String sql = "UPDATE USER SET FirstName='" +user.getFirstName()+ "', LastName='" +user.getLastName()+ "', Address='" +user.getAddress() + "', Email='" +user.getEmail() + "', About='" +user.getAbout() + "' where UserName='" + user.getUserName() +"'";
        int count = stmt.executeUpdate(sql);
        if(count==1) {
            status = "SUCCESS";
            System.out.println("SUCCESS : Record updated successfully for user " + user.getUserName());
        }
        else {
            status = "FAIL";
            System.out.println("FAIL : Record unable to update for user " + user.getUserName());
        }
        return status;
    }
}
