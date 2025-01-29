package org.example.demo_ekz;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.demo_ekz.dao.RequestDAO;
import org.example.demo_ekz.dao.RequestDAOImpl;
import org.example.demo_ekz.models.Request;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class RequestController {

    @FXML
    private TableView<Request> requestTableView; // Таблица для отображения запросов
    @FXML
    private TableColumn<Request, Integer> columnRequestID; // Колонка для Request ID
    @FXML
    private TableColumn<Request, String> columnStartDate; // Колонка для Start Date
    @FXML
    private TableColumn<Request, String> columnOrgTechType; // Колонка для Tech Type
    @FXML
    private TableColumn<Request, String> columnOrgTechModel; // Колонка для Tech Model
    @FXML
    private TableColumn<Request, String> columnProblemDescription; // Колонка для Problem Description
    @FXML
    private TableColumn<Request, String> columnRequestStatus; // Колонка для Status
    @FXML
    private TableColumn<Request, String> columnCompletionDate; // Колонка для Completion Date
    @FXML
    private TableColumn<Request, String> columnRepairParts; // Колонка для Repair Parts
    @FXML
    private TableColumn<Request, Integer> columnMasterID; // Колонка для Master ID
    @FXML
    private TableColumn<Request, Integer> columnClientID; // Колонка для Client ID

    @FXML
    private Label statusLabel; // Метка для отображения статуса
    @FXML
    private Button addButton; // Кнопка для добавления нового запроса

    private Connection connection; // Объявляем переменную connection
    private ObservableList<Request> requestList; // Список запросов

    @FXML
    public void initialize() {
        String url = "jdbc:postgresql://localhost:5432/demo";
        String user = "evgenyportnov";
        String password = "hello88sharky";
        try {
            connection = DriverManager.getConnection(url, user, password);
            statusLabel.setText("Connected to DB!");

            // Инициализация колонок таблицы
            columnRequestID.setCellValueFactory(new PropertyValueFactory<>("requestID"));
            columnStartDate.setCellValueFactory(new PropertyValueFactory<>("startDate"));
            columnOrgTechType.setCellValueFactory(new PropertyValueFactory<>("techType"));
            columnOrgTechModel.setCellValueFactory(new PropertyValueFactory<>("techModel"));
            columnProblemDescription.setCellValueFactory(new PropertyValueFactory<>("problemDescription"));
            columnRequestStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
            columnCompletionDate.setCellValueFactory(new PropertyValueFactory<>("completionDate"));
            columnRepairParts.setCellValueFactory(new PropertyValueFactory<>("repairParts"));
            columnMasterID.setCellValueFactory(new PropertyValueFactory<>("masterID"));
            columnClientID.setCellValueFactory(new PropertyValueFactory<>("clientID"));

            loadRequests(); // Загрузка запросов из базы данных

        } catch (SQLException e) {
            statusLabel.setText("Error connecting to the database!");
        }
    }

    private void loadRequests() {
        RequestDAO requestDAO = new RequestDAOImpl(connection);
        requestList = FXCollections.observableArrayList(requestDAO.getAllRequests()); // Получение всех запросов из базы данных
        requestTableView.setItems(requestList); // Установка списка запросов в таблицу
    }
    @FXML
    protected void onAddButtonClick() {
        RequestDAO requestDAO = new RequestDAOImpl(connection);
        Request newRequest = new Request(); // Создание нового запроса

        // Пример заполнения полей нового запроса
        newRequest.setOrgTechType("Пример типа");
        newRequest.setOrgTechModel("Пример модели");
        newRequest.setProblemDescription("Описание проблемы");

        requestDAO.addRequest(newRequest); // Создание нового запроса в базе данных
        loadRequests(); // Перезагрузка списка запросов после добавления нового
    }
}