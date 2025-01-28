module org.example.demo_ekz {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens org.example.demo_ekz to javafx.fxml;
    requires java.sql; // Добавлено для работы с JDBC
    exports org.example.demo_ekz;
    exports org.example.demo_ekz.models;
    opens org.example.demo_ekz.models to javafx.fxml;
}