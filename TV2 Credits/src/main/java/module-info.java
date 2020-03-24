module com.mycompany.guiexample1 {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.guiexample1 to javafx.fxml;
    exports com.mycompany.guiexample1;
}