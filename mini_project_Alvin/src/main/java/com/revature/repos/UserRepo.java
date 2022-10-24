package com.revature.repos;

import com.revature.models.User;
import com.revature.utils.CRUDDaoInterface;
import com.revature.utils.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepo implements CRUDDaoInterface<User> {

    public Connection conn;

    public UserRepo() {
        try
        {
            conn = ConnectionManager.getConnection();
        }
        catch(SQLException sqlException)
        {
            System.out.println(sqlException.getMessage());
        }
    }

    @Override
    public int create(User user) {

        try
        {
            String sql = "INSERT INTO users (userId, firstName, lastName, " +
                    "userName, pass_word, zodiac) VALUES (default,?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            pstmt.setString(1, user.getFirstName());
            pstmt.setString(2, user.getLastName());
            pstmt.setString(3, user.getUserName());
            pstmt.setString(4, user.getPass_word());
            pstmt.setString(5, user.getZodiac());

            pstmt.executeUpdate();

            ResultSet rs = pstmt.getGeneratedKeys();

            rs.next();
            return rs.getInt("userId");
        }
        catch(SQLException sqlException)
        {
            System.out.println(sqlException.getMessage());
        }


        return 0;
    }

    @Override
    public List<User> getAll() {
        List<User> users = new ArrayList<User>();
        try
        {
            String sql = "Select * FROM users";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            ResultSet rs = pstmt.executeQuery();
            System.out.println("Before the while loop");
            while(rs.next())
            {
                System.out.println("Inside the while loop");
                User user = new User();
                user.setUserId(rs.getInt("userId"));
                user.setFirstName(rs.getString("firstName"));
                user.setLastName(rs.getString("lastName"));
                user.setUserName(rs.getString("userName"));
                user.setPass_word(rs.getString("pass_word"));
                user.setZodiac(rs.getString("zodiac"));
                user.setMood(rs.getString("mood"));
                users.add(user);
            }
            System.out.println("After the while loop");
            return users;
        }
        catch(SQLException sqlException)
        {
            System.out.println(sqlException.getMessage());
        }


        return null;
    }

    @Override
    public User getById(int id) {
        List<User> users = new ArrayList<User>();
        try
        {
            String sql = "SELECT * FROM users WHERE userId = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,id);

            ResultSet rs = pstmt.executeQuery();

            User user = new User();
            while(rs.next())
            {
                user.setUserId(rs.getInt("userId"));
                user.setFirstName(rs.getString("firstName"));
                user.setLastName(rs.getString("lastName"));
                user.setUserName(rs.getString("userName"));
                user.setPass_word(rs.getString("pass_word"));
                user.setZodiac(rs.getString("zodiac"));
                user.setMood(rs.getString("mood"));
                users.add(user);
            }
            return user;
        }
        catch(SQLException sqlException)
        {
            System.out.println(sqlException.getMessage());
        }

        return null;
    }

    @Override
    public User logIn(User user) {
        try
        {
         String sql = "SELECT * FROM users WHERE userName = ?";
         PreparedStatement pstmt = conn.prepareStatement(sql);
         pstmt.setString(1,user.getUserName());

         ResultSet rs = pstmt.executeQuery();

         if(rs.next() && rs.getString("pass_word").equals(user.getPass_word()))
         {
             User newUser = new User(rs.getInt("userId"), rs.getString("firstName"),
                     rs.getString("lastName"), rs.getString("userName"),
                     rs.getString("pass_word"), rs.getString("zodiac"),
                     rs.getString("mood"));

             return newUser;
         }
        }
        catch(Exception exception)
        {
            System.out.println(exception.getMessage());
        }

        return null;
    }

    @Override
    public User update(User user) {
        try//This update will only affect the zodiac
        {
            String sql = "UPDATE users SET mood = ? WHERE userId = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, user.getMood());
            pstmt.setInt(2,user.getUserId());

            pstmt.executeUpdate();

            ResultSet rs = pstmt.getGeneratedKeys();

            while(rs.next())
            {
                user.setMood(rs.getString("mood"));
            }

            return user;
        }
        catch(SQLException sqlException)
        {
            System.out.println("Caught");
            System.out.println(sqlException.getMessage());
        }

        return null;
    }

    @Override
    public boolean delete(User user) {
        try
        {
            String sql = "DELETE FROM users WHERE userId= ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1,user.getUserId());
            return pstmt.execute();
        }
        catch(SQLException sqlException)
        {
            System.out.println(sqlException.getMessage());
        }
        return true;
    }

    @Override
    public boolean deleteById(int id)
    {
        try
        {
            String sql = "DELETE FROM users WHERE userId= ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,id);

            pstmt.execute();
            return true;
        }
        catch(SQLException sqlException)
        {
            System.out.println(sqlException.getMessage());
        }
        return false;
    }
}
