package com.codeup.adlister.dao;

import com.codeup.adlister.models.Image;
import com.codeup.adlister.models.User;
import com.mysql.cj.api.mysqla.result.Resultset;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLImagesDao implements Images{
    private Connection connection;

    public MySQLImagesDao(Config config){
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUser(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }
    @Override
    public ArrayList<Image> findByPostId(long postId) {
        try {
            String query = "SELECT * FROM images WHERE post_id = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setLong(1, postId);
            ResultSet rs = stmt.executeQuery();
            return createImagesFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error finding a user by username", e);
        }
    }
    @Override
    public Long insert(Image image){
        try {
            String insertQuery = "INSERT INTO images(post_id, url, description) VALUES (?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, image.getPostId());
            stmt.setString(2, image.getUrl());
            stmt.setString(3, image.getDescription());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new ad.", e);
        }
    }

    private Image extractImage(ResultSet rs) throws SQLException{
        return new Image(
                rs.getLong("id"),
                rs.getLong("post_id"),
                rs.getString("url"),
                rs.getString("description")
        );
    }

    private ArrayList<Image> createImagesFromResults(ResultSet rs) throws SQLException{
        ArrayList<Image> images = new ArrayList<>();
        while(rs.next()) {
            images.add(extractImage(rs));
        }
        return images;
    }


}


