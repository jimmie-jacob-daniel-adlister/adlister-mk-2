package com.codeup.adlister.dao;//package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.Comments;
import com.codeup.adlister.dao.Config;
import com.codeup.adlister.models.Comment;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLCommentsDao implements Comments {
    private Connection connection;

    public MySQLCommentsDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(

                    config.getURL(),
                    config.getUsername(),
                    config.getPassword()


            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }

    @Override
    public List<Comment> all(int postId) {
        String query = "SELECT * FROM comments WHERE post_id = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, postId);
//            stmt.setString(1, String.valueOf(postId));
            ResultSet rs = stmt.executeQuery();
            return createCommentsResults(rs);
        } catch(SQLException e){
            throw new RuntimeException("Error finding a user by username", e);
        }
    }

    @Override
    public Comment addComment(Comment newComment) {
        try {
            String insertQuery = "INSERT INTO comments( user_id, post_id, content) VALUES (?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
//            stmt.setInt(1, newComment.getId());
            stmt.setLong(1, newComment.getUserId());
            stmt.setLong(2, newComment.getPostId());
            stmt.setString(3, newComment.getContent());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return newComment;
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new ad.", e);
        }
    }

    private Comment extractComment(ResultSet rs) throws SQLException {
//        if (! rs.next()) {
//            return null;
//        }
        return new Comment(
                rs.getInt("id"),
                rs.getInt("user_id"),
                rs.getInt("post_id"),
                rs.getString("content")
        );
    }

    private List<Comment> createCommentsResults(ResultSet rs) throws SQLException {
        List<Comment> comments = new ArrayList<>();
        while (rs.next()) {
            comments.add(extractComment(rs));
        }
        return comments;
    }

}


