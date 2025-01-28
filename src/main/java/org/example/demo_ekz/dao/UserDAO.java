package org.example.demo_ekz.dao;

import org.example.demo_ekz.models.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDAO {
    void createUser(User user) throws SQLException; // Метод для создания пользователя
    User getUserByLogin(String login) throws SQLException; // Получение пользователя по логину
    void updateUser(User user) throws SQLException; // Метод для обновления информации о пользователе
    void deleteUser(int userID) throws SQLException; // Метод для удаления пользователя
    List<User> getAllUsers() throws SQLException; // Получение всех пользователей
    User getUserById(int userId) throws SQLException; // Получение пользователя по ID
}
