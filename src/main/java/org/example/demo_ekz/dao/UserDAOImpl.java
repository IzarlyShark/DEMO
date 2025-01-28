package org.example.demo_ekz.dao;

import org.example.demo_ekz.models.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    private Connection connection;

    public UserDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void createUser(User user) throws SQLException {
        String sql = "INSERT INTO users (login, password, fio, phone, type) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, user.getLogin());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getFio());
            stmt.setString(4, user.getPhone());
            stmt.setString(5, user.getType());
            stmt.executeUpdate();
        }
    }
    @Override
    public User getUserByLogin(String login) throws SQLException {
        String sql = "SELECT * FROM users WHERE login = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, login);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapRowToUser(rs);
                }
            }
        }
        return null; // Пользователь не найден
    }

    @Override
    public void updateUser(User user) throws SQLException {
        String sql = "UPDATE users SET fio = ?, phone = ?, login = ?, password = ?, type = ? WHERE userid = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, user.getFio());
            stmt.setString(2, user.getPhone());
            stmt.setString(3, user.getLogin());
            stmt.setString(4, user.getPassword());
            stmt.setString(5, user.getType());
            stmt.setInt(6, user.getUserID());
            stmt.executeUpdate();
        }
    }

    @Override
    public void deleteUser(int userID) throws SQLException {
        String sql = "DELETE FROM users WHERE userid = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, userID);
            stmt.executeUpdate();
        }
    }

    @Override
    public List<User> getAllUsers() throws SQLException {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                users.add(mapRowToUser(rs));
            }
        }
        return users;
    }

    @Override
    public User getUserById(int userId) throws SQLException {
        String sql = "SELECT * FROM users WHERE userid = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, userId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapRowToUser(rs);
                }
            }
        }
        return null; // Пользователь не найден
    }

    private User mapRowToUser(ResultSet rs) throws SQLException {
        User user = new User();
        user.setUserID(rs.getInt("userid"));
        user.setLogin(rs.getString("login"));
        user.setPassword(rs.getString("password"));
        user.setFio(rs.getString("fio"));
        user.setPhone(rs.getString("phone"));
        user.setType(rs.getString("type"));
        return user;
    }
}