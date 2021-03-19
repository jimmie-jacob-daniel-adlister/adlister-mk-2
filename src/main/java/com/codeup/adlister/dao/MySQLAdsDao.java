package com.codeup.adlister.dao;

import com.codeup.adlister.models.Ad;
import com.mysql.cj.jdbc.Driver;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads {
    private Connection connection = null;

    public MySQLAdsDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            System.out.println(config.getURL());
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
    public List<Ad> all() {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM posts");
            ResultSet rs = stmt.executeQuery();
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.", e);
        }
    }

    @Override
    public List<Ad> byId(long id){
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM posts WHERE id = ?");
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            return createAdsFromResults(rs);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.", e);
        }
    }

    @Override
    public Long insert(Ad ad) {
        try {
            String insertQuery = "INSERT INTO posts(user_id, title, content, price) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, ad.getUserId());
            stmt.setString(2, ad.getTitle());
            stmt.setString(3, ad.getDescription());
            stmt.setDouble(4, ad.getPrice());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new ad.", e);
        }
    }

    private Ad extractAd(ResultSet rs) throws SQLException {
        return new Ad(
                rs.getLong("id"),
            rs.getLong("user_id"),
            rs.getString("title"),
            rs.getString("content"),
                rs.getDouble("price")
        );
    }

    private List<Ad> createAdsFromResults(ResultSet rs) throws SQLException {
        List<Ad> ads = new ArrayList<>();
        while (rs.next()) {
            ads.add(extractAd(rs));
        }
        return ads;
    }
    @Override
    public void delete(Long postId){
        try {
            System.out.println("deleting "+postId);
            String insertQuery = "DELETE FROM ad_categories WHERE post_id = ?";
            PreparedStatement stmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, postId);
            stmt.executeUpdate();
            System.out.println("deleting "+postId);
            String insertQuery1 = "DELETE FROM images WHERE post_id = ?";
            PreparedStatement stmt1 = connection.prepareStatement(insertQuery1, Statement.RETURN_GENERATED_KEYS);
            stmt1.setLong(1, postId);
            stmt1.executeUpdate();
            String insertQuery2 = "DELETE FROM comments WHERE post_id = ?";
            PreparedStatement stmt2 = connection.prepareStatement(insertQuery2, Statement.RETURN_GENERATED_KEYS);
            stmt2.setLong(1, postId);
            stmt2.executeUpdate();
            String insertQuery3 = "DELETE FROM posts WHERE id = ?";
            PreparedStatement stmt3 = connection.prepareStatement(insertQuery3, Statement.RETURN_GENERATED_KEYS);
            stmt3.setLong(1, postId);
            stmt3.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new ad.", e);
        }
    }

    public void edit(Ad ad){
        try {
            System.out.println("ad id: "+ad.getId());
            System.out.println(""+ad.getUserId()+ " "+ ad.getTitle()+ " "+ad.getDescription()+" "+ ad.getPrice());
            String insertQuery = "UPDATE posts SET user_id=?, title = ?, content = ?, price=? WHERE id = ?";
            PreparedStatement stmt = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, ad.getUserId());
            stmt.setString(2, ad.getTitle());
            stmt.setString(3, ad.getDescription());
            stmt.setDouble(4, ad.getPrice());
            stmt.setLong(5, ad.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new ad.", e);
        }


    }

    @Override
    public List<Ad> search(String term){
        String sql = "SELECT * FROM posts WHERE title LIKE ?";
        String searchTermWithWildCards = "%" + term + "%";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, searchTermWithWildCards);

            ResultSet rs = stmt.executeQuery();
            return createAdsFromResults(rs);
        } catch(SQLException throwables){
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public Ad getAdFromPostId(Long postId) {
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("SELECT * FROM posts WHERE id=?");
            stmt.setLong(1, postId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                return new Ad(
                        rs.getLong("id"),
                        rs.getLong("user_id"),
                        rs.getString("title"),
                        rs.getString("content"),
                        rs.getDouble("price")
                );
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.", e);
        }
    }


}
