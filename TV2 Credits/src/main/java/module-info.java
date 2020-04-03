module com.mycompany.guiexample1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.postgresql.jdbc;

    opens com.mycompany.Presentation to javafx.fxml;
    exports com.mycompany.Presentation;
}