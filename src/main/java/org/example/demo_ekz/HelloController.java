package org.example.demo_ekz;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import org.example.demo_ekz.dao.RequestDAO;
import org.example.demo_ekz.dao.RequestDAOImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class HelloController {
    @FXML
    private Label welcomeText;
    private Connection connection; // Объявляем переменную connection

    @FXML
    public void initialize(){
        String url = "jdbc:postgresql://localhost:5432/demo";
        String user = "evgenyportnov";
        String password = "hello88sharky";
        try {
            connection = DriverManager.getConnection(url, user, password);
            welcomeText. setText ("Connect to DB!");
         } catch (SQLException e) {
        welcomeText.setText("Error Date Base connection!");
        }
    }

    @FXML
    protected void onHelloButtonClick() {
        RequestDAO requestDAO = new RequestDAOImpl(connection);
        requestDAO.create();
    }
}