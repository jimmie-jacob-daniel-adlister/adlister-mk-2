package com.codeup.adlister.dao;

import com.codeup.adlister.models.Category;
import com.codeup.adlister.models.Image;
import com.codeup.adlister.models.PostCategories;
import com.codeup.adlister.models.User;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;

public class MySQLCategoriesDao implements Categories{
    private Connection connection;

    public MySQLCategoriesDao(Config config){
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
    public ArrayList<Category> all() {
        try {
            String query = "SELECT * from categories";
            PreparedStatement stmt = connection.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            return createCategoriesFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error finding a user by username", e);
        }
    }

    @Override
    public Long insert(User user) {
        // TODO Auto-generated method stub
        return null;
    }

    private Category extractCategory(ResultSet rs) throws SQLException{

        return new Category(
                rs.getLong("id"),
                rs.getString("category")
        );
    }

    private ArrayList<Category> createCategoriesFromResults(ResultSet rs) throws SQLException{
        ArrayList<Category> categories = new ArrayList<>();
        while(rs.next()) {
            categories.add(extractCategory(rs));
        }
        return categories;
    }
    
}
