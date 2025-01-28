package org.example.demo_ekz.dao;

import org.example.demo_ekz.models.Request;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class RequestDAOTest {

    private static final String URL = "jdbc:postgresql://localhost:5432/demo"; // База данных demo
    private static final String USER = "evgenyportnov"; // Владелец базы данных
    private static final String PASSWORD = "hello88sharky"; // пароль

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            RequestDAO requestDAO = new RequestDAOImpl(connection);

            // Тест добавления заявки
            System.out.println("Тест добавления заявки...");
            Request newRequest = new Request("Type1", "Model1", "Описание заявки", 1, 1);
            requestDAO.addRequest(newRequest);
            System.out.println("Заявка успешно добавлена.");

            // Тест получения всех заявок
            System.out.println("Тест получения всех заявок...");
            List<Request> requests = requestDAO.getAllRequests();
            System.out.println("Всего заявок: " + requests.size());

            // Тест получения заявки по ID
            System.out.println("Тест получения заявки по ID...");
            Request fetchedRequest = requestDAO.getRequestById(1);
            if (fetchedRequest != null) {
                System.out.println("Заявка найдефна: " + fetchedRequest.getOrgTechType());
            } else {
                System.out.println("Заявка с таким ID не найдена.");
            }

            // Тест обновления заявки
            System.out.println("Тест обновления заявки...");
            newRequest.setMaterID(1); // Установите корректный ID
            newRequest.setProblemDescription("Обновленное описание");
            requestDAO.updateRequest(newRequest);
            System.out.println("Заявка успешно обновлена.");

        } catch (SQLException e) {
            System.err.println("Ошибка при выполнении тестов: " + e.getMessage());
        }
    }
}