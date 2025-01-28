package org.example.demo_ekz.dao;

import org.example.demo_ekz.models.Request;

import java.util.List;

public interface RequestDAO {
    void addRequest(Request request); // Метод для добавления заявки
    void updateRequest(Request request); // Метод для обновления заявки
    Request getRequestById(int requestId); // Получение заявки по ID
    List<Request> getAllRequests(); // Получение всех заявок
    List<Request> searchRequests(String query); // Поиск заявок по параметрам
    void assignMasterToRequest(int requestId, int masterId); // Назначение мастера на заявку

    void create();
}