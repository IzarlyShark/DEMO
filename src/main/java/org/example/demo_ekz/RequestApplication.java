package org.example.demo_ekz;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class RequestApplication extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            // Загрузка FXML файла
            FXMLLoader loader = new FXMLLoader(getClass().getResource("request_view.fxml"));
            Parent root = loader.load();

            // Установка заголовка окна
            primaryStage.setTitle("Система управления запросами");

            // Установка сцены
            primaryStage.setScene(new Scene(root));

            // Показать окно
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args); // Запуск приложения
    }
}