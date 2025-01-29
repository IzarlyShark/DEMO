package org.example.demo_ekz.dao;

import org.example.demo_ekz.dao.UserDAOImpl;
import org.example.demo_ekz.models.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UserDAOTest {
    private static final String URL = "jdbc:postgresql://localhost:5432/demo"; // База данных demo
    private static final String USER = "evgenyportnov"; // Владелец базы данных
    private static final String PASSWORD = "hello88sharky"; // пароль
    public static void main(String[] args) {

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            UserDAOImpl userDAO = new UserDAOImpl(connection);

            // Создание нового пользователя
            User newUser = new User();
            newUser.setLogin("testUser");
            newUser.setPassword("testPassword");
            newUser.setFio("Тестовый Пользователь");
            newUser.setPhone("1234567890");
            newUser.setType("user");

            // Вызов метода создания пользователя
            userDAO.createUser(newUser);
            System.out.println("Пользователь успешно создан: " + newUser.getLogin());

        } catch (SQLException e) {
            System.err.println("Ошибка при создании пользователя: " + e.getMessage());
        }
    }
}