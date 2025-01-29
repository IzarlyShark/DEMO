package org.example.demo_ekz.dao;

import org.example.demo_ekz.models.Request;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RequestDAOImpl implements RequestDAO {
    private Connection connection;

    public RequestDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void addRequest(Request request) {
        String sql = "INSERT INTO requests (orgTechType, orgTechModel, problemDescription, masterID, clientID, startDate, requestStatus) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, request.getOrgTechType());
            stmt.setString(2, request.getOrgTechModel());
            stmt.setString(3, request.getProblemDescription());
            stmt.setInt(4, request.getMasterID());
            stmt.setInt(5, request.getClientID());
            stmt.setDate(6, new Date(request.getStartDate().getTime()));
            stmt.setString(7, request.getRequestStatus());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Обработка исключений
        }
    }

    @Override
    public void updateRequest(Request request) {
        String sql = "UPDATE requests SET orgTechType=?, orgTechModel=?, problemDescription=?, masterID=?, requestStatus=? WHERE requestID=?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, request.getOrgTechType());
            stmt.setString(2, request.getOrgTechModel());
            stmt.setString(3, request.getProblemDescription());
            stmt.setInt(4, request.getMasterID());
            stmt.setString(5, request.getRequestStatus());
            stmt.setInt(6, request.getRequestID());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Обработка исключений
        }
    }

    @Override
    public Request getRequestById(int requestId) {
        String sql = "SELECT * FROM requests WHERE requestID=?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, requestId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Request(rs.getString("orgTechType"), rs.getString("orgTechModel"), rs.getString("problemDescription"), rs.getInt("masterID"), rs.getInt("clientID"));
                //установить другие поля
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Обработка исключений
        }
        return null; // Если заявка не найдена
    }

    @Override
    public List<Request> getAllRequests() {
        List<Request> requests = new ArrayList<>();
        String sql = "SELECT * FROM requests";
        try (Statement stmt = connection.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Request request = new Request(rs.getString("orgTechType"), rs.getString("orgTechModel"), rs.getString("problemDescription"), rs.getInt("masterID"), rs.getInt("clientID"));
                //  остальные поля
                requests.add(request);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Обработка исключений
        }
        return requests;
    }

    @Override
    public List<Request> searchRequests(String query) {
        // тут будет логика
        return new ArrayList<>(); // Заглушка
    }

    @Override
    public void assignMasterToRequest(int requestId, int masterId) {
        //  логика назначения мастера на заявку
    }

  public void create() {
        // Логика для создания новой записи
        System.out.println("Create method called");
        // потом добавить код для вставки новой заявки в базу данных.
    }
}


