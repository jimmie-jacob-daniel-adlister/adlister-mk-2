package com.codeup.adlister.dao;

import com.codeup.adlister.models.Image;
import com.codeup.adlister.models.PostCategories;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;

public class MySQLPostsCategoriesDao implements PostsCategories{
    private Connection connection;

    public MySQLPostsCategoriesDao(Config config){
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
    public ArrayList<PostCategories> findByPostId(long postId) {
        try {
            String query = "SELECT p.post_id, p.category_id, c.category FROM posts_categories as p join categories as c ON c.id= p.category_id WHERE post_id = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setLong(1, postId);
            ResultSet rs = stmt.executeQuery();
            return createCategoriesFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error finding a user by username", e);
        }
    }
    @Override
    public long insert(PostCategories postCategories){
        try {
            String insertQuery = "INSERT INTO posts_categories(post_id, category_id) VALUES (?, ?)";
            PreparedStatement stmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, postCategories.getPostId());
            stmt.setLong(2, postCategories.getCategoryId());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new ad.", e);
        }
    }

    private PostCategories extractCategory(ResultSet rs) throws SQLException{

        return new PostCategories(
                rs.getLong("post_id"),
                rs.getLong("category_id"),
                rs.getString("category")
        );
    }

    private ArrayList<PostCategories> createCategoriesFromResults(ResultSet rs) throws SQLException{
        ArrayList<PostCategories> categories = new ArrayList<>();
        while(rs.next()) {
            categories.add(extractCategory(rs));
        }
        return categories;
    }


}
